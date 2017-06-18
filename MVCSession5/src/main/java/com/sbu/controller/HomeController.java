/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller;

//input model
import com.sbu.controller.model.*;
//dao model
import com.sbu.dao.model.Modir;
import com.sbu.dao.model.Prof;
import com.sbu.dao.model.Stdtable;
import com.sbu.dao.model.User;
import com.sbu.dao.model.Course;
import com.sbu.dao.model.Term;
import com.sbu.dao.model.Major;

//service imp
import com.sbu.service.impl.*;

//others
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javafx.scene.control.Alert;
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

    @Autowired
    public CourseProfTermManagerImpl courseProfTermManagerImpl;
    
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
//        if((int)request.getSession().getAttribute("role") != 2)
//            //not correct -> hove to be load sutable error page
//            return "error";
        int id = (int) request.getSession().getAttribute("id");
        Prof prof = profManagerImpl.findProf(id);
        String name = prof.getName();
        request.getSession().setAttribute("name", name);
        
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/student"}, method = RequestMethod.GET)
    public String crearPersonalStudentPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
//        if((int)request.getSession().getAttribute("role") != 1)
//            //not correct -> hove to be load sutable error page
//            return "error";
        int id = (int) request.getSession().getAttribute("id");
        Stdtable std = stdManagerImpl.findStd(id);
        String name = std.getName();
        request.getSession().setAttribute("name", name);
        return helperMethod(request);        
    }
    
    @RequestMapping(value = {"/manager"}, method = RequestMethod.GET)
    public String crearPersonalManagerPage (@ModelAttribute("SpringWeb")UserIn userIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    {       
//        if((int)request.getSession().getAttribute("role") != 3)
//            //not correct -> hove to be load sutable error page
//            return "error";
//
        int id = (int) request.getSession().getAttribute("id");
        Modir manager = managerManagerImpl.findManager(id);
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
    
    
    //tara
    @RequestMapping(value = {"/manager/def_change_course"}, method = RequestMethod.GET)
    public String createCourseDefPage (@ModelAttribute("SpringWeb")CourseIn courseIn, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException 
    { 
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("in createCourseDefPage");
//        if((int)request.getSession().getAttribute("role") != 3)
//            return "error";
        
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
//        if((int)request.getSession().getAttribute("role") != 3)
//            return "error";
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
//        if((int)request.getSession().getAttribute("role") != 3)
//            return "error";
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
	
	@RequestMapping (value = {"/prof/change"} , method = RequestMethod.GET)
    public String changeInfoProf (HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
//        if((int)request.getSession().getAttribute("role") != 2)
//            //not correct -> hove to be load sutable error page
//            return "error";
        int id = (int) request.getSession().getAttribute("id");
        System.out.println("id : "+ id);
        Prof prof = profManagerImpl.findProf(id);        
        
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username : "+ username);
        User user = userManagerImpl.findUser(username);
        
        String email = prof.getEmail();
        request.setAttribute("email", email);
        String pass = user.getPass();
        request.setAttribute("pass", pass);
        return "changeInfo";
    }
    
    @RequestMapping (value = {"/prof/changing"} ,method = RequestMethod.POST)
    public String changingInfoProf (@ModelAttribute("SpringWeb")ChangeInfo changeInfo, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        
        String email = changeInfo.getEmail();
        String pass = changeInfo.getPass();
        String repeatPass = changeInfo.getRepeatPass();
        
        int id = (int) request.getSession().getAttribute("id");
        String username = (String) request.getSession().getAttribute("username");
                
        if (profManagerImpl.updateEmail(id ,email ,username ,pass , repeatPass))  // if update corrrecly            
        {
           response.sendRedirect("../prof");
           return "home";
        }
        else
        {
            return "error";
        }

    }

    @RequestMapping (value = {"manager/change"} , method = RequestMethod.GET)
    public String changeInfoManager (HttpServletRequest request, HttpServletResponse response) throws IOException
    {
//        if((int)request.getSession().getAttribute("role") != 3)
//            //not correct -> hove to be load sutable error page
//            return "error";
        int id = (int) request.getSession().getAttribute("id");
        System.out.println("id : "+ id);
        Modir modir = managerManagerImpl.findManager(id);

        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username : "+ username);
        User user = userManagerImpl.findUser(username);
        
        String email = modir.getEmail();
        request.setAttribute("email", email);
        String pass = user.getPass();
        request.setAttribute("pass", pass);
        return "changeInfo";
    }
    
    @RequestMapping (value = {"/manager/changing"} ,method = RequestMethod.POST)
    public String changingInfoManager (@ModelAttribute("SpringWeb")ChangeInfo changeInfo, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        
        String email = changeInfo.getEmail();
        String pass = changeInfo.getPass();
        String repeatPass = changeInfo.getRepeatPass();
        
        int id = (int) request.getSession().getAttribute("id");
        String username = (String) request.getSession().getAttribute("username");
                
        if (managerManagerImpl.updateEmail(id ,email ,username ,pass , repeatPass))  // if update corrrecly            
        {
           response.sendRedirect("../manager");
           return "home";
        }
        else
        {            
            return "error";
        }
        
    }
    @RequestMapping (value = {"/student/change"} , method = RequestMethod.GET)
    public String changeInfoStd (HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
//        if((int)request.getSession().getAttribute("role") != 1)
//            //not correct -> hove to be load sutable error page
//            return "error";
        int id = (int) request.getSession().getAttribute("id");
        System.out.println("id : "+ id);
        Stdtable std = stdManagerImpl.findStd(id);
        
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username : "+ username);
        User user = userManagerImpl.findUser(username);
        
        String email = std.getEmail();
        request.setAttribute("email", email);
        String pass = user.getPass();
        request.setAttribute("pass", pass);
        return "changeInfo";
    }
    
    @RequestMapping (value = {"/student/changing"} ,method = RequestMethod.POST)
    public String changingInfoStd (@ModelAttribute("SpringWeb")ChangeInfo changeInfo, Model model,HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter() ;
        
        String email = changeInfo.getEmail();
        String pass = changeInfo.getPass();
        String repeatPass = changeInfo.getRepeatPass();
        
        int id = (int) request.getSession().getAttribute("id");
        String username = (String) request.getSession().getAttribute("username");
                
        if (stdManagerImpl.updateEmail(id ,email ,username ,pass , repeatPass))  // if update corrrecly            
        {
           response.sendRedirect("../stdudent");
           return "home";
        }
        else
        {            
            return "error";
        }
        
    }


/////TARA

    @RequestMapping(value = {"/manager/courseForTerm"}, method = RequestMethod.GET)
    public String courseForTermPage (@ModelAttribute("SpringWeb")NewTermIn termIn, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("in courseForTermPage");
//        if((int)request.getSession().getAttribute("role") != 3)
//            return "error";


        List<Course> allCourses = courseManagerImpl.findAlls();
        List<Course> termCourses = courseManagerImpl.findTermCourse(termIn.getTermCode());
        List<Prof> allProfs = profManagerImpl.findAll();
        List<Term> terms = courseManagerImpl.findAllTerms();
        request.setAttribute("term" , terms);
        request.setAttribute("courseName", allCourses);
        request.setAttribute("termCourseName" , termCourses);
        request.setAttribute("profName" , allProfs);



        return "modir-term";
    }
////Tara
@RequestMapping(value = {"/manager/newCourseForTerm"}, method = RequestMethod.POST)
public String newCourseAdding (HttpServletRequest request, HttpServletResponse response) throws IOException
{
//    if((int)request.getSession().getAttribute("role") != 3)
//        return "error";
    System.out.println("in new course for term action");
    int count = Integer.parseInt(request.getParameter("numberOfCourses"));
    if(request.getParameter("numberOfCourses")==null)
        return "error";

    int code = Integer.parseInt(request.getParameter("termCode"));
    if(request.getParameter("termCode")==null)
        return "error";
    System.out.println(count);

  //  String code= request.getParameter("termCode");
    //int termCodeInt= Integer.parseInt(code);
    System.out.println("termCode:"+code);
    //System.out.println("termCode:"+termCodeInt);


    for(int i=1; i<count+1; i++) {

        String cId = "courseId"+i;
        int courseId = Integer.parseInt(request.getParameter(cId));
        if (request.getParameter(cId)==null)
            return "error";

        String pId="profId"+i;
        int profId= Integer.parseInt(request.getParameter(pId));
        if (request.getParameter(pId)==null)
            return "error";

        String cCapacity = "zarfiat"+i;
        int courseCapacity = Integer.parseInt(request.getParameter(cCapacity));
        if (request.getParameter(cCapacity)==null)
            return "error";

        String cDate = "date"+i;
        String courseDate = (String) request.getParameter(cDate);
        if (request.getParameter(cDate)==null)
            return "error";


        String cTime = "time"+i;
        String courseTime = request.getParameter(cTime);
        if (request.getParameter(cTime)==null)
            return "error";



        String cExamDate = "examDate"+i;
        String courseExamDate = request.getParameter(cExamDate);
        if (request.getParameter(cExamDate)==null)
            return "error";



        String cExamTime = "examTime"+i;
        String courseExamTime = request.getParameter(cExamTime);
        if(request.getParameter(cExamTime)==null)
            return "error";

        System.out.println("courseId:"+courseId+"\t pid:"+profId+"\t zarfiat:"+courseCapacity+"\t date:"+courseDate+ "\t time:" +courseTime+"\t examDate:"+courseExamDate+"\t examTime:"+courseExamTime);

        courseProfTermManagerImpl.saveCPT(courseCapacity, courseDate, courseExamDate, courseId, profId , code);

    }
    return "home";
}
}