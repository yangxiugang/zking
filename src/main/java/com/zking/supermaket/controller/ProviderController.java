package com.zking.supermaket.controller;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import com.zking.supermaket.pojo.Smbms_User;
import com.zking.supermaket.service.IBillService;
import com.zking.supermaket.service.IProviderService;
import com.zking.supermaket.service.impl.BillServiceimpl;
import com.zking.supermaket.service.impl.ProviderServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProviderController {


    @Autowired
    private IProviderService ius = new ProviderServiceimpl();
    private Smbms_Provider provider = new Smbms_Provider();


    @RequestMapping(value = "FindProviderPaging")
    public String FindProviderPaging( @ModelAttribute("Showprovider") Smbms_Provider provider, Model model, HttpServletRequest request) {
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        provider.setPage(page);
        List<Smbms_Provider> lu = ius.FindProviderPaging(provider);
        provider.setMax(ius.CountProviderPagings(provider));
        Smbms_Provider p=new Smbms_Provider();
        p.setRows(1);
        provider.setAll(ius.CountProviderPagings(p));
        Map map = new HashMap();
        map.put("page", provider.getPage());
        map.put("rows", provider.getRows());
        map.put("max", provider.getMax());
        request.setAttribute("paramssss", map);
        request.setAttribute("providerList", lu);
        model.addAttribute("Showprovider", provider);
        return "forward:jsp/providerlist.jsp";
    }


    @RequestMapping(value = "FindProviderById")
    public String FindProviderById(HttpServletRequest request) {
        String id = request.getParameter("id");
        provider.setId(id);
        request.setAttribute("provider", ius.FindProviderById(provider));
        return "jsp/providerview";
    }


    @RequestMapping(value = "addProviderWindow")
    public String addProviderWindow(Model model) {
        model.addAttribute("Addprovider", provider);
        return "jsp/provideradd";
    }


    @RequestMapping(value = "addProvider")
    public String addProvider(@Validated @ModelAttribute("Addprovider") Smbms_Provider provider, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (ius.AddProvider(provider) > 0) {
                return "redirect:FindProviderPaging.action";
            }
        }
        List<FieldError> lf = bindingResult.getFieldErrors();
        for (FieldError error : lf) {
            System.out.println(error.getDefaultMessage());
        }
        return "jsp/provideradd";
    }

    @RequestMapping(value = "editProviderWindow")
    public String editProviderWindow(Model model, HttpServletRequest request) {
        String id = request.getParameter("id");
        provider.setId(id);
        Smbms_Provider u = ius.FindProviderById(provider);
        model.addAttribute("Editprovider", u);

        return "jsp/providermodify";
    }


    @RequestMapping(value = "editProvider")
    public String editProvider(@Validated({Smbms_User.Editverfigy.class}) @ModelAttribute("Editprovider") Smbms_Provider provider, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (ius.EditProvider(provider) > 0) {
                return "redirect:FindProviderPaging.action";
            }
        } else {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return "jsp/providermodify";
    }


    @RequestMapping(value = "deleteProvider")
    public String deleteProvider(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        provider.setId(id);
        String out = "y";
        String myreturn = "error";
        if (ius.DeleteProvider(provider) > 0) {
            out = "y";
            myreturn = "redirect:FindProviderPaging.action";
        }
        try {
            response.getWriter().print(out);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myreturn;
    }


}
