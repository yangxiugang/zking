package com.zking.supermaket.mapper;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import org.apache.ibatis.jdbc.SQL;

public class ProviderBuilerMapper {

    public String UpdateProviders(final Smbms_Provider provider) {
        System.out.println("bulider--"+provider);
        return new SQL() {{
            UPDATE("smbms_provider");
            if (provider.getProAddress() != null) {
                SET("proAddress=#{proAddress}");
            }
            if (provider.getProCode() != null) {
                SET("proCode=#{proCode}");
            }
            if (provider.getProContact() !=null) {
                SET("proContact=#{proContact}");
            }
            if (provider.getProDesc() != null) {
                SET("proDesc=#{proDesc}");
            }
            if (provider.getProFax() != null) {
                SET("proFax=#{proFax}");
            }
            if (provider.getProName() != null) {
                SET("proName=#{proName}");
            }
            if (provider.getProPhone() != null) {
                SET("proPhone=#{proPhone}");
            }
            WHERE("id=#{id}");

        }}.toString();
    }

    public String FindProviderPaging(final Smbms_Provider provider) {
        return new SQL() {{
            SELECT("*");
            FROM("smbms_provider");
            if (provider.getProAddress() != null) {
                AND();
                WHERE("proAddress=#{proAddress}");
            }
            if (provider.getProCode() != null) {
                AND();
                WHERE("proCode  like  '%"+provider.getProCode()+"%'");
            }
            if (provider.getProContact() !=null) {
                AND();
                WHERE("proContact=#{proContact}");
            }
            if (provider.getProDesc() != null) {
                AND();
                WHERE("proDesc=#{proDesc}");
            }
            if (provider.getProFax() != null) {
                SET("proFax=#{proFax}");
            }
            if (provider.getProName() != null) {
                AND();
                WHERE("proName  like  '%"+provider.getProName()+"%'");
            }
            if (provider.getProPhone() != null) {
                AND();
                WHERE("proPhone=#{proPhone}");
            }
            ORDER_BY("creationDate desc  limit " + (provider.getPage() - 1) * provider.getRows() + "," + provider.getRows());
        }}.toString();
    }

    ;

    public String CountProviderPagings(final Smbms_Provider provider) {
        return new SQL() {{
            SELECT("ceil(count(*)/" + provider.getRows() + ")");
            FROM("smbms_provider");
            if (provider.getProAddress() != null) {
                AND();
                WHERE("proAddress=#{proAddress}");
            }
            if (provider.getProCode() != null) {
                AND();
                WHERE("proCode=#{proCode}");
            }
            if (provider.getProContact() !=null) {
                AND();
                WHERE("proContact=#{proContact}");
            }
            if (provider.getProDesc() != null) {
                AND();
                WHERE("proDesc=#{proDesc}");
            }
            if (provider.getProFax() != null) {
                SET("proFax=#{proFax}");
            }
            if (provider.getProName() != null) {
                AND();
                WHERE("proName=#{proName}");
            }
            if (provider.getProPhone() != null) {
                AND();
                WHERE("proPhone=#{proPhone}");
            }
        }}.toString();
    }
;



}
