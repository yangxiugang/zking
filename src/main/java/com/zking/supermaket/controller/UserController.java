package com.zking.supermaket.controller;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.supermaket.pojo.Smbms_Role;
import com.zking.supermaket.pojo.Smbms_User;
import com.zking.supermaket.pojo.pageBean;
import com.zking.supermaket.service.IUserService;
import com.zking.supermaket.service.impl.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {


    @Autowired
    private IUserService ius = new UserServiceimpl();
    private Smbms_User user = new Smbms_User();


    @RequestMapping(value = "loginWindow")
    public String logins(Model model) {
        model.addAttribute("user", new Smbms_User());
        System.out.println("-----");
        return "login";
    }


    @RequestMapping(value = "logins")
    public String logins(@Validated({Smbms_User.Loginverfigy.class}) @ModelAttribute("user") Smbms_User user, BindingResult bindingResult, HttpServletRequest request) {
        if (!bindingResult.hasErrors()) {
            Smbms_User smbms_user = ius.LoginUser(user);
            if (smbms_user != null) {
                request.setAttribute("userSession", user);
                request.setAttribute("userpwd", user.getUserPassword());
                request.setAttribute("userid", smbms_user.getId());
                System.out.println("-----");
                return "jsp/frame";
            }
        }
        List<FieldError> le = bindingResult.getFieldErrors();
        for (FieldError fieldError : le) {
            System.out.println("error:" + fieldError.getDefaultMessage());
        }
        return "login";
    }


    @RequestMapping(value = "FindUserPaging")
    public String FindUserPaging(@Validated @ModelAttribute("Showuser") Smbms_User user, Model model, HttpServletRequest request) {
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        user.setPage(page);
        List<Smbms_User> lu = ius.FindUserPaging(user);
        user.setMax(ius.CountUserPagings(user));
        Smbms_User u = new Smbms_User();
        u.setRows(1);
        user.setAll(ius.CountUserPagings(u));
        Map map = new HashMap();
        map.put("page", user.getPage());
        map.put("rows", user.getRows());
        map.put("max", user.getMax());
        map.put("all", user.getMax());
        request.setAttribute("paramssss", map);
        request.setAttribute("userList", lu);
        model.addAttribute("Showuser", CommonMaps());
        return "forward:jsp/userlist.jsp";
    }


    @RequestMapping(value = "FindUserById")
    public String FindUserById(HttpServletRequest request) {
        String id = request.getParameter("id");
        Smbms_User u = new Smbms_User();
        u.setId(id);
        request.setAttribute("Showuser", ius.FindUserById(u));
        return "jsp/userview";
    }


    public Smbms_User CommonMaps() {
        Map<String, Object> maps = new HashMap<>();
        Map<String, Object> maps2 = new HashMap<>();
        List<Smbms_Role> smbms_roles = ius.FindRole();
        for (Smbms_Role role : smbms_roles) {
            maps.put(role.getId(), role.getRoleName());
        }
        maps.put("0", "--请选择--");
        maps2.put("1", "女");
        maps2.put("2", "男");
        user.setUserRoleList(maps);
        user.setGenderList(maps2);
        return user;
    }


    @RequestMapping(value = "addUserWindow")
    public String addUserWindow(Model model) {
        model.addAttribute("Adduser", CommonMaps());
        return "jsp/useradd";
    }


    @RequestMapping(value = "addUser")
    public String addUser(Model model,@Validated(Smbms_User.Addverfigy.class) @ModelAttribute("Adduser") Smbms_User users, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (ius.AddUser(users) > 0) {
                return "redirect:FindUserPaging.action";
            }
        }
        List<FieldError> lf = bindingResult.getFieldErrors();
        for (FieldError error : lf) {
            System.out.println(error.getDefaultMessage());
        }
        users.setGenderList(CommonMaps().getGenderList());
        users.setUserRoleList(CommonMaps().getUserRoleList());
        model.addAttribute("Adduser", users);
        return "jsp/useradd";
    }

    @RequestMapping(value = "editUserWindow")
    public String editUserWindow(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        CommonMaps().setId(id);
        Smbms_User u = ius.FindUserById(CommonMaps());
        System.out.println(CommonMaps().getUserRoleList());
        System.out.println(CommonMaps().getGenderList());
        System.out.println("修改用户");
        u.setUserRoleList(CommonMaps().getUserRoleList());
        u.setGenderList(CommonMaps().getGenderList());
        model.addAttribute("Edituser", u);
        return "/loginWindow.action";
    }


    @RequestMapping(value = "editUser")
    public String editUser(@Validated({Smbms_User.Editverfigy.class}) @ModelAttribute("Adduser") Smbms_User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (ius.EditUser(user) > 0) {
                return "redirect:FindUserPaging.action";
            }
        } else {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return "jsp/usermodify";
    }

    //   @ResponseBody
    @RequestMapping(value = "deleteUser")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        user.setId(id);
        String out = "n";
        String myreturn = "error";
        if (ius.DeleteUser(user) > 0) {
            out = "y";
            myreturn = "redirect:FindUserPaging.action";
        }
        try {
            response.getWriter().print(out);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myreturn;
    }


    @RequestMapping(value = "updatePwdWindow")
    public String updatePwdWindow(Model model, HttpServletRequest request) {
        String id = (String) request.getParameter("userid");
        user.setId(id);
        model.addAttribute("editPwduser", user);
        return "jsp/pwdmodify";
    }


    @RequestMapping(value = "updatePwd")
    public String updatePwd(@Validated @ModelAttribute("editPwduser") Smbms_User userss, BindingResult bindingResult, HttpServletRequest request) {
        if (!bindingResult.hasErrors()) {
            if (ius.EditUser(userss) > 0) {
                return "redirect:loginWindow.action";
            }
        }
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError error : fieldErrors) {
            System.out.println(error.getDefaultMessage());
        }
        return "error";
    }
}
