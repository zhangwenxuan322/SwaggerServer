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
    public VerCode createVerCode(int codeUserId) {
        logger.info("创建短信验证码");
        UserProfile userProfile = userMapper.selectUserById(codeUserId);
        if (userProfile == null) {
            logger.info("不存在id为" + codeUserId + "的用户！");
            return null;
        } else {
            // 生成验证码
            VerCode verCode = new VerCode(codeUserId, SystemUtil.generateCodeWith(codeLength), new Date());
            verCodeMapper.insertCode(verCode);
            logger.info("验证码创建成功：" + verCode.toString());
            return verCode;
        }
    }
}
