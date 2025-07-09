package com.service;

import com.entity.User;

public class UserServiceElse {
    public static User getUser(String account,String password){
        if("BO".equals(account) && "123456".equals(password)){
            var user = new User();
            user.setName("BO");
            return user;
        }
        return null;
    }
}
