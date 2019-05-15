package com.jk.service;

import com.jk.dao.UserMapper;
import com.jk.model.NavBean;
import com.jk.model.RoleBean;

import com.jk.model.RolePawer;
import com.jk.model.User;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;


    @Override
    public List<User> queryUserList() {
        List<User> list=UserMapper.queryUserList();

       /* List<User> list=new ArrayList<>();
        User user=new User();
        user.setAccount("16555");
        user.setAge(0);
        user.setCityCode(1);
        user.setCityName("hsh");

      list.add(user);*/

        return list;
    }

    @Override
    public Map<String, Object> login(String account, String password) {
        // 建一个总的返回
        HashMap<String, Object> result = new HashMap<>();



        // 判断账号

        //UserBean userBean = userMapper.findAccount(account);
     User findUserInfoByAccount = UserMapper.findUserInfoByAccount(account);
        if (findUserInfoByAccount == null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;

        }
        String password2 = findUserInfoByAccount.getPassword();
        String md516 = Md5Util.getMd516(password);
        if (!password2.equals(md516)) {
            result.put("code", 4);
            result.put("msg", "密码错误");
            return result;

        }
        User userBean = new User();

        result.put("code", 0);
        result.put("msg", "登陆成功");

        return result;

    }

    @Override
    public List<NavBean> findNavTreeCommon(Integer id) {


        return UserMapper.findNavTreeCommon(id);
    }

    @Override
    public List<RoleBean> findRoleList() {

            return UserMapper.findRoleList();

        }

    @Override
    public List<NavBean> findRole(Integer roleId) {
        // 查询所有全县的树节点
        // 查询角色所有的权限
        List<NavBean> poweer = UserMapper.findNavTreeCommon2();

        List<RolePawer> rolePawer = UserMapper.findRloer(roleId);

        for (NavBean navBean : poweer) {
            for (RolePawer rolePawer1 : rolePawer) {
                if (navBean.getId() == rolePawer1.getPowerId()) {
                    navBean.setChecked(true);
                }
            }
        }
        return poweer;
    }

    @Override
    public void addPower(Integer roleId, Integer[] powerIds) {
// 删除角色拥有的旧的权限
        UserMapper.deletePowerById(roleId);

        // 保存角色新的权限
        ArrayList<RolePawer> rolePowers = new ArrayList<RolePawer>();

        for (int i = 0; i < powerIds.length; i++) {
            RolePawer rolePawer = new RolePawer();

            rolePawer.setRoleId(roleId);

            rolePawer.setPowerId(powerIds[i]);
            rolePowers.add(rolePawer);
        }
        UserMapper.saverPower(rolePowers);
    }

    @Override
    public User findLogin(String account) {
        return UserMapper.findLogin(account);
    }

}

