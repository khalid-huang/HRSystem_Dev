package com.kevin.HRSystem.service.impl;

import com.kevin.HRSystem.model.User;
import com.kevin.HRSystem.dao.UserDao;
import com.kevin.HRSystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
