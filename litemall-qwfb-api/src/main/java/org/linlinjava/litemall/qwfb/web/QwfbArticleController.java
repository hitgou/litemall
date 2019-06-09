package org.linlinjava.litemall.qwfb.web;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.qwfb.service.QwfbArticleBLLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qwfb/article")
@Validated
public class QwfbArticleController {
    private final Log logger = LogFactory.getLog(QwfbArticleController.class);

    @ModelAttribute
    LocalDateTime lastAccessTime() {
        return LocalDateTime.now();
    }

    @Autowired
    private QwfbArticleBLLService qwfbArticleBLLService;

    // /**
    // * 获取用户的发布队列
    // *
    // * @param type，1-图文、2-图集、3-视频
    // * @param accountGroupId
    // * @param page
    // * @param limit
    // * @return
    // */
    // @RequiresPermissions("admin:ad:list")
    // @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "查询")
    // @GetMapping("/detail/list")
    // public Object articleList(Long articleId) {
    // Subject currentUser = SecurityUtils.getSubject();
    // LitemallUser user = (LitemallUser) currentUser.getPrincipal();
    //
    // return qwfbArticleBLLService.getDetailList(user.getId(), articleId);
    // }

}
