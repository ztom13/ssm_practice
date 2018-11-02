package com.ztom.domain;

import java.util.List;

/**
 * author:ztom
 * date:2018/11/1 19:50
 */
public class PageBean<T> {
    // 当前页
    private Integer pageNum;
    // 当前页显示条数
    private Integer pageSize;
    // 总记录数
    private Long total;
    // 总页数
    private Integer totalPage;
    // 页面数据
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return (int)(Math.ceil(total * 1.0 / pageSize));
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
