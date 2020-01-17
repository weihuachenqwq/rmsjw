package com.itdr.controller;

import com.itdr.commom.ResponseCode;
import com.itdr.pojo.Shop;
import com.itdr.pojo.Users;
import com.itdr.service.ShopService;
import com.itdr.service.UserService;
import com.itdr.service.impl.ShopServiceImpl;
import com.itdr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/backed/shop/*")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    private ShopService shopService=new ShopServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI=request.getRequestURI();
        String[] split = requestURI.split("/");

        switch (split[split.length-1]){
            case "getall":
                getAllShop(request,response);
            break;
            case "toshou":
                toShou(request,response);
            break;
            case "toup":
                toUp(request,response);
                break;
            case "tocha":
                toCha(request,response);
                break;

        }
    }

    //获取商品所有数据
    private void getAllShop(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        ResponseCode allShop = shopService.getAllShop();
        request.setAttribute("slist",allShop);
        request.getRequestDispatcher("/WEB-INF/slist.jsp").forward(request,response);
    }
    //查询
    private void toCha(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String gjz = request.getParameter("gjz");
        ResponseCode cha=shopService.toCha(gjz);
        request.setAttribute("clist",cha);
        request.getRequestDispatcher("/WEB-INF/slist.jsp").forward(request,response);
    }
    //商品下架
    private void toShou(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String sid = request.getParameter("sid");
        ResponseCode allShop = shopService.toShou(sid);
        response.getWriter().write(allShop.getData().toString());
    }
    //上架
    private void toUp(HttpServletRequest request,HttpServletResponse response){
        String sname = request.getParameter("sname");
        String sprice = request.getParameter("sprice");
        String snum = request.getParameter("snum");

        String xq = request.getParameter("xq");
        ResponseCode<Shop> xinShop=shopService.toUp(sname,sprice,snum,xq);
    }

}
