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
    public Map<String, Object> friendFilter(@RequestParam Integer mainUserId,
                                            @RequestParam Integer friendUserId) {
        logger.info("开始查询好友关系：" + mainUserId + "--" + friendUserId);
        Map<String, Integer> map = new HashMap<>();
        map.put("mainUserId", mainUserId);
        map.put("friendUserId", friendUserId);
        FriendsManager friendsManager = friendService.selectFriendsByMainAndFriend(map);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("friend", friendsManager);
        logger.info("关系查询结束：" + resMap);
        return resMap;
    }

    /**
     * 建立好友关系
     *
     * @param friendsManager
     * @return
     */
    @PostMapping("friend/making")
    public Map<String, String> friendMaking(@RequestBody FriendsManager friendsManager) {
        logger.info("开始建立好友关系：" + friendsManager);
        int mainId = friendsManager.getMainUserId();
        int friendId = friendsManager.getFriendUserId();
        friendService.createFriendConnection(mainId, friendId);
        Map<String, String> map = new HashMap<>();
        map.put("code", "400");
        map.put("message", "success");
        return map;
    }

    /**
     * 修改好友信息，包括备注以及分组
     *
     * @param friendsManager
     * @return
     */
    @PutMapping("friend/modification")
    public Map<String, String> friendModification(@RequestBody FriendsManager friendsManager) {
        logger.info("开始修改好友关系：" + friendsManager);
        friendService.modifyFriendRelation(friendsManager);
        Map<String, String> map = new HashMap<>();
        map.put("code", "400");
        map.put("message", "success");
        return map;
    }

    /**
     * 解除好友关系
     *
     * @param friendsManager
     * @return
     */
    @DeleteMapping("friend/release")
    public Map<String, String> friendRelease(@RequestBody FriendsManager friendsManager) {
        logger.info("开始解除好友关系：" + friendsManager);
        friendService.deleteFriends(friendsManager);
        Map<String, String> map = new HashMap<>();
        map.put("code", "400");
        map.put("message", "success");
        return map;
    }
}
