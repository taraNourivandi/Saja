/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

//input model
import com.sbu.controller.model.Student;
import com.sbu.controller.model.UserIn;
import com.sbu.controller.model.CourseIn;

//dao model
import com.sbu.dao.model.Modir;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stdtable;
import com.sbu.dao.model.User;
import com.sbu.dao.model.Course;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Major;

//service imp
import com.sbu.service.impl.ManagerManagerImpl;
import com.sbu.service.impl.ProfManagerImpl;
import com.sbu.service.impl.UserManagerImpl;
import com.sbu.service.impl.StdManagerImpl;
import com.sbu.service.impl.CourseManagerImpl;

//others
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    
    @Autowired
    public ProfManagerImpl profManagerImpl;
    
    @Autowired
    public StdManagerImpl stdManagerImpl;
    
    @Autowired
    public ManagerManagerImpl managerManagerImpl;
    
    @Autowired
    public CourseManagerImpl courseManagerImpl;
    
    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String homePage() 
    {
      return "home";
    }
    
    private String helperMethod (HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        //ArrayList <String> list = userManagerImpl.getRoleList((int)session.getAttribute("role"));
        HashMap list = userManagerImpl.getRoleList((int)session.getAttribute("role"));
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
        int id = (int) request.getSession().getAttribute("id");
        Prof prof = profManagerImpl.findProf(id);
        String name = prof.getName();
        request.getSession().setAttribute("name", name);
        
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public String crearPersonalStudentPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
        if((int)request.getSession().getAttribute("role") != 1)
            //not correct -> hove to be load sutable error page
            return "error"; 
        int id = (int) request.getSession().getAttribute("id");
        Stdtable std = stdManagerImpl.findProf(id);
        String name = std.getName();
        request.getSession().setAttribute("name", name);
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/manager"}, method = RequestMethod.GET)
    public String crearPersonalManagerPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
        if((int)request.getSession().getAttribute("role") != 3)
            //not correct -> hove to be load sutable error page
            return "error"; 
        
        int id = (int) request.getSession().getAttribute("id");
        Modir manager = managerManagerImpl.findProf(id);
        String name = manager.getName();
        request.getSession().setAttribute("name", name);
        
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public void logout (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
        request.getSession().removeAttribute("id");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("role");
        request.getSession().removeAttribute("name");
        
        response.sendRedirect("../login");
        //return "main";               
    }   
    
    //reyhaneh
    @RequestMapping (value = {"/prof/changePassword"} , method = RequestMethod.GET)
    public String changePassProf (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        return "prof-change";
    }
    
    
    //tara
    @RequestMapping(value = {"/manager/def_change_course"}, method = RequestMethod.GET)
    public String createCourseDefPage (@ModelAttribute("SpringWeb")CourseIn courseIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    { 
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("in createCourseDefPage");
        if((int)request.getSession().getAttribute("role") != 3)            
            return "error";         
        
        //create required list
        //1) get all courses
        List<Course> allCourses = courseManagerImpl.findAlls();
        List<Term> allTerms = courseManagerImpl.findAllTerms();
        List<Major> allMajors = courseManagerImpl.findAllMajors();
        List<String> sections = courseManagerImpl.findAllSection();               
        List<String> courseType = courseManagerImpl.findAllCourseType();        
        List<String> courseTypeLab = courseManagerImpl.findAllCourseTypeLab();        
        List<String> courseGender = courseManagerImpl.findAllCourseGender();        
        
        request.setAttribute("courses", allCourses);
        request.setAttribute("terms", allTerms);
        request.setAttribute("majors", allMajors);  
        request.setAttribute("section", sections);  
        request.setAttribute("courseType", courseType);
        request.setAttribute("courseTypeLab", courseTypeLab);
        request.setAttribute("courseGender", courseGender);       
        return "modir-course";
    }
    
    @RequestMapping(value = {"/manager/add_new_course"}, method = RequestMethod.POST)
    public String createCoursePage (@ModelAttribute("SpringWeb")CourseIn courseIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    { 
        if((int)request.getSession().getAttribute("role") != 3)            
            return "error";         
        Integer ID = courseIn.getID();
        String name = courseIn.getName();
        int units = courseIn.getUnits();    
        int preCourse = courseIn.getPreCourse();
        int courseTerm = courseIn.getCourseTerm();
        int courseMager = courseIn.getCourseMager();
        int coursesection = courseIn.getCoursesection();
        int labtheorytype = courseIn.getLabtheorytype();
        int coursetype = courseIn.getCoursetype();
        int coursegender = courseIn.getCoursegender();
        
        courseManagerImpl.saveCourse(ID,name,units,preCourse,courseTerm
                ,courseMager,coursesection,labtheorytype,coursetype,coursegender);
        response.sendRedirect("../manager");
        return "home";
    }   
    
    @RequestMapping(value = {"/manager/change_course"}, method = RequestMethod.POST)
    public String editCoursePage (@ModelAttribute("SpringWeb")CourseIn courseIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        if((int)request.getSession().getAttribute("role") != 3)            
            return "error";         
        Integer ID = courseIn.getID();
        int units = courseIn.getUnits();    
        int preCourse = courseIn.getPreCourse();
        int courseTerm = courseIn.getCourseTerm();
        int courseMager = courseIn.getCourseMager();
        int coursesection = courseIn.getCoursesection();
        int labtheorytype = courseIn.getLabtheorytype();
        int coursetype = courseIn.getCoursetype();
        int coursegender = courseIn.getCoursegender();
        
        System.out.println("change course: " +"units "+ units + " precourse" + preCourse );
        courseManagerImpl.updateCourse(ID,units,preCourse,courseTerm
                ,courseMager,coursesection,labtheorytype,coursetype,coursegender);
        response.sendRedirect("../manager");
        return "home";
    } 
}