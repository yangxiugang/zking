package com.zking.supermaket.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Smbms_Provider extends pageBean implements Serializable {

    private String id;
    private String proCode;
    private String proName;
    @NotBlank(message = "描述不可为空")
    private String proDesc;
    //供应商联系人
    @NotBlank(message = "联系人不可为空")
    private String proContact;
    @NotBlank(message = "电话不可为空")
    private String proPhone;
    @NotBlank(message = "地址不可为空")
    private String proAddress;
    @NotBlank(message = "传真不可为空")
    private String proFax;
    //创建者（userId）
    private String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM--dd")
    private Date creationDate;
    //更新时间
    private Date modifyDate;
    //更新者（userId）
    private String modifyBy;

    public Smbms_Provider() {
    }

    public Smbms_Provider(String id, String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, String createdBy, Date creationDate, Date modifyDate, String modifyBy) {
        this.id = id;
        this.proCode = proCode;
        this.proName = proName;
        this.proDesc = proDesc;
        this.proContact = proContact;
        this.proPhone = proPhone;
        this.proAddress = proAddress;
        this.proFax = proFax;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyDate = modifyDate;
        this.modifyBy = modifyBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProContact() {
        return proContact;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProFax() {
        return proFax;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public String toString() {
        return "Smbms_Provider{" +
                "id='" + id + '\'' +
                ", proCode='" + proCode + '\'' +
                ", proName='" + proName + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", proContact='" + proContact + '\'' +
                ", proPhone='" + proPhone + '\'' +
                ", proAddress='" + proAddress + '\'' +
                ", proFax='" + proFax + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                '}';
    }
}
