package indi.swagger.controller;

import indi.swagger.service.AppPackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Swagger
 * @description: App安装包控制器
 * @author: 张文轩
 * @create: 2020-04-24 14:48
 **/
@RestController
public class AppPackageController {
    Logger logger = LoggerFactory.getLogger(AppPackageController.class);
    @Autowired
    AppPackageService appPackageService;
    @Value("${upload.file.apk-path}")
    private String uploadPathStr;
}
