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
    private int codeUserId;
    private String codeValue;
    private Date codeCreateTime;

    public VerCode() {
    }

    public VerCode(int codeUserId, String codeValue, Date codeCreateTime) {
        this.codeUserId = codeUserId;
        this.codeValue = codeValue;
        this.codeCreateTime = codeCreateTime;
    }

    public int getCodeId() {
        return codeId;
    }

    public int getCodeUserId() {
        return codeUserId;
    }

    public void setCodeUserId(int codeUserId) {
        this.codeUserId = codeUserId;
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
                ", codeUserId=" + codeUserId +
                ", codeValue='" + codeValue + '\'' +
                ", codeCreateTime=" + codeCreateTime +
                '}';
    }
}
