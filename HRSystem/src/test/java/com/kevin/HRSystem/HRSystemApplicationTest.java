package com.kevin.HRSystem;

import com.kevin.HRSystem.dao.ApplicationDao;
import com.kevin.HRSystem.dao.AttendDao;
import com.kevin.HRSystem.dao.EmployeeDao;
import com.kevin.HRSystem.dao.UserDao;
import com.kevin.HRSystem.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class HRSystemApplicationTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private AttendDao attendDao;

    @Test
    public void testSelectUser() throws Exception {
//        long id = 1;
//        User user = userDao.selectUser(id);
//        System.out.println(user);
//
//        User user1 = userDao.selectById(id);
//        System.out.println(user1);
//
//        user1.setUsername("user");
//        userDao.save(user1);

        //测试employee
//        long e_id = 3;
//        Employee employee = employeeDao.selectById(e_id);
//        System.out.println(employee.getManager().getId());
//        System.out.println(employee.toString());

        //测试attend
        long attend_id = 1;
        Attend attend = attendDao.findById(attend_id);
        System.out.println(attend.toString());

        System.out.println(attend.getAttendType().getId());
        System.out.println(attend.getEmployee().getId());

        AttendType attendType = attend.getAttendType();
        attendType.setId(3);
        attend.setAttendType(attendType);
        attendDao.update(attend);


//        Application application = applicationDao.selectApplicationByID(id);
//        System.out.println(application.getAttendType());
//        Application application = new Application();
//        application.setApplicationReason("reason");
//        application.setApplicationResult(true);
//
//        AttendType attendType = new AttendType();
//        attendType.setAmerceAmount(-10);
//        attendType.setTypeName("事假");
//        Attend attend = new Attend();
//        attend.set
//        application.setAttend();
    }
}
