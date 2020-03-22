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
    private Date loginTime;
    private int isLogout;
    private int loginUserId;
    private double loginLong;
    private double loginLat;
    private String loginDevice;

    public UserLoginInfo() {
    }

    public UserLoginInfo(String loginIp, Date loginTime, int isLogout, int loginUserId, double loginLong, double loginLat, String loginDevice) {
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.isLogout = isLogout;
        this.loginUserId = loginUserId;
        this.loginLong = loginLong;
        this.loginLat = loginLat;
        this.loginDevice = loginDevice;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
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

    public double getLoginLong() {
        return loginLong;
    }

    public void setLoginLong(double loginLong) {
        this.loginLong = loginLong;
    }

    public double getLoginLat() {
        return loginLat;
    }

    public void setLoginLat(double loginLat) {
        this.loginLat = loginLat;
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

    public int getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(int loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginDevice() {
        return loginDevice;
    }

    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" +
                "loginId=" + loginId +
                ", loginIp='" + loginIp + '\'' +
                ", loginTime=" + loginTime +
                ", isLogout=" + isLogout +
                ", loginUserId=" + loginUserId +
                ", loginLong=" + loginLong +
                ", loginLat=" + loginLat +
                ", loginDevice='" + loginDevice + '\'' +
                '}';
    }
}
