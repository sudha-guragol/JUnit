package in.ashokit.beans;

public class PalindromeCheck {

	
	public boolean ispalindrome(String str)
	{
		String reverse="";
		int lenght=str.length();
		
		for(int i=lenght-1;i>=0;i--)
		{
			reverse=reverse+str.charAt(i);
			
		}
		
		if(str.equals(reverse))
		{
			return true;
		}
		return false;
	}
}
