package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.MyFocusListener;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.ClientDao;
import org.lanqiao.jdmrg.service.EmailService;
import javax.swing.JPanel;

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
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image img = null;
				try {
					img = new ImageIcon(RoomerAccount.bg).getImage();
				} catch (Exception e) {
					e.printStackTrace();
				}
				g.drawImage(img, 0, 0, 474,351,null);
				repaint();
			}
		};
		panel.setBounds(0, 0, 474, 351);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("注册");
		lblNewLabel.setBounds(213, 20, 50, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("昵称");
		lblNewLabel_1.setBounds(113, 69, 40, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("账号");
		label.setBounds(113, 113, 40, 26);
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(113, 153, 40, 26);
		panel.add(label_1);
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("再次输入");
		label_2.setBounds(98, 193, 70, 26);
		panel.add(label_2);
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("验证码");
		label_3.setBounds(103, 233, 60, 26);
		panel.add(label_3);
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		tf_nickname = new JTextField();
		tf_nickname.setBounds(163, 69, 170, 30);
		panel.add(tf_nickname);
		tf_nickname.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_nickname.setColumns(10);
		
		tf_accountNum = new JTextField();
		tf_accountNum.setBounds(163, 109, 170, 30);
		panel.add(tf_accountNum);
		tf_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_accountNum.setText(info1);
		tf_accountNum.setColumns(10);
		tf_accountNum.addFocusListener(new MyFocusListener(info1, tf_accountNum));
		
		pwdF_pwd = new JPasswordField();
		pwdF_pwd.setBounds(163, 149, 170, 30);
		panel.add(pwdF_pwd);
		pwdF_pwd.setFont(new Font("宋体", Font.PLAIN, 16));
		
		pwdF_comfirepwd = new JPasswordField();
		pwdF_comfirepwd.setBounds(163, 189, 170, 30);
		panel.add(pwdF_comfirepwd);
		pwdF_comfirepwd.setFont(new Font("宋体", Font.PLAIN, 16));
		
		tf_Vcode = new JTextField();
		tf_Vcode.setBounds(163, 229, 170, 30);
		panel.add(tf_Vcode);
		tf_Vcode.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_Vcode.setColumns(10);
		
		JButton btn_sendVcode = new JButton();
		btn_sendVcode.setBounds(340, 110, 100, 34);
		panel.add(btn_sendVcode);
		btn_sendVcode.setIcon(new ImageIcon("src/images/发送验证码.png"));
		
		JButton btn_comfire = new JButton();
		btn_comfire.setBounds(98, 284, 100, 34);
		panel.add(btn_comfire);
		btn_comfire.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_comfire.setIcon(new ImageIcon("src/images/确定.png"));
		
		JButton btn_return = new JButton();
		btn_return.setBounds(263, 284, 100, 34);
		panel.add(btn_return);
		btn_return.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_return.setIcon(new ImageIcon("src/images/返回1.png"));
		
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Denglu();
				dispose();
			}
		});
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
		this.setFocusable(true);
		
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


