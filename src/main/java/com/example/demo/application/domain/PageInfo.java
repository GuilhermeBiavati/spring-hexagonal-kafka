package com.example.demo.application.domain;

public class PageInfo {
    private int pageNumber;
    private int pageSize;

    public PageInfo() {

    }

    public PageInfo(int pageNumber, int pageSize) {
        setPageNumber(pageNumber);
        setPageSize(pageSize);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
