package org.linlinjava.litemall.qwfb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallPlatformWithBLOBs;
import org.linlinjava.litemall.db.service.LitemallPlatformService;
import org.linlinjava.litemall.qwfb.service.PlatformBLLService;
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

    @Autowired
    private PlatformBLLService platformBLLService;

    @GetMapping("/list")
    public Object list() {
        List<LitemallPlatformWithBLOBs> adList = platformBLLService.getPlatformList();
        // platformService.querySelective();
        long total = PageInfo.of(adList).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", adList);

        return ResponseUtil.ok(data);
    }

}
