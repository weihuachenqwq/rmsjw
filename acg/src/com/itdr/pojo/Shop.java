package com.itdr.pojo;

import java.util.Date;

public class Shop {
    private Integer sid;
   private double sprice;
   private int snum;//库存
    private int shou;
    private int stype;
    private String sname;
    private Date create_time;
    private Date update_time;
    private String xq;//详情

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public int getShou() {
        return shou;
    }

    public void setShou(int shou) {
        this.shou = shou;
    }

    public int getStype() {
        return stype;
    }

    public void setStype(int stype) {
        this.stype = stype;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public double getSprice() {
        return sprice;
    }

    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
