package com.wormflesh.server.controller;


import com.wormflesh.server.config.result.Result;
import com.wormflesh.server.pojo.Label;
import com.wormflesh.server.service.ILabelService;
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
@RequestMapping("/api/label")
public class LabelController {

    @Autowired
    private ILabelService iLabelService;

    @GetMapping("/getLabels")
    public Result getLabels() {
        List<Label> labels = iLabelService.list();
        return Result.success(labels);
    }
}
