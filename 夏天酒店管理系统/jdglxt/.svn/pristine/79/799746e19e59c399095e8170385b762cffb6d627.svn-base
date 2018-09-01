package org.lanqiao.jdmrg.view;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Pack200;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.view.*;

//import dao.UpdateClient;
//import view.CanvasFrame;
//import view.KeyFrame;
//import view.RoomClientFrame;
/**
 * 前台界面
 * 
 * @author wzg
 */
@SuppressWarnings("serial")
public class QTPanel extends JPanel{
	
	public QTPanel() {
		JPanel jj=this;
		this.setLayout(null);
		this.setSize(210, 640);
		this.setLocation(0, 0);
		this.setBackground(Color.white);
		
		JButton Key = new JButton();
		Key.setFont(new Font("楷体",Font.BOLD,32));
		Key.setSize(195, 65);
		Key.setLocation(7, 90);
		Key.setIcon(new ImageIcon("src/images/房卡激活.png"));
		
		JButton Indent = new JButton();
		Indent.setFont(new Font("楷体",Font.BOLD,32));
		Indent.setSize(195, 65);
		Indent.setLocation(7, 180);
		Indent.setIcon(new ImageIcon("src/images/订单处理.png"));
		
		JButton Client= new JButton();
		Client.setFont(new Font("楷体",Font.BOLD,32));
		Client.setSize(195, 65);
		Client.setLocation(7, 270);
		Client.setIcon(new ImageIcon("src/images/房客信息.png"));
		
		JButton Roomdie = new JButton();
		Roomdie.setFont(new Font("楷体",Font.BOLD,32));
		Roomdie.setSize(195, 65);
		Roomdie.setLocation(7, 360);
		Roomdie.setIcon(new ImageIcon("src/images/房间维护.png"));
		
		JButton Money = new JButton();
		Money.setFont(new Font("楷体",Font.BOLD,32));
		Money.setSize(195, 65);
		Money.setLocation(7, 450);
		Money.setIcon(new ImageIcon("src/images/历史订单.png"));
		
		JButton Exit = new JButton();
		Exit.setFont(new Font("楷体",Font.BOLD,32));
		Exit.setSize(195, 65);
		Exit.setLocation(7, 540);
		Exit.setIcon(new ImageIcon("src/images/退出系统.png"));
		
		this.add(Key);
		this.add(Indent);
		this.add(Client);
		this.add(Roomdie);
		this.add(Money);
		this.add(Exit);
		/**
		 * 房卡激活
		 */
		Key.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				KeyPanel aKeyFrame=new KeyPanel();
				CanvasFrame2.delePanelRight(aKeyFrame);
				return;
			}
		});
		/**
		 * 订单处理
		 */
		Indent.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addRecepIndent();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
		/**
		 * 房客信息
		 */
		Client.addActionListener(new ActionListener() {
			
			public void actionPerformed(final ActionEvent e) {
			RoomClientPanel  aRoomClientFrame =new RoomClientPanel ();
			CanvasFrame2.delePanelRight(aRoomClientFrame );
			

			}
		});
		/**
		 * 房间维护
		 */
		Roomdie.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addRoomMaintain();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
		/**
		 * 历史订单
		 */
		Money.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addHistoryIndent();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
		/**
		 * 退出系统
		 */
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new Denglu();
				CanvasFrame2.deleAllPanelRight();
				CanvasFrame2.jfff.dispose();
				return;
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = null;
		try {
			img = new ImageIcon("src/images/左边有logo.png").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 210,640,null);
		repaint();
	}
}