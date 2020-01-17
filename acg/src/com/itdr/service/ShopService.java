package com.itdr.service;

import com.itdr.commom.ResponseCode;
import com.itdr.pojo.Shop;

public interface ShopService {
    ResponseCode getAllShop();

    ResponseCode toShou(String sid);


    ResponseCode<Shop> toUp(String sname, String sprice, String snum, String xq);

    ResponseCode toCha(String gjz);
}

