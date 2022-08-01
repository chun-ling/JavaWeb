package com.example.books.web;

import com.example.books.pojo.user;
import com.example.books.service.UserService;
import com.example.books.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YUChangcan
 * @date 2022/7/30 - 16:15
 */
@WebServlet(name = "LoginServlet",value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        user user = userService.login(new user(null,username,password,null));
        if(user == null){
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }else{
            System.out.println(user);
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
        }
    }
}
