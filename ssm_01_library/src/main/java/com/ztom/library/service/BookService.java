package com.ztom.library.service;

import com.ztom.library.domain.Appointment;
import com.ztom.library.domain.Book;
import com.ztom.library.vo.AppointVO;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 15:15
 */
public interface BookService {
    /**
     * 查看图书列表
     * @return
     */
    List<Book> findBookList(int offset,int pageSize);

    /**
     * 根据id查询图书
     * @param id
     * @return
     */
    Book findBookById(Long id);

    /**
     * 根据stuId+bookId来预约图书
     * @param appointment
     * @return
     */
    AppointVO appoint(Appointment appointment);

    /**
     * 取消预约
     * @param studentId
     * @param bookId
     */
    void cancelAppoint(Long studentId,Long bookId);

    /**
     * 根据id减少图书
     * @param id 图书id
     */
    int reduceNumber(Long id);



    /***********************管理员操作***********************/
    /**
     * 添加图书
     * @param book
     */
    int save(Book book);

    /**
     * 修改图书信息
     * @param book
     */
    int update(Book book);


    /**
     * 根据id删除此类所有图书
     * @param id 图书id
     */
    int delById(Long id);
}
