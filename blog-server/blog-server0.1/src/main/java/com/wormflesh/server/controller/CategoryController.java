package com.wormflesh.server.controller;


import com.wormflesh.server.config.result.Result;
import com.wormflesh.server.pojo.Category;
import com.wormflesh.server.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wormflesh
 * @since 2022-04-28
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService icategoryService;

    @GetMapping("/getCategorys")
    public Result getCategorys(){
        List<Category> categorys = icategoryService.list();
        return Result.success(categorys);
    }
}
