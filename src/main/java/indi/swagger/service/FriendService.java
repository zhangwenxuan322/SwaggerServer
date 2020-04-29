package indi.swagger.service;

import indi.swagger.entity.FriendsManager;

import java.util.List;
import java.util.Map;

public interface FriendService {
    /**
     * 根据主从用户id查询好友关系
     *
     * @param map
     * @return
     */
    FriendsManager selectFriendsByMainAndFriend(Map<String, Integer> map);

    /**
     * 建立好友关系
     *
     * @param mainId
     * @param friendId
     */
    void createFriendConnection(int mainId, int friendId);

    /**
     * 修改好友关系信息
     *
     * @param friendsManager
     */
    void modifyFriendRelation(FriendsManager friendsManager);

    /**
     * 删除好友
     *
     * @param friendsManager
     */
    void deleteFriends(FriendsManager friendsManager);

    /**
     * 获取好友列表
     *
     * @param userId
     */
    List<FriendsManager> getFriendList(int userId);
}
