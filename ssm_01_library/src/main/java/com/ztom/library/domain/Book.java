package com.ztom.library.domain;

/**
 * author:ztom
 * date:2018/10/25 14:22
 */
public class Book {
    private Long bookId;
    private String name;
    private Integer number;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("bookId=").append(bookId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", number=").append(number);
        sb.append('}');
        return sb.toString();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
