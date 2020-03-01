package indi.swagger.service;

import indi.swagger.entity.UserLoginInfo;
import indi.swagger.entity.UserProfile;
import io.rong.models.response.TokenResult;

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

    /**
     * 注册用户
     * @param userProfile
     * @return
     */
    TokenResult registerUser(UserProfile userProfile) throws Exception;

    /**
     * 修改用户密码
     * @param phone
     * @param password
     * @return
     */
    Boolean upadteUserPassword(String phone, String password);

    /**
     * 修改用户登录信息
     * @param userLoginInfo
     */
    void updateUserLoginInfoById(UserLoginInfo userLoginInfo);
}
