package com.omisoft.basic_java.Collections.task4;


public class IdValidator {
	/**
	 * Id validator
	 * @param in - input ID string
	 */
	public void validator(String in)
	{

		String sep = "([1-9][0-9])((?:[0][1-9])|(?:[1][0-2]))((?:[0-2][0-9])|(?:[3][0-1]))([0-9])([0-9])([0-9])([0-9])";

		float conNum = 0;
		char ch[] = in.toCharArray();
		
		try
		{
			
			if(in.length()>10 || in.length()<10)
			{
				System.out.println("Invalid ID number!");
			}
			else
			{
				String fn = String.valueOf(ch[0]);			
				String sn = String.valueOf(ch[1]);
				String tn = String.valueOf(ch[2]);
				String fon = String.valueOf(ch[3]);
				String fin = String.valueOf(ch[4]);
				String sin = String.valueOf(ch[5]);
				String svn = String.valueOf(ch[6]);
				String en = String.valueOf(ch[7]);
				String nn = String.valueOf(ch[8]);
				String ten = String.valueOf(ch[9]);
				
				float sum = (Float.parseFloat(fn)*2+Float.parseFloat(sn)*4+Float.parseFloat(tn)*8+Float.parseFloat(fon)*5
						+Float.parseFloat(fin)*10+Float.parseFloat(sin)*9+Float.parseFloat(svn)*7+Float.parseFloat(en)*3
						+Float.parseFloat(nn)*6) % (11);
				
				if (sum <10)
				{
					conNum = sum;
				
				}
				else if (sum == 10)
				{
					conNum = 0;
				}
				
				if (conNum == Integer.parseInt(ten))
				{
					if (in.matches(sep))
					{
						if (Integer.parseInt(nn)%2==0)
						{
							System.out.println("Man");
						}
						else
						{
							System.out.println("Woman");
						}
					}
					else
					{
						System.err.println("This ID is not valid!");
					}
					
				}
				else
				{
					System.err.println("This ID is not valid!");
				}
			}
		
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		System.out.println(ch);
	}
		
}
