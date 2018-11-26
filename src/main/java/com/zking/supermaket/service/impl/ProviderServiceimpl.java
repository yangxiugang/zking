package com.zking.supermaket.service.impl;

import com.zking.supermaket.mapper.IBillMapper;
import com.zking.supermaket.mapper.IProviderMapper;
import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import com.zking.supermaket.service.IBillService;
import com.zking.supermaket.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProviderServiceimpl")
public class ProviderServiceimpl implements IProviderService {
    @Autowired
    private IProviderMapper ibm;

    @Override
    public Smbms_Provider FindProviderById(Smbms_Provider provider) {
        return ibm.FindProviderById(provider);
    }

    @Override
    public int AddProvider(Smbms_Provider provider) {
        return ibm.AddProvider(provider);
    }

    @Override
    public int EditProvider(Smbms_Provider provider) {
        return ibm.EditProvider(provider);
    }

    @Override
    public int DeleteProvider(Smbms_Provider provider) {
        return ibm.DeleteProvider(provider);
    }

    @Override
    public List<Smbms_Provider> FindProviderPaging(Smbms_Provider provider) {
        return ibm.FindProviderPaging(provider);
    }

    @Override
    public int CountProviderPagings(Smbms_Provider provider) {
        return ibm.CountProviderPagings(provider);
    }
}
