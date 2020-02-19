package indi.swagger;

import indi.swagger.entity.UserProfile;
import indi.swagger.entity.VerCode;
import indi.swagger.mapper.UserMapper;
import indi.swagger.mapper.VerCodeMapper;
import indi.swagger.service.UserService;
import indi.swagger.util.EncryptionUtil;
import indi.swagger.util.SystemUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SwaggerApplicationTests {
    Logger logger = LoggerFactory.getLogger(SwaggerApplicationTests.class);
    @Autowired
    UserService userService;
    @Autowired
    VerCodeMapper verCodeMapper;
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

    @Test
    public void insertCodeTest() {
        VerCode verCode = new VerCode(1, SystemUtil.generateCodeWith(6), new Date());
        verCodeMapper.insertCode(verCode);
        logger.info("新增短信验证码-->" + verCode.getCodeValue());
    }

    @Test
    public void selectCodeByValueAndUserTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("codeUserId", 1);
        map.put("codeValue", "243521");
        VerCode verCode = verCodeMapper.selectCodeByValueAndUser(map);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(verCode.getCodeCreateTime());
        logger.info("验证码创建时间-->" + dateString);
    }

    @Test
    public void generateCodeTest() {
        String code = SystemUtil.generateCodeWith(4);
        logger.info("code:" + code);
    }
}
