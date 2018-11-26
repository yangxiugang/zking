package com.zking.supermaket.service;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;

import java.util.List;

public interface IBillService {

    public Smbms_Bill FindBillById(Smbms_Bill bill);



    public int AddBill(Smbms_Bill bill);


    public int EditBill(Smbms_Bill bill);


     public int DeleteBill(Smbms_Bill bill);


     public List<Smbms_Bill> FindBillPaging(Smbms_Bill bill);

    public int CountBillPagings(Smbms_Bill bill);

    public List<Smbms_Provider> findProvider(Smbms_Provider provider);

}
