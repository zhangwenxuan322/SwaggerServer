package indi.swagger.service;

import indi.swagger.entity.FriendRequest;
import indi.swagger.mapper.FriendReqMapper;

import java.util.List;
import java.util.Map;

public interface FriendReqService {
    /**
     * 根据主从用户id查询请求
     *
     * @param friendRequest
     * @return
     */
    FriendRequest selectRequestByMainAndSubId(FriendRequest friendRequest);

    /**
     * 根据主用户id查询所有待处理的请求
     *
     * @param mainId
     * @return
     */
    List<FriendRequest> selectAllReqsByMain(int mainId);

    /**
     * 新增好友请求信息
     *
     * @param friendRequest
     */
    void insertRequestInfo(FriendRequest friendRequest);

    /**
     * 修改好友请求信息
     *
     * @param friendRequest
     */
    void updateRequestInfo(FriendRequest friendRequest);
}
