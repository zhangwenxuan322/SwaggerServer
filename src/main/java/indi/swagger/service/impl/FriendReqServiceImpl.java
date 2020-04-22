package indi.swagger.service.impl;

import indi.swagger.mapper.FriendMapper;
import indi.swagger.service.FriendReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    FriendMapper friendMapper;
}
