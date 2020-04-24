package indi.swagger.service;

import indi.swagger.entity.AppPackage;

public interface AppPackageService {
    /**
     * 新增安装包信息
     *
     * @param appPackage
     */
    void insertPackageInfo(AppPackage appPackage);
}
