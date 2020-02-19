package indi.swagger.mapper;

import indi.swagger.entity.Test;
import org.springframework.stereotype.Repository;

/**
 * @program: Swagger
 * @description: 测试类
 * @author: 张文轩
 * @create: 2020-02-11 12:21
 **/
@Repository
public interface TestMapper {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Test selectById(int id);
}
