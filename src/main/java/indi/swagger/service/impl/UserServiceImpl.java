package indi.swagger.service.impl;

import indi.swagger.constant.Constant;
import indi.swagger.entity.UserLoginInfo;
import indi.swagger.entity.UserProfile;
import indi.swagger.mapper.UserMapper;
import indi.swagger.service.UserService;
import indi.swagger.util.EncryptionUtil;
import io.rong.RongCloud;
import io.rong.methods.user.User;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Swagger
 * @description: 用户服务实现类
 * @author: 张文轩
 * @create: 2020-02-19 13:49
 **/
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    RongCloud rongCloud = Constant.RONG_CLOUD;
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

    @Transactional
    @Override
    public TokenResult registerUser(UserProfile userProfile) {
        logger.info("开始用户注册服务，注册用户：" + userProfile.toString());
        // 创建Swagger账户
        // 密码加密
        userProfile.setUserPassword(EncryptionUtil.SHA256(userProfile.getUserPassword()));
        userMapper.insertUser(userProfile);
        // 判断用户注册的方式
        if (!userProfile.getUserPhone().equals("")) {
            // 手机号注册
            userProfile = userMapper.selectUserByPhone(userProfile.getUserPhone());
        } else {
            // SwaggerId注册
            userProfile = userMapper.selectUserBySwaggerId(userProfile.getUserSwaggerId());
        }
        // 创建登录信息
        UserLoginInfo userLoginInfo = new UserLoginInfo("", "", null, 0, userProfile.getUserId());
        userMapper.insertUserLoginInfo(userLoginInfo);
        int loginId = userMapper.selectLoginInfoByUserId(userProfile.getUserId());
        userProfile.setUserLoginInfoId(loginId);
        userMapper.updateUserById(userProfile);
        logger.info("完成Swagger账户创建");
        // 创建融云账户
        User user = rongCloud.user;
        UserModel userModel = new UserModel()
                .setId(String.valueOf(userProfile.getUserId()))
                .setName(userProfile.getUserName())
                .setPortrait(userProfile.getUserPortrait());
        TokenResult result = null;
        try {
            result = user.register(userModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("完成融云账户创建");
        return result;
    }
}
