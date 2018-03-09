/**
 * 用于存放员工与经理的共同方法
 */
package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.constant.ConstantManager;
import com.kevin.HRSystem.constant.WebConstant;
import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import com.kevin.HRSystem.vo.PaymentVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommonController {

    @Resource
    private EmpManagerService empManagerService;

    @Resource
    private MgrManagerService mgrManagerService;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        return new ModelAndView("login", "employee", new Employee());
    }

    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public ModelAndView processLogin(@ModelAttribute("employee") Employee employee, HttpServletRequest request) {
        System.out.println(employee);
        System.out.println(request.getProtocol());
        ModelAndView modelAndView;
        int result = empManagerService.validLogin(employee);
        String message;
        //登录结果为普通员工
        System.out.println(result);
        if(result == ConstantManager.LOGIN_EMP) {
            //设置Session
            request.getSession().setAttribute(WebConstant.USER, employee.getName());
            request.getSession().setAttribute(WebConstant.LEVEL, WebConstant.EMP_LEVEL);

            message = "您已成功登录系统,您的身份是普通员工";
            System.out.println(message);
//            modelAndView = new ModelAndView("success");
            modelAndView = new ModelAndView("employee/index");
            modelAndView.addObject("message", message);
            return  modelAndView;
        } else if(result == ConstantManager.LOGIN_MGR){
            request.getSession().setAttribute(WebConstant.USER, employee.getName());
            request.getSession().setAttribute(WebConstant.LEVEL, WebConstant.MGR_LEVEL);

            message = "您已成功登录系统,您的身份是经理";
            System.out.println(message);
//            modelAndView = new ModelAndView("success");
            modelAndView = new ModelAndView("manager/index");
            modelAndView.addObject("message", message);
            return modelAndView;
        } else {
            message = "用户名与密码不匹配，登录失败";
            System.out.println(message);
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("message", message);
            return modelAndView;
        }
    }


    @RequestMapping(value = {"/employeePunch", "/managerPunch"}, method = RequestMethod.GET)
    public ModelAndView punch(HttpServletRequest request) {

        String user = (String)request.getSession().getAttribute(WebConstant.USER);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dutyDay = simpleDateFormat.format(new Date());
        int punchIsValid = empManagerService.validPunch(user, dutyDay);

        ModelAndView modelAndView;
        if(request.getServletPath().equals("/employeePunch")) {
            modelAndView = new ModelAndView("employee/punch");
        } else {
            modelAndView = new ModelAndView("manager/punch");
        }

        modelAndView.addObject("punchIsValid", punchIsValid);
        return modelAndView;

    }

    //查看本人历史工资
    @RequestMapping(value = {"viewEmployeeSalary", "viewManagerSalary"}, method = RequestMethod.GET)
    public ModelAndView viewEmployeeSalary(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("user");

        System.out.println("user: " + user);

        List<PaymentVo> salarys = empManagerService.employeeSalary(user);
        ModelAndView modelAndView;
        System.out.println(salarys.size());
        System.out.println(request.getServletPath());
        if(request.getServletPath().equals("/viewEmployeeSalary")) {
            modelAndView = new ModelAndView("employee/viewSalary");
        } else {
            modelAndView = new ModelAndView("manager/viewSalary");
        }
        modelAndView.addObject("salarys", salarys);
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //使session无效化
        session.invalidate();
        return new ModelAndView("main");
    }


}
