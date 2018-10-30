package com.ztom.library.domain;

import java.util.Date;
import java.util.List;

/**
 * author:ztom
 * date:2018/10/25 14:27
 */
public class Appointment {
    private Long bookId;
    private Long studentId;
    private Date appointTime;
    // stuId+bookId查询出唯一一本书
    private Book book;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Appointment{");
        sb.append("bookId=").append(bookId);
        sb.append(", studentId=").append(studentId);
        sb.append(", appointTime=").append(appointTime);
        sb.append(", book=").append(book);
        sb.append('}');
        return sb.toString();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

}
