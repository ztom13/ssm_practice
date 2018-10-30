package com.ztom.ssm.test;

import com.ztom.library.dao.AppointmentDao;
import com.ztom.library.domain.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 17:02
 */
public class AppointmentDaoTest extends BaseTest {
    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void insertAppointment(){
        Appointment appointment = new Appointment();
        appointment.setStudentId(5704250L);
        appointment.setBookId(1000L);
        appointment.setAppointTime(new Date());

        int i = appointmentDao.insertAppointment(appointment);
        System.out.println(i);
    }

    @Test
    public void findAppointById(){
        Appointment appoint = appointmentDao.findAppointById(5704250L, 1000L);
        System.out.println(appoint);
    }
}
