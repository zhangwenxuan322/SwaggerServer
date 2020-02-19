package indi.swagger.mapper;

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
}
