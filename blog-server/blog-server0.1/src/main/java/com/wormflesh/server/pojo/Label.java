package com.wormflesh.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
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
@TableName("blog_label")
@ApiModel(value="Label对象", description="")
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "label_id", type = IdType.AUTO)
    private Integer label_id;

    private String label_name;

    private String label_description;

    private LocalDateTime label_date;


}
