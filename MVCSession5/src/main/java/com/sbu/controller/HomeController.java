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
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    public UserManagerImpl userManagerImpl;

    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String homePage() 
    {
      return "home";
    }
    
    private String helperMethod (HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        ArrayList <String> list = userManagerImpl.getRoleList((int)session.getAttribute("role"));
        session.setAttribute("listItem",list);      
        return "home";
        
    }
    
   //should be separated
   @RequestMapping(value = {"/prof"}, method = RequestMethod.GET)
    public String crearPersonalProfPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
        if((int)request.getSession().getAttribute("role") != 2)
            //not correct -> hove to be load sutable error page
            return "error";            
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public String crearPersonalStudentPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
        if((int)request.getSession().getAttribute("role") != 1)
            //not correct -> hove to be load sutable error page
            return "error";            
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/manager"}, method = RequestMethod.GET)
    public String crearPersonalManagerPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
        if((int)request.getSession().getAttribute("role") != 3)
            //not correct -> hove to be load sutable error page
            return "error";            
        return helperMethod(request);        
    }
    
    
   /*
   @RequestMapping(value = "/check", method = RequestMethod.POST)
   public void checkUser(@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
   {
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
            String name = (String)request.getAttribute("name");
            String pass = (String)request.getAttribute("pass");
           //String name = userIn.getName();
           //String pass = userIn.getPass();
            User user = userManagerImpl.findLoginUser( name,pass);
            if(user == null)
                out.print("notFound");
            else
            {
                HttpSession session = request.getSession();
                session.setAttribute("id", user.getId());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("role", user.getRole());
                out.print("home");
            } 
            
        
   }
   
   @RequestMapping(value = "/addStudent2", method = RequestMethod.POST)
   public String addStudent2(@ModelAttribute("SpringWeb")Student student, Model model, HttpServletRequest request) {
      model.addAttribute("name", student.getName());
      model.addAttribute("age", student.getAge());
      model.addAttribute("id", student.getId());
      
      return "studentinfo";
   }
*/
}