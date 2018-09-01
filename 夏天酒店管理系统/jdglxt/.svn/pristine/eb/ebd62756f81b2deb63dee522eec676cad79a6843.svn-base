package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.RoomerDao;

public class QTFindRoomNo extends JPanel {

	public JPanel pane1 = new JPanel();
	Roomer roomerDao = new Roomer();
	public JButton button1 = new JButton("确定");
	public JButton button2 = new JButton("返回");

	public QTFindRoomNo() {

		JPanel jj = this;
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);
		button1.setSize(100, 50);
		button2.setSize(100, 50);
		button1.setLocation(250, 520);
		button2.setLocation(380, 520);
		button1.setFont(new Font("黑体", Font.BOLD, 20));
		button2.setFont(new Font("黑体", Font.BOLD, 20));

		JLabel FindNo = new JLabel("请输入房间号");
		FindNo.setBounds(50, 90, 200, 50);
		FindNo.setFont(new Font("黑体", Font.BOLD, 20));
		TextField FindNo1 = new TextField();
		FindNo1.setSize(200, 30);
		FindNo1.setLocation(300, 100);

		this.add(FindNo);
		this.add(FindNo1);
		this.add(button1);
		this.add(button2);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String FindNo2 = FindNo1.getText();
				Roomer roomer = new RoomerDao().findById(FindNo2, "已入住");

				if (roomer == null) {
					JOptionPane.showMessageDialog(null, "此房间没人住", getName(), JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				char contac1[] = FindNo2.toCharArray();
				for (int i = 0; i < contac1.length; i++) {
					if (!Character.isDigit(contac1[i])) {
						JOptionPane.showMessageDialog(null, "房间号要为数字", getName(), JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}

				FindClient aRoomClientFrame = new FindClient(roomer);
				CanvasFrame2.delePanel(jj, aRoomClientFrame);
				return;
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

				RoomClientPanel aRoomClientFrame = new RoomClientPanel();
				CanvasFrame2.delePanel(jj, aRoomClientFrame);
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
		g.drawImage(img, 0, 0, 840, 640, null);
		repaint();
	}

}
