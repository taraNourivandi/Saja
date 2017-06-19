<%@ page import="java.util.List" %>
<%@ page import="com.sbu.dao.model.Stdgrade" %>
<%@ page import="com.sbu.controller.model.GradeCourses" %>
<%@ page import="com.sbu.controller.model.TermGrade" %>
<%--
  Created by IntelliJ IDEA.
  User: Tara
  Date: 6/18/2017
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<% List<TermGrade> gradeList = (List<TermGrade>) request.getAttribute("termList");%>--%>
<% List<TermGrade> termGrade = (List<TermGrade>) request.getAttribute("termList");%>
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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
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
                    <img class="responsive-img" src="${pageContext.request.contextPath}/resources/img/saja_logo.png" alt="سجا">
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
    <%@ include file="sidebar.jsp" %>
    <!--//sidebar-->

</header>
<!--//main header-->
<main>
    <!--main-content-->
    <div class="container">
        <ul id="tabs-swipe-demo" class="tabs">
            <%for(int j=0;j<termGrade.size();j++){%>
            <li class="tab col s3"><a href="#tab<%=j%>"><%=termGrade.get(j).getTermCode()%></a></li>
            <%}%>
        </ul>


    <%for (int k=0;k<termGrade.size();k++){%>
        <div id="tab<%=k%>" class="col m11 s12">
            <div class="row">

                <div class="col s12 m11">
                    <div class="card-panel teal center-align">
                        <div class="row">
                            <div class="col m3">
                                معدل ترم:

                                <%=termGrade.get(k).getAvg()%>
                            </div>
                            <div class="col m3">
                                تعداد واحد اخذ شده:
                                <%=termGrade.get(k).getTotalUnits()%>
                            </div>
                            <div class="col m3">
                                تعداد واحد گذرانده:
                                <%=termGrade.get(k).getPassedUnits()%>
                            </div>
                            <div class="col m3">
                                تعداد واحد رد شده:
                                <%=termGrade.get(k).getFailedUnits()%>
                            </div>
                        </div>
                    </div>



                    <div class="col m12">
                        <div class="responsive-table">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th><center>کد درس</center></th>
                                    <th><center>نام درس</center></th>
                                    <th><center>نام استاد</center></th>
                                    <th><center>تعداد واحد</center></th>
                                    <th><center>نمره</center></th>
                                    <th><center>نتیجه نمره</center></th>
                                    <th><center>وضعیت نمره</center></th>
                                    <th><center>نوع درس</center></th>

                                </tr>
                                </thead>
                                <tbody>
                                <%for (int i=0;i<termGrade.get(k).getGradeCourses().size();i++){%>
                                <tr>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getCourseId()%></td>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getCourseName()%></td>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getProfName()%></td>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getCourseUnit()%></td>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getGrade()%></td>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getGradeStatus()%></td>
                                    <td></td>
                                    <td><%=termGrade.get(k).getGradeCourses().get(i).getCourseType()%></td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>



                </div>
            </div>
        </div>
        <%}%>

        <%--<div id="1" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 16--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 17--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 17--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 0--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>شبکه های کامپیوتری</center></td>--%>
                                    <%--<td><center>مقصود عباسپور</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>شبکه های کامپیوتری</center></td>--%>
                                    <%--<td><center>مقصود عباسپور</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>شبکه های کامپیوتری</center></td>--%>
                                    <%--<td><center>مقصود عباسپور</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>




        <%--<div id="test-swipe-3" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 16.87--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 20--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 17--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 3--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>برنامه نویسی پیشرفته</center></td>--%>
                                    <%--<td><center>صادق علی اکبری</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>17</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>برنامه نویسی پیشرفته</center></td>--%>
                                    <%--<td><center>صادق علی اکبری</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>17</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>برنامه نویسی پیشرفته</center></td>--%>
                                    <%--<td><center>صادق علی اکبری</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>17</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>







        <%--<div id="test-swipe-4" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 17.35--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 16--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 16--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 0--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>تربیت بدنی</center></td>--%>
                                    <%--<td><center>نقی نقوی</center></td>--%>
                                    <%--<td><center>1</center></td>--%>
                                    <%--<td><center>19</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>عمومی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>تربیت بدنی</center></td>--%>
                                    <%--<td><center>نقی نقوی</center></td>--%>
                                    <%--<td><center>1</center></td>--%>
                                    <%--<td><center>19</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>عمومی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>تربیت بدنی</center></td>--%>
                                    <%--<td><center>نقی نقوی</center></td>--%>
                                    <%--<td><center>1</center></td>--%>
                                    <%--<td><center>19</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>عمومی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>







        <%--<div id="test-swipe-5" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 16.12--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 20--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 20--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 0--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>پایگاه داده ها</center></td>--%>
                                    <%--<td><center>حسن حقیقی</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>پایگاه داده ها</center></td>--%>
                                    <%--<td><center>حسن حقیقی</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>پایگاه داده ها</center></td>--%>
                                    <%--<td><center>حسن حقیقی</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>






        <%--<div id="test-swipe-6" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 19.11--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 18--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 18--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 0--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>سیستم های عامل</center></td>--%>
                                    <%--<td><center>هادی طباطبایی</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>19</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>سیستم های عامل</center></td>--%>
                                    <%--<td><center>هادی طباطبایی</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>19</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>سیستم های عامل</center></td>--%>
                                    <%--<td><center>هادی طباطبایی</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>19</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>






        <%--<div id="test-swipe-7" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 17.21--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 17--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 17--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 0--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>طراحی الگوریتم ها</center></td>--%>
                                    <%--<td><center>رامک قوامی زاده</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>15</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>طراحی الگوریتم ها</center></td>--%>
                                    <%--<td><center>رامک قوامی زاده</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>15</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>طراحی الگوریتم ها</center></td>--%>
                                    <%--<td><center>رامک قوامی زاده</center></td>--%>
                                    <%--<td><center>3</center></td>--%>
                                    <%--<td><center>15</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>تخصصی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>





        <%--<div id="test-swipe-8" class="col s12">--%>
            <%--<div class="row">--%>

                <%--<div class="col s12 m11">--%>
                    <%--<div class="card-panel teal center-align">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col m3">--%>
                                <%--معدل ترم: 14.98--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد اخذ شده: 19--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد گذرانده: 17--%>
                            <%--</div>--%>
                            <%--<div class="col m3">--%>
                                <%--تعداد واحد رد شده: 2--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                    <%--<div class="col m12">--%>
                        <%--<div class="responsive-table">--%>
                            <%--<table class="table">--%>
                                <%--<thead>--%>
                                <%--<tr>--%>
                                    <%--<th><center>کد درس</center></th>--%>
                                    <%--<th><center>نام درس</center></th>--%>
                                    <%--<th><center>نام استاد</center></th>--%>
                                    <%--<th><center>تعداد واحد</center></th>--%>
                                    <%--<th><center>نمره</center></th>--%>
                                    <%--<th><center>نتیجه نمره</center></th>--%>
                                    <%--<th><center>وضع نمره</center></th>--%>
                                    <%--<th><center>نوع درس</center></th>--%>

                                <%--</tr>--%>
                                <%--</thead>--%>
                                <%--<tbody>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>انقلاب اسلامی</center></td>--%>
                                    <%--<td><center>تقی تقوی</center></td>--%>
                                    <%--<td><center>1</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>عمومی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>انقلاب اسلامی</center></td>--%>
                                    <%--<td><center>تقی تقوی</center></td>--%>
                                    <%--<td><center>1</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>عمومی</center></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td><center>123456789</center></td>--%>
                                    <%--<td><center>انقلاب اسلامی</center></td>--%>
                                    <%--<td><center>تقی تقوی</center></td>--%>
                                    <%--<td><center>1</center></td>--%>
                                    <%--<td><center>18</center></td>--%>
                                    <%--<td><center>قبول</center></td>--%>
                                    <%--<td><center>تایید شده</center></td>--%>
                                    <%--<td><center>عمومی</center></td>--%>
                                <%--</tr>--%>
                                <%--</tbody>--%>
                            <%--</table>--%>
                        <%--</div>--%>
                    <%--</div>--%>



                <%--</div>--%>
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
            <a href="#" class="modal-action waves-effect waves-green btn-flat"><i class="material-icons right">done</i>ثبت تغییرات</a>
            <a href="#" class="modal-action modal-close waves-effect waves-green btn-flat"><i class="material-icons right">close</i>انصراف</a>
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
            © ۱۳۹۶ تمامی حقوق نزد گروه سجا محفوظ است
            <!--<a class="grey-text text-lighten-4 right" href="#!">More Links</a>-->
        </div>
    </div>
</footer>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqueryMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materializeMin.js"></script>
<!--<script type="text/javascript" src="assets/js/init.js"></script>-->
<!--<script type="text/javascript" src="assets/js/URI.min.js"></script>-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jscripts.js"></script>
</body>

</html>
