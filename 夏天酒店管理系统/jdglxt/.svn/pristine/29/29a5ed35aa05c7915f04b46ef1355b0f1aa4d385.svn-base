package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.ClientDao;

public class UpdatePwd extends JPanel{
	/**当前窗口画布*/
	private JPanel thisPanel;
	/**密码框数组*/
	private JPasswordField[] jt;
	
	public UpdatePwd() {

		thisPanel = this;
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		showLabel();
		showText();
		showOKbnt();

		// 添加画布到窗口画布
//		TestFrame.addPanelRight(this);
//		repaint();
	}
	
	/**
	 * 绘制标签
	 */
	public void showLabel() {
		JLabel[] jlb = new JLabel[3];
		for(int i = 0 ; i < 3; i++) {
			jlb[i] = new JLabel();
			jlb[i].setSize(200,200);
			jlb[i].setLocation(140, i*150+50);
			jlb[i].setFont(new Font("黑体",Font.BOLD,24));
			this.add(jlb[i]);
		}
		jlb[0].setText("原密码");
		jlb[1].setText("新密码");
		jlb[2].setText("再次输入");
	}
	
	/**
	 * 绘制密码框
	 */
	public void showText() {
		jt = new JPasswordField[3];
		for(int i = 0; i < 3; i++) {
			jt[i] = new JPasswordField();
			jt[i].setSize(350, 50);
			jt[i].setLocation(250, i*150+125);
			jt[i].setFont(new Font("",Font.BOLD,24));
			this.add(jt[i]);
		}

	}
	
	
	/**
	 * 确认按钮
	 */
	public void showOKbnt() {
		JButton jb = new JButton();
		jb.setSize(200, 50);
		jb.setLocation(320, 530);
		jb.setFont(new Font("黑体",Font.BOLD,24));
		jb.setIcon(new ImageIcon("src/images/确认.png"));
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exeOKbnt();
            }
        });
		this.add(jb);
	}
	
	/**按钮执行*/
	public void exeOKbnt() {
		Client client=new ClientDao().findByaccountNum(RoomerAccount.accountNum);
		String s=client.getPwd();
		if("".equals(new String(jt[0].getPassword()))||"".equals(new String(jt[1].getPassword()))||"".equals(new String(jt[2].getPassword()))) {
			JOptionPane.showMessageDialog(null,"原密码,新密码都不能为空！","",JOptionPane.WARNING_MESSAGE);
		}else if(false==Check.checkpwd(new String(jt[1].getPassword()))) {
			JOptionPane.showMessageDialog(null,"新密码长度为至少6且不含空格！","",JOptionPane.WARNING_MESSAGE);
		}
		else if(!s.equals(new String(jt[0].getPassword()))) {
			JOptionPane.showMessageDialog(null,"原密码输入有误！","",JOptionPane.WARNING_MESSAGE);
		}else if(new String(jt[1].getPassword()).equals(new String(jt[2].getPassword()))&&s.equals(new String(jt[0].getPassword()))){
			Client obj=new Client(RoomerAccount.accountNum,new String(jt[1].getPassword()),null,-1,null,null,null);
			new ClientDao().updateByacconutNum(obj);
			JOptionPane.showMessageDialog(null,"密码修改成功！");
			UpdatePwd updatePwd=new UpdatePwd();
			CanvasFrame2.delePanelRight(updatePwd);
			return;
		}else {
			JOptionPane.showMessageDialog(null,"两次密码输入不同！","",JOptionPane.WARNING_MESSAGE);
		}
//		System.out.println(new String(jt[0].getPassword()));
//		System.out.println(new String(jt[1].getPassword()));
//		System.out.println(new String(jt[2].getPassword()));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = null;
		try {
			img = new ImageIcon(RoomerAccount.bg).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 840,640,null);
		repaint();
	}
}
