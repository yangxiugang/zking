package com.zking.supermaket.mapper;

import com.zking.supermaket.pojo.Smbms_User;
import org.apache.ibatis.jdbc.SQL;

public class UserBuilerMapper {

    public String UpdateUsers(final Smbms_User user) {
        return new SQL() {{
            UPDATE("smbms_user");
            if (user.getAddress() != null && user.getAddress() != "null") {
                SET("address=#{address}");
            }
            if (user.getBirthday() != null) {
                SET("birthday=#{birthday}");
            }
            if (user.getCreatedBy() != null && user.getCreatedBy() != "null") {
                SET("createdBy=#{createdBy}");
            }
            if (user.getGender() > 0) {
                SET("gender=#{gender}");
            }
            if (user.getModifyBy() != null && user.getModifyBy() != "null") {
                SET("modifyBy=#{modifyBy}");
            }
            if (user.getModifyDate() != null) {
                SET("modifyDate=#{modifyDate}");
            }
            if (user.getPhone() != null && user.getPhone() != "null") {
                SET("phone=#{phone}");
            }
            if (user.getUserCode() != null && user.getUserCode() != "null") {
                SET("userCode=#{userCode}");
            }
            if (user.getUserName() != null) {
                SET("userName=#{userName}");
            }
           if (user.getUserPassword() != null && user.getUserPassword() != "null") {
                SET("userPassword=#{userPassword}");
            }
            if (user.getUserRole() != null && user.getUserRole() != "0") {
                SET("userRole=#{userRole}");
            }
            WHERE("id=#{id}");

        }}.toString();
    }

    public String FindUserPagings(final Smbms_User user) {

        return new SQL() {{
            SELECT("*");
            FROM("smbms_user u");
            INNER_JOIN(" smbms_role r ON r.id=u.userRole");
            if (user.getUserName() != null) {
                AND();
                WHERE("userName like '%" + user.getUserName() + "%'");
            }
            if (user.getUserRole() != null && !user.getUserRole().equals("0")) {
                AND();
                WHERE("userRole=#{userRole}");
            }
            ORDER_BY("u.creationDate desc  limit " + (user.getPage() - 1) * user.getRows() + "," + user.getRows());
        }}.toString();
    }

    ;

    public String CountUserPagings(final Smbms_User user) {

        return new SQL() {{
            SELECT("ceil(count(*)/" + user.getRows()+")");
            FROM("smbms_user u");
            INNER_JOIN(" smbms_role r ON r.id=u.userRole");
            if (user.getUserName() != null) {
                AND();
                WHERE("userName like '%" + user.getUserName() + "%'");
            }
            if (user.getUserRole() != null && !user.getUserRole().equals("0")) {
                AND();
                WHERE("userRole=#{userRole}");
            }
        }}.toString();
    }


}
