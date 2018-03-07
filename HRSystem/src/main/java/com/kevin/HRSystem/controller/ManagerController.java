package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class ManagerController {
    @Resource
    private EmpManagerService empManagerService;

    @Resource
    private MgrManagerService managerService;

//    打卡
    @RequestMapping(value = "managerPunch",method = RequestMethod.GET)
    public ModelAndView managerPunch() {
    }

    //查看历史工资
    @RequestMapping(value = "viewManagerSalary", method = RequestMethod.GET)
    public ModelAndView viewManagerSalary() {

    }

    //签核申请
    @RequestMapping(value = "viewApp", method = RequestMethod.GET)
    public ModelAndView viewApp() {

    }

    //管理部门员工
    @RequestMapping(value = "viewEmp", method = RequestMethod.GET)
    public ModelAndView viewEmp() {

    }

    //新增员工
    @RequestMapping(value = "addEmp", method = RequestMethod.GET)
    public ModelAndView addEmp() {

    }

    @RequestMapping(value = "processAddEmploee", method = RequestMethod.POST)
    public ModelAndView processAddEmploee() {

    }

    //查看上月部门发薪
    @RequestMapping(value = "viewDeptSal", method = RequestMethod.GET)
    public ModelAndView viewDeptSal() {

    }
}
