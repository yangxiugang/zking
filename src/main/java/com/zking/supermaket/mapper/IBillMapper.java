package com.zking.supermaket.mapper;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import com.zking.supermaket.pojo.Smbms_User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillMapper {

    @Select("select * from smbms_bill b  INNER JOIN  smbms_provider p ON  b.providerid=p.id   where b.id=#{id}  ")
    public Smbms_Bill FindBillById(Smbms_Bill bill);


    @Insert("insert into smbms_bill(billCode,productName,productUnit,productCount,totalPrice,isPayment,providerId)  value(#{billCode},#{productName},#{productUnit},#{productCount},#{totalPrice},#{isPayment},#{providerId})")
    public int AddBill(Smbms_Bill bill);


    @UpdateProvider(type = BillBuilerMapper.class, method = "UpdateBill")
    public int EditBill(Smbms_Bill bill);


    @Delete("delete from smbms_bill where id=#{id}")
    public int DeleteBill(Smbms_Bill bill);


    @SelectProvider(type = BillBuilerMapper.class, method = "FindBillPaging")
    public List<Smbms_Bill> FindBillPaging(Smbms_Bill bill);


    @SelectProvider(type = BillBuilerMapper.class, method = "CountBillPagings")
    public int CountBillPagings(Smbms_Bill bill);


    @Select("select * from smbms_provider  order by id")
    public List<Smbms_Provider> findProvider(Smbms_Provider provider);
}
