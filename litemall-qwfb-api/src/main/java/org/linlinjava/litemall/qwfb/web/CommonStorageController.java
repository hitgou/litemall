package org.linlinjava.litemall.qwfb.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.core.storage.StorageService;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.validator.Order;
import org.linlinjava.litemall.core.validator.Sort;
import org.linlinjava.litemall.db.domain.LitemallStorage;
import org.linlinjava.litemall.db.service.LitemallStorageService;
import org.linlinjava.litemall.qwfb.annotation.RequiresPermissionsDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/common/storage")
@Validated
public class CommonStorageController {
    private final Log logger = LogFactory.getLog(CommonStorageController.class);

    @Autowired
    private StorageService storageService;
    @Autowired
    private LitemallStorageService litemallStorageService;

    @RequiresPermissions("admin:storage:list")
    @RequiresPermissionsDesc(menu = { "系统管理", "对象存储" }, button = "查询")
    @GetMapping("/list")
    public Object list(String key, String name, @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit,
            @Sort @RequestParam(defaultValue = "add_time") String sort,
            @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallStorage> storageList = litemallStorageService.querySelective(key, name, page, limit, sort, order);
        long total = PageInfo.of(storageList).getTotal();
        Map<String, Object> data = new HashMap<>();
        data.put("total", total);
        data.put("items", storageList);

        return ResponseUtil.ok(data);
    }

    @RequiresPermissions("admin:storage:create")
    @RequiresPermissionsDesc(menu = { "系统管理", "对象存储" }, button = "上传")
    @PostMapping("/create")
    public Object create(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename.indexOf(".") < 0) {
            String contentType = file.getContentType();
            if (contentType.indexOf("/") >= 0) {
                contentType = contentType.substring(contentType.lastIndexOf("/") + 1);
            }
            originalFilename = originalFilename + "." + contentType;
        }

        String url = storageService.store(file.getInputStream(), file.getSize(), file.getContentType(),
                originalFilename);
        Map<String, Object> data = new HashMap<>();
        data.put("url", url);
        return ResponseUtil.ok(data);
    }

    @RequiresPermissions("admin:storage:read")
    @RequiresPermissionsDesc(menu = { "系统管理", "对象存储" }, button = "详情")
    @PostMapping("/read")
    public Object read(@NotNull Integer id) {
        LitemallStorage storageInfo = litemallStorageService.findById(id);
        if (storageInfo == null) {
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok(storageInfo);
    }

    @RequiresPermissions("admin:storage:update")
    @RequiresPermissionsDesc(menu = { "系统管理", "对象存储" }, button = "编辑")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallStorage litemallStorage) {
        if (litemallStorageService.update(litemallStorage) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(litemallStorage);
    }

    @RequiresPermissions("admin:storage:delete")
    @RequiresPermissionsDesc(menu = { "系统管理", "对象存储" }, button = "删除")
    @PostMapping("/delete")
    public Object delete(@RequestBody LitemallStorage litemallStorage) {
        String key = litemallStorage.getKey();
        if (StringUtils.isEmpty(key)) {
            return ResponseUtil.badArgument();
        }
        litemallStorageService.deleteByKey(key);
        storageService.delete(key);
        return ResponseUtil.ok();
    }
}
