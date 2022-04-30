package com.wormflesh.server.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wormflesh.server.pojo.Article;
import com.wormflesh.server.pojo.Category;
import com.wormflesh.server.pojo.Label;
import com.wormflesh.server.pojo.REArticle;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 分页查询REArticle
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    @Results(id = "articleByPage",
        value = {
                @Result(property = "article.art_id", column = "art_id", id = true),
                @Result(property = "article.art_title", column = "art_title"),
                @Result(property = "article.art_summary", column = "art_summary"),
                @Result(property = "article.art_content", column = "art_content"),
                @Result(property = "article.art_views", column = "art_views"),
                @Result(property = "article.art_date", column = "art_date"),
                @Result(property = "article.art_image", column = "art_image"),
                @Result(property = "category", many =@Many(select="selectCategoryById"), column = "art_id"),
                @Result(property = "labels", many =@Many(select="selectLabelsById"), column = "art_id"),
        })
    @Select("SELECT blog_article.*\n" +
            "FROM blog_article\n" +
            "${ew.customSqlSegment}")
    IPage<REArticle> getArticleByPage(IPage<REArticle> iREArticlePage, @Param(Constants.WRAPPER) QueryWrapper<REArticle> wrapper);

    /**
     * 查询分类(根据文章id)
     * @param art_id
     * @return
     */
    @Select({"SELECT blog_category.cate_id,blog_category.cate_name \n" +
            "FROM blog_category \n" +
            "LEFT JOIN blog_art_category \n" +
            "ON blog_category.cate_id = blog_art_category.cate_id \n" +
            "WHERE blog_art_category.art_id = #{art_id}"})
    Category selectCategoryById(@Param("art_id") int art_id);

    /**
     * 查询标签列表（根据文章）
     * @param art_id
     * @return
     */
    @Select({"SELECT blog_label.label_id,blog_label.label_name\n" +
            "FROM blog_label\n" +
            "LEFT JOIN blog_art_label\n" +
            "ON blog_label.label_id = blog_art_label.label_id\n" +
            "WHERE blog_art_label.art_id = #{art_id}"})
    List<Label> selectLabelsById(@Param("art_id") int art_id);


    /**
     * 根据文件id查找文件
     * @param id
     * @return
     */
    @Results(id = "articleById",
            value = {
                    @Result(property = "article.art_id", column = "art_id", id = true),
                    @Result(property = "article.art_title", column = "art_title"),
                    @Result(property = "article.art_summary", column = "art_summary"),
                    @Result(property = "article.art_content", column = "art_content"),
                    @Result(property = "article.art_views", column = "art_views"),
                    @Result(property = "article.art_date", column = "art_date"),
                    @Result(property = "article.art_image", column = "art_image"),
                    @Result(property = "category", many =@Many(select="selectCategoryById"), column = "art_id"),
                    @Result(property = "labels", many =@Many(select="selectLabelsById"), column = "art_id"),
            })
    @Select("SELECT blog_article.*\n" +
            "FROM blog_article\n" +
            "WHERE art_id = #{id}")
    REArticle getArticleById(@Param("id") int id);


    /**
     * 根据分类分页查询文件
     * @param iREArticlePage
     * @param wrapper
     * @return
     */
    @Results(id = "articleByCategory",
            value = {
                    @Result(property = "article.art_id", column = "art_id", id = true),
                    @Result(property = "article.art_title", column = "art_title"),
                    @Result(property = "article.art_summary", column = "art_summary"),
                    @Result(property = "article.art_content", column = "art_content"),
                    @Result(property = "article.art_views", column = "art_views"),
                    @Result(property = "article.art_date", column = "art_date"),
                    @Result(property = "article.art_image", column = "art_image"),
                    @Result(property = "category", many =@Many(select="selectCategoryById"), column = "art_id"),
                    @Result(property = "labels", many =@Many(select="selectLabelsById"), column = "art_id"),
            })
    @Select("SELECT blog_article.* FROM (blog_article LEFT JOIN blog_art_category ON blog_article.art_id=blog_art_category.art_id ) LEFT JOIN blog_category ON blog_category.cate_id=blog_art_category.cate_id\n" +
            "${ew.customSqlSegment}")
    IPage<REArticle> getArticleByCategory(IPage<REArticle> iREArticlePage, @Param(Constants.WRAPPER) QueryWrapper<REArticle> wrapper);

    /**
     * id文件的views加一
     * @param id
     */
    @Select("UPDATE blog_article SET art_views = art_views+1 WHERE art_id = #{id};")
    void addviews(@Param("id") int id);

    @Results(id = "articleByLabel",
            value = {
                    @Result(property = "article.art_id", column = "art_id", id = true),
                    @Result(property = "article.art_title", column = "art_title"),
                    @Result(property = "article.art_summary", column = "art_summary"),
                    @Result(property = "article.art_content", column = "art_content"),
                    @Result(property = "article.art_views", column = "art_views"),
                    @Result(property = "article.art_date", column = "art_date"),
                    @Result(property = "article.art_image", column = "art_image"),
                    @Result(property = "category", many =@Many(select="selectCategoryById"), column = "art_id"),
                    @Result(property = "labels", many =@Many(select="selectLabelsById"), column = "art_id"),
            })
    @Select("SELECT blog_article.* FROM \n" +
            "(blog_article LEFT JOIN blog_art_label ON blog_article.art_id=blog_art_label.art_id ) \n" +
            "LEFT JOIN blog_label \n" +
            "ON blog_label.label_id=blog_art_label.label_id\n" +
            "${ew.customSqlSegment}")
    IPage<REArticle> getArticleByLabel(IPage<REArticle> iREArticlePage, @Param(Constants.WRAPPER) QueryWrapper<REArticle> wrapper);

    /**
     * 获取浏览量前三的文章
     * @return
     */
    @Select("SELECT art_id,art_title,art_image\n" +
            "FROM blog_article\n" +
            "ORDER BY art_views DESC\n" +
            "LIMIT 3")
    List<Article> getFeatureArticle();
}
