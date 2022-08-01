package com.example.books.web;

import com.example.books.pojo.user;
import com.example.books.service.UserService;
import com.example.books.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author YUChangcan
 * @date 2022/7/30 - 8:44
 */
@WebServlet(name = "RegistServlet",value = "/registServlet")
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if("abcde".equalsIgnoreCase(code)){
            if(userService.existsUsername(name)){
                System.out.println("the username has existed");
            }else{
                userService.registUser(new user(null,name,password,email));
                req.getRequestDispatcher("pages/user/regist_success.html").forward(req,resp);

            }
        }else{
            System.out.println("the code is wrong");
            req.getRequestDispatcher("pages/user/regist.html").forward(req,resp);
        }
    }
}
