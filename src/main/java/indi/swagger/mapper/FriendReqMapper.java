package indi.swagger.mapper;

import indi.swagger.entity.FriendRequest;
import org.springframework.stereotype.Repository;

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
}
