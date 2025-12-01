package stringoperations;

public class PutUnderScore {
	
	public static void main(String[] args) {
		 String str = "HelloHowAreYouWelcome";
		 
		 StringBuffer sb = new StringBuffer();
		 
		 for (int i=0;i<str.length();i++) {
			 char ch = str.charAt(i);
			 if(Character.isUpperCase(ch)) {
				 sb.append(ch).append("_");
			 }else {
				 sb.append(ch);
			 }	 
		 } 
		 System.out.println(sb);
	}
}
