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
    console.log("in the fuction");
	var user = $("#user-field").val();
	var pass = $("#pass-field").val();
        var URL = "";
	if(user == "" || user == undefined)
	{
		$("#user-field").removeClass("validate");
		$("#user-field").addClass("invalid");
		$("#user-icon").addClass("invalid");
		
	}
	if (pass== "" || pass == undefined)
	{
		$("#pass-field").removeClass("validate");
		$("#pass-field").addClass("invalid");
		$("#pass-icon").addClass("invalid");
	}
	else //user and pass is not empty
	{           
            //URL = ""+ user + ".html";
                $.post("check",
                {
                  name: $("#user-field").val(),
                  pass: $("#pass-field").val(),
                },
                function(data,status){
                    alert(data);
                    if(data == "notFound")
                    {
                        console.log("is false");
                        $("p.error-message").removeClass("hidden");    
                        $("#pass-field").removeClass("validate");
                        $("#pass-field").addClass("invalid");
                        $("#pass-icon").addClass("invalid");
                        $("#user-field").removeClass("validate");
                        $("#user-field").addClass("invalid");
                        $("#user-icon").addClass("invalid");
                    }
                    else
                    {
                        console.log("is url");
                        window.location = data; 
                    }                       
                });            
	}       
}

$("#submit-btn").click(
function() {
    createDynamicURL();
  });


