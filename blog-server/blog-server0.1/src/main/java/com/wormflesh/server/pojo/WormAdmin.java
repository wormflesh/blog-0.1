package com.wormflesh.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("blog_worm_admin")
@ApiModel(value="WormAdmin对象", description="")
public class WormAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "管理员id")
    @TableId(value = "ad_id", type = IdType.AUTO)
    private Integer ad_id;

    @ApiModelProperty(value = "管理员头像")
    private String ad_profile;

    @ApiModelProperty(value = "管理员昵称")
    private String ad_nickname;

    @ApiModelProperty(value = "管理员账号")
    private String ad_account;

    @ApiModelProperty(value = "管理员密码")
    private String ad_passwd;

    @ApiModelProperty(value = "管理员状态")
    private Integer ad_status;

    @ApiModelProperty(value = "token")
    private String token;

}
