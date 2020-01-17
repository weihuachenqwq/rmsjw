package com.itdr.service.impl;

import com.itdr.commom.ResponseCode;
import com.itdr.dao.ShopDao;
import com.itdr.pojo.Shop;
import com.itdr.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private ShopDao shopDao=new ShopDao();

    @Override
    public ResponseCode getAllShop() {
        List<Shop> shopList=shopDao.selectAll();
        return ResponseCode.toSuccess(shopList);
    }

    @Override
    public ResponseCode toCha(String gjz) {

        if (gjz==null||"".equals(gjz)){
           return ResponseCode.toDefeated("非法参数");
       }
        List<Shop> gjz1 = shopDao.selectByGjz(gjz);
        return ResponseCode.toSuccess(gjz1);
    }
//下架
    @Override
    public ResponseCode toShou(String sid) {
        if (sid==null||"".equals(sid)){
            return ResponseCode.toDefeated("非法参数");
        }
        int i = Integer.parseInt(sid);
        //查找商品
        Shop p=shopDao.selectBySid(i);
        if (p==null){
            return ResponseCode.toDefeated("null");
        }
        //修改商品
        int i2=shopDao.updateBySid(i);
        if (i2<0){
            return ResponseCode.toDefeated("Defeated");
        }
        return ResponseCode.toSuccess(i2);
    }
//上架商品
    @Override
    public ResponseCode toUp(String sname,String sprice,String snum,String xq) {
        if (sname==null||"".equals(sname)){
            return ResponseCode.toDefeated("非法参数");
        }//查找商品
        Shop s = shopDao.selectBySname(sname);
        if (s!=null){
            return ResponseCode.toDefeated("已有");
        }
        return null;
    }



}
