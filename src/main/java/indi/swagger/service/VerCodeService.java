package indi.swagger.service;

import indi.swagger.entity.VerCode;

/**
 * 验证码服务接口
 */
public interface VerCodeService {

    /**
     * 根据用户id生成验证码
     * @param codeUserId
     * @return
     */
    VerCode createVerCode(String codePhone);
}
