package question;

public class StringUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings={"f","o","o","bar"};
		System.out.println(concat(strings));
	}
	public static String concat(String[] strings){
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < strings.length; i++) {
		    sb.append(strings[i]);
		}
		return sb.toString();
	}
}
