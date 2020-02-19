package indi.swagger.service;

import indi.swagger.entity.UserProfile;

/**
 * 用户服务接口
 */
public interface UserService {
    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    UserProfile selectUserByPhone(String phone);

    /**
     * 根据SwaggerId查询用户信息
     * @param swaggerId
     * @return
     */
    UserProfile selectUserBySwaggerId(String swaggerId);
}
