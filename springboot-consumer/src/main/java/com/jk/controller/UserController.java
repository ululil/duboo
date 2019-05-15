package com.jk.controller;

import com.jk.model.NavBean;
import com.jk.model.RoleBean;
import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main")
public class UserController {


@Autowired
    private UserService userService;

@RequestMapping("query")
@ResponseBody
    public List<User> queryUserList(){
    List<User> list= userService.queryUserList();

    return list;
}

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(String account, String password, HttpSession session ){

        User user = new User();
        User findLogin = userService.findLogin(account);
        BeanUtils.copyProperties(findLogin, user);
        session.setAttribute(session.getId(), user);
        return userService.login(account,password);

    }

    @RequestMapping("findNavTreeCommon")
    @ResponseBody
    public List<NavBean> findNavTreeCommon(HttpSession session){

        User userBean = (User) session.getAttribute(session.getId());

        Integer id=userBean.getId();
        return userService.findNavTreeCommon(id);
    }

    @RequestMapping("findNavTreeCommon2")
    @ResponseBody
    public List<RoleBean> findRoleLists(){
        return userService.findRoleList();
    }

    @RequestMapping("findRole")
    @ResponseBody
    public List<NavBean> findRole(Integer roleId){
        return userService.findRole(roleId);
    }

    //新增权限树
    @RequestMapping("addPower")
    @ResponseBody
    public Boolean addPower(Integer roleId,Integer[] powerIds){

        try {
            userService.addPower(roleId,powerIds);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
