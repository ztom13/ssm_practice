package com.ztom.ssm.test;

import com.ztom.library.domain.Appointment;
import com.ztom.library.domain.Book;
import com.ztom.library.enums.AppointStateEnum;
import com.ztom.library.exception.NoNumberException;
import com.ztom.library.exception.RepeatAppointException;
import com.ztom.library.service.BookService;
import com.ztom.library.vo.AppointVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 18:25
 */
public class BookServiceTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void findBookList() {
        List<Book> bookList = bookService.findBookList(0, 20);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void appoint() {
        Appointment appointment = new Appointment();
        appointment.setBookId(1000L);
        appointment.setStudentId(5704250L);
        appointment.setAppointTime(new Date());
        AppointVO appoint = null;
        try {
            appoint = bookService.appoint(appointment);
        } catch (NoNumberException e) {
            appoint = new AppointVO(appointment.getBookId(), AppointStateEnum.NO_NUM);
        } catch (RepeatAppointException e){
            appoint = new AppointVO(appointment.getBookId(),AppointStateEnum.REPEAT_APPOINT);
        }
        System.out.println(appoint);
    }
}
