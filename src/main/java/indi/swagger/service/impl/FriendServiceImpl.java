package indi.swagger.service.impl;

import indi.swagger.mapper.FriendMapper;
import indi.swagger.service.FriendService;
import indi.swagger.service.NearbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
