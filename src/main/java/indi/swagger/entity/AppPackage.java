package indi.swagger.entity;

/**
 * @program: Swagger
 * @description: App打包实体类
 * @author: 张文轩
 * @create: 2020-04-24 14:44
 **/
public class AppPackage {
    private int apkId;
    private String apkCode;
    private String apkName;
    private String apkDesc;

    public AppPackage() {
    }

    public AppPackage(int apkId, String apkCode, String apkName, String apkDesc) {
        this.apkId = apkId;
        this.apkCode = apkCode;
        this.apkName = apkName;
        this.apkDesc = apkDesc;
    }

    public int getApkId() {
        return apkId;
    }

    public void setApkId(int apkId) {
        this.apkId = apkId;
    }

    public String getApkCode() {
        return apkCode;
    }

    public void setApkCode(String apkCode) {
        this.apkCode = apkCode;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public String getApkDesc() {
        return apkDesc;
    }

    public void setApkDesc(String apkDesc) {
        this.apkDesc = apkDesc;
    }

    @Override
    public String toString() {
        return "AppPackage{" +
                "apkId=" + apkId +
                ", apkCode='" + apkCode + '\'' +
                ", apkName='" + apkName + '\'' +
                ", apkDesc='" + apkDesc + '\'' +
                '}';
    }
}
