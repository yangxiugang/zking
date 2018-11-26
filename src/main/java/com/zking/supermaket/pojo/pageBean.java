package com.zking.supermaket.pojo;

import java.io.Serializable;

public class pageBean  implements Serializable {

    private int page=1;
    private int rows=5;
    private int max;
    private int all;



    public pageBean() {
    }

    public pageBean(int page, int rows,int max) {
        this.page = page;
        this.rows = rows;
        this.max = max;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "pageBean{" +
                "page=" + page +
                ", rows=" + rows +
                ", max=" + max +
                '}';
    }
}
