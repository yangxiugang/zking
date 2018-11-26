package com.zking.supermaket.service;

import com.zking.supermaket.pojo.Smbms_Role;
import com.zking.supermaket.pojo.Smbms_User;

import java.util.List;

public interface IUserService {
    public Smbms_User LoginUser(Smbms_User user);

    public Smbms_User FindUserById(Smbms_User user);

    public int AddUser(Smbms_User user);

    public int EditUser(Smbms_User user);

    public int DeleteUser(Smbms_User user);

    public List<Smbms_User> FindUserPaging(Smbms_User user);

    public int CountUserPagings(Smbms_User user);

    public  List<Smbms_Role>  FindRole();
}
