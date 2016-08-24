package cn.zw.dto;

import java.util.List;
/**
 * @description 分页对象
 * @auther 'Amos'
 * @created 2016/8/5  16:12
 */
public class Page<T> {



    private int  page;// 当前页
    private int pageSize; // 每页显示的条数
    private  int pages; // 总页数
    private long totals; //  中条数
    private List<T> datas;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotals() {
        return totals;
    }

    public void setTotals(long totals) {
        this.totals = totals;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }


    public Page(com.github.pagehelper.Page page) {
        this.datas = page.getResult();
        this.page = page.getPageNum();
        this.pageSize= page.getPageSize();
        this.pages = page.getPages();
        this.totals = page.getTotal();

    }
}
