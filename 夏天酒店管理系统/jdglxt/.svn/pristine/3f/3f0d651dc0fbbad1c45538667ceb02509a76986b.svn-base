package org.lanqiao.jdmrg.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.ClientDao;
/**
 * 联系客服（客户界面）
 * 
 * @author wzg
 */
@SuppressWarnings("serial")
public class Contact_KFpanel extends JPanel{
	public Contact_KFpanel() {
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);
		this.setBackground(Color.white);
		
		JLabel contactNum=new JLabel("联系电话：");
		contactNum.setFont(new Font("楷体",Font.BOLD,32));
		contactNum.setSize(200, 80);
		contactNum.setLocation(195, 230);
		this.add(contactNum);
		
		JLabel Num2=new JLabel("13566778899");
		Num2.setFont(new Font("楷体",Font.BOLD,32));
		Num2.setSize(250, 80);
		Num2.setLocation(375, 230);
		this.add(Num2);
		
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





