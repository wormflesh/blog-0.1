package com.wormflesh.experiment.controller;

import com.wormflesh.experiment.config.result.Result;
import com.wormflesh.experiment.utils.ConvertCsvToHtml;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description: 用于实验小项目的接口
 * @Author: wormflesh
 * @Date: Created in 17:32 2022/5/4
 */
@RestController
@RequestMapping("/api/experiment")
public class ExperimentController {
    /**
     * 时间格式化
     */
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");



    @PostMapping(path = "/csvToHtml")
    public Result csvToHtml(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        String halfUrl = ConvertCsvToHtml.uploadFile(file);
        //协议 :// ip地址 ：端口号 / 文件目录(/images/2020/03/15/xxx.jpg)
        String url = request.getScheme() + "://" + request.getServerName() + ":" + halfUrl;

        return Result.success(url);
    }
}
