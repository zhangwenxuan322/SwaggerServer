package indi.swagger.entity;

import java.util.Date;

/**
 * @program: Swagger
 * @description: 用户信息
 * @author: 张文轩
 * @create: 2020-02-19 13:18
 **/
public class UserProfile {
    private int userId;
    private String userName;
    private String userSex;
    private String userPassword;
    private String userPhone;
    private String userSwaggerId;
    private String userPortrait;
    private String userBio;
    private Date userCreateTime;
    private Date userModifyTime;
    private int userLoginInfoId;

    public UserProfile() {
    }

    public UserProfile(String userName, String userSex, String userPassword, String userPhone, String userSwaggerId, String userPortrait, String userBio, Date userCreateTime, Date userModifyTime, int userLoginInfoId) {
        this.userName = userName;
        this.userSex = userSex;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userSwaggerId = userSwaggerId;
        this.userPortrait = userPortrait;
        this.userBio = userBio;
        this.userCreateTime = userCreateTime;
        this.userModifyTime = userModifyTime;
        this.userLoginInfoId = userLoginInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSwaggerId() {
        return userSwaggerId;
    }

    public void setUserSwaggerId(String userSwaggerId) {
        this.userSwaggerId = userSwaggerId;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserModifyTime() {
        return userModifyTime;
    }

    public void setUserModifyTime(Date userModifyTime) {
        this.userModifyTime = userModifyTime;
    }

    public int getUserLoginInfoId() {
        return userLoginInfoId;
    }

    public void setUserLoginInfoId(int userLoginInfoId) {
        this.userLoginInfoId = userLoginInfoId;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSwaggerId='" + userSwaggerId + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                ", userBio='" + userBio + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", userModifyTime=" + userModifyTime +
                ", userLoginInfoId=" + userLoginInfoId +
                '}';
    }
}
