/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

import com.sbu.controller.model.Student;
import com.sbu.controller.model.UserIn;
import com.sbu.dao.model.User;
import com.sbu.service.impl.UserManagerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    public UserManagerImpl userManagerImpl;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mainPage() 
    {
      return "main";
    }
   
   @RequestMapping(value = "/check", method = RequestMethod.POST)
   public void checkUser(@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
   {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
           // String name = (String)request.getParameter("name");
           // String pass = (String)request.getParameter("pass");
            String name = userIn.getName();
            String pass = userIn.getPass();
            User user = userManagerImpl.findLoginUser(name,pass);
            if(user == null)
                out.print("notFound");
            else
            {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getRefId());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                
                switch (user.getRole())
                {
                    case 1 : 
                       out.print("home/student"); 
                        break;
                    case 2 :
                        out.print("home/prof");
                        break;
                    case 3 :
                        out.print("home/manager");
                        break;
                }            
            }    
            
   }
   
}