package indi.swagger.service.impl;

import indi.swagger.entity.NearbyUser;
import indi.swagger.mapper.NearbyMapper;
import indi.swagger.service.NearbyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: Swagger
 * @description:
 * @author: 张文轩
 * @create: 2020-03-22 09:49
 **/
@Service
public class NearbyServiceImpl implements NearbyService {
    Logger logger = LoggerFactory.getLogger(NearbyService.class);
    @Autowired
    NearbyMapper nearbyMapper;

    @Override
    public List<NearbyUser> getNearbyUsers(Map<String, Object> map) {
        logger.info("调用附近用户查找服务：" + map);
        return nearbyMapper.getNearbyUsers(map);
    }
}
