package indi.swagger.controller;

import indi.swagger.entity.UserProfile;
import indi.swagger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 用户控制层
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
}
