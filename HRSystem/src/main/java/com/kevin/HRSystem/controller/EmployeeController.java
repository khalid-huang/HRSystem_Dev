package com.kevin.HRSystem.controller;

import com.kevin.HRSystem.constant.ConstantManager;
import com.kevin.HRSystem.constant.WebConstant;
import com.kevin.HRSystem.model.Employee;
import com.kevin.HRSystem.service.EmpManagerService;
import com.kevin.HRSystem.service.MgrManagerService;
import com.kevin.HRSystem.vo.AttendVo;
import com.kevin.HRSystem.vo.PaymentVo;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.kevin.HRSystem.constant.ConstantManager.*;

@Controller
public class EmployeeController {

    @Resource
    private EmpManagerService empManagerService;

//    @RequestMapping(value = "/employeePunch",method = RequestMethod.GET)
//    public ModelAndView employeePunch(HttpServletRequest request) {
//
//        String user = (String)request.getSession().getAttribute(WebConstant.USER);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dutyDay = simpleDateFormat.format(new Date());
//        int punchIsValid = empManagerService.validPunch(user, dutyDay);
//
//        ModelAndView modelAndView = new ModelAndView("employee/punch");
//        modelAndView.addObject("punchIsValid", punchIsValid);
//        return modelAndView;
//
//    }
    //获取打卡异常
    @RequestMapping(value = "/viewUnPunch", method = RequestMethod.GET)
    public ModelAndView viewUnPunch(HttpServletRequest request) {
        String user = (String) request.getSession().getAttribute("user");
        List<AttendVo> unAttends = empManagerService.getUnAttend(user);

        ModelAndView modelAndView = new ModelAndView("employee/viewUnAttend");
        modelAndView.addObject("unAttends", unAttends);
        return modelAndView;

    }


    /**
     * 上班打卡
     * @return
     */
    @RequestMapping(value = "/employeeCome", method = RequestMethod.GET)
    public ModelAndView employeeCome(HttpServletRequest request) {
        String message = processPunch(request, true);

        ModelAndView modelAndView = new ModelAndView("employee/index");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
//
    @RequestMapping(value = "/employeeLeave", method = RequestMethod.GET)
    public ModelAndView employeeLeave(HttpServletRequest request) {
        String message = processPunch(request, false);

        ModelAndView modelAndView = new ModelAndView("employee/index");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "appChange", method = RequestMethod.GET)
    public ModelAndView appChange(@RequestParam("attId") long attId) {
        ModelAndView modelAndView = new ModelAndView("employee/appChange");
        List types = empManagerService.getAllType();
        modelAndView.addObject("types", types);
        modelAndView.addObject("attId", attId);
        return modelAndView;
    }

    @RequestMapping(value = "/processApp", method = RequestMethod.POST)
    public ModelAndView processApp(String attId, String typeId, String reason) {
        boolean result = empManagerService.addApplication(Integer.parseInt(attId), Integer.parseInt(typeId), reason);
        String message = "";
        if(result) {
            message = "您已经申请成功，等待经理审阅";
        } else {
            message = "申请失败，请注意不要重复申请";
        }
        ModelAndView modelAndView = new ModelAndView("employee/index");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

//    内部函数

    /**
     * 处理上下班打卡
     * @param request 请求实体
     * @param isCome true表示上班打卡，false表示下班打卡
     * @return
     */
    private String processPunch(HttpServletRequest request, boolean isCome) {
        String user = (String)request.getSession().getAttribute("user");
        System.out.println("---------打卡--------" + user);
        String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
        int result = empManagerService.punch(user, dutyDay, isCome);
        String message = "";
        switch (result) {
            case PUNCH_FALT:
                message = "打卡失败";
                break;
            case PUNCHED:
                message = "您已经打过卡了，不用重复打卡";
                break;
            case PUNCH_SUCC:
                message = "打卡成功";
                break;
        }
        return message;
    }



}
