package com.cinema_ticketing_sys.support.utils;

import java.util.List;

/**
 * Created by huitianrui on 2017/5/23.
 * 分页辅助类
 * 用来保存分页信息，统一发送给前端
 */
public class Page<T> {

    private Integer pageSize = 2; //每页记录条数=2

    private Integer totalCount; //总记录条数

    private Integer totalPage; //总页数

    private Integer currPage; //当前页

    //private Integer startIndex; //开始索引

    private List<T> list; //结果集

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
