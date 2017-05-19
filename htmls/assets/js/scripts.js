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
