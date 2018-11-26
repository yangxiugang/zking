package com.zking.supermaket.mapper;

import com.zking.supermaket.pojo.Smbms_Bill;
import org.apache.ibatis.jdbc.SQL;

public class BillBuilerMapper {

    public String UpdateBill(final Smbms_Bill bill) {
        return new SQL() {{
            UPDATE("smbms_bill");
            if (bill.getBillCode() != null) {
                SET("billCode=#{billCode}");
            }
            if (bill.getCreatedBy() != null) {
                SET("createdBy=#{createdBy}");
            }
            if (bill.getProductCount() > 0) {
                SET("productCount=#{productCount}");
            }
            if (bill.getProductDesc() != null) {
                SET("productDesc=#{productDesc}");
            }
            if (bill.getProductName() != null) {
                SET("productName=#{productName}");
            }
            if (bill.getProductUnit() != null) {
                SET("productUnit=#{productUnit}");
            }
            if (bill.getProviderId() != null) {
                SET("providerId=#{providerId}");
            }
            if (bill.getTotalPrice() > 0) {
                SET("totalPrice=#{totalPrice}");
            }
            if (bill.getModifyBy() != null) {
                SET("modifyBy=#{modifyBy}");
            }
            if (bill.getModifyDate() != null) {
                SET("modifyDate=#{modifyDate}");
            }
            WHERE("id=#{id}");

        }}.toString();
    }

    public String FindBillPaging(final Smbms_Bill bill) {
        return new SQL() {{
            SELECT("*");
            FROM("smbms_bill b");
            INNER_JOIN(" smbms_provider p on  b.providerid=p.id");
            if (bill.getBillCode() != null) {
                AND();
                WHERE("billCode=#{billCode}");
            }

            if (bill.getProductCount() > 0) {
                AND();
                WHERE("productCount=#{productCount}");
            }
            if (bill.getProductDesc() != null) {
                AND();
                WHERE("productDesc=#{productDesc}");
            }
            if (bill.getProductName() != null) {
                AND();
                WHERE("productName=#{productName}");
            }
            if (bill.getProductUnit() != null) {
                AND();
                WHERE("productUnit=#{productUnit}");
            }
            if (bill.getProviderId() != null) {
                AND();
                WHERE("providerId=#{providerId}");
            }
            if (bill.getTotalPrice() > 0) {
                AND();
                WHERE("totalPrice=#{totalPrice}");
            }

            ORDER_BY("b.creationDate desc  limit " + (bill.getPage() - 1) * bill.getRows() + "," + bill.getRows());
        }}.toString();
    }

    ;

    public String CountBillPagings(final Smbms_Bill bill) {
        return new SQL() {{
            SELECT("ceil(count(*)/" + bill.getRows() + ")");
            FROM("smbms_bill b");
            INNER_JOIN(" smbms_provider p on  b.providerid=p.id");
            if (bill.getBillCode() != null) {
                AND();
                WHERE("billCode=#{billCode}");
            }

            if (bill.getProductCount() > 0) {
                AND();
                WHERE("productCount=#{productCount}");
            }
            if (bill.getProductDesc() != null) {
                AND();
                WHERE("productDesc=#{productDesc}");
            }
            if (bill.getProductName() != null) {
                AND();
                WHERE("productName=#{productName}");
            }
            if (bill.getProductUnit() != null) {
                AND();
                WHERE("productUnit=#{productUnit}");
            }
            if (bill.getProviderId() != null) {
                AND();
                WHERE("providerId=#{providerId}");
            }
            if (bill.getTotalPrice() > 0) {
                AND();
                WHERE("totalPrice=#{totalPrice}");
            }

        }}.toString();
    }

    ;
}
