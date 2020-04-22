package indi.swagger.controller;

import indi.swagger.entity.FriendRequest;
import indi.swagger.service.FriendReqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 发布好友请求
     *
     * @param friendRequest
     * @return
     */
    @PostMapping("request")
    public Map<String, Object> postRequest(@RequestBody FriendRequest friendRequest) {
        logger.info("开始发布好友请求，信息：" + friendRequest);
        Map<String, Object> resMap = new HashMap<>();
        // 判断请求是否存在
        FriendRequest dealReq = friendReqService.selectRequestByMainAndSubId(friendRequest);
        if (dealReq != null) {
            // 判断是否之前被拒
            if (dealReq.getReqCode() == 2) {
                // 重置状态
                dealReq.setReqCode(0);
                friendReqService.updateRequestInfo(dealReq);
                resMap.put("code", "200");
                resMap.put("message", "success");
            } else {
                resMap.put("code", "404");
                resMap.put("message", "request_exist");
            }
        } else {
            // 请求不存在则创建请求
            friendReqService.insertRequestInfo(friendRequest);
            resMap.put("code", "200");
            resMap.put("message", "success");
        }
        return resMap;
    }
}
