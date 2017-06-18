/**
 * Created by hsh on 3/26/17.
 */
(function () {
    $(".button-collapse").sideNav({
        edge: 'right'
    });
    $('.collapsible').collapsible();
    $('.modal').modal();
    $('select').material_select();
    $('.carousel').carousel({
        // fullWidth: true,
        // indicators: true
        padding: 0,
        shift: 0
    });
})();

$("#user-field").keyup(
function() {
    $("#user-field").removeClass("invalid");
	$("#user-field").addClass("validate");
	$("#user-icon").removeClass("invalid");
  })
  .keyup();
  
$("#pass-field").keyup(
function() {
    $("#pass-field").removeClass("invalid");
	$("#pass-field").addClass("validate");
	$("#pass-icon").removeClass("invalid");
  })
  .keyup();

function createDynamicURL()
{
    //The variable to be returned
	var user = $("#user-field").val();
	var pass = $("#pass-field").val();
    var URL = "";
	if(user == "" || user == undefined)
	{
		$("#user-field").removeClass("validate");
		$("#user-field").addClass("invalid");
		$("#user-icon").addClass("invalid");
		URL = false;
	}
	if (pass== "" || pass == undefined)
	{
		$("#pass-field").removeClass("validate");
		$("#pass-field").addClass("invalid");
		$("#pass-icon").addClass("invalid");
		URL = false;
	}
	else
	{
		URL = ""+ user + ".html";
	}
    return URL;
}

$("#submit-btn").click(
function() {
    RedirectURL();
  });

function RedirectURL()
{
	var url = createDynamicURL();
    if(url != false)
		window.location = url;  
}

function createDynamicCourse(divName)
{
    //The variable to be returned
	var user = $("#user-field").val();
	var pass = $("#pass-field").val();

	var courseNameId = "#course-name-opt-" + $("#course-name").val();

	var courseName = $("#course-name").val();
	var zarfiat = $("#zarfiat").val();
    var date = $("#date").val();
    var time = $("#time").val();
    var examDate = $("#examDate").val();
    var examTime = $("#examTime").val();


    //var URL = "";
    var flag = true;
	if(courseName == "" || courseName == undefined)
	{
		$("#course-name").removeClass("validate");
		$("#course-name").addClass("invalid");
		//$("#user-icon").addClass("invalid");
		//URL = false;
		flag = false;
	}
	if (zarfiat== "" || zarfiat == undefined)
	{
		$("#zarfiat").removeClass("validate");
		$("#zarfiat").addClass("invalid");
		flag = false;
		//$("#pass-icon").addClass("invalid");
		//URL = false;
	}
	if (date== "" || date == undefined)
	{
		$("#date").removeClass("validate");
		$("#date").addClass("invalid");
		flag = false;
		//$("#pass-icon").addClass("invalid");
		//URL = false;
	}
	if (time== "" || time == undefined)
	{
		$("#time").removeClass("validate");
		$("#time").addClass("invalid");
		flag = false;
		//$("#pass-icon").addClass("invalid");
		//URL = false;
	}
	if (examDate== "" || examDate == undefined)
	{
		$("#examDate").removeClass("validate");
		$("#examDate").addClass("invalid");
		flag = false;
		//$("#pass-icon").addClass("invalid");
		//URL = false;
	}
	if (examTime== "" || examTime == undefined)
	{
		$("#examTime").removeClass("validate");
		$("#examTime").addClass("invalid");
		flag = false;
		//$("#pass-icon").addClass("invalid");
		//URL = false;
	}
	if (flag)
	{
		addInput(divName);
		$("#add-course-modal").modal('close');
	}
    return URL;
}

var counter = 1;
    //var limit = 3;
    function addInput(divName)
    {
       console.log("in function");
        {
              var newdiv = document.createElement('tr');
              newdiv.id = "tr"+(counter);
              var courseNameId = "#course-name-opt-" + $("#course-name").val();

              //newdiv.innerHTML = "field " + (counter) + " <br><input type='text' name=inputName"+(counter + 1)+">"
              //  +"<input type='text' name=inputVal"+(counter + 1)+">";
              newdiv.innerHTML = "<td>"+$("#course-name").val()+ " , "+ $(courseNameId).html()
                +"</td>"

                +"<td>"+ $("#zarfiat").val() +"</td>"

                +"<td>"+$("#date").val()+"</td>"

                +"<td>"+$("#time").val()+"</td>"

                +"<td>"+$("#examDate").val()+"</td>"

                +"<td>"+$("#examTime").val()+"</td>"

                + '<td><a class="btn-floating waves-effect waves-light red"><i class="material-icons">delete</i></a></td>'

                document.getElementById("send-form").innerHTML = document.getElementById("send-form").innerHTML
                +'<input name=courseId'+(counter)+' type="text" value='+$("#course-name").val()+' style="display: none;">'
                +'<input name=zarfiat'+(counter)+' type="text" value='+$("#zarfiat").val()+' style="display: none;">'
                +'<input name=date'+(counter)+' type="text" value='+$("#date").val()+' style="display: none;">'
                +'<input name=time'+(counter)+' type="text" value='+$("#time").val()+' style="display: none;">'
                +'<input name=examDate'+(counter)+' type="text" value='+$("#examDate").val()+' style="display: none;">'
                +'<input name=examTime'+(counter)+' type="text" value='+$("#examTime").val()+' style="display: none;">'
                   ;

              document.getElementById(divName).appendChild(newdiv);
              document.getElementById("counter").value = counter;
              counter++;
        }
    }
	
	var chosedCourseCounter = 1;
	function addDynamicCourse(divName , id)
	{
		console.log("in function : " + id);
		var selectedDiveId = "#btn" + id;
		
		var newdiv = document.createElement('tr');
		newdiv.innerHTML = $(selectedDiveId).parent().parent().html();
		console.log(newdiv);
		$(selectedDiveId).parent().parent().remove();
		//newdiv.find('td').first().remove();
		document.getElementById(divName).appendChild(newdiv);
		$("#"+divName+" tr:last-child").find('td').first().remove();
		
		var tempCourseId = "#course-id"+id;
		document.getElementById("send-form").innerHTML = document.getElementById("send-form").innerHTML
                +'<input name=courseId'+(chosedCourseCounter)+' type="text" value='+$(tempCourseId).html() +' style="display: none;">'
                
				 +'<input name=courseId'+(chosedCourseCounter)+' type="text" value='+$("#course-name").val()+' style="display: none;">'
		;
		
		document.getElementById("counter").value = chosedCourseCounter;
		//document.getElementById(divName).
		
		
		
		
	}

    function remInput(divName)
    {
        {
              var newdiv = document.getElementById('div'+counter).remove();
              counter--;
        }
    }

$("#course-name").keyup(
function() {
    $("#course-name").removeClass("invalid");
	$("#course-name").addClass("validate");
  })
  .keyup();

  $("#zarfiat").keyup(
function() {
    $("#zarfiat").removeClass("invalid");
	$("#zarfiat").addClass("validate");
  })
  .keyup();

  $("#time").keyup(
function() {
    $("#time").removeClass("invalid");
	$("#time").addClass("validate");
  })
  .keyup();

  $("#date").keyup(
function() {
    $("#date").removeClass("invalid");
	$("#date").addClass("validate");
  })
  .keyup();

  $("#examDate").keyup(
function() {
    $("#examDate").removeClass("invalid");
	$("#examDate").addClass("validate");
  })
  .keyup();

  $("#examTime").keyup(
function() {
    $("#examTime").removeClass("invalid");
	$("#examTime").addClass("validate");
  })
  .keyup();

