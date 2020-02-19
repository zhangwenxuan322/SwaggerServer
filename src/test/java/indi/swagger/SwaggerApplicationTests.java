package indi.swagger;

import indi.swagger.entity.UserProfile;
import indi.swagger.mapper.UserMapper;
import indi.swagger.service.UserService;
import indi.swagger.util.EncryptionUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SwaggerApplicationTests {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
    }
    @Test
    public void encryptTest() {
        String password = EncryptionUtil.SHA256("hello");
        System.out.println(password);
        System.out.println(password.length());
    }

    @Test
    public void selectUserByPhoneTest() {
        UserProfile userProfile = userService.selectUserByPhone("13813968440");
        logger.info(userProfile.toString());
    }

    @Test
    public void selectUserBySwaggerIdTest() {
        UserProfile userProfile = userService.selectUserBySwaggerId("swagger001");
        logger.info(userProfile.toString());
    }
}
