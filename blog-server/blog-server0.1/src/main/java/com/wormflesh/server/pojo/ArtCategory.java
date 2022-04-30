package com.wormflesh.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 文章分类设置表
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_art_category")
@ApiModel(value="ArtCategory对象", description="文章分类设置表")
public class ArtCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer art_id;

    private Integer cate_id;


}
