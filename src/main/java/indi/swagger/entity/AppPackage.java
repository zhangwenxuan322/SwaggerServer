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
    private String apk_desc;

    public AppPackage() {
    }

    public AppPackage(int apkId, String apkCode, String apkName, String apk_desc) {
        this.apkId = apkId;
        this.apkCode = apkCode;
        this.apkName = apkName;
        this.apk_desc = apk_desc;
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

    public String getApk_desc() {
        return apk_desc;
    }

    public void setApk_desc(String apk_desc) {
        this.apk_desc = apk_desc;
    }

    @Override
    public String toString() {
        return "AppPackage{" +
                "apkId=" + apkId +
                ", apkCode='" + apkCode + '\'' +
                ", apkName='" + apkName + '\'' +
                ", apk_desc='" + apk_desc + '\'' +
                '}';
    }
}
