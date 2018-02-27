package com.kevin.HRSystem.dao;

import com.kevin.HRSystem.model.User;


public interface UserDao extends BaseDao<User>{
    User selectUser(long id);
}
