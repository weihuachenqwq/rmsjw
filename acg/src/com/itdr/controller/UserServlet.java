package com.itdr.controller;

import com.itdr.commom.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/backed/user/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
private UserService userService=new UserServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI=request.getRequestURI();
        String[] split = requestURI.split("/");

        switch (split[split.length-1]){
            case "login":login(request,response);
            break;
            case "getmsg":getmsg(request,response);
            break;
        }
    }
    //管理员登录
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        ResponseCode<Users> login = userService.login(username, password);
        //登录成功保存用户信息
        if (login.getData()!=null){
            HttpSession session = request.getSession();
            Users data = login.getData();
            session.setAttribute("us",data);
            //request.setAttribute("user",login);

            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }
       else {
            request.getRequestDispatcher("/WEB-INF/uhome.jsp").forward(request,response);
        }


    }
    //管理员信息
    private void getmsg(HttpServletRequest request,HttpServletResponse response){
        System.out.println("管理员信息");
    }

}