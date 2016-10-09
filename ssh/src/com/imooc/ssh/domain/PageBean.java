package com.imooc.ssh.domain;

import java.util.List;

/**
 * 分页显示类
 */
public class PageBean<T> {
    //当前页数
    private int currPage;
    //总页数
    private int totalPage;
    //每页显示条数
    private int pageSize;
    //总记录数
    private int totalCount;
    //每页显示的数据
    private List<T> list;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrPage() {

        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }
}
