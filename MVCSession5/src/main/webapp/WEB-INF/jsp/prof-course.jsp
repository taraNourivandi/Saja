<%-- 
    Document   : prof-course
    Created on : Apr 27, 2017, 8:17:24 PM
    Author     : Fatemeh-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="fa">
<head>
	<meta charset="UTF-8">
    <!--<base href="enter base url here">-->
    <title>سجا - مشاهده دروس</title>
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
      <p>صادق علی اکبری</p>
      <!--user-profile-modal trigger-->
      <a href=main.html>
                <i class="material-icons tooltipped" data-position="bottom" data-delay="50"
                   data-tooltip="خروج از سیستم">power_settings_new</i>
            </a>
    </li>
    <li class="right-align">
      <ul class="collapsible collapsible-accordion">
        <li class="bold">
          <a href="prof-change.html" class="collapsible-header waves-effect waves-teal">تغییر مشخصات</a>
        </li>
        <li class="bold">
          <a href="prof-marking.html" class="collapsible-header waves-effect waves-teal">ثبت نمره</a>
        </li>
      </ul>
    </li>
  </ul>
	<!--//sidebar-->

</header>
<!--//main header-->
<main>
	<!--main-content-->
<div class="container">
<ul id="tabs-swipe-demo" class="tabs">
    <li class="tab col s3"><a href="#test-swipe-1">مهندسی اینترنت</a></li>
    <li class="tab col s3"><a href="#test-swipe-2">برنامه نویسی پیشرفته</a></li>
    <li class="tab col s3"><a href="#test-swipe-3">شبکه های کامپیوتری</a></li>
  </ul>



  <div id="test-swipe-1" class="col s12">
  <div class="row">
            
      <div class="col s12 m11">
        <div class="card-panel teal center-align">
          <div class="row">
        <div class="col m4">
        
           نام درس: مهندسی اینترنت
        
        </div>
        <div class="col m4">
            ساعت ارائه درس: شنبه و دوشنبه ساعت 9 تا 10:30
        </div>
        <div class="col m4">
            تاریخ و ساعت امتحان: 20 خرداد
        </div>
      </div>
      </div>



<div class="container">
  <div class="responsive-table">          
  <table class="table">
    <thead>
      <tr>
        <th>شماره</th>
        <th>شماره دانشجویی</th>
        <th>نام خانوادگی</th>
        <th>نام</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>92213201</td>
        <td>علوی</td>
        <td>علی</td>
      </tr>
      <tr>
        <td>2</td>
        <td>92213202</td>
        <td>تقوی</td>
        <td>تقی</td>
      </tr>
      <tr>
        <td>3</td>
        <td>92213203</td>
        <td>نقوی</td>
        <td>نقی</td>
      </tr>
    </tbody>
  </table>
  </div>
        </div>



        </div>
      </div>
    </div>
      
  <div id="test-swipe-2" class="col s12 ">
      <div class="row">
            
      <div class="col s12 m11">
        <div class="card-panel teal center-align">
          <div class="row">
        <div class="col m4">
        
           نام درس: برنامه نویسی پیشرفته
        
        </div>
        <div class="col m4">
            ساعت ارائه درس: دوشنبه و چهارشنبه ساعت 10.5 تا 12
        </div>
        <div class="col m4">
            تاریخ و ساعت امتحان: 21 خرداد
        </div>
      </div>
      </div>



<div class="container">
  <div class="responsive-table">          
  <table class="table">
    <thead>
      <tr>
        <th>شماره</th>
        <th>شماره دانشجویی</th>
        <th>نام خانوادگی</th>
        <th>نام</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>4</td>
        <td>92213201</td>
        <td>علوی</td>
        <td>علی</td>
      </tr>
      <tr>
        <td>5</td>
        <td>92213202</td>
        <td>تقوی</td>
        <td>تقی</td>
      </tr>
      <tr>
        <td>6</td>
        <td>92213203</td>
        <td>نقوی</td>
        <td>نقی</td>
      </tr>
    </tbody>
  </table>
  </div>
        </div>



        </div>
      </div>
    
      
  </div>
  <div id="test-swipe-3" class="col s12 ">
      <div class="row">
            
      <div class="col s12 m11">
        <div class="card-panel teal center-align">
          <div class="row">
        <div class="col m4">
        
           نام درس: شبکه های کامپیوتری
        
        </div>
        <div class="col m4">
            ساعت ارائه درس: یکشنبه و سهشنبه ساعت 9 تا 10:30
        </div>
        <div class="col m4">
            تاریخ و ساعت امتحان: 22 خرداد
        </div>
      </div>
      </div>



<div class="container">
  <div class="responsive-table">          
  <table class="table">
    <thead>
      <tr>
        <th>شماره</th>
        <th>شماره دانشجویی</th>
        <th>نام خانوادگی</th>
        <th>نام</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>7</td>
        <td>92213201</td>
        <td>علوی</td>
        <td>علی</td>
      </tr>
      <tr>
        <td>8</td>
        <td>92213202</td>
        <td>تقوی</td>
        <td>تقی</td>
      </tr>
      <tr>
        <td>9</td>
        <td>92213203</td>
        <td>نقوی</td>
        <td>نقی</td>
      </tr>
    </tbody>
  </table>
  </div>
        </div>



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
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/materialize.min.js"></script>
<!--<script type="text/javascript" src="assets/js/init.js"></script>-->
<!--<script type="text/javascript" src="assets/js/URI.min.js"></script>-->
<script type="text/javascript" src="assets/js/scripts.js"></script>
</body>
</html>

