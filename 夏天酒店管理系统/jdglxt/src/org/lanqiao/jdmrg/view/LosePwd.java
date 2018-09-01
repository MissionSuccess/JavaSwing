package org.lanqiao.jdmrg.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;

import org.lanqiao.jdmrg.dao.ClientDao;
import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.service.EmailService;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

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
		
		JLabel lblNewLabel = new JLabel("忘记密码");
		lblNewLabel.setBounds(193, 27, 100, 27);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setBounds(89, 82, 40, 35);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("新密码");
		label.setBounds(84, 132, 50, 35);
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("确认密码");
		label_1.setBounds(77, 182, 65, 35);
		panel.add(label_1);
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("验证码");
		label_2.setBounds(84, 232, 50, 35);
		panel.add(label_2);
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		tf_accountNum = new JTextField();
		tf_accountNum.setBounds(144, 82, 186, 35);
		panel.add(tf_accountNum);
		tf_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_accountNum.setEnabled(false);
		tf_accountNum.setText(s);
		tf_accountNum.setColumns(10);
		
		tf_yanzhengma = new JTextField();
		tf_yanzhengma.setBounds(144, 232, 186, 35);
		panel.add(tf_yanzhengma);
		tf_yanzhengma.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_yanzhengma.setColumns(10);
		
		JButton btn_send = new JButton();
		btn_send.setBounds(340, 83, 100, 34);
		panel.add(btn_send);
		btn_send.setFont(new Font("宋体", Font.PLAIN, 12));
		btn_send.setIcon(new ImageIcon("src/images/发送验证码.png"));
		
		pwf_newpwd = new JPasswordField();
		pwf_newpwd.setBounds(144, 132, 186, 35);
		panel.add(pwf_newpwd);
		pwf_newpwd.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btn_confrie = new JButton();
		btn_confrie.setBounds(79, 287, 100, 34);
		panel.add(btn_confrie);
		btn_confrie.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_confrie.setIcon(new ImageIcon("src/images/确定.png"));
		
		pwf_surepwd = new JPasswordField();
		pwf_surepwd.setBounds(144, 182, 186, 35);
		panel.add(pwf_surepwd);
		pwf_surepwd.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btn_return = new JButton();
		btn_return.setBounds(271, 287, 100, 34);
		panel.add(btn_return);
		btn_return.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_return.setIcon(new ImageIcon("src/images/返回1.png"));
		
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Denglu();
				dispose();
			}
		});
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
		
		setVisible(true);
		
	}
	
}
