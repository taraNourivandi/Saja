<!--//fatemeh-->
<%@page import="com.sbu.dao.model.Courseprofterm"%>
<%-- 
    Document   : modir-course
    Created on : Apr 24, 2017, 12:10:46 PM
    Author     : Fatemeh-pc
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Courseprofterm> courses = (List<Courseprofterm>) request.getAttribute("currentTermCourses");
%>
<!DOCTYPE html>
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
	<div class="container">
<div class="row">
            

        </div>

        <div class="row">
        <div class="col s12 m12">
          <div class="card-panel teal center-align">
            <div class="card-content white-text">
              <span class="card-title">دروس اخذ شده</span>
              
            </div>
           
          </div>





                      <div class="container">
<div class="responsive-table">          
  <table class="table">
    <thead>
      <tr>
        <th>کد درس</th>
        <th>نام درس</th>
        <th>نام استاد</th>
        <th>ساعت و روز کلاس</th>
        <th>ساعت و روز امتحان</th>
        <th></th>
      </tr>
    </thead>
	
	<!--new change -------------------------------------------------------------------->
    <tbody id="dynamicInput">




    </tbody>
	 <!---------------------------------------------------------------------------------->
  </table>
  </div>
        </div>
        </div>
        
		<!--new change -------------------------------------------------------------------->
            <br><br>
		<form  method="get" action="form submition" id="send-form">
                <input name="numberOfCourses" id="counter" style="display: none;" >
                <a href="#take-course-modal" class="btn-floating btn-large waves-effect waves-light blue"><i class="material-icons">add</i></a>
                <button type="submit" class="btn-floating btn-large waves-effect waves-light green"><i class="material-icons">done_all</i></button>


            </form>
             <!---------------------------------------------------------------------------------->

		
      </div>
      </div>



	<!--//main-content-->
	<!--user-profile-modal structure-->





	<div id="take-course-modal" class="modal">
		<div class="modal-content">
			<div class="card-panel teal center-align">
            <div class="card-content white-text">
            <div class="row">
            <div class="col m6">
				<form>
					<div class="input-field inline">
					<input placeholder="کد درس" type="text" name="code"></div>
					<a class="btn-floating btn-small waves-effect waves-light green"><i class="material-icons">search</i></a>
					<a href="std-reg.html" class="btn-floating btn-small waves-effect waves-light blue"><i class="material-icons">call_received</i></a>
					</div>				
			   </form>
            </div>
            </div>
			</div>
			</div>




                     <div class="container">
<div class="responsive-table">          
  <table class="table">
    <thead>
      <tr>
      <th></th>
        <th>کد درس</th>
        <th>نام درس</th>
        <th>نام استاد</th>
        <th>ساعت و روز کلاس</th>
        <th>ساعت و روز امتحان</th>
        
      </tr>
    </thead>
    <tbody>
        <% for (int i = 0;i<courses.size();i++) {%>
        <tr>
            <td>
                <button id="btn<%=i+1%>" class="btn-floating btn-small waves-effect waves-light green"  onClick="addDynamicCourse('dynamicInput' , <%=i+1%>);"><i class="material-icons">add</i></button>
            </td>
            <div id ="div<%=i+1%>"> 
                <td id = "course-id<%=i+1%>"><%=courses.get(i).getCourseid().getId() %></td>
                <!--course name-->
                <td><%=courses.get(i).getCourseid().getName()%></td>
                <!--teacher name-->
                <td><%=courses.get(i).getProfid().getName()%></td>
                <!--datetime-->
                <td><%=courses.get(i).getDatetime() %></td>
                <!--examTime-->
                <td><%=courses.get(i).getExamdate()%></td>
          </div>  
      </tr>
      <%}%>
    </tbody>
  </table>
  </div>
        </div>
		
		
	</div>




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

<%@ include file="footer.html" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jqueryMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/materializeMin.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jscripts.js"></script>

</body>
</html>