package com.wormflesh.server.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Description: 返回用类--用于返回前端数据（Article、Category、Label）
 * @Author: wormflesh
 * @Date: Created in 22:50 2022/4/28
 */
@Data
public class REArticle {

    private Article article;

    private Category category;

    private List<Label> labels;
}
