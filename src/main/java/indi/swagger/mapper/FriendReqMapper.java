package indi.swagger.mapper;

import indi.swagger.entity.FriendRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FriendReqMapper {

    /**
     * 根据主从用户id查询请求信息
     *
     * @param map
     * @return
     */
    FriendRequest selectRequestByMainAndSubId(Map<String, Object> map);

    /**
     * 根据主用户id查询所有待处理的请求
     *
     * @param map
     * @return
     */
    List<FriendRequest> selectAllReqsByMain(Map<String, Object> map);

    /**
     * 新增好友请求信息
     *
     * @param map
     */
    void insertRequestInfo(Map<String, Object> map);

    /**
     * 修改好友请求信息
     *
     * @param map
     */
    void updateRequestInfo(Map<String, Object> map);

    /**
     * 删除好友请求信息
     *
     * @param map
     */
    void deleteRequestInfo(Map<String, Integer> map);
}
