package indi.swagger.controller;

import indi.swagger.entity.AppPackage;
import indi.swagger.service.AppPackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 上传apk
     *
     * @param apk
     * @param apkCode
     * @param apkName
     * @param apkDesc
     * @return
     */
    @PostMapping("apk")
    public Map<String, Object> postApk(@RequestParam MultipartFile apk,
                                       @RequestParam String apkCode,
                                       @RequestParam String apkName,
                                       @RequestParam String apkDesc) {
        logger.info("开始上传apk，apk名：" + apkName);
        Map<String, Object> map = new HashMap<>();
        AppPackage appPackage = new AppPackage();
        appPackage.setApkCode(apkCode);
        appPackage.setApkName(apkName);
        appPackage.setApkDesc(apkDesc);
        try (InputStream inputStream = apk.getInputStream()) {
            Path uploadPath = Paths.get(uploadPathStr);
            if (!uploadPath.toFile().exists()) {
                uploadPath.toFile().mkdirs();
            }
            Files.copy(inputStream, Paths.get(uploadPathStr).resolve(apkName), StandardCopyOption.REPLACE_EXISTING);
            appPackageService.insertPackageInfo(appPackage);
            map.put("code", "200");
            map.put("message", "success");
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code", "404");
            map.put("message", "io_exception");
            return map;
        }
    }

    /**
     * 获取最新版本apk
     *
     * @return
     */
    @GetMapping("apk/latest")
    public AppPackage getLatestApk() {
        return appPackageService.selectLatestApk();
    }
}
