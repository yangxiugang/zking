package com.zking.supermaket.service;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;

import java.util.List;

public interface IProviderService {

    public Smbms_Provider FindProviderById(Smbms_Provider provider);



    public int AddProvider(Smbms_Provider provider);


    public int EditProvider(Smbms_Provider provider);


    public int DeleteProvider(Smbms_Provider provider);


    public List<Smbms_Provider> FindProviderPaging(Smbms_Provider provider);

    public int CountProviderPagings(Smbms_Provider provider);
}
