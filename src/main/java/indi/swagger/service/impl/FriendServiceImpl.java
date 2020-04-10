package indi.swagger.service.impl;

import indi.swagger.entity.FriendsManager;
import indi.swagger.mapper.FriendMapper;
import indi.swagger.service.FriendService;
import indi.swagger.service.NearbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 好友关系服务层
 * @author: 张文轩
 * @create: 2020-04-10 16:57
 **/
@Service
public class FriendServiceImpl implements FriendService {
    Logger logger = LoggerFactory.getLogger(FriendService.class);
    @Autowired
    FriendMapper friendMapper;

    @Override
    public FriendsManager selectFriendsByMainAndFriend(Map<String, Integer> map) {
        logger.info("调用好友关系查询服务");
        return friendMapper.selectFriendsByMainAndFriend(map);
    }

    @Override
    @Transactional
    public void createFriendConnection(int mainId, int friendId) {
        logger.info("调用好友关系创建服务");
        Map<String, Integer> map = new HashMap<>();
        map.put("mainId", mainId);
        map.put("friendId", friendId);
        friendMapper.addFriends(map);
        map.clear();
        map.put("mainId", friendId);
        map.put("friendId", mainId);
        friendMapper.addFriends(map);
    }

    @Override
    public void modifyFriendRelation(FriendsManager friendsManager) {
        logger.info("调用好友关系信息修改服务");
        friendMapper.updateFriendRelation(friendsManager);
    }

    @Override
    @Transactional
    public void deleteFriends(FriendsManager friendsManager) {
        logger.info("调用删除好友服务");
        Map<String, Integer> map = new HashMap<>();
        map.put("mainUserId", friendsManager.getMainUserId());
        map.put("friendUserId", friendsManager.getFriendUserId());
        friendMapper.deleteFriends(map);
        map.clear();
        map.put("mainUserId", friendsManager.getFriendUserId());
        map.put("friendUserId", friendsManager.getMainUserId());
        friendMapper.deleteFriends(map);
    }
}
