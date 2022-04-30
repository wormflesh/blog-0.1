package com.wormflesh.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wormflesh.server.pojo.Article;
import com.wormflesh.server.pojo.REArticle;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
public interface IArticleService extends IService<Article> {

    /**
     * 分页查询（多表）
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    IPage<REArticle> getArticleByPage(IPage<REArticle> iREArticlePage, QueryWrapper<REArticle> wrapper);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    REArticle getArticleById(int id);

    /**
     * 根据分类分页查询
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    IPage<REArticle> getArticleByCategory(IPage<REArticle> iREArticlePage, QueryWrapper<REArticle> wrapper);

    /**
     * 浏览量加一
     * @param id
     */
    void addviews(int id);

    /**
     * 根据标签分页查询
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    IPage<REArticle> getArticleByLabel(IPage<REArticle> iREArticlePage, QueryWrapper<REArticle> wrapper);

    /**
     * 获取浏览量前三的文件
     * @return
     */
    List<Article> getFeatureArticle();

}
