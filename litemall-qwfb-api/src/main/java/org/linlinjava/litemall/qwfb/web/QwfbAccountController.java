package org.linlinjava.litemall.qwfb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.qwfb.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.qwfb.service.QwfbAccountBLLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/qwfb/account")
@Validated
public class QwfbAccountController {
    private final Log logger = LogFactory.getLog(QwfbAccountController.class);

    @Autowired
    private QwfbAccountBLLService qwfbAccountBLLService;

    @RequiresPermissions("admin:ad:list")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "查询")
    @GetMapping("/list")
    public Object list(Integer platformId, Integer accountGroupId, @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            @Sort @RequestParam(defaultValue = "add_time") String sort,
            @Order @RequestParam(defaultValue = "desc") String order) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        List<LitemallQwfbAccount> adList = qwfbAccountBLLService.querySelective(user.getId(), platformId,
                accountGroupId, page, limit, sort, order);
        long total = PageInfo.of(adList).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", adList);

        return ResponseUtil.ok(data);
    }

    private Object validate(LitemallQwfbAccount ad) {
        String name = ad.getLoginName();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }
        Integer content = ad.getPlatformId();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    @RequiresPermissions("admin:ad:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @PostMapping("/precreate")
    public Object precreate(Integer platformId) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        LitemallQwfbAccount account = qwfbAccountBLLService.precreate(user, platformId);
        return ResponseUtil.ok(account);
    }

    @RequiresPermissions("admin:ad:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @PostMapping("/updateLoginInfo")
    public Object updateLoginInfo(@NotNull Integer accountId, @NotNull String accountName, String headIcon,
            String headIconSite, String loginName, String password, String authToken) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        qwfbAccountBLLService.updateLoginInfo(user, accountId, accountName, headIcon, headIconSite, loginName, password,
                authToken);
        return ResponseUtil.ok();
    }

    @RequiresPermissions("admin:ad:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @PostMapping("/create")
    public Object create(@RequestBody LitemallQwfbAccount ad) {
        Object error = validate(ad);
        if (error != null) {
            return error;
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        qwfbAccountBLLService.add(ad, user.getId());
        return ResponseUtil.ok(ad);
    }

    @RequiresPermissions("admin:ad:read")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "详情")
    @GetMapping("/read")
    public Object read(@NotNull Integer id) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        LitemallQwfbAccount brand = qwfbAccountBLLService.findById(id, user.getId());
        return ResponseUtil.ok(brand);
    }

    @RequiresPermissions("admin:ad:update")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallQwfbAccount ad) {
        Object error = validate(ad);
        if (error != null) {
            return error;
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        if (qwfbAccountBLLService.updateById(ad, user.getId()) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        return ResponseUtil.ok(ad);
    }

    @RequiresPermissions("admin:ad:update")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "编辑")
    @PostMapping("/changeGroup")
    public Object changeGroup(@RequestBody String body) {
        Integer id = JacksonUtil.parseInteger(body, "id");
        Integer accountGroupId = JacksonUtil.parseInteger(body, "accountGroupId");
        if (id <= 0 || accountGroupId < 0) {
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        qwfbAccountBLLService.changeGroup(id, accountGroupId, user.getId());

        return ResponseUtil.ok();
    }

    @RequiresPermissions("admin:ad:delete")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody LitemallQwfbAccount ad) {
        Integer id = ad.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        qwfbAccountBLLService.deleteById(id, user.getId());
        return ResponseUtil.ok();
    }

}
