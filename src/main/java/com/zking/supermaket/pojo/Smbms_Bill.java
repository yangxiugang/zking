package com.zking.supermaket.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Smbms_Bill extends pageBean implements Serializable {
    private int id;
    //账单编码
    @NotBlank(message = "账单编码不可以为空")
    private String billCode;
    //商品名称
    @NotBlank(message = "商品名称不可以为空")
    private String productName;
    //商品描述
    private String productDesc;
    //商品单位
    @NotBlank(message = "商品单位不可以为空")
    private String productUnit;
    //商品数量
    private double productCount;
    //商品总额
    private double totalPrice;
    //是否支付（1：未支付 2：已支付）
    private int isPayment;
    //创建者（userId）
    private String createdBy;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    //更新者（userId）
    private String modifyBy;
    //更新时间
    private Date modifyDate;
    //供应商ID
    private String providerId;

    //连接外表
    //供应商名称
    private String proName;

    private Map<String,Object> proNameList;
    private Map<String,Object> isPaymentList;

    public Smbms_Bill() {
    }


    public Smbms_Bill(int id, String billCode, String productName, String productDesc, String productUnit, double productCount, double totalPrice, int isPayment, String createdBy, Date creationDate, String modifyBy, Date modifyDate, String providerId) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.providerId = providerId;
    }

    public Map<String, Object> getIsPaymentList() {
        return isPaymentList;
    }

    public void setIsPaymentList(Map<String, Object> isPaymentList) {
        this.isPaymentList = isPaymentList;
    }

    public Map<String, Object> getProNameList() {
        return proNameList;
    }

    public void setProNameList(Map<String, Object> proNameList) {
        this.proNameList = proNameList;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public double getProductCount() {
        return productCount;
    }

    public void setProductCount(double productCount) {
        this.productCount = productCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
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

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    @Override
    public String toString() {
        return "Smbms_Bill{" +
                "id='" + id + '\'' +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount=" + productCount +
                ", totalPrice=" + totalPrice +
                ", isPayment=" + isPayment +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", providerId='" + providerId + '\'' +
                '}';
    }
}
