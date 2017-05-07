/**
 * Function for the equal button
 */
function calculate()
{

	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.match('/0'))
		{
			Calc.Input.value = "Division is undefined";
		}
		else
		{
			Calc.Input.value = eval(Calc.Input.value);
		}
		
	}
	
}
/**
 * Function for the <- backspace button
 * @param input
 */
function deleteOne(input)
{
	Calc.Input.value = Calc.Input.value.substring(0,Calc.Input.value.length = Calc.Input.value.length-1);
}

/**
 * Function for the + button
 */
function plusFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf('+') === -1)
		{
			Calc.Input.value += '+';
		}
		else
		{
			Calc.Input.value = Calc.Input.value;
		}
	}
}

/**
 * Function for the + button
 */
function minusFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf('-') === -1)
		{
			Calc.Input.value += '-';
		}
		else
		{
			Calc.Input.value = Calc.Input.value;
		}
	}
}

/**
 * Function for the dot button
 */
function dotFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = '0.';
	}
	else
	{
		Calc.Input.value += '.';
	}
}

/**
 * Function for the multiply button
 */
function multFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf('*') === -1)
		{
			Calc.Input.value += '*';
		}
		else
		{
			Calc.Input.value = Calc.Input.value;
		}
	}
}

/**
 * Function for the divide button
 */
function divFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf('/') === -1)
		{
			Calc.Input.value += '/';
		}
		else
		{
			Calc.Input.value = Calc.Input.value;
		}
	}
}

/**
 * Function for the sin button
 */
function sinFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf("+") > -1 || Calc.Input.value.indexOf("-") > -1 || Calc.Input.value.indexOf("*") > -1 || Calc.Input.value.indexOf("/") > -1)
		{
			Calc.Input.value = Calc.Input.value;
		}
		else
		{
			Calc.Input.value = Math.sin(Calc.Input.value);
		}
	}
}

/**
 * Function for the cos button
 */
function cosFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf("+") > -1 || Calc.Input.value.indexOf("-") > -1 || Calc.Input.value.indexOf("*") > -1 || Calc.Input.value.indexOf("/") > -1)
		{
			Calc.Input.value = Calc.Input.value;
		}
		else
		{
			Calc.Input.value = Math.cos(Calc.Input.value);
		}
	}
}

/**
 * Function for the sqrt button
 */
function sqrtFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf("+") > -1 || Calc.Input.value.indexOf("-") > -1 || Calc.Input.value.indexOf("*") > -1 || Calc.Input.value.indexOf("/") > -1)
		{
			Calc.Input.value = Calc.Input.value;
		}
		else
		{
			Calc.Input.value = Math.sqrt(Calc.Input.value);
		}
	}
}

/**
 * Function for the sqr button
 */
function sqrFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf("+") > -1 || Calc.Input.value.indexOf("-") > -1 || Calc.Input.value.indexOf("*") > -1 || Calc.Input.value.indexOf("/") > -1)
		{
			Calc.Input.value = Calc.Input.value;
		}
		else
		{
			Calc.Input.value = Calc.Input.value * Calc.Input.value;
		}
	}
}

/**
 * Function for the percent button
 */
function percentFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf("+") > -1 || Calc.Input.value.indexOf("-") > -1 || Calc.Input.value.indexOf("*") > -1 || Calc.Input.value.indexOf("/") > -1)
		{
			Calc.Input.value = Calc.Input.value;
		}
		else
		{
			Calc.Input.value = Calc.Input.value / 100;
		}
	}
}

/**
 * Function for the pow button
 */
function powFunc()
{
	if(Calc.Input.value === '')
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		if(Calc.Input.value.indexOf("+") > -1 || Calc.Input.value.indexOf("-") > -1 || Calc.Input.value.indexOf("*") > -1 || Calc.Input.value.indexOf("/") > -1)
		{
			Calc.Input.value = Calc.Input.value;
		}
		else
		{
			if(Calc.Input.value.indexOf("pow") > -1)
			{
				var num1 = Calc.Input.value.substring(0,Calc.Input.value.indexOf('p'));
				var num2 = Calc.Input.value.substring(Calc.Input.value.indexOf('w')+1,Calc.Input.value.length);
				
				Calc.Input.value = Math.pow(num1,num2);
			}
			else
			{
				Calc.Input.value += 'pow';
			}
		}
	}
}

/**
 * Function for the zero button
 */
function zeroFunc()
{
	if(Calc.Input.value === "0")
	{
		Calc.Input.value = Calc.Input.value;
	}
	else
	{
		Calc.Input.value += '0';
	}
}