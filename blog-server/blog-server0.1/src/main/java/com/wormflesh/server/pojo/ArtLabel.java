package com.wormflesh.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("blog_art_label")
@ApiModel(value="ArtLabel对象", description="")
public class ArtLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer art_id;

    private Integer label_id;


}
