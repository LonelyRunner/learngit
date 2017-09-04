package com.zh.hib.pojo;

import java.sql.Date;

/**
 * Created by ZH on 2017/3/15.
 */
public class News {

    private Integer nId;

    private String nTitle;

    private String nAuthor;

    private Date nDate;

    public News() {
    }

    public News(String nTitle, String nAuthor, Date nDate) {
        this.nTitle = nTitle;
        this.nAuthor = nAuthor;
        this.nDate = nDate;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnAuthor() {
        return nAuthor;
    }

    public void setnAuthor(String nAuthor) {
        this.nAuthor = nAuthor;
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    @Override
    public String toString() {
        return "News{" +
                "nId=" + nId +
                ", nTitle='" + nTitle + '\'' +
                ", nAuthor='" + nAuthor + '\'' +
                ", nDate=" + nDate +
                '}';
    }
}
