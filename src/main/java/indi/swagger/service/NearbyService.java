package indi.swagger.service;

import indi.swagger.entity.NearbyUser;

import java.util.List;
import java.util.Map;

public interface NearbyService {
    /**
     * 获取附近的用户
     *
     * @param map
     * @return
     */
    List<NearbyUser> getNearbyUsers(Map<String, Object> map);
}
