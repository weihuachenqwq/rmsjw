package com.itdr.configs;

import com.itdr.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/backed/*")
public class FullFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//乱码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

//管理校验
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String[] split = requestURI.split("/");
        HttpSession session = ((HttpServletRequest) request).getSession();
        Users us = (Users) session.getAttribute("us");
        if ("login".equals(split[split.length-1])){
            chain.doFilter(request,response);

        }else {

            if (us==null||us.getType()!=5){
                request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request,response);
            } else {
                chain.doFilter(request, response);
            }

        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
