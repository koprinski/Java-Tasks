var checkRez;

function idMatch(focTag, id, regEx, tag, text)
{
	if (firstname.length == 0) 
	{
		$('#h1').text("All the fields must be filled.");
			
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
		var email = $('#email').val();
		var pass = $('#password').val();
		var age = $('#age').val();
		
		// initialize regEx
		
		var name_reg = '^[a-zA-Z]{2,16}$';
		var email_reg = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		var age_reg = '^(0?[1-9]|[1-9][0-9])$';
		
		idMatch($("#firstname"), firstname, name_reg, '#p1', "Please use letters only for your first name.");
		
		idMatch($("#lastname"), lastname, name_reg, '#p2', "Please use letters only for your last name.");
		
		idMatch($("#email"), email, email_reg, '#p3', "Please enter a valid email address.");
		
		idMatch($("#age"), age, age_reg, '#p5', "Please enter your real age.");
		
		if(!(pass.length >= 6 && pass.length <= 15) || pass.length == 0)
		{
			$('#p4').text("Please enter a password that us between 6 and 15 characters.");
		
			$("#password").focus();
			if(checkRez)
			{
				checkRez = false;
			}
			
		}	
		
		if(checkRez)
		{
			alert("Form Submitted Successfuly!");
			window.location.href = "Success.jsp";
		}
			
		return checkRez;
		
	});
		
});

function Redirect() 
{  
	window.location="index.html"; 
} 
