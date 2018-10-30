package com.ztom.library.service.impl;

import com.ztom.library.dao.AppointmentDao;
import com.ztom.library.dao.BookDao;
import com.ztom.library.domain.Appointment;
import com.ztom.library.domain.Book;
import com.ztom.library.enums.AppointStateEnum;
import com.ztom.library.exception.AppointException;
import com.ztom.library.exception.NoNumberException;
import com.ztom.library.exception.RepeatAppointException;
import com.ztom.library.service.BookService;
import com.ztom.library.vo.AppointVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 16:52
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public List<Book> findBookList(int offset, int pageSize) {
        return bookDao.findAll(offset, pageSize);
    }

    @Override
    public Book findBookById(Long id) {
        return bookDao.findById(id);
    }

    @Override
    public AppointVO appoint(Appointment appointment) {
        try {
            // 执行预约操作,库存减一
            int reduceNumber = bookDao.reduceNumber(appointment.getBookId());
            if (reduceNumber <= 0) {
                // 库存不足
                throw new NoNumberException("库存不足");
            } else {
                // 执行预约操作,插入一条预约记录
                int insertAppoint = appointmentDao.insertAppointment(appointment);
                if (insertAppoint <= 0) {
                    // 插入预约失败,重复预约
//                    return new AppointVO(appointment.getBookId(),AppointStateEnum.REPEAT_APPOINT);
                    throw new RepeatAppointException("请勿重复预约");
                } else {
                    // 预约成功,返回预约信息
                    return new AppointVO(
                            appointment.getBookId(),
                            AppointStateEnum.SUCCESS,
                            appointment
                    );
                }
            }
        } catch (NoNumberException | RepeatAppointException e) {
            // 抛出异常,回滚事务
            throw e;
        } catch (Exception e) {
            // 抛出异常,回滚事务
            throw new AppointException("服务器内部错误:" + e.getMessage());
        }
    }

    @Override
    public void cancelAppoint(Long studentId, Long bookId) {
        bookDao.addNumber(bookId);
        appointmentDao.delAppointment(studentId, bookId);
    }


    @Override
    public int save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public int reduceNumber(Long id) {
        return bookDao.reduceNumber(id);
    }

    @Override
    public int delById(Long id) {
        return bookDao.delById(id);
    }
}
