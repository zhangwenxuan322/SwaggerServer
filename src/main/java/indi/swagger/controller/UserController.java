package indi.swagger.controller;

import indi.swagger.entity.UserProfile;
import indi.swagger.service.UserService;
import io.rong.models.response.TokenResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param phone
     * @return
     */
    @GetMapping("user/phone/{phone}")
    public Map<String, Object> getUserByPhone(@PathVariable(value = "phone") String phone) {
        logger.info("调用手机号查询用户信息服务");
        UserProfile userProfile = userService.selectUserByPhone(phone);
        Map<String, Object> map = new HashMap<>();
        if (userProfile == null) {
            map.put("code", 404);
            map.put("use_profile", null);
        }else {
            map.put("code", 200);
            map.put("user_profile", userProfile);
        }
        return map;
    }

    /**
     * 根据SwaggerId查询用户信息
     * @param swaggerId
     * @return
     */
    @GetMapping("user/swagger_id/{swaggerId}")
    public Map<String, Object> gerUserBySwaggerId(@PathVariable(value = "swaggerId") String swaggerId) {
        logger.info("调用SwaggerId查询用户信息服务");
        UserProfile userProfile = userService.selectUserBySwaggerId(swaggerId);
        Map<String, Object> map = new HashMap<>();
        if (userProfile == null) {
            map.put("code", 404);
            map.put("use_profile", null);
        }else {
            map.put("code", 200);
            map.put("user_profile", userProfile);
        }
        return map;
    }

    /**
     * 注册用户
     * @return
     */
    @PostMapping("user")
    public Map<String, Object> postUser(@RequestBody UserProfile userProfile) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 请求参数有误
        if (userProfile == null) {
            map.put("code", 406);
            map.put("state", "not_acceptable");
            return map;
        }
        // 判断用户是否存在
        if (userService.selectUserByPhone(userProfile.getUserPhone()) != null
                || userService.selectUserBySwaggerId(userProfile.getUserSwaggerId()) != null) {
            map.put("code", 415);
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
}
