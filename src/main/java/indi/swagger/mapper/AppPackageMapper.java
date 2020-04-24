package indi.swagger.mapper;

import indi.swagger.entity.AppPackage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppPackageMapper {
    /**
     * 新增安装包信息
     *
     * @param appPackage
     */
    void insertPackageInfo(AppPackage appPackage);

    /**
     * 获取最新Apk
     *
     * @return
     */
    List<AppPackage> selectLatestApk();
}
