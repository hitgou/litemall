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
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccountGroup;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.QwfbAccountGroupService;
import org.linlinjava.litemall.qwfb.annotation.RequiresPermissionsDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qwfb/account/group")
@Validated
public class QwfbAccountGroupController {
    private final Log logger = LogFactory.getLog(QwfbAccountGroupController.class);

    @Autowired
    private QwfbAccountGroupService qwfbAccountGroupService;

    @RequiresPermissions("admin:qwfbAccountGroup:list")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "查询")
    @GetMapping("/list")
    public Object list() {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        List<LitemallQwfbAccountGroup> adList = qwfbAccountGroupService.querySelective(user.getId());
        Map<String, Object> data = new HashMap<>();
        data.put("items", adList);

        return ResponseUtil.ok(data);
    }

    private Object validate(LitemallQwfbAccountGroup qwfbAccountGroup) {
        String name = qwfbAccountGroup.getName();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    @RequiresPermissions("admin:qwfbAccountGroup:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @PostMapping("/create")
    public Object create(@RequestBody LitemallQwfbAccountGroup qwfbAccountGroup) {
        Object error = validate(qwfbAccountGroup);
        if (error != null) {
            return error;
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        qwfbAccountGroup.setUserId(user.getId());

        qwfbAccountGroupService.add(qwfbAccountGroup);
        return ResponseUtil.ok(qwfbAccountGroup);
    }

    @RequiresPermissions("admin:qwfbAccountGroup:read")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "详情")
    @GetMapping("/read")
    public Object read(@NotNull Integer id) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        LitemallQwfbAccountGroup brand = qwfbAccountGroupService.findById(user.getId(), id);

        return ResponseUtil.ok(brand);
    }

    @RequiresPermissions("admin:qwfbAccountGroup:update")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallQwfbAccountGroup qwfbAccountGroup) {
        Object error = validate(qwfbAccountGroup);
        if (error != null) {
            return error;
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        if (qwfbAccountGroupService.updateById(qwfbAccountGroup, user.getId()) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        return ResponseUtil.ok(qwfbAccountGroup);
    }

    @RequiresPermissions("admin:qwfbAccountGroup:delete")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody LitemallQwfbAccountGroup qwfbAccountGroup) {
        Integer id = qwfbAccountGroup.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        qwfbAccountGroupService.deleteById(user.getId(), id);

        return ResponseUtil.ok();
    }

}
