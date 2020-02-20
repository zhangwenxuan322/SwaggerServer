package indi.swagger.mapper;

import indi.swagger.entity.UserLoginInfo;
import indi.swagger.entity.UserProfile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户相关mapper
 */
@Repository
public interface UserMapper {
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
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    UserProfile selectUserById(int userId);

    /**
     * 新增用户
     * @param userProfile
     */
    void insertUser(UserProfile userProfile);

    /**
     * 新增用户登录信息
     * @param userLoginInfo
     */
    void insertUserLoginInfo(UserLoginInfo userLoginInfo);

    /**
     * 根据用户id查询用户登录信息
     * @param userId
     * @return
     */
    int selectLoginInfoByUserId(int userId);

    /**
     * 根据id更新用户信息
     * @param userProfile
     */
    void updateUserById(UserProfile userProfile);
}
