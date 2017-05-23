<%-- 
    Document   : sidebar
    Created on : Apr 30, 2017, 4:54:20 PM
    Author     : Fatemeh-pc
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<String> listItem = (ArrayList)session.getAttribute("listItem");
   String name = (String)session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <!--sidebar-->
    <ul id="nav-mobile" class="side-nav right fixed">
        <li class="user-profile valign-wrapper">
            <!--<img src="assets/img/photo_2017-03-27_09-55-25.jpg" alt="عکس کاربر" class="circle responsive-img">-->
            <i class="material-icons medium">face</i>
            <p><%=name%></p>

            <a href=main.html>
                <i class="material-icons tooltipped" data-position="bottom" data-delay="50"
                   data-tooltip="خروج از سیستم">power_settings_new</i>
            </a>
        </li>
        <li class="right-align">
            <ul class="collapsible collapsible-accordion">
                <% 
                    for (String item: listItem){
                    %>
                <li class="bold">
                    <a href="modir-term.html" class="collapsible-header waves-effect waves-teal"><%=item%></a>
                </li>
                <%}%>
            </ul>
        </li>
    </ul>
    <!--//sidebar-->

    </body>
</html>
