package test1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t1 {

	public static void main(String[] args) {
		String s ="AAA123fsdfsdf";
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(s);
		
		while(m.find()){
		System.out.println(m.group());
		System.out.println(m.group().getClass());
		}
	}

}
