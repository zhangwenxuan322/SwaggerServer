package indi.swagger.controller;

import indi.swagger.service.FriendReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Swagger
 * @description: 好友请求控制器
 * @author: 张文轩
 * @create: 2020-04-22 14:07
 **/
@RestController
public class FriendReqController {
    Logger logger = LoggerFactory.getLogger(FriendReqController.class);
    @Autowired
    FriendReqService friendReqService;
}
