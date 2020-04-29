package indi.swagger.mapper;

import indi.swagger.entity.FriendsManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FriendMapper {
    /**
     * 根据主从用户id查询好友关系
     *
     * @param map
     * @return
     */
    FriendsManager selectFriendsByMainAndFriend(Map<String, Integer> map);

    /**
     * 创建好友关系
     *
     * @param map
     */
    void addFriends(Map<String, Integer> map);

    /**
     * 修改好友关系信息
     *
     * @param friendsManager
     */
    void updateFriendRelation(FriendsManager friendsManager);

    /**
     * 解除好友关系
     *
     * @param map
     */
    void deleteFriends(Map<String, Integer> map);

    /**
     * 获取好友列表
     *
     * @param userId
     * @return
     */
    List<FriendsManager> getFriendList(int userId);
}
