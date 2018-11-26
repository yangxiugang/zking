package com.zking.supermaket.mapper;

import com.zking.supermaket.pojo.Smbms_Role;
import com.zking.supermaket.pojo.Smbms_User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserMapper {

    @Select("select * from smbms_user where userName=#{userName} and userPassword=#{userPassword} ")
    public Smbms_User LoginUser(Smbms_User user);

    @Select("select * from smbms_user where id=#{id}   ")
    public Smbms_User FindUserById(Smbms_User user);


    @Insert("insert into smbms_user(userCode,birthday,userName,userPassword,gender,phone,address,userRole)  value(#{userCode},#{birthday},#{userName},#{userPassword},#{gender},#{phone},#{address},#{userRole})")
    public int AddUser(Smbms_User user);


    @UpdateProvider(type = UserBuilerMapper.class, method = "UpdateUsers")
    public int EditUser(Smbms_User user);


    @Delete("delete from smbms_user where id=#{id}")
    public int DeleteUser(Smbms_User user);


    @SelectProvider(type = UserBuilerMapper.class, method = "FindUserPagings")
    public List<Smbms_User> FindUserPaging(Smbms_User user);

    @SelectProvider(type = UserBuilerMapper.class, method = "CountUserPagings")
    public int CountUserPagings(Smbms_User user);


    @Select("select * from smbms_role")
    public List<Smbms_Role> FindRole();
}
