package indi.swagger.controller;

import indi.swagger.constant.Constant;
import indi.swagger.entity.Test;
import indi.swagger.service.TestService;
import io.rong.RongCloud;
import io.rong.methods.user.User;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: Hello World
 * @author: 张文轩
 * @create: 2020-02-03 14:43
 **/
@RestController
public class HelloController {
    @Autowired
    TestService testService;
    RongCloud rongCloud = Constant.RONG_CLOUD;
    /**
     * 测试Hello World
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    /**
     * 返回Json测试
     *
     * @return
     */
    @RequestMapping("/getMap")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("data", "Hello World!");
        return map;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("getTest/{id}")
    public Map<String, Object> getTest(@PathVariable int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Test test = testService.selectById(id);
        map.put("id", test.getId());
        map.put("name", test.getName());
        return map;
    }

    /**
     * API 文档: http://www.rongcloud.cn/docs/server_sdk_api/user/user.html#register
     *
     * 注册用户，生成用户在融云的唯一身份标识 Token
     */
    @RequestMapping("register")
    public Map<String, Object> register() throws Exception {
        User user = rongCloud.user;
        UserModel userModel = new UserModel()
                .setId("hHjap87")
                .setName("RongCloud")
                .setPortrait("http://www.rongcloud.cn/images/logo.png");
        TokenResult result = user.register(userModel);
        Map<String, Object> map = new HashMap<>();
        map.put("code", result.getCode());
        map.put("token", result.getToken());
        map.put("userId", result.getUserId());
        map.put("errorMessage", result.getErrorMessage());
        return map;
    }


}
