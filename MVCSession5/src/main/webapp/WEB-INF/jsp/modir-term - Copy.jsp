<%--
    Document   : modir-course
    Created on : May 28, 2017, 12:10:46 PM
    Author     : Tara
--%>
<%@page import="com.sbu.dao.model.Course"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.sbu.dao.model.Prof" %>
<%@ page import="com.sbu.dao.model.Term" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Course>allCourses = (List<Course>) request.getAttribute("courseName");%>
<% List<Prof> allProfs = (List<Prof>) request.getAttribute("profName");%>
<% List<Course> termCourses = (List<Course>) request.getAttribute("termCourseName");%>
<% List<Term> terms = (List<Term>) request.getAttribute("term");%>
<%--<% int termCode = (int) request.getAttribute("ID");%>--%>


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
        <ul id="tabs-swipe-demo3" class="tabs">
            <li class="tab col s6"><a href="#add-term">تعریف ترم جدید</a></li>
            <li class="tab col s6"><a href="#change-term">تغییر ترم</a></li>
        </ul>

        <div id="add-term" class="col s12 row">
            <div method="post" action="newCourseForTerm">
                <div class="row">

                    <div class="row">
                        <div class="input-field col s6">
                            <label for="termCode"  >کد ترم:</label>
                            <input id="termCode" name="termCode" type="number" data-length="10" required>

                        </div>
                    </div>

                </div>



                <div class="container">
                    <div class="responsive-table">
                        <table class="table" name="termCourses">
                            <thead>
                            <tr>
                                <th>نام درس</th>
                                <th>ظرفیت</th>
                                <th>روز کلاس</th>
                                <th>ساعت کلاس</th>
                                <th>روز آزمون</th>
                                <th>ساعت آزمون</th>
                                <th></th>
                            </tr>
                            </thead>

                            <%--fateme--%>
                            <tbody id="dynamicInput">

                            </tbody>

                        </table>
                    </div>
                </div>

                <!--modal trigger:-->
                <br><br>
                <form  method="get" action="newCourseForTerm" id="send-form">
                    <input name="numberOfCourses" id="counter" style="display: none;" >
                    <a href="#add-course-modal" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">add</i></a>
                    <button type="submit" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">done_all</i></button>


                </form>
            </div>
                <%--<a href="#add-course-modal" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">add</i></a>--%>
                <%--<button class="btn-floating btn-large waves-effect waves-light green"--%>
                        <%--type="submit" name="action">--%>

                    <%--<i class="material-icons right">done</i>--%>
                <%--</button>--%>

                <%--<a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>--%>
            <%--</form>--%>
        <%--</div>--%>


        <!--modal structure:-->
        <div id="add-course-modal" class="modal">
            <div class="modal-content">

                <form method="post" action="newCourseForTerm">
                    <div class="col s6">

                        <label for="courseBeingAddedName">درس را انتخاب کنید:</label>
                        <select id="courseBeingAddedName" name="ID" class="browser-default" required="required">
                            <option value="" disabled selected>انتخاب...</option>
                            <%
                                for (Course allCourse : allCourses) {
                            %>
                            <option value="<%=allCourse.getId()%>"><%=allCourse.getName()%> , <%=allCourse.getId()%> </option>
                            <%}%>
                        </select>
                    </div>

                    <div class="col s6">

                        <label for="courseBeingAddedProf">استاد درس را انتخاب کنید:</label>
                        <select id="courseBeingAddedProf" name="profId" class="browser-default" required="required">
                            <option value="" disabled selected>انتخاب...</option>

                            <%
                                for (Prof prof : allProfs) {
                            %>
                            <option value="<%=prof.getId()%>"> <%=prof.getName()%></option>
                            <%}%>
                        </select>
                    </div>

                    <div class="row">

                        <%--<div class="row">--%>
                            <div class="input-field col s6">
                                <input id="zarfiat" name="capacity" type="number" data-length="3" required="required">
                                <label for="zarfiat">ظرفیت:</label>
                            </div>
                        <%--</div>--%>

                    </div>

                    <div class="row">

                        <div class="row">
                            <div class="input-field col s6">
                                <input id="classDate" name="date" type="text" class="validate" required="required">
                                <label for="classDate">روز:</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="time" name="hour" Type="text" class="validate" required="required">
                                <label for="time">ساعت:</label>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="row">
                            <div class="input-field col s6">
                                <input id="examDay" name="examDate" type="text" class="validate" required="required">
                                <label for="examDay">تاریخ آزمون:</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="examTime" name="examHour" type="text" class="validate" required="required">
                                <label for="examTime">ساعت آزمون:</label>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button class="btn-floating btn-large waves-effect waves-light green"  onClick="createDynamicCourse('dynamicInput');"><i class="material-icons">done_all</i></button>
                        <button class="btn-floating btn-large waves-effect waves-light red modal-close"><i class="material-icons">not_interested</i></button>
                    </div>
                </form>

            </div>
        </div>

            <%--<div id="change-term" class="col s12">--%>

                <%--<div class="row">--%>
                    <%--<div >--%>
                        <%--<label>ترم:</label>--%>


                        <%--<select id="changingTerm" name="changingTermCode" class="browser-default" required="required">--%>
                            <%--<option value="" disabled selected>انتخاب...</option>--%>
                            <%--<%--%>
                                <%--for (Term thisTerm : terms) {--%>
                            <%--%>--%>
                            <%--<option value="<%=thisTerm.getId()%>"><%=thisTerm.getName()%>  </option>--%>
                            <%--<%}%>--%>
                        <%--</select>--%>





                    <%--</div>--%>
                <%--</div>--%>
                <%--&lt;%&ndash;<a href="#change-course-modal" class="btn-floating btn-large waves-effect waves-light green"><i&ndash;%&gt;--%>
                        <%--&lt;%&ndash;class="material-icons right">done</i></a>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input type="button" name="btn" value="Submit" id="submitBtn" data-toggle="modal" data-target="#change-course-modal" class="btn btn-default" />&ndash;%&gt;--%>
                <%--&lt;%&ndash;<button type="submit" data-toggle="modal" data-target="#change-course-modal" class="btn-floating btn-large waves-effect waves-light green"&ndash;%&gt;--%>
                         <%--&lt;%&ndash;name="action">&ndash;%&gt;--%>

                    <%--&lt;%&ndash;<i class="material-icons right">done</i>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                <%--<button type="submit" data-target="change-course-modal" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons right">done</i></button>--%>
                <%--<a href="modir-home.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>--%>
            <%--</div>--%>


        <%--<div id="change-course-modal" class="modal">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="container">--%>
                    <%--<div class="responsive-table">--%>
                        <%--<table class="table">--%>
                            <%--<thead>--%>
                            <%--<tr>--%>
                                <%--<th>نام درس</th>--%>
                                <%--<th>ظرفیت</th>--%>
                                <%--<th>روز کلاس</th>--%>
                                <%--<th>ساعت کلاس</th>--%>
                                <%--<th>روز آزمون</th>--%>
                                <%--<th>ساعت آزمون</th>--%>
                                <%--<th></th>--%>
                            <%--</tr>--%>
                            <%--</thead>--%>
                            <%--<tbody>--%>
                            <%--<tr>--%>
                                <%--<td>مهندسی اینترنت</td>--%>
                                <%--<td>50</td>--%>
                                <%--<td>شبنه و دوشنبه</td>--%>
                                <%--<td>9-10:30</td>--%>
                                <%--<td>20 خرداد</td>--%>
                                <%--<td>9-12</td>--%>
                                <%--<td><a href="#edit-courseInterm-modal" class="btn-floating waves-effect waves-light red"><i class="material-icons">mode_edit</i></a></td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                                <%--<td>مهندسی اینترنت</td>--%>
                                <%--<td>50</td>--%>
                                <%--<td>شبنه و دوشنبه</td>--%>
                                <%--<td>9-10:30</td>--%>
                                <%--<td>20 خرداد</td>--%>
                                <%--<td>9-12</td>--%>
                                <%--<td><a href="#edit-courseInterm-modal" class="btn-floating waves-effect waves-light red"><i class="material-icons">mode_edit</i></a></td>--%>
                            <%--</tr>--%>
                            <%--<tr>--%>
                                <%--<td>مهندسی اینترنت</td>--%>
                                <%--<td>50</td>--%>
                                <%--<td>شبنه و دوشنبه</td>--%>
                                <%--<td>9-10:30</td>--%>
                                <%--<td>20 خرداد</td>--%>
                                <%--<td>9-12</td>--%>
                                <%--<td><a href="#edit-courseInterm-modal" class="btn-floating waves-effect waves-light red"><i class="material-icons">mode_edit</i></a></td>--%>
                            <%--</tr>--%>
                            <%--</tbody>--%>
                        <%--</table>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<a href="modir-term.html" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">done_all</i></a>--%>
                <%--<a href="modir-term.html" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div id="edit-courseInterm-modal" class="modal">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="row">--%>
                    <%--<div class="col s4">--%>
                        <%--نام درس:--%>
                    <%--</div>--%>
                    <%--<div class="col s4">--%>
                        <%--<blockquote>--%>
                            <%--مهندسی اینترنت--%>
                        <%--</blockquote>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="col s12" >--%>
                    <%--<div class="row">--%>
                        <%--<form>--%>
                            <%--<div class="row">--%>
                                <%--<form class="col s6">--%>
                                    <%--<div class="row">--%>
                                        <%--<div class="input-field col s6">--%>
                                            <%--<input id="input_text21" type="number" data-length="1">--%>
                                            <%--<label for="input_text21">تعداد واحد</label>--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                <%--</form>--%>
                            <%--</div>--%>

                            <%--<div class="row">--%>
                                <%--<div class="col s6">--%>
                                    <%--<label>درس پیش نیاز:</label>--%>
                                    <%--<select class="browser-default">--%>
                                        <%--<option value="" disabled selected>انتخاب...</option>--%>
                                        <%--<option value="1">عدم وجود درس پیش نیاز</option>--%>
                                        <%--<option value="2">شبکه های کامپیوتری</option>--%>
                                        <%--<option value="3">الگوریتم</option>--%>
                                        <%--<option value="4">ساختمان داده</option>--%>
                                        <%--<option value="5">برنامه نویسی پیشرفته</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>


                                <%--<div class="col s6">--%>
                                    <%--<label>درس هم نیاز:</label>--%>
                                    <%--<select class="browser-default">--%>
                                        <%--<option value="" disabled selected>انتخاب...</option>--%>
                                        <%--<option value="1">عدم وجود درس هم نیاز</option>--%>
                                        <%--<option value="2">شبکه های کامپیوتری</option>--%>
                                        <%--<option value="3">الگوریتم</option>--%>
                                        <%--<option value="4">ساختمان داده</option>--%>
                                        <%--<option value="5">برنامه نویسی پیشرفته</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="row">--%>
                                <%--<div class="col s6">--%>
                                    <%--<label>مجاز برای ترم:</label>--%>
                                    <%--<select class="browser-default">--%>
                                        <%--<option value="" disabled selected>انتخاب...</option>--%>
                                        <%--<option value="1">ترم اول به بالا</option>--%>
                                        <%--<option value="2">ترم دوم به بالا</option>--%>
                                        <%--<option value="3">ترم سوم به بالا</option>--%>
                                        <%--<option value="4">ترم چهارم به بالا</option>--%>
                                        <%--<option value="5">ترم پنجم به بالا</option>--%>
                                        <%--<option value="6">ترم ششم به بالا</option>--%>
                                        <%--<option value="7">ترم هفتم به بالا</option>--%>
                                        <%--<option value="8">ترم هشتم به بالا</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>


                                <%--<div class="col s6">--%>
                                    <%--<label>مجاز برای رشته و گرایش:</label>--%>
                                    <%--<select class="browser-default">--%>
                                        <%--<option value="" disabled selected>انتخاب...</option>--%>
                                        <%--<option value="1">مهندسی کامپیوتر گرایش نرم افزار</option>--%>
                                        <%--<option value="2">مهندسی کامپیوتر گرایش سخت افزار</option>--%>
                                        <%--<option value="3">معماری سامانه های کامیوتری</option>--%>
                                        <%--<option value="4">فناوری اطلاعات</option>--%>
                                        <%--<option value="5">نرم افزار و سیستم های اطلاعاتی</option>--%>
                                        <%--<option value="6">هوش مصنوعی</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>


                            <%--<div class="row">--%>
                                <%--<div class="col s6">--%>
                                    <%--<label>مقطع:</label>--%>
                                    <%--<select class="browser-default">--%>
                                        <%--<option value="" disabled selected>انتخاب...</option>--%>
                                        <%--<option value="1">کارشناسی</option>--%>
                                        <%--<option value="2">کارشناسی ارشد</option>--%>
                                        <%--<option value="3">دکترا</option>--%>
                                        <%--<option value="4">مجازی</option>--%>
                                    <%--</select>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="row">--%>
                                <%--<div class="col s6">--%>
                                    <%--<label>نوع درس به صورت عام:</label>--%>
                                    <%--<form action="#" >--%>
                                        <%--<p>--%>
                                            <%--<input name="group21" type="radio" id="test31" />--%>
                                            <%--<label for="test31">اصلی</label>--%>

                                            <%--<input name="group21" type="radio" id="test41" />--%>
                                            <%--<label for="test41">پایه</label>--%>

                                            <%--<input name="group21" type="radio" id="test51" />--%>
                                            <%--<label for="test51">اختیاری</label>--%>
                                        <%--</p>--%>
                                    <%--</form>--%>
                                <%--</div>--%>

                                <%--<div class="col s6">--%>
                                    <%--<label>نوع درس(آزمایشگاهی بودن):</label>--%>
                                    <%--<form action="#" >--%>
                                        <%--<p>--%>
                                            <%--<input name="group11" type="radio" id="test11" />--%>
                                            <%--<label for="test11">عملی</label>--%>

                                            <%--<input name="group11" type="radio" id="test21" />--%>
                                            <%--<label for="test21">نظری</label>--%>
                                        <%--</p>--%>
                                    <%--</form>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="row">--%>
                                <%--<div class="col s6">--%>
                                    <%--<label>جنسیت مجاز:</label>--%>
                                    <%--<form action="#" >--%>
                                        <%--<p>--%>
                                            <%--<input name="group31" type="radio" id="test81" />--%>
                                            <%--<label for="test81">مختلط</label>--%>

                                            <%--<input name="group31" type="radio" id="test61" />--%>
                                            <%--<label for="test61">زن</label>--%>


                                            <%--<input name="group31" type="radio" id="test71" />--%>
                                            <%--<label for="test71">مرد</label>--%>

                                        <%--</p>--%>
                                    <%--</form>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="modal-footer">--%>
                <%--<a href="#change-course-modal" class="btn-floating btn-large waves-effect waves-light green"--%>
                   <%--onclick="Materialize.toast('ثبت با موفقیت انجام شد.', 10000)"><i class="material-icons">done_all</i></a>--%>
                <%--<a href="#change-course-modal" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">not_interested</i></a>--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>

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
    </div>
</main>

<%@ include file="footer.html" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqueryMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materializeMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jscripts.js"></script>
</body>
</html>
