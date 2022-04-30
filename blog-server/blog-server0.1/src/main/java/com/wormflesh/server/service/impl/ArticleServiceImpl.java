package com.wormflesh.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wormflesh.server.mapper.ArticleMapper;
import com.wormflesh.server.pojo.Article;
import com.wormflesh.server.pojo.REArticle;
import com.wormflesh.server.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     *
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    @Override
    public IPage<REArticle> getArticleByPage(IPage<REArticle> iREArticlePage, QueryWrapper<REArticle> wrapper) {
        IPage<REArticle> reArticlePage = articleMapper.getArticleByPage(iREArticlePage, wrapper);
        return reArticlePage;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public REArticle getArticleById(int id) {
        REArticle reArticle = articleMapper.getArticleById(id);
        return reArticle;
    }

    /**
     *
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    @Override
    public IPage<REArticle> getArticleByCategory(IPage<REArticle> iREArticlePage, QueryWrapper<REArticle> wrapper) {
        IPage<REArticle> reArticlePage = articleMapper.getArticleByCategory(iREArticlePage, wrapper);
        return reArticlePage;
    }

    /**
     *
     * @param id
     */
    @Override
    public void addviews(int id) {
        articleMapper.addviews(id);
    }

    /**
     * 根据标签名称分页查询
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    @Override
    public IPage<REArticle> getArticleByLabel(IPage<REArticle> iREArticlePage, QueryWrapper<REArticle> wrapper) {
        IPage<REArticle> reArticlePage = articleMapper.getArticleByLabel(iREArticlePage, wrapper);
        return reArticlePage;
    }

    /**
     * 获取浏览量前三的文章
     * @return
     */
    @Override
    public List<Article> getFeatureArticle() {
        List<Article> articles = articleMapper.getFeatureArticle();
        return articles;
    }
}
