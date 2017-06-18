<%-- 
    Document   : home
    Created on : Apr 24, 2017, 12:10:46 PM
    Author     : Fatemeh-pc
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String email = (String) request.getAttribute("email");
    String pass = (String) request.getAttribute("pass");
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
    <div class="container col-md-offset-2">
        <div class="row">
            <div class="col-md-9">
                <div class="jumbotron">
                    <h4>تغییر مشخصات</h4>                   
                    <form id="change_form" action ="changing" method="POST"
                               name="change_form" class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-lg-3 control-label" id="email"><h6>ایمیل:</h6></label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" required id="email"  name="email" value="<%=email%>" />
                            </div>
                        </div>
                        <!--
                        <div class="form-group">
                            <label class="col-md-3 control-label" id="userName"><H6>شناسه ورود:</H6></label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" required id="userName">
                            </div>
                        </div>-->
                        <div class="form-group">
                            <label class="col-md-3 control-label" ><h6>گذرواژه:</h6></label>
                            <div class="col-md-8">
                                <input class="form-control" type=password required id="pass_field" name="pass" value="<%=pass%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label" ><h6>تکرار گذرواژه:</h6></label>
                            <div class="col-md-8">
                                <input class="form-control" type=password requireds id="repeatPass_field" name="repeatPass" value="<%=pass%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <!--<a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">done_all</i></a>-->
                                <a class="btn-floating btn-large waves-effect waves-light green"> <i onclick="checkChangesPass()" class="material-icons right">done</i><input class="btn-floating waves-effect waves-light green" type="button"
                                       name="submit_changes" id="submit_changes_field" ></a>
                                <!--<button id="submit_changes_field" >helllo</button>-->
                                <a href=".." class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>                                
                            </div>
                        </div>
                    </form>
                </div>
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
