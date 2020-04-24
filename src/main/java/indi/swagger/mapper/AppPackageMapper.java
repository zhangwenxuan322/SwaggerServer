package indi.swagger.mapper;

import indi.swagger.entity.AppPackage;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPackageMapper {
    /**
     * 新增安装包信息
     *
     * @param appPackage
     */
    void insertPackageInfo(AppPackage appPackage);
}
