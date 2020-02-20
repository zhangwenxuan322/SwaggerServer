package indi.swagger.controller;

import indi.swagger.entity.VerCode;
import indi.swagger.service.VerCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Swagger
 * @description: 验证码控制器
 * @author: 张文轩
 * @create: 2020-02-19 21:23
 **/
@RestController
public class VerCodeController {
    Logger logger = LoggerFactory.getLogger(VerCodeController.class);
    @Autowired
    VerCodeService verCodeService;

    /**
     * 发送短信验证码
     * @param codePhone
     * @return
     */
    @PostMapping("code")
    public Map<String, Object> postCode(@RequestParam("code_phone") String codePhone) {
        logger.info("手机号：" + codePhone +"调用模拟短信服务");
        VerCode verCode = verCodeService.createVerCode(codePhone);
        Map<String, Object> map = new HashMap<>();
        if (verCode == null) {
            map.put("code", 404);
            map.put("ver_code", null);
        }else {
            map.put("code", 200);
            map.put("ver_code", verCode);
        }
        return map;
    }
}
