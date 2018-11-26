package com.zking.supermaket.service.impl;

import com.zking.supermaket.mapper.IUserMapper;
import com.zking.supermaket.pojo.Smbms_Role;
import com.zking.supermaket.pojo.Smbms_User;
import com.zking.supermaket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UserServiceimpl")
public class UserServiceimpl implements IUserService {

    @Autowired
    private IUserMapper ium;

    @Override
    public Smbms_User LoginUser(Smbms_User user) {
        return ium.LoginUser(user);
    }

    @Override
    public Smbms_User FindUserById(Smbms_User user) {
        return ium.FindUserById(user);
    }

    @Override
    public int AddUser(Smbms_User user) {
        return ium.AddUser(user);
    }

    @Override
    public int EditUser(Smbms_User user) {
        return ium.EditUser(user);
    }

    @Override
    public int DeleteUser(Smbms_User user) {
        return ium.DeleteUser(user);
    }

    @Override
    public List<Smbms_User> FindUserPaging(Smbms_User user) {
        return ium.FindUserPaging(user);
    }

    @Override
    public int CountUserPagings(Smbms_User user) {
        return ium.CountUserPagings(user);
    }

    @Override
    public  List<Smbms_Role>  FindRole() {
        return ium.FindRole();
    }
}
