package com.ztom.library.controller;

import com.ztom.library.domain.Appointment;
import com.ztom.library.domain.Book;
import com.ztom.library.enums.AppointStateEnum;
import com.ztom.library.exception.NoNumberException;
import com.ztom.library.exception.RepeatAppointException;
import com.ztom.library.service.BookService;
import com.ztom.library.vo.AppointVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 20:29
 */
@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/findBookList", method = RequestMethod.GET)
    public ModelAndView findBookList() {
        ModelAndView model = new ModelAndView();

        List<Book> bookList = bookService.findBookList(0, 570);
        model.addObject("bookList", bookList);

        model.setViewName("showBookList");
        return model;
    }

    @RequestMapping(value = "/appoint", method = RequestMethod.GET)
    public ModelAndView appoint(Long bookId, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

        Long stuId = Long.parseLong((String) request.getSession().getAttribute("stuId"));
        Appointment appointment = new Appointment();
        appointment.setBookId(bookId);
        appointment.setStudentId(stuId);
        appointment.setAppointTime(new Date());
        Book book = bookService.findBookById(bookId);
        appointment.setBook(book);
        AppointVO appoint = null;
        try {
            appoint = bookService.appoint(appointment);
        } catch (NoNumberException e) {
            appoint = new AppointVO(bookId, AppointStateEnum.NO_NUM, appointment);
        } catch (RepeatAppointException e) {
            appoint = new AppointVO(bookId, AppointStateEnum.REPEAT_APPOINT, appointment);
        } catch (Exception e) {
            appoint = new AppointVO(bookId, AppointStateEnum.INNER_ERROR, appointment);
        }
        model.addObject("appoint", appoint);
        model.setViewName("showAppointMsg");
        return model;
    }

    @RequestMapping(value = "/cancelAppoint",method = RequestMethod.GET)
    public String cancelAppoint(Long studentId,Long bookId){

        bookService.cancelAppoint(studentId,bookId);

        return "redirect:findBookList";
    }
}
