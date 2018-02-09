package JavaProgram;

public class ReverseString {

	public static void main(String[] args) {
		String str="MANISH"; // Reverse String
		//String str="123459";

		int len=str.length();
		String s="";
		//System.out.println(len);
		
		for(int i=len-1;i>=0;i--)
		{
			s=s+str.charAt(i);
			
		}
		System.out.println(s);

	}

}
