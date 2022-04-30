package com.wormflesh.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wormflesh.server.config.result.Result;
import com.wormflesh.server.pojo.Article;
import com.wormflesh.server.pojo.REArticle;
import com.wormflesh.server.service.IArticleService;
import com.wormflesh.server.service.ICategoryService;
import com.wormflesh.server.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *  有关文件的控制器操作
 * @author wormflesh
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;
    @Autowired
    private ICategoryService icategoryService;
    @Autowired
    private ILabelService iLabelService;


    /**
     * 查看文件列表
     * @param current
     * @param size
     * @return  article、category、labels
     */
    @GetMapping("/getArticlesByPage/{current}/{size}")
    public Result getArticlesByPage(@PathVariable int current, @PathVariable int size) {
        IPage<REArticle> iREArticlePage = new Page<>(current, size);
        QueryWrapper<REArticle> wrapper = new QueryWrapper<>();
        IPage<REArticle> iREArticleIPage = iArticleService.getArticleByPage(iREArticlePage, wrapper);
        return Result.success(iREArticleIPage);
    }

    /**
     * 根据文件id查找文件（查看文件时，文件浏览量加一）
     * @param id
     * @return
     */
    @GetMapping("/getArticleById/{id}")
    public Result getArticleById(@PathVariable int id) {
        if (iArticleService.getById(id) != null) {
            iArticleService.addviews(id);
            REArticle reArticle = iArticleService.getArticleById(id);
            return Result.success(reArticle);
        }
        return Result.error(-1, "数据库中没有此文件");
    }

    /**
     * 根据文件名查找文件
     * @param condition
     * @return
     */
    @GetMapping("/getArticleByTitle/{condition}/{current}/{size}")
    public Result getArticleByTitle(@PathVariable String condition, @PathVariable int current, @PathVariable int size) {
        IPage<REArticle> iREArticlePage = new Page<>(current, size);
        QueryWrapper<REArticle> wrapper = new QueryWrapper<>();
        wrapper.like("blog_article.art_title", condition);  // column为数据库字段名，语句转换为SQL语句--》blog_article.art_title LIKE ?
        IPage<REArticle> iREArticleIPage = iArticleService.getArticleByPage(iREArticlePage, wrapper);
        return Result.success(iREArticleIPage);

    }

    /**
     * 根据分类分页查询
     * @param category
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/getArticleByCategory/{category}/{current}/{size}")
    public Result getArticleByCategory(@PathVariable String category, @PathVariable int current, @PathVariable int size) {
        IPage<REArticle> iREArticlePage = new Page<>(current, size);
        QueryWrapper<REArticle> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_category.cate_name", category);  // column为数据库字段名，语句转换为SQL语句--》blog_article.art_title LIKE ?
        IPage<REArticle> iREArticleIPage = iArticleService.getArticleByCategory(iREArticlePage, wrapper);
        return Result.success(iREArticleIPage);
    }

    /**
     * 根据标签名字查询文件
     * @return
     */
    @GetMapping("/getArticleByLabel/{label}/{current}/{size}")
    public Result getArticleByLabel(@PathVariable String label, @PathVariable int current, @PathVariable int size) {
        IPage<REArticle> iREArticlePage = new Page<>(current, size);
        QueryWrapper<REArticle> wrapper = new QueryWrapper<>();
        wrapper.eq("blog_label.label_name", label);  // column为数据库字段名，语句转换为SQL语句--》blog_article.art_title LIKE ?
        IPage<REArticle> iREArticleIPage = iArticleService.getArticleByLabel(iREArticlePage, wrapper);
        return Result.success(iREArticleIPage);
    }


    /**
     * 获取浏览量前三的文件
     * @return
     */
    @GetMapping("/getFeatureArticle")
    public Result getFeatureArticle(){
        List<Article> articles = iArticleService.getFeatureArticle();
        return Result.success(articles);
    }
}
