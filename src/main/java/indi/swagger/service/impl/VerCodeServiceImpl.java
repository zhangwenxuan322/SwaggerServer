package indi.swagger.service.impl;

import indi.swagger.entity.UserProfile;
import indi.swagger.entity.VerCode;
import indi.swagger.mapper.UserMapper;
import indi.swagger.mapper.VerCodeMapper;
import indi.swagger.service.VerCodeService;
import indi.swagger.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 验证码服务实现类
 * @author: 张文轩
 * @create: 2020-02-19 21:22
 **/
@Service
public class VerCodeServiceImpl implements VerCodeService {
    Logger logger = LoggerFactory.getLogger(VerCodeService.class);
    @Autowired
    VerCodeMapper verCodeMapper;
    @Autowired
    UserMapper userMapper;

    // 设置验证码长度
    private final int codeLength = 6;

    @Transactional
    @Override
    public VerCode createVerCode(String codePhone) {
        logger.info("创建短信验证码");
        Boolean isMobile = SystemUtil.isMobileNO(codePhone);
        if (!isMobile) {
            logger.info("手机号" + codePhone + "有误");
            return null;
        } else {
            // 生成验证码
            VerCode verCode = new VerCode(codePhone, SystemUtil.generateCodeWith(codeLength), new Date());
            verCodeMapper.insertCode(verCode);
            Map<String, Object> map = new HashMap<>();
            map.put("codePhone", verCode.getCodePhone());
            map.put("codeValue", verCode.getCodeValue());
            verCode = verCodeMapper.selectCodeByValueAndPhone(map).get(0);
            logger.info("验证码创建成功：" + verCode.toString());
            return verCode;
        }
    }
}
