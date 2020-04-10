package indi.swagger.controller;

import indi.swagger.entity.FriendsManager;
import indi.swagger.service.FriendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 好友管理控制器
 * @author: 张文轩
 * @create: 2020-04-10 16:23
 **/
@RestController
public class FriendController {
    Logger logger = LoggerFactory.getLogger(FriendController.class);
    @Autowired
    FriendService friendService;

    /**
     * 好友过滤器，判断两个用户是否为好友
     *
     * @param mainUserId
     * @param friendUserId
     * @return
     */
    @GetMapping("friend/filter")
    public Map<String, String> friendFilter(@RequestParam Integer mainUserId,
                                            @RequestParam Integer friendUserId) {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    /**
     * 建立好友关系
     *
     * @param friendsManager
     * @return
     */
    @PostMapping("friend/making")
    public Map<String, String> friendMaking(@RequestBody FriendsManager friendsManager) {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    /**
     * 修改好友信息，包括备注以及分组
     *
     * @param friendsManager
     * @return
     */
    @PutMapping("friend/modification")
    public Map<String, String> friendModification(@RequestParam FriendsManager friendsManager) {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    /**
     * 解除好友关系
     *
     * @param friendsManager
     * @return
     */
    @DeleteMapping("friend/release")
    public Map<String, String> friendRelease(@RequestParam FriendsManager friendsManager) {
        Map<String, String> map = new HashMap<>();
        return map;
    }
}
