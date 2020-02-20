package indi.swagger.mapper;

import indi.swagger.entity.VerCode;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 验证码Mapper
 */
@Repository
public interface VerCodeMapper {
    /**
     * 根据请求用户生成模拟短信验证码
     * @param map
     */
    void insertCode(VerCode verCode);

    /**
     * 根据验证码值和请求用户查找验证码
     * @param map
     */
    List<VerCode> selectCodeByValueAndPhone(Map<String, Object> map);
}
