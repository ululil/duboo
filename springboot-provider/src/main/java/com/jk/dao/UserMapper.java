package com.jk.dao;

import com.jk.model.NavBean;
import com.jk.model.RoleBean;
import com.jk.model.RolePawer;
import com.jk.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper {

	List<User> queryUserList();

    @Select("select tu.id,tu.name,tu.password,tu.age,tu.account,tu.deptId,tu.sex,tu.headImg ,tu.status,tu.provinceCode,tu.cityCode from t_user tu  where tu.account=#{value}")
    User findUserInfoByAccount(String account);

    @Select("select * from t_shu tn left join t_roler_power tp on tn.id=tp.powerId left join t_user_role tr on tp.roleId=tr.roleId where tr.userId=#{value}")
    List<NavBean> findNavTreeCommon(Integer id);

    @Select("select * from t_role")
    List<RoleBean> findRoleList();
    
    @Select("select * from t_shu")
    List<NavBean> findNavTreeCommon2();

    @Select("select powerId from t_roler_power where roleId=#{value}")
    List<RolePawer> findRloer(Integer roleId);

    @Delete("delete from t_roler_power where roleId =#{value}")
    void deletePowerById(Integer roleId);


    void saverPower(ArrayList<RolePawer> rolePowers);

    @Select("select tu.id,tu.name,tu.password,tu.age,tu.account,tu.deptId,tu.sex,tu.headImg ,tu.status,tu.provinceCode,tu.cityCode from t_user tu  where tu.account=#{value}")
    User findLogin(String account);
}
