package indi.swagger.controller;

import indi.swagger.entity.NearbyUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: Swagger
 * @description: 附近的人控制器
 * @author: 张文轩
 * @create: 2020-03-22 09:50
 **/
@RestController
public class NearbyController {

    /**
     * 获取指定坐标附近用户列表
     *
     * @param place
     * @return
     */
    @GetMapping("nearby/list")
    public List<NearbyUser> getNearbyList(@RequestParam String place) {
        return null;
    }
}
