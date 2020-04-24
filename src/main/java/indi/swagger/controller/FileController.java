package indi.swagger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
 * @description: 文件控制器
 * @author: 张文轩
 * @create: 2020-03-04 10:50
 **/
@RestController
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    @Value("${upload.file.portrait-path}")
    private String uploadPathStr;

    /**
     * 上传用户头像
     *
     * @param file
     * @param filename
     * @return
     */
    @PostMapping("user/portrait")
    public Map<String, Object> upload(@RequestParam MultipartFile file, @RequestParam String filename) {
        logger.info("开始上传头像，文件名：" + filename);
        Map<String, Object> map = new HashMap<>();
        if (file == null || file.isEmpty() || filename == null || filename.isEmpty()) {
            map.put("code", "404");
            map.put("message", "file_error");
            return map;
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path uploadPath = Paths.get(uploadPathStr);
            if (!uploadPath.toFile().exists()) {
                uploadPath.toFile().mkdirs();
            }
            Files.copy(inputStream, Paths.get(uploadPathStr).resolve(filename), StandardCopyOption.REPLACE_EXISTING);
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
     * 下载用户头像
     * @param filename
     * @return
     */
    @GetMapping("user/portrait/{filename}")
    public ResponseEntity<FileSystemResource> download(@PathVariable(value = "filename") String filename) {
        logger.info("开始下载头像，文件名：" + filename);
        if (filename == null || filename.isEmpty()) {
            return null;
        }
        File file = Paths.get(uploadPathStr).resolve(filename).toFile();
        if (file.exists() && file.canRead()) {
            return ResponseEntity.ok()
                    .contentType(file.getName().contains(".jpg") ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG)
                    .body(new FileSystemResource(file));
        } else {
            return null;
        }
    }
}
