package indi.swagger.service.impl;

import indi.swagger.entity.AppPackage;
import indi.swagger.mapper.AppPackageMapper;
import indi.swagger.service.AppPackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Swagger
 * @description: App安装包服务实现类
 * @author: 张文轩
 * @create: 2020-04-24 14:47
 **/
@Service
public class AppPackageServiceImpl implements AppPackageService {
    Logger logger = LoggerFactory.getLogger(AppPackageService.class);
    @Autowired
    AppPackageMapper appPackageMapper;

    @Override
    public void insertPackageInfo(AppPackage appPackage) {
        logger.info("调用apk上传服务");
        appPackageMapper.insertPackageInfo(appPackage);
    }
}
