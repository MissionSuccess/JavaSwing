package org.lanqiao.jdmrg.common;

import java.util.regex.Pattern;

public class Check {
	

	/**邮箱验证*/
	public static boolean checkemali(String s) {
		return Pattern.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",s);
	}
	
	/**手机号码验证*/
	public static boolean checkphone(String s){
		return  Pattern.matches("^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$",s);
	}
	
	/**年龄验证*/
	public static boolean checkage(String s) {
		return Pattern.matches("^[1-9]|([1-9]\\d)",s);
	}
	
	/**身份证验证*/
	public static boolean checkidcard(String s) {
		return Pattern.matches("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",s);
	}
	
	/**密码验证*/
	public static boolean checkpwd(String s) {
		return Pattern.matches("^\\S{6,}$",s);
	}
	
	/**房间号验证*/
	public static boolean checkroomnum(String s) {
		return Pattern.matches("^[1-6][0][1-8]$",s);
	}
}
