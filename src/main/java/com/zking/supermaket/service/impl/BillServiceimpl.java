package com.zking.supermaket.service.impl;

import com.zking.supermaket.mapper.IBillMapper;
import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import com.zking.supermaket.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BillServiceimpl")
public class BillServiceimpl implements IBillService {
    @Autowired
    private IBillMapper ibm;

    @Override
    public Smbms_Bill FindBillById(Smbms_Bill bill) {
        return ibm.FindBillById(bill);
    }


    @Override
    public int AddBill(Smbms_Bill bill) {
        return ibm.AddBill(bill);
    }

    @Override
    public int EditBill(Smbms_Bill bill) {
        return ibm.EditBill(bill);
    }

    @Override
    public int DeleteBill(Smbms_Bill bill) {
        return ibm.DeleteBill(bill);
    }

    @Override
    public List<Smbms_Bill> FindBillPaging(Smbms_Bill bill) {
        return ibm.FindBillPaging(bill);
    }

    @Override
    public int CountBillPagings(Smbms_Bill bill) {
        return ibm.CountBillPagings(bill);
    }

    @Override
    public List<Smbms_Provider> findProvider(Smbms_Provider provider) {
        return ibm.findProvider(provider);
    }
}
