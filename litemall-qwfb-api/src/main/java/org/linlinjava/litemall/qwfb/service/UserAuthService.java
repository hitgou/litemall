package org.linlinjava.litemall.qwfb.service;

import static org.linlinjava.litemall.qwfb.util.ResponseCode.USER_INVALID_NAME;
import static org.linlinjava.litemall.qwfb.util.ResponseCode.USER_INVALID_PASSWORD;
import static org.linlinjava.litemall.qwfb.util.ResponseCode.USER_MOBILE_EXIST;
import static org.linlinjava.litemall.qwfb.util.ResponseCode.USER_NAME_EXIST;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.linlinjava.litemall.core.redis.RedisConfig;
import org.linlinjava.litemall.core.sms.SmsSender;
import org.linlinjava.litemall.core.sms.TencentValidator;
import org.linlinjava.litemall.core.system.SystemConfig;
import org.linlinjava.litemall.core.util.HttpUtil;
import org.linlinjava.litemall.core.util.RegexUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.StringUtil;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.linlinjava.litemall.qwfb.util.RedisKey;
import org.linlinjava.litemall.qwfb.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserAuthService {
    private final Log logger = LogFactory.getLog(UserAuthService.class);

    @Autowired
    private LitemallUserService userService;

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private TencentValidator tencentValidator;

    @Resource
    private RedisConfig redisConfig;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public Object validateInvationCode(Subject currentUser, String invationCode) {
        if (StringUtils.isEmpty(invationCode)) {
            return ResponseUtil.badArgument();
        }

        Boolean isExist = true;
        if (!isExist) {
            return ResponseUtil.fail(ResponseCode.USER_INVALID_InvationCode, "邀请码不存在，请点击帮助查看如何获取验证码");
        }

        return null;
    }

    public Object validateRegist(Subject currentUser, String username, String password) {
        if (StringUtils.isEmpty(username)) {
            return ResponseUtil.badArgument();
        }
        if (!RegexUtil.isUsername(username)) {
            return ResponseUtil.fail(USER_INVALID_NAME, "用户名不符合规定");
        }
        if (StringUtils.isEmpty(password) || password.length() < 6) {
            return ResponseUtil.fail(USER_INVALID_PASSWORD, "用户密码长度不能小于6");
        }

        // 判断用户名和手机号码是否已经存在
        List<LitemallUser> userList = userService.queryByUsername(username);
        if (userList.size() > 0) {
            return ResponseUtil.fail(USER_NAME_EXIST, "用户名已注册");
        }

        return null;
    }

    public Object checkValidation(Subject currentUser, String captcha, String ticket, String rand) {
        if (StringUtils.isEmpty(ticket)) {
            return ResponseUtil.badArgument();
        }

        if (!tencentValidator.verify(ticket, rand, HttpUtil.getInternetIp())) {
            return ResponseUtil.fail(ResponseCode.USER_Tel_Need_Validate, "需要进行校验");
        }

        return null;
    }

    public Object validateTel(Subject currentUser, String tel, String captcha, String ticket, String rand,
            String userIP) {
        if (StringUtils.isEmpty(tel)) {
            return ResponseUtil.badArgument();
        }

        if (!RegexUtil.isMobileExact(tel)) {
            return ResponseUtil.fail(ResponseCode.USER_INVALID_MOBILE, "用户手机号码格式不正确");
        }

        // 如果该 session 为前3次获取验证码，则不弹出验证码选项
        // 从 redis 中获取session获取验证码的次数
        String sessionId = currentUser.getSession().getId().toString();
        String key = RedisKey.getKey(RedisKey.Key_Validate_Count, sessionId);

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Integer count = (Integer) valueOperations.get(key);
        count = count == null ? 0 : count;
        if (count > 1) {
            // 检查是否有
            if (StringUtils.isEmpty(ticket) || StringUtils.isEmpty(rand) || StringUtils.isEmpty(userIP)) {
                return ResponseUtil.fail(ResponseCode.USER_Tel_Need_Validate, "需要进行校验");
            }
        }
        // 使用跟 session 过期一样的时间
        valueOperations.set(RedisKey.Key_Validate_Count, count + 1, redisConfig.getTimeout(), TimeUnit.MILLISECONDS);

        return null;
    }

    public void sendValidateCode(String tel) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String validateCode = StringUtil.getRndNumber(4);
                logger.info("验证码：" + validateCode);

                Subject currentUser = SecurityUtils.getSubject();
                String sessionId = currentUser.getSession().getId().toString();
                String key = RedisKey.getKey(RedisKey.Key_Validate, sessionId);

                // 保存到 redis 缓存中
                int validateMS = SystemConfig.getSmsValidateMS();
                redisTemplate.opsForValue().set(key, validateCode, validateMS, TimeUnit.MILLISECONDS);

                // smsSender.sendValidateSms(tel, validateCode);
            }
        }).start();
    }

    public Object checkValidateCode(Subject currentUser, String tel, String validateCode) {
        String sessionId = currentUser.getSession().getId().toString();
        String key = RedisKey.getKey(RedisKey.Key_Validate, sessionId);
        Boolean validKey = true;
        if (redisTemplate.hasKey(key)) {
            String cacheCode = (String) redisTemplate.opsForValue().get(key);
            if (!validateCode.equalsIgnoreCase(cacheCode)) {
                validKey = false;
            }
        } else {
            validKey = false;
        }

        if (!validKey) {
            return ResponseUtil.fail(ResponseCode.USER_INVALID_Validation_Code_Exist, "手机验证码无效，请确认");
        }

        return null;
    }

    public boolean checkForgetPassword(String tel, String captcha, String validateCode) {
        // 检查验证码是否正确
        // TODO Auto-generated method stub

        // 如果正确，redis生成一个特殊key，指明该用户可以修改密码；如果不存在，需要用户重新输入

        return false;
    }

    public Object changePassword(String newPassword) {
        // TODO Auto-generated method stub
        // 检查

        return null;
    }

}
