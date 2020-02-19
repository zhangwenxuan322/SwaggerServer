package indi.swagger.entity;

import java.util.Date;

/**
 * @program: Swagger
 * @description: 用户登录信息
 * @author: 张文轩
 * @create: 2020-02-19 13:23
 **/
public class UserLoginInfo {
    private int loginId;
    private String loginIp;
    private String loginPlace;
    private Date loginTime;
    private int isLogout;

    public UserLoginInfo() {
    }

    public UserLoginInfo(String loginIp, String loginPlace, Date loginTime, int isLogout) {
        this.loginIp = loginIp;
        this.loginPlace = loginPlace;
        this.loginTime = loginTime;
        this.isLogout = isLogout;
    }

    public int getLoginId() {
        return loginId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginPlace() {
        return loginPlace;
    }

    public void setLoginPlace(String loginPlace) {
        this.loginPlace = loginPlace;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public int getIsLogout() {
        return isLogout;
    }

    public void setIsLogout(int isLogout) {
        this.isLogout = isLogout;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "loginId=" + loginId +
                ", loginIp='" + loginIp + '\'' +
                ", loginPlace='" + loginPlace + '\'' +
                ", loginTime=" + loginTime +
                ", isLogout=" + isLogout +
                '}';
    }
}
