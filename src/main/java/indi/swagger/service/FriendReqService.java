package indi.swagger.service;

import indi.swagger.entity.FriendRequest;

public interface FriendReqService {
    /**
     * 根据主从用户id查询请求
     *
     * @param friendRequest
     * @return
     */
    FriendRequest selectRequestByMainAndSubId(FriendRequest friendRequest);

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
