package indi.swagger.service.impl;

import indi.swagger.entity.FriendRequest;
import indi.swagger.mapper.FriendReqMapper;
import indi.swagger.service.FriendReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 好友请求服务实现类
 * @author: 张文轩
 * @create: 2020-04-22 14:06
 **/
@Service
public class FriendReqServiceImpl implements FriendReqService {
    Logger logger = LoggerFactory.getLogger(FriendReqService.class);
    @Autowired
    FriendReqMapper friendReqMapper;

    @Override
    public FriendRequest selectRequestByMainAndSubId(FriendRequest friendRequest) {
        logger.info("调用查询好友请求服务");
        Map<String, Object> map = new HashMap<>();
        map.put("mainId", friendRequest.getReqMainId());
        map.put("subId", friendRequest.getReqSubId());
        return friendReqMapper.selectRequestByMainAndSubId(map);
    }

    @Override
    public List<FriendRequest> selectAllReqsByMain(int mainId) {
        logger.info("调用查询所有未处理请求服务");
        Map<String, Object> map = new HashMap<>();
        map.put("mainId", mainId);
        return friendReqMapper.selectAllReqsByMain(map);
    }

    @Override
    @Transactional
    public void insertRequestInfo(FriendRequest friendRequest) {
        logger.info("调用新增好友请求服务");
        Map<String, Object> map = new HashMap<>();
        map.put("mainId", friendRequest.getReqMainId());
        map.put("subId", friendRequest.getReqSubId());
        map.put("msg", friendRequest.getReqMsg());
        friendReqMapper.insertRequestInfo(map);
    }

    @Override
    public void updateRequestInfo(FriendRequest friendRequest) {
        logger.info("调用修改好友请求服务");
        Map<String, Object> map = new HashMap<>();
        map.put("reqId", friendRequest.getReqId());
        map.put("reqCode", friendRequest.getReqCode());
        friendReqMapper.updateRequestInfo(map);
    }
}
