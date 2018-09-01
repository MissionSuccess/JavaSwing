package org.lanqiao.jdmrg.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDeal {
	public static Date addAndSubtractDaysByGetTime(Date dateTime/*待处理的日期*/,int n/*加减天数*/){ 

	     //日期格式 
	     SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
	     SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     

//	     System.out.println(df.format(new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L))); 
	     //System.out.println(dd.format(new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L))); 
	     //注意这里一定要转换成Long类型，要不n超过25时会出现范围溢出，从而得不到想要的日期值 
//	     System.out.println(dateTime.getTime());
	     return new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L); 
	   } 

	   public static Date addAndSubtractDaysByCalendar(Date dateTime/*待处理的日期*/,int n/*加减天数*/){ 

	     //日期格式 
	     SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
	     SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

	     java.util.Calendar calstart = java.util.Calendar.getInstance(); 
	       calstart.setTime(dateTime); 

	     calstart.add(java.util.Calendar.DAY_OF_WEEK, n);  
//	     System.out.println(df.format(calstart.getTime())); 
	     //System.out.println(dd.format(calstart.getTime())); 
	     return calstart.getTime(); 
	   } 
	   /**
	    * 判断日期输入是否合理 
	    */
	   public static boolean isRational(Date first,Date last) {
		   return first.getTime() < last.getTime();
		   
	   }
	   
	   /**
	    * 计算天数
	    */
	   public static long dayNum(Date first,Date last) {
		   return (last.getTime()-first.getTime())/(24*60*60)/1000;
	   }
	   
	   /**
	    * 判断日期格式是否正确
	    */
	    public static boolean isValidDate(String str) {
	        boolean convertSuccess = true;
	        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
	        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	        try {
	            // 设置lenient为false.
	            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
	            format.setLenient(false);
	            format.parse(str);
	            if(!isRational(addAndSubtractDaysByGetTime(new Date(),-1),format.parse(str))) {
	            	convertSuccess = false;
	            }
	        } catch (Exception e) {
	            // e.printStackTrace();
	            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
	            convertSuccess = false;
	        }

	        return convertSuccess;
	    }
}
