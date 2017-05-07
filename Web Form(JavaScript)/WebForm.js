/**
 * JavaScript file for the validation of all the fields in the html file. Also this file 
 * contains two functions that visualize the users address on the map(using google maps API).
 */
var checkRez;
function idMatch(focTag, id, regEx, tag, text)
{
	if (firstname.length == 0) 
	{
		$('#head').text("All the fields must be filled.");
			
		$("#firstname").focus();
		
	}
	else if(!id.match(regEx) || id.length == 0)
	{
		$(tag).text(text);
		
		focTag.focus();
		if(checkRez)
		{
			checkRez = false;
		}
	}
	
}
	$(document).ready(function() {
		$('#submit').click(function (e) {
			checkRez = true;
			
			// initialize variables
			var firstname = $('#firstname').val();
			var lastname = $('#lastname').val();
			var address = $('#address').val();
			var email = $('#email').val();
			var pass = $('#password').val();
			var cPass = $('#conPassword').val();
			var url = $('#webSite').val();
			
			// initialize regEx
			
			var name_reg = '^[a-zA-Z]{2,16}$';
			var addr_reg = /^[a-zA-Z0-9\s]{3,20}$/;
			var email_reg = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			var url_reg = /^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/|www\.)[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/;
			
			idMatch($("#firstname"), firstname, name_reg, '#p1', "Please use letters only for your first name.");
			
			idMatch($("#lastname"), lastname, name_reg, '#p2', "Please use letters only for your last name.");
			
			idMatch($("#address"), address, addr_reg, '#p3', "Please use letters and numbers only for your address.");
			
			idMatch($("#email"), email, email_reg, '#p4', "Please enter a valid email address.");
			
			if(!(pass.length >= 6 && pass.length <= 15) || pass.length == 0)
			{
				$('#p5').text("Please enter a password that us between 6 and 15 characters.");
			
				$("#password").focus();
				if(checkRez)
				{
					checkRez = false;
				}
			}
			else if(cPass != pass)
			{
				$('#p6').text("Please confirm your password.");
				
				$("#conPassword").focus();
				if(checkRez)
				{
					checkRez = false;
				}
			}

			idMatch($("#webSite"), url, url_reg, '#p7', "Please enter a valid URL address.");
			
			if(checkRez)
			{
				alert("Form Submitted Successfuly!");
			}
			
			return checkRez;
			
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