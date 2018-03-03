package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class EmployeeController {

    @Resource
    private EmpManagerService empManagerService;

    @Resource
    private MgrManagerService mgrManagerService;

    @RequestMapping("/loginPage")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }


}
