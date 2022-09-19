package in.ashokit.beans;

public class StringUtils {

	public static Integer convertToInt(String str)
	{
		if(str==null || str.trim().length()==0)
		{
			throw new IllegalArgumentException("String mut not be null or empty");
			
		}
		return Integer.valueOf(str);
	}
}
