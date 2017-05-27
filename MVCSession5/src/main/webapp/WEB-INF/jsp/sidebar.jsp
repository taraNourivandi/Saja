<%-- 
    Document   : sidebar
    Created on : Apr 30, 2017, 4:54:20 PM
    Author     : Fatemeh-pc
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   HashMap listItem = (HashMap)session.getAttribute("listItem");
   String name = (String)session.getAttribute("name");
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

            <a href="logout">
                <i class="material-icons tooltipped" data-position="bottom" data-delay="50"
                   data-tooltip="خروج از سیستم">power_settings_new</i>
            </a>
        </li>
        <li class="right-align">
            <ul class="collapsible collapsible-accordion">
                <% 
                    Set <String> keySet = listItem.keySet();
                                   
                    for (Iterator i = keySet.iterator() ; i.hasNext() ;){
                        String item = (String) i.next();
                        String ref = (String) listItem.get(item) ; 
                    %>
                <li class="bold">
                    <a href="<%=ref%>" class="collapsible-header waves-effect waves-teal"><%=item%></a>
                </li>
                <%}%>
            </ul>
        </li>
    </ul>
    <!--//sidebar-->

    </body>
</html>
