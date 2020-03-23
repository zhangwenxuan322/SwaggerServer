package indi.swagger.mapper;

import indi.swagger.entity.NearbyUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NearbyMapper {
    /**
     * 获取附近的用户
     *
     * @param map
     * @return
     */
    List<NearbyUser> getNearbyUsers(Map<String, Object> map);
}
