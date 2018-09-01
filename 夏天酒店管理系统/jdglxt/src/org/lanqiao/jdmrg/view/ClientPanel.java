package org.lanqiao.jdmrg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.bean.Client;
import org.lanqiao.jdmrg.common.RoomerAccount;
//import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.ClientDao;
import org.lanqiao.jdmrg.view.*;

//import view.RoomClientFrame;
/**
 * 客户界面
 * 
 * @author wzg
 */
@SuppressWarnings("serial")
public class ClientPanel extends JPanel {

	private JPanel thisP;

	public ClientPanel() {
		thisP = this;
		this.setLayout(null);
		this.setSize(210, 640);
		this.setLocation(0, 0);
		this.setBackground(Color.white);

		JButton Information = new JButton();
		Information.setFont(new Font("楷体", Font.BOLD, 32));
		Information.setSize(195, 65);
		Information.setLocation(7, 90);
		Information.setIcon(new ImageIcon("src/images/个人信息.png"));

		JButton Update_pwd = new JButton();
		Update_pwd.setFont(new Font("楷体", Font.BOLD, 32));
		Update_pwd.setSize(195, 65);
		Update_pwd.setLocation(7, 165);
		Update_pwd.setIcon(new ImageIcon("src/images/修改密码.png"));

		JButton Findroom = new JButton();
		Findroom.setFont(new Font("楷体", Font.BOLD, 32));
		Findroom.setSize(195, 65);
		Findroom.setLocation(7, 240);
		Findroom.setIcon(new ImageIcon("src/images/查询房间.png"));

		JButton Selectroom = new JButton();
		Selectroom.setFont(new Font("楷体", Font.BOLD, 32));
		Selectroom.setSize(195, 65);
		Selectroom.setLocation(7, 315);
		Selectroom.setIcon(new ImageIcon("src/images/预订房间.png"));

		JButton Myindent = new JButton();
		Myindent.setFont(new Font("楷体", Font.BOLD, 32));
		Myindent.setSize(195, 65);
		Myindent.setLocation(7, 390);
		Myindent.setIcon(new ImageIcon("src/images/我的订单.png"));
		
		JButton Contact_KF = new JButton();
		Contact_KF.setFont(new Font("楷体", Font.BOLD, 32));
		Contact_KF.setSize(195, 65);
		Contact_KF.setLocation(7, 465);
		Contact_KF.setIcon(new ImageIcon("src/images/联系客服.png"));
		
		JButton Exit = new JButton();
		Exit.setFont(new Font("楷体", Font.BOLD, 32));
		Exit.setSize(195, 65);
		Exit.setLocation(7, 540);
		Exit.setIcon(new ImageIcon("src/images/退出系统.png"));

		this.add(Information);
		this.add(Update_pwd);
		this.add(Findroom);
		this.add(Selectroom);
		this.add(Myindent);
		this.add(Contact_KF);
		this.add(Exit);
		/**
		 * 个人信息
		 */
		Information.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				InformationPanel aInformationFrame = new InformationPanel();
				CanvasFrame2.delePanelRight(aInformationFrame);
				return;
			}
		});
		/**
		 * 修改密码
		 */
		Update_pwd.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				UpdatePwd updatePwd = new UpdatePwd();
				CanvasFrame2.delePanelRight(updatePwd);
				return;
			}
		});
		/**
		 * 查询房间
		 */
		Findroom.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addQueryRoomState0();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
		/**
		 * 预定房间
		 */
		Selectroom.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addReserveTimeType();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});

		/**
		 * 订单处理
		 */
		Myindent.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addRoomerIndent();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
		/**
		 * 联系客服
		 */
		Contact_KF.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				Contact_KFpanel contact_KFpanel = new Contact_KFpanel();
				CanvasFrame2.delePanelRight(contact_KFpanel);
				return;
			}
		});
		/**
		 * 退出登录
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
		g.drawImage(img, 0, 0, 210, 640, null);
		repaint();
	}
}