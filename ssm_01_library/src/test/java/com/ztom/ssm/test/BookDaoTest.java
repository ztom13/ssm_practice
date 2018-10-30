package com.ztom.ssm.test;

import com.ztom.library.dao.BookDao;
import com.ztom.library.domain.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 15:27
 */
public class BookDaoTest extends BaseTest {
    @Autowired
    private BookDao bookDao;


    @Test
    public void findAll(){
        List<Book> bookList = bookDao.findAll(0,20);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void findById(){
        Book book = bookDao.findById(1002L);
        System.out.println(book);
    }

    @Test
    public void save(){
        Book book = new Book();
        book.setName("spring源码解读");
        book.setNumber(57);
        bookDao.save(book);
    }

    @Test
    public void update(){
        Book book = new Book();
        book.setBookId(1000L);
        book.setName("Java编程思想");
        book.setNumber(10);
        bookDao.update(book);
    }

    @Test
    public void reduceNumber(){
        int i = bookDao.reduceNumber(1000L);
        System.out.println(i);
    }
}
