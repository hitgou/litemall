package org.linlinjava.litemall.qwfb.web;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.core.util.StringUtil;
import org.linlinjava.litemall.db.domain.LitemallQwfbAccount;
import org.linlinjava.litemall.db.domain.LitemallQwfbArticle;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.qwfb.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.qwfb.service.QwfbAccountBLLService;
import org.linlinjava.litemall.qwfb.service.QwfbArticleBLLService;
import org.linlinjava.litemall.qwfb.service.QwfbPublishBLLService;
import org.linlinjava.litemall.qwfb.vm.ArticleStepVM;
import org.linlinjava.litemall.qwfb.vm.PublishArticleVM;
import org.linlinjava.litemall.qwfb.vm.UpdateArticleVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qwfb/publish")
@Validated
public class QwfbPublishController {
    private final Log logger = LogFactory.getLog(QwfbPublishController.class);

    @ModelAttribute
    LocalDateTime lastAccessTime() {
        return LocalDateTime.now();
    }

    @Autowired
    private QwfbAccountBLLService qwfbAccountBLLService;

    @Autowired
    private QwfbArticleBLLService qwfbArticleBLLService;

    @Autowired
    private QwfbPublishBLLService qwfbPublishBLLService;

    @RequiresPermissions("admin:ad:list")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "查询")
    @GetMapping("/account/list")
    public Object getAccountList(
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam @ModelAttribute LocalDateTime lastAccessTime) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        return qwfbPublishBLLService.getAccountList(user.getId());
    }

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
    @GetMapping("/article/list")
    public Object articleList(String title, Integer status, @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer limit) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        return qwfbPublishBLLService.getArticleList(user.getId(), title, status, page, limit);
    }

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
    @GetMapping("/article/queue")
    public Object getArticleQueueList(
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam @ModelAttribute LocalDateTime lastAccessTime,
            // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ModelAttribute LocalDateTime
            // lastAccessTime,
            @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        List<PublishArticleVM> result = qwfbPublishBLLService.getArticleQueueList(user.getId(), lastAccessTime, page,
                limit);

        return ResponseUtil.ok(result);
    }

    /**
     * 保存图文
     * 
     * @param article
     *            图文
     * @param attachments
     *            保存方式，1-暂存
     * @param saveType
     *            保存方式，1-暂存
     * @return
     */
    @RequiresPermissions("admin:ad:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @PostMapping("/createOrUpdateArticle")
    public Object createOrUpdateArticle(@RequestBody LitemallQwfbArticle article) {
        Object error = validate(article);
        if (error != null) {
            return error;
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        article = qwfbPublishBLLService.createOrUpdateArticle(article, user.getId());

        return ResponseUtil.ok(article);
    }

    @RequiresPermissions("admin:ad:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @PostMapping("/changeArticleByStep")
    public Object changeArticleByStep(@RequestBody ArticleStepVM articleStepVo) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();

        Object result = qwfbPublishBLLService.changeArticleByStep(user.getId(), articleStepVo.getArticleId(),
                articleStepVo.getAccountGroupId(), articleStepVo.getArticleDetails());
        if (result != null) {
            return result;
        }

        return ResponseUtil.ok();
    }

    private Object validate(LitemallQwfbArticle article) {
        String name = article.getTitle();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }
        String content = article.getContent();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    @RequiresPermissions("admin:ad:create")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "添加")
    @GetMapping("/getArticle")
    public Object getArticle(Long articleId) {
        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        LitemallQwfbArticle account = qwfbPublishBLLService.getArticle(user.getId(), articleId);
        return ResponseUtil.ok(account);
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

    @RequiresPermissions("admin:ad:update")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "编辑")
    @PostMapping("/article/detail/updateArticlePublished")
    public Object updateArticlePublished(@RequestBody UpdateArticleVM articleDetail) {
        Long detailId = articleDetail.detailId;
        Integer status = articleDetail.status;
        if (detailId == null || detailId <= 0 || !StringUtil.isIn(status.toString(), "2", "3", "4")) {
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        Object result = qwfbArticleBLLService.updateArticlePublished(user.getId(), articleDetail);
        if (result != null) {
            return result;
        }

        return ResponseUtil.ok();
    }

    @RequiresPermissions("admin:ad:update")
    @RequiresPermissionsDesc(menu = { "推广管理", "广告管理" }, button = "编辑")
    @PostMapping("/article/detail/updateArticleList")
    public Object updateArticleList(@RequestBody List<UpdateArticleVM> articleList) {
        if (articleList.size() == 0) {
            return ResponseUtil.ok();
        }

        Subject currentUser = SecurityUtils.getSubject();
        LitemallUser user = (LitemallUser) currentUser.getPrincipal();
        Object result = qwfbPublishBLLService.updateArticleList(user.getId(), articleList);
        if (result != null) {
            return result;
        }

        return ResponseUtil.ok();
    }

}
