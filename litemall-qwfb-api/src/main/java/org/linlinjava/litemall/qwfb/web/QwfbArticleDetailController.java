package org.linlinjava.litemall.qwfb.web;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.domain.QwfbArticleDetailCustom;
import org.linlinjava.litemall.qwfb.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.qwfb.service.QwfbArticleBLLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/qwfb/article")
@Validated
public class QwfbArticleDetailController {
    private final Log logger = LogFactory.getLog(QwfbArticleDetailController.class);

    @ModelAttribute
    LocalDateTime lastAccessTime() {
        return LocalDateTime.now();
    }

    @Autowired
    private QwfbArticleBLLService qwfbArticleBLLService;

    /**
     * 获取用户的发布队列
     * 
     * @param type，1-图文、2-图集、3-视频
     * @param accountGroupId
     * @param page
     * @param limit
     * @return
     */
    @RequiresPermissions("admin:ad:list")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "查询")
    @GetMapping("/detail/list")
    public Object articleDetailList(Long articleId, @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "0") Integer status, @RequestParam(defaultValue = "20") Integer limit) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        Object data = qwfbArticleBLLService.getDetailList(user.getId(), status, articleId, page, limit);

        return data;
    }

}
