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

import java.util.Date;

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

    @Override
    public UserProfile selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Transactional
    @Override
    public TokenResult registerUser(UserProfile userProfile) throws Exception {
        logger.info("开始用户注册服务，注册用户：" + userProfile.toString());
        // 创建Swagger账户
        // 密码加密
        userProfile.setUserPassword(EncryptionUtil.SHA256(userProfile.getUserPassword()));
        userProfile.setUserCreateTime(new Date());
        userMapper.insertUser(userProfile);
        // 判断用户注册的方式
        if (!"".equals(userProfile.getUserPhone())) {
            // 手机号注册
            userProfile = userMapper.selectUserByPhone(userProfile.getUserPhone());
        } else if (!"".equals(userProfile.getUserSwaggerId())) {
            // SwaggerId注册
            userProfile = userMapper.selectUserBySwaggerId(userProfile.getUserSwaggerId());
        }
        // 创建登录信息
        UserLoginInfo userLoginInfo = new UserLoginInfo("", null, 1, userProfile.getUserId(), 0.0, 0.0, null);
        userMapper.insertUserLoginInfo(userLoginInfo);
        int loginId = userMapper.selectLoginInfoByUserId(userProfile.getUserId());
        userProfile.setUserLoginInfoId(loginId);
        // 创建融云账户
        User user = rongCloud.user;
        UserModel userModel = new UserModel()
                .setId("swaggertestid" + String.valueOf(userProfile.getUserId())) // TODO:上线后修改
                .setName(userProfile.getUserName())
                .setPortrait("http://106.15.91.232:8080/swagger/user/portrait/" + userProfile.getUserPortrait());
        TokenResult result = user.register(userModel);
        userProfile.setUserToken(result.getToken());
        userMapper.updateUserById(userProfile);
        logger.info("完成Swagger账户创建");
        logger.info("完成融云账户创建");
        return result;
    }

    @Transactional
    @Override
    public Boolean upadteUserPassword(String phone, String password) {
        logger.info("开始修改密码");
        UserProfile userProfile = userMapper.selectUserByPhone(phone);
        if (userProfile == null) {
            // 用户不存在
            return false;
        }
        // 密码加密
        userProfile.setUserPassword(EncryptionUtil.SHA256(password));
        userMapper.updateUserPasswordById(userProfile);
        return true;
    }

    @Override
    public void updateUserLoginInfoById(UserLoginInfo userLoginInfo) {
        userMapper.updateUserLoginInfoById(userLoginInfo);
    }

    @Transactional
    @Override
    public void logout(int loginId) {
        logger.info("开始修改用户退出状态");
        UserLoginInfo userLoginInfo = userMapper.selectLoginInfoById(loginId);
        userLoginInfo.setIsLogout(1);
        userMapper.updateUserLoginInfoById(userLoginInfo);
        logger.info("退出状态修改成功");
    }
}
