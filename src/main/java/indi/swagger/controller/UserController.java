package indi.swagger.controller;

import indi.swagger.entity.UserLoginInfo;
import indi.swagger.entity.UserProfile;
import indi.swagger.service.UserService;
import indi.swagger.util.EncryptionUtil;
import indi.swagger.util.SystemUtil;
import io.rong.models.response.TokenResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 用户控制器
 * @author: 张文轩
 * @create: 2020-02-19 15:20
 **/
@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    /**
     * 根据手机号查询用户信息
     *
     * @param phone
     * @return
     */
    @GetMapping("user/phone/{phone}")
    public Map<String, Object> getUserByPhone(@PathVariable(value = "phone") String phone) {
        logger.info("调用手机号查询用户信息服务");
        Map<String, Object> map = new HashMap<>();
        UserProfile userProfile = userService.selectUserByPhone(phone);
        if (userProfile == null) {
            map.put("code", "404");
            map.put("message", "user_not_exist");
        } else {
            map.put("code", "200");
            map.put("userProfile", userProfile);
        }
        return map;
    }

    /**
     * 根据SwaggerId查询用户信息
     *
     * @param swaggerId
     * @return
     */
    @GetMapping("user/swaggerId/{swaggerId}")
    public Map<String, Object> gerUserBySwaggerId(@PathVariable(value = "swaggerId") String swaggerId) {
        logger.info("调用SwaggerId查询用户信息服务");
        Map<String, Object> map = new HashMap<>();
        UserProfile userProfile = userService.selectUserBySwaggerId(swaggerId);
        if (userProfile == null) {
            map.put("code", "404");
            map.put("message", "user_not_exist");
        } else {
            map.put("code", "200");
            map.put("userProfile", userProfile);
        }
        return map;
    }

    /**
     * 用户注册
     *
     * @return
     */
    @PostMapping("user")
    public Map<String, Object> postUser(@RequestBody UserProfile userProfile) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 请求参数有误
        if (userProfile == null) {
            map.put("code", "406");
            map.put("state", "not_acceptable");
            return map;
        }
        // 判断用户是否存在
        if (userService.selectUserByPhone(userProfile.getUserPhone()) != null
                || userService.selectUserBySwaggerId(userProfile.getUserSwaggerId()) != null) {
            map.put("code", "415");
            map.put("state", "user_exist");
            return map;
        }
        // 调用注册服务
        logger.info("调用用户注册服务");
        TokenResult result = userService.registerUser(userProfile);
        map.put("code", result.getCode());
        map.put("user_id", result.getUserId());
        map.put("token", result.getToken());
        map.put("error_message", result.getErrorMessage());
        return map;
    }


    /**
     * 用户登录
     *
     * @param account
     * @param password
     * @return
     */
    @GetMapping("user/auth")
    public Map<String, Object> userLogin(@RequestParam(value = "account") String account,
                                         @RequestParam(value = "password") String password,
                                         @RequestParam(value = "ip") String ip,
                                         @RequestParam(value = "place") String place) {
        logger.info("账号：" + account + "开始登录");
        Map<String, Object> map = new HashMap<>();
        if (account == null || password == null) {
            map.put("code", "404");
            map.put("message", "null_paramaters");
            return map;
        }
        UserProfile userProfile;
        // 判断登录方式
        if (SystemUtil.isMobileNO(account)) {
            // 手机号登录
            userProfile = userService.selectUserByPhone(account);
        } else {
            // SwaggerId登录
            userProfile = userService.selectUserBySwaggerId(account);
        }
        if (userProfile == null) {
            map.put("code", "404");
            map.put("message", "user_not_exist");
            return map;
        }
        // 验证密码
        String encryPwd = EncryptionUtil.SHA256(password);
        if (userProfile.getUserPassword().equals(encryPwd)) {
            // 密码正确
            map.put("code", "200");
            map.put("token", userProfile.getUserToken());
            // 更新用户登录信息表
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.setLoginIp(ip);
            userLoginInfo.setLoginPlace(place);
            userLoginInfo.setLoginTime(new Date());
            userLoginInfo.setIsLogout(0);
            userLoginInfo.setLoginId(userProfile.getUserLoginInfoId());
            userService.updateUserLoginInfoById(userLoginInfo);
        } else {
            // 密码错误
            map.put("code", "404");
            map.put("message", "wrong_password");
        }
        return map;
    }

    /**
     * 修改用户密码
     *
     * @param phone
     * @param password
     * @return
     */
    @PutMapping("user/info")
    public Map<String, Object> changePassword(@RequestParam String phone, @RequestParam String password) {
        logger.info("手机号：" + phone + "开始修改密码");
        Map<String, Object> map = new HashMap<>();
        logger.info("调用修改密码服务");
        Boolean status = userService.upadteUserPassword(phone, password);
        if (status) {
            map.put("code", "200");
            map.put("message", "success");
            logger.info("修改成功");
        } else {
            map.put("code", "404");
            map.put("message", "user_not_exist");
            logger.info("用不存在，修改失败");
        }
        return map;
    }
}
