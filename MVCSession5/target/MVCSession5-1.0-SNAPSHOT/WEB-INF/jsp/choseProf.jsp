<%-- 
    Document   : modir-course
    Created on : Apr 24, 2017, 12:10:46 PM
    Author     : Fatemeh-pc
--%>

<%@page import="com.sbu.dao.model.Prof"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Prof>profs = (List<Prof>) request.getAttribute("profs");
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
            <li class="tab col s6"><a href="#chose-course">انتخاب استاد</a></li>         
        </ul>

        <div id="chose-course" >
            <div class="row">
                <form method="get" action="see_profclass_list">
                    <div>                    
                       <label>نام استاد</label>
                    </div>   
                    <div class="input-field col s6">
                            
                        <select name="profName" class="browser-default" required="">
                            <option value="" disabled selected>انتخاب...</option>

                                    <%
                                        for (Prof prof : profs) {                                
                                    %>
                            <option value="<%=prof.getId()%>"> <%=prof.getName()%> </option>
                                <%}%>
                        </select>
                    </div>
                           
                    <div class="row">                             
                        </div>
                        
                        <button class="btn-floating btn-large waves-effect waves-light green" type="submit" name="action">          
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
