package indi.swagger.service;

import indi.swagger.entity.Test;
import indi.swagger.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Swagger
 * @description:
 * @author: 张文轩
 * @create: 2020-02-11 12:24
 **/
@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public Test selectById(int id) {
        return testMapper.selectById(id);
    }
}
