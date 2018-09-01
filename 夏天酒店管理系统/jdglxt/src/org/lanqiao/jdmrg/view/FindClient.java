package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.view.*;
//import bean.Roomer;
//import dao.UpdateClient;
//import view.CanvasFrame;
//import view.RoomClientFrame;

import org.omg.CORBA.PUBLIC_MEMBER;

public class FindClient extends JPanel {
	Roomer roomerDao = new Roomer();
	public JButton button1 = new JButton();
	public JButton button2 = new JButton();
       
	public FindClient(Roomer roomerDao) {
		JPanel jj = this;
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);
		button1.setSize(200, 50);
		button2.setSize(200, 50);
		button1.setLocation(140, 530);
		button2.setLocation(440, 530);
		button1.setIcon(new ImageIcon("src/images/修改.png"));
		button2.setIcon(new ImageIcon("src/images/返回.png"));


	

		// 1
		JLabel label1 = new JLabel("房客信息");
		label1.setBounds(320, 0, 150, 100);
		label1.setFont(new Font("黑体", Font.BOLD, 28));

		// 2
		JLabel name = new JLabel("姓名");
		name.setBounds(50, 90, 90, 50);
		name.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_name = new JLabel(roomerDao.getName());
		Canvas_name.setSize(200, 50);
		Canvas_name.setLocation(180, 90);
		Canvas_name.setFont(new Font("黑体", Font.BOLD, 24));

		// 3
		JLabel contact = new JLabel("联系方式");
		contact.setBounds(400, 90, 100, 50);
		contact.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_contact = new JLabel(roomerDao.getContact());
		Canvas_contact.setSize(200, 50);
		Canvas_contact.setLocation(550, 90);
		Canvas_contact.setFont(new Font("黑体", Font.BOLD, 24));

		// 4
		JLabel roomNo = new JLabel("房间号");
		roomNo.setBounds(50, 180, 90, 50);
		roomNo.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_roomNo = new JLabel(roomerDao.getRoomNo());
		Canvas_roomNo.setSize(200, 50);
		Canvas_roomNo.setLocation(180, 180);
		Canvas_roomNo.setFont(new Font("黑体", Font.BOLD, 24));

		// 5
		JLabel roomType = new JLabel("类型");
		roomType.setBounds(400, 180, 100, 50);
		roomType.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_roomType = new JLabel(roomerDao.getRoomType());
		Canvas_roomType.setSize(200, 50);
		Canvas_roomType.setLocation(550, 180);
		Canvas_roomType.setFont(new Font("黑体", Font.BOLD, 24));

		// 6
		JLabel roomPrice = new JLabel("价格");
		roomPrice.setBounds(50, 340, 100, 50);
		roomPrice.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_roomPrice = new JLabel("￥"+roomerDao.getRoomPrice());
		Canvas_roomPrice.setSize(200, 50);
		Canvas_roomPrice.setLocation(180, 340);
		Canvas_roomPrice.setFont(new Font("黑体", Font.BOLD, 24));

		// 7 400 250 100 50 120 30 550 260 入住
		JLabel firstTime = new JLabel("入住时间");
		firstTime.setBounds(50, 260, 100, 50);
		firstTime.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_firstTime = new JLabel(roomerDao.getFirstTime());
		Canvas_firstTime.setSize(200, 50);
		Canvas_firstTime.setLocation(180, 260);
		Canvas_firstTime.setFont(new Font("黑体", Font.BOLD, 24));

		// 8
		JLabel lastTime = new JLabel("离开时间");
		lastTime.setBounds(400, 260, 100, 50);
		lastTime.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_lastTime = new JLabel(roomerDao.getLastTime());
		Canvas_lastTime.setSize(200, 50);
		Canvas_lastTime.setLocation(550, 260);
		Canvas_lastTime.setFont(new Font("黑体", Font.BOLD, 24));

		// 9
		JLabel dayNum = new JLabel("入住天数");
		dayNum.setBounds(400, 340, 100, 50);
		dayNum.setFont(new Font("黑体", Font.BOLD, 24));
		String aString = roomerDao.getDayNum().toString();
		JLabel Canvas_dayNum = new JLabel(aString);
		Canvas_dayNum.setSize(200, 50);
		Canvas_dayNum.setLocation(550, 340);
		Canvas_dayNum.setFont(new Font("黑体", Font.BOLD, 24));

		// 10
		JLabel inTime = new JLabel("到店时间");
		inTime.setBounds(50, 410, 100, 50);
		inTime.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_inTime = new JLabel(roomerDao.getInTime());
		Canvas_inTime.setSize(200, 50);
		Canvas_inTime.setLocation(180, 410);
		Canvas_inTime.setFont(new Font("黑体", Font.BOLD, 24));

		// 11
		JLabel id = new JLabel("身份证号");
		id.setBounds(400, 410, 100, 50);
		id.setFont(new Font("黑体", Font.BOLD, 24));
		JLabel Canvas_id = new JLabel(roomerDao.getId());
		Canvas_id.setSize(250, 50);
		Canvas_id.setLocation(550, 410);
		Canvas_id.setFont(new Font("黑体", Font.BOLD, 24));

		this.add(label1);
		this.add(name);
		this.add(contact);
		this.add(roomNo);
		this.add(roomType);
		this.add(roomPrice);
		this.add(firstTime);
		this.add(lastTime);
		this.add(dayNum);
		this.add(inTime);
		this.add(id);

		this.add(Canvas_name);
		this.add(Canvas_contact);
		this.add(Canvas_roomNo);
		this.add(Canvas_roomType);
		this.add(Canvas_roomPrice);
		this.add(Canvas_firstTime);
		this.add(Canvas_lastTime);
		this.add(Canvas_dayNum);
		this.add(Canvas_inTime);
		this.add(Canvas_id);
		this.add(button1);
		this.add(button2);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
//				UpdateClient updateClient = new UpdateClient(roomerDao);
//				CanvasFrame2.delePanel(jj, updateClient);
				UpdateClientInfo updateClientInfo = new UpdateClientInfo(roomerDao);
				CanvasFrame2.delePanel(jj, updateClientInfo);
				return ;
				
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				UpdateRoomerInfo updateRoomerInfo = new UpdateRoomerInfo();
				CanvasFrame2.delePanel(jj, updateRoomerInfo);
				return;
				
			}
		});

//		CanvasFrame.addPanel(this);
//		repaint();
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
