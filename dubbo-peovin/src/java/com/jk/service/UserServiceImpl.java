package com.jk.service;

import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService {
    @Override
    public String hello(String name, Integer age) {
        return "姓名："+name+"age"+age;
    }

    @Override
    public void sayHello(String name, String hobby) {
        System.out.println("姓名："+name+"爱好"+hobby);
    }
}
