package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.constant.WebConstant;
import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import com.kevin.HRSystem.vo.ApplicationVo;
import com.kevin.HRSystem.vo.SalaryVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class ManagerController {
    @Resource
    private EmpManagerService empManagerService;

    @Resource
    private MgrManagerService managerService;

////    打卡
//    @RequestMapping(value = "managerPunch",method = RequestMethod.GET)
//    public ModelAndView managerPunch() {
//    }

//    //查看历史工资
//    @RequestMapping(value = "viewManagerSalary", method = RequestMethod.GET)
//    public ModelAndView viewManagerSalary() {
//
//    }

    //签核申请
    @RequestMapping(value = "viewApp", method = RequestMethod.GET)
    public ModelAndView viewApp(HttpServletRequest request) {
        String user = (String)request.getSession().getAttribute(WebConstant.USER);
        List<ApplicationVo> apps = managerService.getApplicationsByManager(user);
        System.out.println("manager:viewApp:apps:" + apps.size());
        if(apps.size() > 0) {
            System.out.println(apps.get(0));
        }
        ModelAndView modelAndView = new ModelAndView("manager/viewApp");
        modelAndView.addObject("apps", apps);
        return modelAndView;
    }

    //管理部门员工
    @RequestMapping(value = "viewEmp", method = RequestMethod.GET)
    public ModelAndView viewEmp(HttpServletRequest request) {
        String user = (String)request.getSession().getAttribute(WebConstant.USER);
        List emps = managerService.getEmployeesByManager(user);
        ModelAndView modelAndView = new ModelAndView("manager/viewEmp");
        modelAndView.addObject("emps", emps);
        return modelAndView;
    }

    //新增员工
    @RequestMapping(value = "addEmp", method = RequestMethod.GET)
    public ModelAndView addEmp() {
        return new ModelAndView("manager/addEmp");
    }

    @RequestMapping(value = "processAddEmployee", method = RequestMethod.POST)
    public ModelAndView processAddEmployee(Employee employee, HttpServletRequest request) {
        System.out.println(employee);
        String mgr = (String) request.getSession().getAttribute(WebConstant.USER);
        managerService.addEmployee(employee, mgr);
        return new ModelAndView("manager/index");
    }

    //查看上月部门发薪
    @RequestMapping(value = "viewDeptSal", method = RequestMethod.GET)
    public ModelAndView viewDeptSal(HttpServletRequest request) {
        String mgr = (String)request.getSession().getAttribute(WebConstant.USER);
        List<SalaryVo> salarys = managerService.getSalarysByManger(mgr);

        ModelAndView modelAndView = new ModelAndView("manager/viewDeptSal");
        modelAndView.addObject("salarys", salarys);
        return modelAndView;
    }

    //这里应该是返回json
    //进行审批
    @RequestMapping(value = "/checkApp", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String> checkApp(@RequestParam(value = "result") String result, @RequestParam(value = "appId") long appId, HttpServletRequest request) {
        System.out.println("checkApp");
        System.out.println(result);
        System.out.println(appId);

        HashMap<String, String> checkResult = new HashMap<>();
        String mgr = (String) request.getSession().getAttribute(WebConstant.USER);

        if(result.equals("pass")) {
            managerService.check(appId, mgr, true);
            checkResult.put("message", "pass");
        } else if(result.equals("deny")) {
            managerService.check(appId, mgr, false);
            checkResult.put("message", "deny");
        } else {
//            throw new Exception("参数丢失");
            checkResult.put("message", "参数丢失");
        }
        return checkResult;
    }
}
