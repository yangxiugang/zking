package com.zking.supermaket.controller;

import com.zking.supermaket.pojo.Smbms_Bill;
import com.zking.supermaket.pojo.Smbms_Provider;
import com.zking.supermaket.pojo.Smbms_Role;
import com.zking.supermaket.pojo.Smbms_User;
import com.zking.supermaket.service.IBillService;
import com.zking.supermaket.service.IUserService;
import com.zking.supermaket.service.impl.BillServiceimpl;
import com.zking.supermaket.service.impl.UserServiceimpl;
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
public class BillController {


    @Autowired
    private IBillService ius = new BillServiceimpl();
    private Smbms_Bill bill = new Smbms_Bill();

    public Smbms_Bill CommonMap() {
        List<Smbms_Provider> lp = ius.findProvider(new Smbms_Provider());
        Map<String, Object> maps = new HashMap<>();
        maps.put("0", "--请选择--");
        for (Smbms_Provider provider : lp) {
            maps.put(provider.getId(), provider.getProName());
        }
        Map<String, Object> maps2 = new HashMap<>();
        maps2.put("0", "--请选择--");
        maps2.put("1", "未支付");
        maps2.put("2", "已付款");
        bill.setProNameList(maps);
        bill.setIsPaymentList(maps2);
        return bill;
    }


    @RequestMapping(value = "FindBillPaging")
    public String FindBillPaging(@ModelAttribute("Showbill") Smbms_Bill bill, Model model, HttpServletRequest request) {
        int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        bill.setPage(page);
        List<Smbms_Bill> lu = ius.FindBillPaging(bill);
        bill.setMax(ius.CountBillPagings(bill));
        Smbms_Bill b = new Smbms_Bill();
        b.setRows(1);
        bill.setAll(ius.CountBillPagings(b));
        Map map = new HashMap();
        map.put("page", bill.getPage());
        map.put("rows", bill.getRows());
        map.put("max", bill.getMax());
        request.setAttribute("paramssss", map);
        request.setAttribute("billList", lu);
        bill.setIsPaymentList(CommonMap().getIsPaymentList());
        bill.setProNameList(CommonMap().getProNameList());
        model.addAttribute("Showbill", bill);
        return "forward:jsp/billlist.jsp";
    }


    @RequestMapping(value = "FindBillById")
    public String FindBillById(HttpServletRequest request) {
        int id = Integer.valueOf( request.getParameter("id"));
        bill.setId(id);
        request.setAttribute("Showbill", ius.FindBillById(bill));
        return "jsp/billview";
    }


    @RequestMapping(value = "addBillWindow")
    public String addBillWindow(Model model) {
        bill.setIsPaymentList(CommonMap().getIsPaymentList());
        bill.setProNameList(CommonMap().getProNameList());
        model.addAttribute("Addbill", bill);
        return "jsp/billadd";
    }


    @RequestMapping(value = "addBill")
    public String addBill(Model model,@Validated @ModelAttribute("Addbill") Smbms_Bill bill, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (ius.AddBill(bill) > 0) {
                return "redirect:FindBillPaging.action";
            }
        }
        List<FieldError> lf = bindingResult.getFieldErrors();
        for (FieldError error : lf) {
            System.out.println(error.getDefaultMessage());
        }
        bill.setIsPaymentList(CommonMap().getIsPaymentList());
        bill.setProNameList(CommonMap().getProNameList());
        model.addAttribute("Addbill", bill);
        return "jsp/billadd";
    }

    @RequestMapping(value = "editBillWindow")
    public String editBillWindow(Model model, HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id")) ;
        bill.setId(id);
        Smbms_Bill u = ius.FindBillById(bill);
        u.setIsPaymentList(CommonMap().getIsPaymentList());
        u.setProNameList(CommonMap().getProNameList());
        model.addAttribute("Editbill", u);
        return "jsp/billmodify";
    }


    @RequestMapping(value = "editBill")
    public String editBill(@Validated({Smbms_User.Editverfigy.class}) @ModelAttribute("Addbill") Smbms_Bill bill, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (ius.EditBill(bill) > 0) {
                return "redirect:FindBillPaging.action";
            }
        } else {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }
        return "jsp/billmodify";
    }


    @RequestMapping(value = "deleteBill")
    public String deleteBill(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.valueOf( request.getParameter("id"));
        bill.setId(id);
        String out = "n";
        String myreturn = "error";
        if (ius.DeleteBill(bill) > 0) {
            out = "y";
            myreturn = "redirect:FindBillPaging.action";
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
