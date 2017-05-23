<%-- 
    Document   : modir-change
    Created on : Apr 24, 2017, 12:00:59 PM
    Author     : Fatemeh-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="fa" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <!--<base href="enter base url here">-->
    <title>سجا - سیستم جامع آموزش</title>
    <link rel="icon" href="assets/img/favicon.png" type="image/png" sizes="32x32">
    <meta name="description" content="سجا - سیستم جامع آموزش">
    <meta name="keywords" content="سجا,آموزش,جامع,سیستم">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link type="text/css" rel="stylesheet" href="assets/css/materialize.min.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="assets/css/materialize_rtl.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="assets/css/admin_styles.css">
    <link type="text/css" rel="stylesheet" href="assets/css/material-icons.css">
</head>
<body>
<!--main hedader-->
<header>
    <!--top-header-->
    <nav class="top-header">
        <div class="container">
            <div class="nav-wrapper ">
                <a href="#" class="brand-logo right">
                    <h1 class="hide">سجاد سیستم جامع آموزش</h1>
                    <img class="responsive-img" src="assets/img/saja_logo.png" alt="سجا">
                </a>
                <a class="page-title right hide-on-med-and-down">سیستم جامع آموزش</a>
                <!--nav-mobile menu button-->
                <a href="#" id="nav-mobile-button" data-activates="nav-mobile"
                   class="button-collapse  hide-on-large-only left"><i class="material-icons">menu</i>
                </a>
                <!--//nav-mobile menu button-->
            </div>
        </div>
    </nav>
    <!--//top-header-->

    <!--sidebar-->
    <ul id="nav-mobile" class="side-nav right fixed">
        <li class="user-profile valign-wrapper">
            <!--<img src="assets/img/photo_2017-03-27_09-55-25.jpg" alt="عکس کاربر" class="circle responsive-img">-->
            <i class="material-icons medium">face</i>
            <p>رامک قوامی زاده</p>

            <a href=main.html>
                <i class="material-icons tooltipped" data-position="bottom" data-delay="50"
                   data-tooltip="خروج از سیستم">power_settings_new</i>
            </a>
        </li>
        <li class="right-align">
            <ul class="collapsible collapsible-accordion">
                <li class="bold">
                    <a href="modir-course.html" class="collapsible-header waves-effect waves-teal">تعریف/تغییر درس</a>
                </li>
                <li class="bold">
                    <a href="modir-term.html" class="collapsible-header waves-effect waves-teal">تعریف/تغییر ترم</a>
                </li>
                <li class="bold">
                    <a href="modir-view.html" class="collapsible-header waves-effect waves-teal">مشاهده دروس ارائه شده در هر ترم</a>
                </li>
            </ul>
        </li>
    </ul>
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

                    <form name="modir-change-form" class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-lg-3 control-label"><h6>ایمیل:</h6></label>
                            <div class="col-lg-8">
                                <input class="form-control" type="text" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"><H6>شناسه ورود:</H6></label>
                            <div class="col-md-8">
                                <input class="form-control" type="text" required >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"><h6>گذرواژه:</h6></label>
                            <div class="col-md-8">
                                <input class="form-control" type="password" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"><h6>تکرار گذرواژه:</h6></label>
                            <div class="col-md-8">
                                <input class="form-control" type="password" requireds>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label"></label>
                            <div class="col-md-8">
                                <a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">done_all</i></a>
                                <a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>


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
<footer class="page-footer">
    <div class="container">
        <div class="row">
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">
            تمامی حقوق نزد گروه سجا محفوظ است ۱۳۹۶ ©
        </div>
    </div>
</footer>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/materialize.min.js"></script>
<script type="text/javascript" src="assets/js/scripts.js"></script>
</body>
</html>

