package org.lanqiao.jdmrg.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.dao.ClientDao;
import org.lanqiao.jdmrg.dao.FrontDeskDao;
import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.bean.FrontDesk;
import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.MyFocusListener;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;
import java.awt.Font;

public class Denglu extends JFrame{
	private JTextField tf_accountNum;
	private JPasswordField Jpwd_pwd;
	private String s;
	private JFrame jfff;
    String info1 = "请输入 账号<邮箱>";  
    String info2 = "请输入 密码"; 
	public Denglu() {
		jfff = this;
		setTitle("欢迎使用");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 480, 380);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel label_accountNum = new JLabel("账号");
		label_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		label_accountNum.setBounds(110, 100, 40, 35);
		getContentPane().add(label_accountNum);
		
		JLabel label_pwd = new JLabel("密码");
		label_pwd.setFont(new Font("宋体", Font.PLAIN, 16));
		label_pwd.setBounds(110, 180, 40, 35);
		getContentPane().add(label_pwd);
		
		
		tf_accountNum = new JTextField();
		tf_accountNum.setFont(new Font("宋体", Font.PLAIN, 16));
		tf_accountNum.setText(info1);
		tf_accountNum.setBounds(160, 100, 208, 35);
		getContentPane().add(tf_accountNum);
		tf_accountNum.setColumns(10);
		tf_accountNum.addFocusListener(new MyFocusListener(info1, tf_accountNum));
		this.setFocusable(true);
		
		  ButtonGroup group = new ButtonGroup();
		
		JButton btn_login = new JButton("登录");
		btn_login.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=tf_accountNum.getText().toLowerCase();
				String s2=new String(Jpwd_pwd.getPassword());
//				System.out.println(s2);
				if(s1!=null&&s1.contains("@")) {
					Client client=new ClientDao().findByaccountNum(s1);
					if(false==Check.checkemali(s1)) {
						JOptionPane.showMessageDialog(null,"邮箱格式错误！","",JOptionPane.WARNING_MESSAGE);
					}else if(null==client) {
						JOptionPane.showMessageDialog(null,"账户不存在！","",JOptionPane.WARNING_MESSAGE);
					}else if(client.getPwd().equals(s2)){
						new CanvasFrame2(s1).addPanelLeft(new ClientPanel());
						EmptyBg aInformationFrame=new EmptyBg();
						CanvasFrame2.delePanelRight(aInformationFrame);
						jfff.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"密码有误！","",JOptionPane.WARNING_MESSAGE);
					}
				}else{
					FrontDesk fdesk=new FrontDeskDao().findByaccountNum(s1);
					if(null==fdesk) {
						JOptionPane.showMessageDialog(null,"账号不存在！","",JOptionPane.WARNING_MESSAGE);
					}else if(fdesk.getPwd().equals(s2)) {
					new CanvasFrame2(s1).addPanelLeft(new QTPanel());
					EmptyBg aInformationFrame=new EmptyBg();
					CanvasFrame2.delePanelRight(aInformationFrame);
					jfff.dispose();
					}else {
						JOptionPane.showMessageDialog(null,"密码有误！","",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btn_login.setBounds(60, 269, 100, 34);
		getContentPane().add(btn_login);
		
		JButton btn_reg = new JButton("注册");
		btn_reg.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Zhuce();
				dispose();
			}
		});
		btn_reg.setBounds(190, 269, 100, 34);
		getContentPane().add(btn_reg);
		
		JButton btn_losepwd= new JButton("忘记密码");
		btn_losepwd.setFont(new Font("宋体", Font.PLAIN, 14));
		btn_losepwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("".equals(tf_accountNum.getText())) {
					JOptionPane.showMessageDialog(null,"账号不能为空！","",JOptionPane.WARNING_MESSAGE);
				}else {
					new LosePwd(tf_accountNum.getText());
					dispose();
				}
			}
		});
		btn_losepwd.setBounds(320, 269, 93, 34);
		getContentPane().add(btn_losepwd);
		
		Jpwd_pwd = new JPasswordField();
		Jpwd_pwd.setFont(new Font("宋体", Font.PLAIN, 16));
		Jpwd_pwd.setBounds(160, 180, 208, 35);
		getContentPane().add(Jpwd_pwd);
		
		JLabel label = new JLabel("    夏天酒店管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 28));
		label.setBounds(80, 25, 320, 45);
		getContentPane().add(label);
//		Jpwd_pwd.addFocusListener(new MyFocusListener(info2, Jpwd_pwd));
		
		setVisible(true);
	}
	
	/**获取账号*/
	public String getNum() {
		return tf_accountNum.getText();
	}
	
	/**获取密码*/
	public String getPwd() {
		return Jpwd_pwd.getPassword().toString();
	}
}
  