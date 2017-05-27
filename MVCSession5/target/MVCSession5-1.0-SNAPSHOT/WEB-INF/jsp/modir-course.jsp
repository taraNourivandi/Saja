<%-- 
    Document   : modir-course
    Created on : Apr 24, 2017, 12:10:46 PM
    Author     : Fatemeh-pc
--%>

<%@page import="com.sbu.dao.model.Major"%>
<%@page import="com.sbu.dao.model.Term"%>
<%@page import="com.sbu.dao.model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Course>allCourses = (List<Course>) request.getAttribute("courses");
    List<Term>allTerms = (List<Term>) request.getAttribute("terms");
    List<Major>allMajors = (List<Major>) request.getAttribute("majors");
    List<String>sections = (List<String>) request.getAttribute("section");
    List<String>courseType = (List<String>) request.getAttribute("courseType");
    List<String>courseTypeLab = (List<String>) request.getAttribute("courseTypeLab");
    List<String>courseGender = (List<String>) request.getAttribute("courseGender");
%>
<!DOCTYPE html>
<html lang="fa">

<head>
    <meta charset="UTF-8">
    <!--<base href="enter base url here">-->
    <title>سجا - سیستم جامع آموزش</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.png" type="image/png" sizes="32x32">
    <meta name="description" content="سجا - سیستم جامع آموزش">
    <meta name="keywords" content="سجا,آموزش,جامع,سیستم">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materializeMin.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materializeRtl.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainStyles.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialIcons.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_styles.css"/>
</head>
<body>
<!--main hedader-->
<header>
    <!--top-header-->    
        <%@ include file="top-header.html" %>    
    <!--//top-header-->
    <!--sidebar-->
        <%@ include file="sidebar.jsp" %>
    <!--//sidebar-->

</header>
<!--//main header-->
<main>
    <!--main-content-->
    <div class="container" >
        <ul id="tabs-swipe-demo2" class="tabs">
            <li class="tab col s6"><a href="#add-course">تعریف درس جدید</a></li>
            <li class="tab col s6"><a href="#change-course">تغییر درس</a></li>
        </ul>

        <div id="add-course" class="col s12">
            <div class="row">
                <form method="POST" action="add_new_course">
                    <div class="col s6">
                        <div class="row">
                            <div class="input-field">
                                <input id="input_course_name" name="name" type="text" data-length="10" required>
                                <label for="input_course_name">نام درس</label>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col s6">
                            
                                <div class="input-field col s6">
                                    <input id="input_course_id" name="ID" type="number" data-length="10" required>
                                    <label for="input_course_id">کد درس</label>
                                </div>
                           
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            
                                <div class="input-field col s6">
                                    <input id="input_text2" name="units" type="number" data-length="1" required>
                                    <label for="input_text2">تعداد واحد</label>
                                </div>
                            
                        </div>
                    </div>



                    <div class="row">
                    <div class="col s6">
                            <label>مقطع:</label>
                            <select name="coursesection" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%  for (int idx = 0; idx < sections.size(); idx++) {
                                        String elem = sections.get(idx);                                 
                                %>
                                    <option value="<%=idx+1%>"><%=elem%></option>
                                            
                                 <%}%>                                
                            </select>
                        </div>



                        <div class="col s6">
                            <label >درس پیش نیاز:</label>
                            <select name="preCourse" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="-1">عدم وجود درس پیش نیاز</option>
                                <%
                                    for (Course course : allCourses) {                                
                                %>
                                <option value="<%=course.getId()%>"><%=course.getName()%> , <%=course.getId()%> </option>
                                <%}%>
                            </select>
                        </div>
                    </div>



                    <div class="row">
                        <div class="col s6">
                            <label>مجاز برای ترم:</label>
                            <select name="courseTerm" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (Term term : allTerms) {                                
                                %>
                                <option value="<%=term.getId()%>"> <%=term.getName()%> </option>
                                <%}%>
                            </select>
                        </div>


                        <div class="col s6">
                            <label>مجاز برای رشته و گرایش:</label>
                            <select name="courseMager" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (Major major : allMajors) {                                
                                %>
                                <option value="<%=major.getId()%>"> <%=major.getMajor()%> </option>
                                <%}%>                                
                            </select>
                        </div>
                    </div>                    

                        <div class="row">
                         <div class="col s6">
                            <label>نوع درس به صورت عام:</label>
                            <select name="coursetype" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (String type : courseType) {                                
                                %>
                                <option value="<%=type%>"> <%=type%> </option>
                                <%}%>                                
                            </select>
                        </div>



<div class="col s6">
                            <label>نوع درس(آزمایشگاهی بودن):</label>
                            <select name="labtheorytype" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (String typeLab : courseTypeLab) {                                
                                %>
                                <option value="<%=typeLab%>"> <%=typeLab%> </option>      
                                 <%}%>
                            </select>
                        </div>



                       
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>جنسیت مجاز:</label>
                            
                                
                                    <SELECT name="coursegender" class="browser-default" required >
                                    <option value="" disabled selected>انتخاب...</option>
                                    <%
                                    for (String gender : courseGender) {                                
                                    %>
                                    <option value="<%=gender%>"> <%=gender%> </option>  
                                     <%}%>
                                    </SELECT>


                                    

                                
                            
                        </div>
                    </div>
                    <button class="btn-floating btn-large waves-effect waves-light green"
                type="submit" name="action">
          
          <i class="material-icons right">done</i>
          </button>

          <a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>
                   

					
               		</form>
            </div>

            
        </div>
		
        <!--end of the "add_course"------------------------------------------------------------------------------------------ -->

        <div id="change-course" class="col s12" >
            <div class="row">
                <form method="POST" action="change_course">
                    <div class="row">
                        <div class="col s6">
                            <label>نام درس</label>
                            <select name="ID" class="browser-default" required="">
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (Course course : allCourses) {                                
                                %>
                                <option value="<%=course.getId()%>"><%=course.getName()%> , <%=course.getId()%> </option>
                                <%}%>
                            </select>
                        </div>

                        <div class="input-field col s6">
                                    <input name="units" id="input_text21" type="number" data-length="1" required>
                                    <label for="input_text21">تعداد واحد</label>
                                </div>
                    </div>


                    <div class="row">

                     
<div class="col s6">
                            <label>مقطع:</label>
                            <select name="coursesection" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%  for (int idx = 0; idx < sections.size(); idx++) {
                                        String elem = sections.get(idx);                                 
                                %>
                                    <option value="<%=idx+1%>"><%=elem%></option>
                                            
                                 <%}%>                                
                            </select>
                        </div>

                        <div class="col s6">
                            <label>درس پیش نیاز:</label>
                            <select name="preCourse" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                
                                <option value="1">عدم وجود درس پیش نیاز</option>
                                <%
                                    for (Course course : allCourses) {                                
                                %>
                                <option value="<%=course.getId()%>"><%=course.getName()%> , <%=course.getId()%> </option>
                                <%}%>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>مجاز برای ترم:</label>
                            <select name="courseTerm" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (Term term : allTerms) {                                
                                %>
                                <option value="<%=term.getId()%>"> <%=term.getName()%> </option>
                                <%}%>
                            </select>
                        </div>


                        <div class="col s6">
                            <label>مجاز برای رشته و گرایش:</label>
                            <select name="courseMager" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                               <%
                                    for (Major major : allMajors) {                                
                                %>
                                <option value="<%=major.getId()%>"> <%=major.getMajor()%> </option>
                                <%}%>  
                            </select>
                        </div>
                    </div>


                    <div class="row">
                       
                    </div>                 
                    



                    <div class="row">
                         <div class="col s6">
                            <label>نوع درس به صورت عام:</label>
                            <select name="coursetype" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (String type : courseType) {                                
                                %>
                                <option value="<%=type%>"> <%=type%> </option>
                                <%}%>                                
                            </select>
                        </div>



<div class="col s6">
                            <label>نوع درس(آزمایشگاهی بودن):</label>
                            <select name="labtheorytype" class="browser-default" required>
                                <option value="" disabled selected>انتخاب...</option>
                                <%
                                    for (String typeLab : courseTypeLab) {                                
                                %>
                                <option value="<%=typeLab%>"> <%=typeLab%> </option>      
                                 <%}%>
                                
                            </select>
                        </div>



                       
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>جنسیت مجاز:</label>
                            
                                
                                    <SELECT name="coursegender" class="browser-default" required >
                                    <option value="" disabled selected>انتخاب...</option>
                                    <%
                                    for (String gender : courseGender) {                                
                                    %>
                                    <option value="<%=gender%>"> <%=gender%> </option>  
                                     <%}%>                                    
                                    </SELECT>                                  

                                
                            
                        </div>
                    </div>
                    <button class="btn-floating btn-large waves-effect waves-light green"
                type="submit" name="action">
          
          <i class="material-icons right">done</i>
          </button>

          <a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>
                   

                </form>
                 
            </div>
      </div>

    </div>


    <!--//main-content-->

    <!--user-profile-modal structure-->
    <div id="user-profile-modal" class="modal">
        <div class="modal-content">
            <h4>ویرایش تنظیمات کاربر</h4>
            <p>تنظیمات کاربر را ویرایش کنید</p>
        </div>
        <div class="modal-footer">
            <a href="#" class="modal-action waves-effect waves-green btn-flat"><i class="material-icons right">done</i>ثبت
                تغییرات</a>
            <a href="#" class="modal-action modal-close waves-effect waves-green btn-flat"><i
                    class="material-icons right">close</i>انصراف</a>
        </div>
    </div>
    <!--//user-profile-modal structure-->
</main>

<%@ include file="footer.html" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqueryMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materializeMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jscripts.js"></script>
</body>
</html>
