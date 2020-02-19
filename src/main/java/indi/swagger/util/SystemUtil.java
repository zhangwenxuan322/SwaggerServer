package indi.swagger.util;

/**
 * @program: Swagger
 * @description: 系统工具类
 * @author: 张文轩
 * @create: 2020-02-19 22:14
 **/
public class SystemUtil {
    /**
     * 生成相应位数的验证码
     * @param codeLength
     * @return
     */
    public static String generateCodeWith(int codeLength) {
        return String.valueOf((int)((Math.random()*9+1)*Math.pow(10, codeLength - 1)));
    }
}
