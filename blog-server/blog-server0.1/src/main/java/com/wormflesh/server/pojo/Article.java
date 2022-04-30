package com.wormflesh.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_article")
@ApiModel(value="Article对象", description="")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章id")
    @TableId(value = "art_id", type = IdType.AUTO)
    private Integer art_id;

    @ApiModelProperty(value = "文章标题")
    private String art_title;

    @ApiModelProperty(value = "文章概述")
    private String art_summary;

    @ApiModelProperty(value = "文章内容地址")
    private String art_content;

    @ApiModelProperty(value = "浏览量")
    private Integer art_views;

    @ApiModelProperty(value = "文章日期")
    private LocalDateTime art_date;

    @ApiModelProperty(value = "文章封面")
    private String art_image;


}
