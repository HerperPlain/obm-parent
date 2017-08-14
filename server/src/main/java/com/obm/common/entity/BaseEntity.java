package com.obm.common.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{
    public int pageSize = 10;
    public int pageNumber = 1;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
