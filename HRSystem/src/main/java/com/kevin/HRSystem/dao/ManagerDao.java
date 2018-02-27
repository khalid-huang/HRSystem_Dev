package com.kevin.HRSystem.dao;

import com.kevin.HRSystem.model.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerDao extends BaseDao<Manager> {

    /**
     * 根据用户名和密码查询经理
     * @param managerName 经理名
     * @param password 密码
     * @return 符合指定用户名和密码的经理
     */
    Manager findByNameAndPass(@Param("name") String managerName, @Param("password") String password);

    /**
     * 根据用户名查找经理
     * @param name 经理的名字
     * @return 名字对应的经理
     */
    Manager findByName(@Param("name") String name);
}
