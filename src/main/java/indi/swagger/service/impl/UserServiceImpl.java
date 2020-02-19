package indi.swagger.service.impl;

import indi.swagger.entity.UserProfile;
import indi.swagger.mapper.UserMapper;
import indi.swagger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Swagger
 * @description: 用户服务实现类
 * @author: 张文轩
 * @create: 2020-02-19 13:49
 **/
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;
    @Override
    public UserProfile selectUserByPhone(String phone) {
        logger.info("根据手机号查询用户信息");
        return userMapper.selectUserByPhone(phone);
    }

    @Override
    public UserProfile selectUserBySwaggerId(String swaggerId) {
        logger.info("根据SwaggerId查询用户信息");
        return userMapper.selectUserBySwaggerId(swaggerId);
    }
}
