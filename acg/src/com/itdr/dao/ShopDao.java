package com.itdr.dao;

import com.itdr.pojo.Shop;
import com.itdr.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ShopDao {



    public List<Shop> selectAll(){
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="select sid,sname,sprice,snum,shou,create_time,update_time from shop";
        List<Shop> shops =null;
        try {
           shops= qr.query(sql, new BeanListHandler<Shop>(Shop.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }
    public List<Shop> selectByGjz(String gjz){
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="select sid,sname,sprice,snum,shou,create_time,update_time from shop where sname like ?";
        String i="%"+gjz+"%";
        List<Shop> shops =null;
        try {
           shops= qr.query(sql, new BeanListHandler<Shop>(Shop.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    public Shop selectBySid(int i) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="select sid,sname,sprice,snum,shou,create_time,update_time from shop where sid = ?";
        Shop shops =null;
        try {
            shops= qr.query(sql, new BeanHandler<Shop>(Shop.class),i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    public int updateBySid(int i) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="update shop set shou = 1 where sid = ?";
       int m=0;
        try {
            m= qr.update(sql,i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    //增加商品
    public Shop selectBySname(String sname) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="select sid,sname,sprice,snum,shou,create_time,update_time,xq from shop where sname = ?";
        Shop shops =null;
        try {
            shops= qr.query(sql, new BeanHandler<Shop>(Shop.class),sname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    public int insertBySname(String sname,int sprice,int snum,String xq) {
        QueryRunner qr=new QueryRunner(C3P0Util.getCom());
        String sql="insert into shop values(null,?,?,null,?,null,null,0,0,?)?";
        int m=0;
        try {
            m= qr.update(sql,sname,sprice,snum,xq);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
    //修改商品

}
