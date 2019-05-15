package com.jk.service;

import com.jk.model.NavBean;
import com.jk.model.RoleBean;
import com.jk.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> queryUserList();

    Map<String, Object> login(String account, String password);

    List<NavBean> findNavTreeCommon(Integer id);

    List<RoleBean> findRoleList();

    List<NavBean> findRole(Integer roleId);

    void addPower(Integer roleId, Integer[] powerIds);

    User findLogin(String account);
}
