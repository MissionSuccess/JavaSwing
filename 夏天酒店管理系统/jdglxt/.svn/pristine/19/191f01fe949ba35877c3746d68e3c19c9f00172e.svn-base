package org.lanqiao.jdmrg.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.dao.ClientDao;
import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.service.EmailService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LosePwd extends JFrame{
	private JTextField tf_accountNum;
	private JTextField tf_yanzhengma;
	private JPasswordField pwf_newpwd;
	private JPasswordField pwf_surepwd;
	String s3;
	public LosePwd(String s) {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 24));
		setTitle("欢迎使用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 480, 380);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("忘记密码");
		lblNewLabel.setBounds(190, 20, 100, 27);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(110, 75, 40, 35);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("新密码");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(105, 125, 50, 35);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("确认密码");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(98, 175, 65, 35);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("验证码");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(105, 225, 50, 35);
		getContentPane().add(label_2);
		
		tf_accountNum = new JTextField();
		tf_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_accountNum.setBounds(165, 75, 150, 35);
		tf_accountNum.setEnabled(false);
		tf_accountNum.setText(s);
		getContentPane().add(tf_accountNum);
		tf_accountNum.setColumns(10);
		
		tf_yanzhengma = new JTextField();
		tf_yanzhengma.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_yanzhengma.setBounds(165, 225, 150, 35);
		tf_yanzhengma.setColumns(10);
		getContentPane().add(tf_yanzhengma);
		
		JButton btn_send = new JButton("发送验证码");
		btn_send.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailService email=new EmailService(tf_accountNum.getText());
				s3=email.sendnum();
				boolean b=email.sendMa();
				if(!b) {
					JOptionPane.showMessageDialog(null,"验证码发送失败，请检查邮箱填写是否正确！","",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_send.setBounds(340, 75, 114, 35);
		getContentPane().add(btn_send);
		
		pwf_newpwd = new JPasswordField();
		pwf_newpwd.setFont(new Font("宋体", Font.PLAIN, 16));
//		pwf_newpwd.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				String pwds=new String(pwf_newpwd.getPassword());
//				if(pwds.length() >5) e.consume();
//			}
//		});
		pwf_newpwd.setBounds(165, 125, 150, 35);
		getContentPane().add(pwf_newpwd);
		
		pwf_surepwd = new JPasswordField();
		pwf_surepwd.setFont(new Font("宋体", Font.PLAIN, 16));
		pwf_surepwd.setBounds(165, 175, 150, 35);
		
		JButton btn_confrie = new JButton("确认");
		btn_confrie.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_confrie.setBounds(100, 280, 100, 35);
		btn_confrie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=new String(pwf_newpwd.getPassword());
				String s2=new String(pwf_surepwd.getPassword());
				if("".equals(tf_accountNum.getText())||"".equals(s1)||"".equals(s2)||"".equals(tf_yanzhengma.getText())) {
					JOptionPane.showMessageDialog(null,"密码,验证码都不能为空！","",JOptionPane.WARNING_MESSAGE);
				}else if(s1.length()<6) {
					JOptionPane.showMessageDialog(null,"密码长度至少6位！","",JOptionPane.WARNING_MESSAGE);
				}
				else if(s1.equals(s2)&&tf_yanzhengma.getText().equals(s3)) {
					Client obj=new Client(tf_accountNum.getText(),s1,null,-1,null,null,null);
					new ClientDao().updateByacconutNum(obj);
					new Denglu();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"两次密码输入不同！","",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		getContentPane().add(btn_confrie);
		
		getContentPane().add(pwf_surepwd);
		JButton btn_return = new JButton("返回");
		btn_return.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_return.setBounds(280, 280, 100, 35);
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Denglu();
				dispose();
			}
		});
		getContentPane().add(btn_return);
		
		setVisible(true);
		
	}
	
}
