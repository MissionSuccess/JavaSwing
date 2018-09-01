package org.lanqiao.jdmrg.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;

import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.ClientDao;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class PersonMasssge extends JFrame{
	private JTextField tf_accountNum;
	private JTextField tf_nickname;
	private JTextField tf_name;
	private JTextField tf_age;
	private JTextField tf_Idcard;
	private JTextField tf_phone;
	public PersonMasssge(String s,String s1,String s2) {
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
		
		JLabel lblNewLabel = new JLabel("完善个人信息");
		lblNewLabel.setBounds(179, 31, 150, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setBounds(104, 87, 40, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label = new JLabel("昵称");
		label.setBounds(104, 122, 40, 30);
		panel.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(104, 157, 40, 30);
		panel.add(label_1);
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("年龄");
		label_2.setBounds(104, 192, 40, 30);
		panel.add(label_2);
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_3 = new JLabel("身份证号");
		label_3.setBounds(89, 227, 70, 30);
		panel.add(label_3);
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("手机号码");
		label_4.setBounds(89, 262, 70, 30);
		panel.add(label_4);
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		tf_accountNum = new JTextField();
		tf_accountNum.setBounds(163, 87, 190, 30);
		panel.add(tf_accountNum);
		tf_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_accountNum.setEnabled(false);
		tf_accountNum.setColumns(10);
		tf_accountNum.setText(s);
		
		tf_nickname = new JTextField();
		tf_nickname.setBounds(163, 122, 190, 30);
		panel.add(tf_nickname);
		tf_nickname.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_nickname.setColumns(10);
		tf_nickname.setText(s2);
		
		tf_name = new JTextField();
		tf_name.setBounds(163, 157, 190, 30);
		panel.add(tf_name);
		tf_name.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_name.setColumns(10);
		
		tf_age = new JTextField();
		tf_age.setBounds(163, 192, 190, 30);
		panel.add(tf_age);
		tf_age.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_age.setColumns(10);
		
		tf_Idcard = new JTextField();
		tf_Idcard.setBounds(163, 227, 190, 30);
		panel.add(tf_Idcard);
		tf_Idcard.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_Idcard.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  String ids = tf_Idcard.getText();  
				  if(ids.length() >17) e.consume();
			}
		});
		tf_Idcard.setColumns(10);
		
		tf_phone = new JTextField();
		tf_phone.setBounds(163, 262, 190, 30);
		panel.add(tf_phone);
		tf_phone.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				  String phs = tf_phone.getText();  
				  if(phs.length()>10) e.consume();
			}
		});
		tf_phone.setColumns(10);
		
		JButton btn_comfire = new JButton();
		btn_comfire.setBounds(104, 307, 100, 34);
		panel.add(btn_comfire);
		btn_comfire.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_comfire.setIcon(new ImageIcon("src/images/确定.png"));
		
		JButton btn_return = new JButton();
		btn_return.setBounds(284, 307, 100, 34);
		panel.add(btn_return);
		btn_return.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_return.setIcon(new ImageIcon("src/images/返回1.png"));
		
		btn_return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Denglu();
				dispose();
			}
		});
		btn_comfire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(tf_Idcard.getText())||"".equals(tf_name.getText())||"".equals(tf_phone.getText())) {
					JOptionPane.showMessageDialog(null,"身份证号，姓名，手机号码不能为空!","",JOptionPane.WARNING_MESSAGE);
				}else if(false==Check.checkage(tf_age.getText())) {
					JOptionPane.showMessageDialog(null,"年龄输入有误！","",JOptionPane.WARNING_MESSAGE);
				}else if(false==Check.checkidcard(tf_Idcard.getText())){
					JOptionPane.showMessageDialog(null,"身份证号输入有误！","",JOptionPane.WARNING_MESSAGE);
				}else if(false==Check.checkphone(tf_phone.getText())){
					JOptionPane.showMessageDialog(null,"手机号输入有误！","",JOptionPane.WARNING_MESSAGE);
				}else {
					Client obj=new Client(tf_accountNum.getText(),s1,tf_nickname.getText(),Integer.valueOf(tf_age.getText()),tf_name.getText(),tf_Idcard.getText(),tf_phone.getText());
					new ClientDao().add(obj);
					new Denglu();
					dispose();
				}
			}
		});
		setVisible(true);
		
	}
}
