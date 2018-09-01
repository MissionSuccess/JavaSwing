package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.MyFocusListener;
import org.lanqiao.jdmrg.dao.ClientDao;
import org.lanqiao.jdmrg.service.EmailService;

public class Zhuce extends JFrame{
	private JTextField tf_nickname;
	private JTextField tf_accountNum;
	private JPasswordField pwdF_pwd;
	private JPasswordField pwdF_comfirepwd;
	private JTextField tf_Vcode;
	String s3;
	String info1 = "请输入 账号<邮箱>";
	String info2="111111";
	private JTextField textField;
	public Zhuce() {
		setTitle("欢迎使用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 480, 380);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("注册");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(215, 26, 50, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("昵称");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(115, 75, 40, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("账号");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(115, 119, 40, 26);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(115, 159, 40, 26);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("再次输入");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(100, 199, 70, 26);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("验证码");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(105, 239, 60, 26);
		getContentPane().add(label_3);
		
		tf_nickname = new JTextField();
		tf_nickname.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_nickname.setBounds(165, 75, 150, 30);
		getContentPane().add(tf_nickname);
		tf_nickname.setColumns(10);
		
		tf_accountNum = new JTextField();
		tf_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_accountNum.setText(info1);
		tf_accountNum.setColumns(10);
		tf_accountNum.setBounds(165, 115, 150, 30);
		getContentPane().add(tf_accountNum);
		tf_accountNum.addFocusListener(new MyFocusListener(info1, tf_accountNum));
		this.setFocusable(true);
		
		pwdF_pwd = new JPasswordField();
		pwdF_pwd.setFont(new Font("宋体", Font.PLAIN, 16));
//		pwdF_pwd.setText(info2);
//		pwdF_pwd.addKeyListener(new KeyAdapter() {
//		@Override
//		public void keyTyped(KeyEvent e) {
//			String s = new String(pwdF_pwd.getPassword());
//				if (s.length() > 5)
//				e.consume();
//			}
//		});
	   pwdF_pwd.setBounds(165, 155, 150, 30);
//	   pwdF_pwd.addFocusListener(new MyFocusListener(info2,pwdF_pwd));
	   getContentPane().add(pwdF_pwd);
				
		pwdF_comfirepwd = new JPasswordField();
		pwdF_comfirepwd.setFont(new Font("宋体", Font.PLAIN, 16));
		pwdF_comfirepwd.setBounds(165, 195, 150, 30);
		getContentPane().add(pwdF_comfirepwd);
		
		tf_Vcode = new JTextField();
		tf_Vcode.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_Vcode.setBounds(165, 235, 150, 30);
		getContentPane().add(tf_Vcode);
		tf_Vcode.setColumns(10);
		
		JButton btn_sendVcode = new JButton("发送验证码");
		btn_sendVcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new ClientDao().isExist(tf_accountNum.getText())){
					JOptionPane.showMessageDialog(null,"该用户已存在！","",JOptionPane.WARNING_MESSAGE);
				}else if(false==Check.checkemali(tf_accountNum.getText())) {
					JOptionPane.showMessageDialog(null,"邮箱格式错误！","",JOptionPane.WARNING_MESSAGE);
				}
				else {
					EmailService e = new EmailService(tf_accountNum.getText());
					s3=e.sendnum();
					boolean b=e.sendMa();
					if(!b) {
						JOptionPane.showMessageDialog(null,"验证码发送失败！","",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btn_sendVcode.setBounds(346, 113, 100, 34);
		getContentPane().add(btn_sendVcode);
		
		JButton btn_comfire = new JButton("确认");
		btn_comfire.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_comfire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=new String(pwdF_pwd.getPassword()).trim();
				String s1=new String(pwdF_comfirepwd.getPassword());
				if("".equals(tf_accountNum.getText())||"".equals(s)||"".equals(tf_nickname.getText())) {
					JOptionPane.showMessageDialog(null,"账号,密码,昵称都不能为空！","",JOptionPane.WARNING_MESSAGE);
				}else if(false==Check.checkpwd(s)){
					JOptionPane.showMessageDialog(null,"密码长度至少6位且不含空格！","",JOptionPane.WARNING_MESSAGE);
				}else if("".equals(tf_Vcode.getText())) {
					JOptionPane.showMessageDialog(null,"先获取验证码！","",JOptionPane.WARNING_MESSAGE);
				}else if(s.equals(s1)&&s3.equals(tf_Vcode.getText())){
					new PersonMasssge(tf_accountNum.getText().toLowerCase(),s,tf_nickname.getText());
					dispose();
				}else if(!s3.equals(tf_Vcode.getText())){
					JOptionPane.showMessageDialog(null,"验证码错误！","",JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,"两次密码输入不同！","",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_comfire.setBounds(100, 290, 100, 34);
		getContentPane().add(btn_comfire);
		
		JButton btn_return = new JButton("返回");
		btn_return.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Denglu();
				dispose();
			}
		});
		btn_return.setBounds(280, 290, 100, 34);
		getContentPane().add(btn_return);
		
		setVisible(true);
		
	}

	/**获取昵称*/
	public String getName() {
		return tf_nickname.getText();
	}
	
	/**获取账号*/
	public String getaccontNum() {
		return tf_accountNum.getText();
	}
	
	/**获取密码*/
	public String getPwdone() {
		return pwdF_pwd.getPassword().toString();
	}
	
	/**再次获取密码*/
	public String getPwdtwo() {
		return pwdF_comfirepwd.getPassword().toString();
	}
	
	/**获取验证码*/
	public String getYanzhengma() {
		return tf_Vcode.getText();
	}
}


