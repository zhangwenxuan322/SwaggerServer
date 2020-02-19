package indi.swagger.entity;

import org.springframework.context.annotation.Bean;

/**
 * @program: Swagger
 * @description: 测试类
 * @author: 张文轩
 * @create: 2020-02-11 12:20
 **/
public class Test {
    private int id;
    private String name;

    public Test() {
    }

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
