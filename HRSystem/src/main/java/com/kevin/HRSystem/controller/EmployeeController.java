package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.constant.ConstantManager;
import com.kevin.HRSystem.constant.WebConstant;
import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.kevin.HRSystem.constant.ConstantManager.*;

@Controller
public class EmployeeController {

    @Resource
    private EmpManagerService empManagerService;

    @Resource
    private MgrManagerService mgrManagerService;

//    @RequestMapping(value = "/employeePunch",method = RequestMethod.GET)
//    public ModelAndView employeePunch() {
//
//    }
//
//    @RequestMapping(value = "/viewUnPunch", method = RequestMethod.GET)
//    public ModelAndView viewUnPunch() {
//
//    }
//
//    @RequestMapping(value = "/viewEmployeeSalary", method = RequestMethod.GET)
//    public ModelAndView viewEmployeeSalary() {
//
//    }
//
//    /**
//     * 上班打卡
//     * @return
//     */
//    @RequestMapping(value = "/employeeCome", method = RequestMethod.GET)
//    public ModelAndView employeeCome() {
//
//    }
//
//    @RequestMapping(value = "/employeeLeave", method = RequestMethod.GET)
//    public ModelAndView employeeLeave() {
//
//    }



}
