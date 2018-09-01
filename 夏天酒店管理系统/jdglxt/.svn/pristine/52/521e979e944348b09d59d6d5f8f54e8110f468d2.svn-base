package org.lanqiao.jdmrg.service;

import org.apache.commons.mail.HtmlEmail;
public class EmailService {
	private String s1;
	String s2=(int)((Math.random()*9+1)*100000)+"";
	boolean b=false;
	public EmailService(String s1) {
		this.s1 = s1;
	}

	public boolean sendMa() {
		try {
			HtmlEmail htmlEmail = new HtmlEmail();
			//设置邮件内容编码
			htmlEmail.setCharset("utf-8");
			//设置发送邮件服务器
			htmlEmail.setHostName("smtp.qq.com");
			//设置发件人邮箱地址
			htmlEmail.setFrom("599772986@qq.com");
			//设置发件人邮箱认证信息（用户名,密码）
			htmlEmail.setAuthentication("599772986@qq.com","edhtbiaiiijqbddj");
			//设置接收人邮箱地址
			htmlEmail.addTo(s1);
			//设置邮件主题
			htmlEmail.setSubject("验证码:"+s2);
			//设置邮件正文
			htmlEmail.setMsg("hello，尊敬的客户，您的验证码："+s2+"，三分钟有效！");
			//发送邮件
			htmlEmail.send();
			b=true;
			return b;
		} catch (Exception e) {
			return b;
		}
	}
	
	public String  sendnum() {
		return s2;
	}
}

