package indi.swagger.entity;

import java.util.Date;

/**
 * @program: Swagger
 * @description: 验证码实体类
 * @author: 张文轩
 * @create: 2020-02-19 21:17
 **/
public class VerCode {
    private int codeId;
    private String codePhone;
    private String codeValue;
    private Date codeCreateTime;

    public VerCode() {
    }

    public VerCode(String codePhone, String codeValue, Date codeCreateTime) {
        this.codePhone = codePhone;
        this.codeValue = codeValue;
        this.codeCreateTime = codeCreateTime;
    }

    public int getCodeId() {
        return codeId;
    }

    public String getCodePhone() {
        return codePhone;
    }

    public void setCodePhone(String codePhone) {
        this.codePhone = codePhone;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public Date getCodeCreateTime() {
        return codeCreateTime;
    }

    public void setCodeCreateTime(Date codeCreateTime) {
        this.codeCreateTime = codeCreateTime;
    }

    @Override
    public String toString() {
        return "VerCode{" +
                "codeId=" + codeId +
                ", codePhone='" + codePhone + '\'' +
                ", codeValue='" + codeValue + '\'' +
                ", codeCreateTime=" + codeCreateTime +
                '}';
    }
}
