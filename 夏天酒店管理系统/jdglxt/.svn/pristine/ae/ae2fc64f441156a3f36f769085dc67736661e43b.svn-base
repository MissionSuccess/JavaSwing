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
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.view.*;

//import bean.Roomer;
//import dao.AddClient;
//import dao.FindClient;
//import dao.UpdateClient;
//import view.CanvasFrame;
/**
 * 房客信息（前台界面）
 * 
 * @author wzg
 */

@SuppressWarnings("serial")
public class RoomClientPanel extends JPanel {

	public RoomClientPanel() {
		JPanel jj = this;
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);
		this.setBackground(Color.white);

		JButton Show_allroom = new JButton();
		Show_allroom.setFont(new Font("楷体", Font.BOLD, 32));
		Show_allroom.setSize(300, 65);
		Show_allroom.setLocation(280, 100);
		Show_allroom.setIcon(new ImageIcon("src/images/显示房间状态.png"));

		JButton Add_roomClient = new JButton();
		Add_roomClient.setFont(new Font("楷体", Font.BOLD, 32));
		Add_roomClient.setSize(300, 65);
		Add_roomClient.setLocation(280, 200);
		Add_roomClient.setIcon(new ImageIcon("src/images/增加房客.png"));

		JButton Update_roomClient = new JButton();
		Update_roomClient.setFont(new Font("楷体", Font.BOLD, 32));
		Update_roomClient.setSize(300, 65);
		Update_roomClient.setLocation(280, 300);
		Update_roomClient.setIcon(new ImageIcon("src/images/修改房客信息.png"));

		JButton Exitroom = new JButton();
		Exitroom.setFont(new Font("楷体", Font.BOLD, 32));
		Exitroom.setSize(300, 65);
		Exitroom.setLocation(280, 400);
		Exitroom.setIcon(new ImageIcon("src/images/退房.png"));
		
		this.add(Show_allroom);
		this.add(Add_roomClient);
		this.add(Update_roomClient);
		this.add(Exitroom);
		/**
		 * 显示房间状态
		 */
		Show_allroom.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addQueryRoomStatePre();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
		/**
		 * 添加房客
		 */
		Add_roomClient.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				AddClient a = new AddClient();
				CanvasFrame2.delePanel(jj, a);
				return;
			}
		});
		/**
		 * 修改客房信息
		 */
		Update_roomClient.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// FindClient bClient=new FindClient(new Roomer(" ","", "", "", "", "","", "",
				// 1,"","",""));
				QTFindRoomNo qtFindRoomNo = new QTFindRoomNo();
				CanvasFrame2.delePanel(jj, qtFindRoomNo);
				return;
			}
		});
		/**
		 * 退房
		 */
		Exitroom.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				new TestFrame().addRoomExit();
				CanvasFrame2.delePanelRight(TestFrame.j2);
				return;
			}
		});
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
