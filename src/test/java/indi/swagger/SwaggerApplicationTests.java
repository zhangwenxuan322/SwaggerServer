package indi.swagger;

import indi.swagger.entity.UserLoginInfo;
import indi.swagger.entity.UserProfile;
import indi.swagger.entity.VerCode;
import indi.swagger.mapper.UserMapper;
import indi.swagger.mapper.VerCodeMapper;
import indi.swagger.service.UserService;
import indi.swagger.service.VerCodeService;
import indi.swagger.util.EncryptionUtil;
import indi.swagger.util.SystemUtil;
import io.rong.models.response.TokenResult;
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
    VerCodeService verCodeService;
    @Autowired
    VerCodeMapper verCodeMapper;
    @Autowired
    UserMapper userMapper;
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
        VerCode verCode = verCodeService.createVerCode("1887415157");
    }

    @Test
    public void selectCodeByValueAndPhoneTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("codePhone", "13813968440");
        map.put("codeValue", "212630");
        VerCode verCode = verCodeMapper.selectCodeByValueAndPhone(map).get(0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(verCode.getCodeCreateTime());
        logger.info("验证码创建时间-->" + dateString);
    }

    @Test
    public void generateCodeTest() {
        String code = SystemUtil.generateCodeWith(4);
        logger.info("code:" + code);
    }

    @Test
    public void insertUserTest() {
        UserProfile userProfile = new UserProfile("friend", "男", "123", "13851567613", "", "", "life~", new Date(), null, 2);
        userMapper.insertUser(userProfile);
    }

    @Test
    public void insertUserLoginInfoTest() {
        UserLoginInfo userLoginInfo = new UserLoginInfo("127.0.0.1", "江苏南京", new Date(), 0, 1);
        userMapper.insertUserLoginInfo(userLoginInfo);
    }

    @Test
    public void selectLoginInfoByUserIdTest() {
        int loginId = userMapper.selectLoginInfoByUserId(1);
        logger.info(String.valueOf(loginId));
    }

    @Test
    public void updateUserByIdTest() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(1);
        userProfile.setUserLoginInfoId(1);
        userMapper.updateUserById(userProfile);
    }

    @Test
    public void registerUserTest() throws Exception {
        UserProfile userProfile = new UserProfile("张建", "男", "123", "13770625437", "", "test.png", "嘿嘿", new Date(), null, 0);
        TokenResult result = userService.registerUser(userProfile);
        System.out.println(result);
    }

    @Test
    public void tokenLengthTest() {
        String token = "rfvKdLy+SGCw2HgjQQjy3vRAIsOQWErBebWt660uOIMgyrAQwEhBhasXu0F5hgszHQ5f2NzlIwKAdjq/QVTe1Lts7WhchtLQ";
        System.out.println(token.length());
    }
}
