package indi.swagger.service.impl;

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
}
