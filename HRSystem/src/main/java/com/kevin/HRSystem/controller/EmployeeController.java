package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class EmployeeController {

    @Resource
    private EmpManagerService empManagerService;

    @Resource
    private MgrManagerService mgrManagerService;

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView showLoginPage() {
        return new ModelAndView("login", "employee", new Employee());
    }

    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public ModelAndView processLogin(@ModelAttribute("employee") Employee employee) {
        System.out.println(employee);
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }


}
