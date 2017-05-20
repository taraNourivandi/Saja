<%-- 
    Document   : modir-course
    Created on : Apr 24, 2017, 12:10:46 PM
    Author     : Fatemeh-pc
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fa">

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
                <form>
                    <div class="col s6">
                        <label>نام درس</label>
                        <select class="browser-default">
                            <option value="" disabled selected>انتخاب...</option>
                            <option value="1">مهندسی اینترنت</option>
                            <option value="2">مهندسی نرم افزار1</option>
                            <option value="3">شبکه های کامپیوتری</option>
                        </select>
                    </div>


                    <div class="row">
                        <form class="col s6">
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="input_text" type="number" data-length="10">
                                    <label for="input_text">کد درس</label>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="row">
                        <form class="col s6">
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="input_text2" type="number" data-length="1">
                                    <label for="input_text2">تعداد واحد</label>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>درس پیش نیاز:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">عدم وجود درس پیش نیاز</option>
                                <option value="2">شبکه های کامپیوتری</option>
                                <option value="3">الگوریتم</option>
                                <option value="4">ساختمان داده</option>
                                <option value="5">برنامه نویسی پیشرفته</option>
                            </select>
                        </div>


                        <div class="col s6">
                            <label>درس هم نیاز:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">عدم وجود درس هم نیاز</option>
                                <option value="2">شبکه های کامپیوتری</option>
                                <option value="3">الگوریتم</option>
                                <option value="4">ساختمان داده</option>
                                <option value="5">برنامه نویسی پیشرفته</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>مجاز برای ترم:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">ترم اول به بالا</option>
                                <option value="2">ترم دوم به بالا</option>
                                <option value="3">ترم سوم به بالا</option>
                                <option value="4">ترم چهارم به بالا</option>
                                <option value="5">ترم پنجم به بالا</option>
                                <option value="6">ترم ششم به بالا</option>
                                <option value="7">ترم هفتم به بالا</option>
                                <option value="8">ترم هشتم به بالا</option>
                            </select>
                        </div>


                        <div class="col s6">
                            <label>مجاز برای رشته و گرایش:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">مهندسی کامپیوتر گرایش نرم افزار</option>
                                <option value="2">مهندسی کامپیوتر گرایش سخت افزار</option>
                                <option value="3">معماری سامانه های کامیوتری</option>
                                <option value="4">فناوری اطلاعات</option>
                                <option value="5">نرم افزار و سیستم های اطلاعاتی</option>
                                <option value="6">هوش مصنوعی</option>
                            </select>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col s6">
                            <label>مقطع:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">کارشناسی</option>
                                <option value="2">کارشناسی ارشد</option>
                                <option value="3">دکترا</option>
                                <option value="4">مجازی</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>نوع درس به صورت عام:</label>
                            <form action="#" >
                                <p>
                                    <input name="group2" type="radio" id="test3" />
                                    <label for="test3">اصلی</label>

                                    <input name="group2" type="radio" id="test4" />
                                    <label for="test4">پایه</label>

                                    <input name="group2" type="radio" id="test5" />
                                    <label for="test5">اختیاری</label>
                                </p>
                            </form>
                        </div>

                        <div class="col s6">
                            <label>نوع درس(آزمایشگاهی بودن):</label>
                            <form action="#" >
                                <p>
                                    <input name="group1" type="radio" id="test1" />
                                    <label for="test1">عملی</label>

                                    <input name="group1" type="radio" id="test2" />
                                    <label for="test2">نظری</label>
                                </p>
                            </form>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>جنسیت مجاز:</label>
                            <form action="#" >
                                <p>
                                    <input name="group3" type="radio" id="test8" />
                                    <label for="test8">مختلط</label>

                                    <input name="group3" type="radio" id="test6" />
                                    <label for="test6">زن</label>


                                    <input name="group3" type="radio" id="test7" />
                                    <label for="test7">مرد</label>

                                </p>
                            </form>
                        </div>
                    </div>
                </form>
            </div>

            <a href="modir-course.html" class="btn-floating btn-large waves-effect waves-light green"
               onclick="Materialize.toast('ثبت با موفقیت انجام شد.', 10000)"><i class="material-icons">done_all</i></a>
            <a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>
        </div>
        <!--end of the "add_course" -->

        <div id="change-course" class="col s12" >
            <div class="row">
                <form>
                    <div class="row">
                        <div class="col s6">
                            <label>نام درس</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="11">مهندسی اینترنت</option>
                                <option value="12">مهندسی نرم افزار1</option>
                                <option value="13">شبکه های کامپیوتری</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <form class="col s6">
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="input_text21" type="number" data-length="1">
                                    <label for="input_text21">تعداد واحد</label>
                                </div>
                            </div>
                        </form>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>درس پیش نیاز:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">عدم وجود درس پیش نیاز</option>
                                <option value="2">شبکه های کامپیوتری</option>
                                <option value="3">الگوریتم</option>
                                <option value="4">ساختمان داده</option>
                                <option value="5">برنامه نویسی پیشرفته</option>
                            </select>
                        </div>


                        <div class="col s6">
                            <label>درس هم نیاز:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">عدم وجود درس هم نیاز</option>
                                <option value="2">شبکه های کامپیوتری</option>
                                <option value="3">الگوریتم</option>
                                <option value="4">ساختمان داده</option>
                                <option value="5">برنامه نویسی پیشرفته</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>مجاز برای ترم:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">ترم اول به بالا</option>
                                <option value="2">ترم دوم به بالا</option>
                                <option value="3">ترم سوم به بالا</option>
                                <option value="4">ترم چهارم به بالا</option>
                                <option value="5">ترم پنجم به بالا</option>
                                <option value="6">ترم ششم به بالا</option>
                                <option value="7">ترم هفتم به بالا</option>
                                <option value="8">ترم هشتم به بالا</option>
                            </select>
                        </div>


                        <div class="col s6">
                            <label>مجاز برای رشته و گرایش:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">مهندسی کامپیوتر گرایش نرم افزار</option>
                                <option value="2">مهندسی کامپیوتر گرایش سخت افزار</option>
                                <option value="3">معماری سامانه های کامیوتری</option>
                                <option value="4">فناوری اطلاعات</option>
                                <option value="5">نرم افزار و سیستم های اطلاعاتی</option>
                                <option value="6">هوش مصنوعی</option>
                            </select>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col s6">
                            <label>مقطع:</label>
                            <select class="browser-default">
                                <option value="" disabled selected>انتخاب...</option>
                                <option value="1">کارشناسی</option>
                                <option value="2">کارشناسی ارشد</option>
                                <option value="3">دکترا</option>
                                <option value="4">مجازی</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>نوع درس به صورت عام:</label>
                            <form action="#" >
                                <p>
                                    <input name="group21" type="radio" id="test31" />
                                    <label for="test31">اصلی</label>

                                    <input name="group21" type="radio" id="test41" />
                                    <label for="test41">پایه</label>

                                    <input name="group21" type="radio" id="test51" />
                                    <label for="test51">اختیاری</label>
                                </p>
                            </form>
                        </div>

                        <div class="col s6">
                            <label>نوع درس(آزمایشگاهی بودن):</label>
                            <form action="#" >
                                <p>
                                    <input name="group11" type="radio" id="test11" />
                                    <label for="test11">عملی</label>

                                    <input name="group11" type="radio" id="test21" />
                                    <label for="test21">نظری</label>
                                </p>
                            </form>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col s6">
                            <label>جنسیت مجاز:</label>
                            <form action="#" >
                                <p>
                                    <input name="group31" type="radio" id="test81" />
                                    <label for="test81">مختلط</label>

                                    <input name="group31" type="radio" id="test61" />
                                    <label for="test61">زن</label>


                                    <input name="group31" type="radio" id="test71" />
                                    <label for="test71">مرد</label>

                                </p>
                            </form>
                        </div>
                    </div>

                    <a href="modir_course.html" class="btn-floating btn-large waves-effect waves-light green"
                       onclick="Materialize.toast('ثبت با موفقیت انجام شد.', 10000)"><i class="material-icons">done_all</i></a>

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

<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/materialize.min.js"></script>
<script type="text/javascript" src="assets/js/scripts.js"></script>
</body>
</html>
