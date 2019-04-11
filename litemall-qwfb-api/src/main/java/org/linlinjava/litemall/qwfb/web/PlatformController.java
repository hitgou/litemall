package org.linlinjava.litemall.qwfb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPlatform;
import org.linlinjava.litemall.db.service.LitemallPlatformService;
import org.linlinjava.litemall.qwfb.annotation.RequiresPermissionsDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/qwfb/platform")
@Validated
public class PlatformController {
    private final Log logger = LogFactory.getLog(PlatformController.class);

    @Autowired
    private LitemallPlatformService platformService;

    @RequiresPermissions("admin:ad:list")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "查询")
    @GetMapping("/list")
    public Object list() {
        List<LitemallPlatform> adList = platformService.querySelective();
        long total = PageInfo.of(adList).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", adList);

        return ResponseUtil.ok(data);
    }

}
