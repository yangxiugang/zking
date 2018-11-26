package com.zking.supermaket.mapper;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProviderMapper {


    @Select("select * from smbms_provider where id=#{id}  ")
    public Smbms_Provider FindProviderById(Smbms_Provider provider);


    @Insert("insert into smbms_provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax)  value(#{proCode},#{proName},#{proDesc},#{proContact},#{proPhone},#{proAddress},#{proFax})")
    public int AddProvider(Smbms_Provider provider);


    @UpdateProvider(type = ProviderBuilerMapper.class, method = "UpdateProviders")
    public int EditProvider(Smbms_Provider provider);


    @Delete("delete from smbms_provider where id=#{id}")
    public int DeleteProvider(Smbms_Provider provider);


    @SelectProvider(type = ProviderBuilerMapper.class, method = "FindProviderPaging")
    public List<Smbms_Provider> FindProviderPaging(Smbms_Provider provider);


    @SelectProvider(type = ProviderBuilerMapper.class, method = "CountProviderPagings")
    public int CountProviderPagings(Smbms_Provider provider);

}
