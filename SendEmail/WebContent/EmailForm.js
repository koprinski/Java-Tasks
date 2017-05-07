/**
 * JavaScript file for the function of the submit button. It validates all the fields in the
 * form and fills the text field of the Thunderbird mail text body. Also this file contains two
 * functions that visualize the users address on the map(using google maps API).
 */
$(document).ready(function() {
	$('#submit').click(function (e) {
		var emails = $('#eList').val();
		var subject = $('#subject').val();
		var text = $('#textBody').val();
		
		var res = emails.split(",");
	    var email_reg = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	    
	    for(i = 0; i < res.length; i++)
	    {
	        if(!email_reg.test(res[i]) || emails.length == 0) 
	        {
	        	$('#p1').text("Please enter a valid email address.");
	        	
	        	$("#eList").focus();
	        	return false;
	        }
	        else if(subject.length == 0)
	        {
	        	$('#p2').text("Please enter an email subject.");
	        	
	        	$("#subject").focus();
	        	return false;
	        }
	        else if(text.length == 0)
	        {
	        	$('#p3').text("Please enter some text in the text field.");
	        	
	        	$("#textBody").focus();
	        	return false;
	        }
	        else
	        {
				alert("Form Submitted Successfuly!");
				return true;
	        }
	    }
	});
});

function initialize() {
	var mapOptions = {
		zoom: 10,
		center: new google.maps.LatLng(43.8500,25.9667)
	  };

	var map = new google.maps.Map(document.getElementById('map-canvas'),mapOptions);

}

function loadScript() {
	var script = document.createElement('script');
	script.type = 'text/javascript';
	script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&' +
		'callback=initialize';
	document.body.appendChild(script);
}
window.onload = loadScript;

