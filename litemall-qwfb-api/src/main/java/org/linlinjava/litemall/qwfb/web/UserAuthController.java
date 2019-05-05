package org.linlinjava.litemall.qwfb.web;

import static org.linlinjava.litemall.qwfb.util.ResponseCode.ADMIN_INVALID_ACCOUNT;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.linlinjava.litemall.core.sms.TencentValidator;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.StringUtil;
import org.linlinjava.litemall.core.util.bcrypt.BCryptPasswordEncoder;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.LitemallAdminService;
import org.linlinjava.litemall.db.service.LitemallPermissionService;
import org.linlinjava.litemall.db.service.LitemallRoleService;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.linlinjava.litemall.qwfb.service.UserAuthBLLService;
import org.linlinjava.litemall.qwfb.util.Permission;
import org.linlinjava.litemall.qwfb.util.PermissionUtil;
import org.linlinjava.litemall.qwfb.util.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
@Validated
public class UserAuthController {
    private final Log logger = LogFactory.getLog(UserAuthController.class);

    @Autowired
    private LitemallAdminService adminService;
    @Autowired
    private LitemallRoleService roleService;
    @Autowired
    private LitemallPermissionService permissionService;

    @Autowired
    private LitemallUserService userService;

    @Autowired
    private UserAuthBLLService userAuthService;

    @Autowired
    private TencentValidator tencentValidator;

    /*
     * { invationCode : value}
     */
    @PostMapping("/checkInvationCode")
    public Object checkInvationCode(@RequestBody String body) {
        String invationCode = JacksonUtil.parseString(body, "invationCode");

        Subject currentUser = SecurityUtils.getSubject();
        Object error = userAuthService.validateInvationCode(currentUser, invationCode);
        if (error != null) {
            return error;
        }

        return ResponseUtil.ok(currentUser.getSession().getId());
    }

    /*
     * { username : value, captcha : value}
     */
    @PostMapping("/checkValidation")
    public Object checkValidation(@RequestBody String body) {
        String captcha = JacksonUtil.parseString(body, "captcha");
        String tel = JacksonUtil.parseString(body, "tel");
        Boolean needTelCode = JacksonUtil.parseBoolean(body, "needTelCode");

        String ticket = JacksonUtil.parseString(body, "ticket");
        String rand = JacksonUtil.parseString(body, "rand");

        if (!StringUtil.isNullOrEmpty(ticket)) {
            Boolean verifyResult = tencentValidator.verify(ticket, rand, tel);
            if (!verifyResult) {
                return ResponseUtil.fail(ResponseCode.USER_INVALID_Validation_Code_Exist, "无效验证，请重新输入");
            }
        }

        if (needTelCode != null && needTelCode) {
            userAuthService.sendValidateCode(tel);
        }

        return ResponseUtil.ok();
    }

    /*
     * { username : value, captcha : value}
     */
    @PostMapping("/getTelCode")
    public Object getTelCode(@RequestBody String body) {
        String tel = JacksonUtil.parseString(body, "tel");
        String captcha = JacksonUtil.parseString(body, "captcha");

        String ticket = JacksonUtil.parseString(body, "ticket");
        String rand = JacksonUtil.parseString(body, "rand");
        String userIP = JacksonUtil.parseString(body, "userIP");

        Boolean verifyResult = tencentValidator.verify(ticket, rand, userIP);
        if (!verifyResult) {
            return ResponseUtil.fail(ResponseCode.USER_INVALID_Validation_Code_Exist, "无效验证，请重新输入");
        }

        Subject currentUser = SecurityUtils.getSubject();
        Object error = userAuthService.validateTel(currentUser, tel, captcha, ticket, rand, userIP);
        if (error != null) {
            return error;
        }
        // 初期异步调用阿里云发送短信，后期改为队列发送
        userAuthService.sendValidateCode(tel);

        return ResponseUtil.ok();
    }

    /*
     * { invationCode : value, captcha : value, password:XXX, tel : xxx，username :
     * XXX}
     */
    @PostMapping("/regist")
    public Object regist(@RequestBody String body) {
        String invationCode = JacksonUtil.parseString(body, "invationCode");
        String captcha = JacksonUtil.parseString(body, "captcha");
        String tel = JacksonUtil.parseString(body, "tel");
        String validateCode = JacksonUtil.parseString(body, "validateCode");
        String password = JacksonUtil.parseString(body, "password");
        String username = JacksonUtil.parseString(body, "username");

        String ticket = JacksonUtil.parseString(body, "ticket");
        String rand = JacksonUtil.parseString(body, "rand");
        String userIP = JacksonUtil.parseString(body, "userIP");

        Subject currentUser = SecurityUtils.getSubject();
        Object error = userAuthService.validateInvationCode(currentUser, invationCode);
        if (error != null) {
            return error;
        }
        error = userAuthService.validateTel(currentUser, tel, captcha, ticket, rand, userIP);
        if (error != null) {
            return error;
        }

        error = userAuthService.checkValidateCode(currentUser, tel, validateCode);
        if (error != null) {
            return error;
        }

        error = userAuthService.validateRegist(currentUser, username, password);
        if (error != null) {
            return error;
        }

        // 开始注册
        LitemallUser user = new LitemallUser();
        user.setUsername(username);
        user.setMobile(tel);
        user.setNickname(username);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);

        userService.add(user);

        return ResponseUtil.ok(currentUser.getSession().getId());
    }

    /*
     * { username : value, password : value }
     */
    @PostMapping("/login")
    public Object login(@RequestBody String body) {
        String tel = JacksonUtil.parseString(body, "tel");
        String password = JacksonUtil.parseString(body, "password");

        if (StringUtils.isEmpty(tel) || StringUtils.isEmpty(password)) {
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordToken(tel, password));
        } catch (UnknownAccountException uae) {
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, "用户帐号或密码不正确");
        } catch (LockedAccountException lae) {
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, "用户帐号已锁定不可用");

        } catch (AuthenticationException ae) {
            return ResponseUtil.fail(ADMIN_INVALID_ACCOUNT, ae.getMessage());
        }

        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        Integer userId = user.getId();
        userAuthService.initWhenLogin(userId);

        return ResponseUtil.ok(currentUser.getSession().getId());
    }

    /*
     *
     */
    @RequiresAuthentication
    @PostMapping("/logout")
    public Object logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseUtil.ok();
    }

    @PostMapping("/forgetPassword")
    public Object forgetPassword(@RequestBody String body) {
        String tel = JacksonUtil.parseString(body, "tel");
        String captcha = JacksonUtil.parseString(body, "captcha");

        if (StringUtils.isEmpty(tel) || StringUtils.isEmpty(captcha)) {
            return ResponseUtil.badArgument();
        }

        userAuthService.sendValidateCode(tel);

        return ResponseUtil.ok();
    }

    @PostMapping("/checkForgetPassword")
    public Object checkForgetPassword(@RequestBody String body) {
        String tel = JacksonUtil.parseString(body, "tel");
        String captcha = JacksonUtil.parseString(body, "captcha");
        String validateCode = JacksonUtil.parseString(body, "validateCode");

        if (StringUtils.isEmpty(tel) || StringUtils.isEmpty(captcha) || StringUtils.isEmpty(validateCode)) {
            return ResponseUtil.badArgument();
        }

        boolean result = userAuthService.checkForgetPassword(tel, captcha, validateCode);
        if (!result) {
            return ResponseUtil.fail(ResponseCode.USER_INVALID_Validation_Code_Exist, "验证码不正确");
        }

        return ResponseUtil.ok();
    }

    @PostMapping("/changePassword")
    public Object changePassword(@RequestBody String body) {
        String newPassword = JacksonUtil.parseString(body, "newPassword");
        String newPassword1 = JacksonUtil.parseString(body, "newPassword1");
        String tel = JacksonUtil.parseString(body, "tel");

        if (StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(newPassword1)) {
            return ResponseUtil.badArgument();
        }

        if (!newPassword.equals(newPassword1)) {
            return ResponseUtil.fail(ResponseCode.USER_INVALID_Password_Not_Equal, "两个密码不相等");
        }

        Object error = userAuthService.changePassword(newPassword);
        if (error != null) {
            return error;
        }

        return ResponseUtil.ok();
    }

    @RequiresAuthentication
    @GetMapping("/info")
    public Object info() {
        Subject currentUser = SecurityUtils.getSubject();

        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        Map<String, Object> data = new HashMap<>();
        data.put("name", user.getUsername());
        data.put("avatar", user.getAvatar());

        Integer[] roleIds = PermissionUtil.qwfbUserRoles;
        // Integer[] roleIds = admin.getRoleIds();

        Set<String> roles = roleService.queryByIds(roleIds);
        Set<String> permissions = permissionService.queryByRoleIds(roleIds);
        data.put("roles", roles);
        // NOTE
        // 这里需要转换perms结构，因为对于前端而已API形式的权限更容易理解
        data.put("perms", toAPI(permissions));
        return ResponseUtil.ok(data);
    }

    @Autowired
    private ApplicationContext context;
    private HashMap<String, String> systemPermissionsMap = null;

    private Collection<String> toAPI(Set<String> permissions) {
        if (systemPermissionsMap == null) {
            systemPermissionsMap = new HashMap<>();
            final String basicPackage = "org.linlinjava.litemall.admin";
            List<Permission> systemPermissions = PermissionUtil.listPermission(context, basicPackage);
            for (Permission permission : systemPermissions) {
                String perm = permission.getRequiresPermissions().value()[0];
                String api = permission.getApi();
                systemPermissionsMap.put(perm, api);
            }
        }

        Collection<String> apis = new HashSet<>();
        for (String perm : permissions) {
            String api = systemPermissionsMap.get(perm);
            apis.add(api);

            if (perm.equals("*")) {
                apis.clear();
                apis.add("*");
                return apis;
                // return systemPermissionsMap.values();
            }
        }
        return apis;
    }

    @GetMapping("/401")
    public Object page401() {
        return ResponseUtil.unlogin();
    }

    @GetMapping("/index")
    public Object pageIndex() {
        return ResponseUtil.ok();
    }

    @GetMapping("/403")
    public Object page403() {
        return ResponseUtil.unauthz();
    }

}
