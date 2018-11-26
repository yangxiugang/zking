package com.zking.supermaket.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Smbms_User extends pageBean implements Serializable {

    private String id;
    @NotBlank(message = "用户编码不可以为空", groups = Addverfigy.class)
    private String userCode;
    @NotBlank(message = "用户名不可以为空", groups = {Loginverfigy.class, Editverfigy.class})
    @Length(min = 2, max = 12)
    private String userName;
    @NotBlank(message = "密码不可以为空", groups ={Loginverfigy.class,Addverfigy.class})
    private String userPassword;
    private int gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @NotBlank(message = "手机号不可以为空", groups ={ Editverfigy.class,Addverfigy.class})
    private String phone;
    @NotBlank(message = "地址不可以为空", groups = {Editverfigy.class,Addverfigy.class})
    private String address;
    private String userRole;
    private String createdBy;
    private Date creationDate;
    private String modifyBy;
    private Date modifyDate;
    //连表所用
    private String roleName;
    private Map<String, Object> userRoleList;
    private Map<String, Object> genderList;

    public interface Loginverfigy {
    }

    public interface Editverfigy {
    }

    public interface Addverfigy {
    }

    public Smbms_User() {
    }

    public Smbms_User(String id, String userCode, String userName, String userPassword, int gender, Date birthday, String phone, String address, String userRole, String createdBy, Date creationDate, String modifyBy, Date modifyDate) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Map<String, Object> getGenderList() {
        return genderList;
    }

    public void setGenderList(Map<String, Object> genderList) {
        this.genderList = genderList;
    }

    public Map<String, Object> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(Map<String, Object> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Smbms_User{" +
                "id='" + id + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole='" + userRole + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
