package com.duan.pojo;

import java.util.List;

/**
 * 封装分页数据发送到前端
 * @param <T>
 */
public class PageBean<T> {
    //商品总数
    private int totalCount;
    //当列数据
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
