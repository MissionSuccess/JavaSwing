package org.lanqiao.jdmrg.view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.common.TimeDeal;
import org.lanqiao.jdmrg.dao.RoomerDao;
import org.lanqiao.jdmrg.dao.RoomerViewDao;
import org.lanqiao.jdmrg.view.*;
//import bean.Roomer;
//import view.CanvasFrame;
//import view.RoomClientFrame ;

//import view.CanvasFrame;
//import view.RoomClientFrame;
import org.lanqiao.jdmrg.view.*;
public class AddClient extends JPanel {

	public JPanel pane1 = new JPanel();
	Roomer roomerDao = new Roomer();
	public JButton button1 = new JButton();
	public JButton button2 = new JButton();
	private static String s="标准单人间";
	private static String s2="08:00";
	/**时间格式*/
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public AddClient() {
		JPanel jj=this;
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);
		button1.setSize(200, 50);
		button2.setSize(200, 50);
		button1.setLocation(230, 520);
		button2.setLocation(480, 520);
		button1.setFont(new Font("黑体", Font.BOLD, 20));
		button2.setFont(new Font("黑体", Font.BOLD, 20));
		button1.setIcon(new ImageIcon("src/images/确认.png"));
		button2.setIcon(new ImageIcon("src/images/返回.png"));

		// 标题
		JLabel label1 = new JLabel("添加房客信息");
		label1.setBounds(350, 0, 150, 100);
		label1.setFont(new Font("黑体", Font.BOLD, 24));

		// 添加房客名字
		JLabel name = new JLabel("姓名");
		name.setBounds(50, 90, 90, 50);
		name.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_name = new TextField();
		Canvas_name.setSize(200, 30);
		Canvas_name.setLocation(160, 100);

		// 添加房客联系方式
		JLabel contact = new JLabel("联系方式");
		contact.setBounds(420, 85, 90, 50);
		contact.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_contact = new TextField();
		Canvas_contact.setSize(200, 30);
		Canvas_contact.setLocation(530, 100);

		// 添加房客房间号
		JLabel roomNo = new JLabel("房间号");
		roomNo.setBounds(50, 170, 90, 50);
		roomNo.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_roomNo = new TextField();
		Canvas_roomNo.setSize(200, 30);
		Canvas_roomNo.setLocation(160, 180);

		// 添加房间类型
		JLabel roomType = new JLabel("类型");
		roomType.setBounds(420, 170, 90, 50);
		roomType.setFont(new Font("黑体", Font.BOLD, 20));
		String str1[] = { "标准单人间", "标准双人间", "豪华单人间", "豪华双人间", "三人间", "总统套房" };
		JComboBox<String> jcb = new JComboBox<String>(str1);
		jcb.setSize(200, 30);
		jcb.setLocation(530, 180);
		jcb.setFont(new Font("黑体", Font.BOLD, 24));
		jcb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// System.out.println(e.getItem());
				s = (String) e.getItem();
			}
		});

		// 添加价格
		JLabel roomPrice = new JLabel("价格");
		roomPrice.setBounds(50, 330, 90, 50);
		roomPrice.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_roomPrice = new TextField("￥100");
		Canvas_roomPrice.setSize(200, 30);
		Canvas_roomPrice.setLocation(160, 340);
		Canvas_roomPrice.setEditable(false);

		// 添加入住时间
		JLabel firstTime = new JLabel("入住时间");
		firstTime.setBounds(50, 250, 90, 50);
		firstTime.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_firstTime = new TextField(sdf.format(new Date()));
		Canvas_firstTime.setSize(200, 30);
		Canvas_firstTime.setLocation(160, 260);

		// 添加离开时间
		JLabel lastTime = new JLabel("离开时间");
		lastTime.setBounds(420, 250, 90, 50);
		lastTime.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_lastTime = new TextField(sdf.format(TimeDeal.addAndSubtractDaysByCalendar(new Date(), 1)));
		Canvas_lastTime.setSize(200, 30);
		Canvas_lastTime.setLocation(530, 260);

		// 添加入住天数
		JLabel dayNum = new JLabel("入住天数");
		dayNum.setBounds(420, 330, 90, 50);
		dayNum.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_dayNum = new TextField("1");
		Canvas_dayNum.setSize(200, 30);
		Canvas_dayNum.setLocation(530, 340);
		Canvas_dayNum.setEnabled(false);

		// 添加到店时间
		JLabel inTime = new JLabel("到店时间");
		inTime.setBounds(50, 410, 90, 50);
		inTime.setFont(new Font("黑体", Font.BOLD, 20));
		
		String str2[] = {"08:00", "12:00", "14:00", "18:00", "20:00", "23:59"};
		JComboBox<String> jcb2 = new JComboBox<String>(str2);
		jcb2.setSize(200, 30);
		jcb2.setLocation(160, 410);
		jcb2.setFont(new Font("黑体", Font.BOLD, 24));
		jcb2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// System.out.println(e.getItem());
				s2 = (String) e.getItem();
			}
		});

		// 添加身份证
		JLabel id = new JLabel("身份证号");
		id.setBounds(420, 410, 90, 50);
		id.setFont(new Font("黑体", Font.BOLD, 20));
		TextField Canvas_id = new TextField();
		Canvas_id.setSize(200, 30);
		Canvas_id.setLocation(530, 410);

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
		this.add(jcb);
		this.add(Canvas_roomPrice);
		this.add(Canvas_firstTime);
		this.add(Canvas_lastTime);
		this.add(Canvas_dayNum);
		this.add(jcb2);
		this.add(Canvas_id);

		this.add(button1);
       this.add(button2);
		// *确认按钮/
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 判断名字
				String name = Canvas_name.getText();
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "名字不能为空！", getName(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				char name1[] = name.toCharArray();
				for (int i = 0; i < name1.length; i++) {
					if (Character.isDigit(name1[i])) {
						JOptionPane.showMessageDialog(null, "名字不能包含数字！", getName(), JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				// 判断电话号码
				String contact = Canvas_contact.getText();
				if(!Check.checkphone(contact)) {
					JOptionPane.showMessageDialog(null, "请输入正确的联系方式！", getName(), JOptionPane.ERROR_MESSAGE);
					return;
				}
//				if (contact.length() != 11) {
//					JOptionPane.showMessageDialog(null, "电话号码要为11位", getName(), JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
//				char contac1[] = contact.toCharArray();
//				for (int i = 0; i < contac1.length; i++) {
//					if (!Character.isDigit(contac1[i])) {
//						JOptionPane.showMessageDialog(null, "电话号码要为数字", getName(), JOptionPane.INFORMATION_MESSAGE);
//						return;
//					}
//				}

				// 判断房间号
				
				
				String roomNo = Canvas_roomNo.getText();
				if(!Check.checkroomnum(roomNo)) {
					JOptionPane.showMessageDialog(null, "房间号输入有误！", getName(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				boolean q = new RoomerViewDao().findsimState(roomNo);
				if(q==false) {
					JOptionPane.showMessageDialog(null, "此房间不可用", getName(), JOptionPane.ERROR_MESSAGE);
					return;
				}
//				if (roomNo.length() != 3) {
//					JOptionPane.showMessageDialog(null, "房间号要为3位", getName(), JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
//				char[] roomNO1 = roomNo.toCharArray();
//				for (int i = 0; i < roomNO1.length; i++) {
//					if (!Character.isDigit(roomNO1[i])) {
//						JOptionPane.showMessageDialog(null, "房间号要为数字", getName(), JOptionPane.INFORMATION_MESSAGE);
//						return;
//					}
//				}

				// 判断类型
				String roomType = s;
				if(!new RoomerViewDao().findById(roomNo).getRoomType().equals(s)) {
					JOptionPane.showMessageDialog(null, "房间类型与房号不符", getName(), JOptionPane.ERROR_MESSAGE);
					return;
				}

				// 判断房间价格
//				String roomPrice = Canvas_roomPrice.getText();
//				char[] roomPrice1 = roomPrice.toCharArray();
//				if (roomPrice1.length == 0) {
//					JOptionPane.showMessageDialog(null, "价钱不能为空", getName(), JOptionPane.INFORMATION_MESSAGE);
//					return;
//				}
//				for (int i = 0; i < roomPrice1.length; i++) {
//					if (!Character.isDigit(roomPrice1[i])) {
//						JOptionPane.showMessageDialog(null, "价钱要为数字", getName(), JOptionPane.INFORMATION_MESSAGE);
//						return;
//					}
//				}
				String roomPrice = new RoomerViewDao().findById(roomNo).getRoomType();
				Canvas_roomPrice.setText(roomPrice);
						

				// 判断入住时间
				String firstTime = Canvas_firstTime.getText();

				// 判断离店时间
				String lastTime = Canvas_lastTime.getText();
				
				if(!isRational(firstTime,lastTime)) {
					JOptionPane.showMessageDialog(null, "日期格式不对，请重新输入！","警告",JOptionPane.ERROR_MESSAGE);
					return;
				}

				// 判断住的天数
				long t = 0;
				try {
					t = TimeDeal.dayNum(sdf.parse(firstTime), sdf.parse(lastTime));
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "发生错误，请重新确认！","警告",JOptionPane.ERROR_MESSAGE);
					return ;
				}
				Canvas_dayNum.setText(t+"");
				Integer dayNum = new Integer((int)t);

				// 判断到店时间
				String inTime = s2;

				// 判断身份证
				String id = Canvas_id.getText();
				if(!Check.checkidcard(id)) {
					JOptionPane.showMessageDialog(null, "请输入正确的身份证号!", getName(), JOptionPane.ERROR_MESSAGE);
					return ;
				}

				// 添加住户
				
				Roomer a = new Roomer(RoomerAccount.accountNum,name, contact, roomNo, roomType, roomPrice, firstTime, lastTime, dayNum, inTime,id,"已入住");
				
				
				boolean b = new RoomerDao().add(a);
				boolean c = new RoomerViewDao().update("已入住",a.getRoomNo() );
				
				if(b==true&&c==true) {
					JOptionPane.showMessageDialog(null, "添加成功！", getName(), JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "添加失败！", getName(), JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				RoomClientPanel  aRoomClientFrame =new RoomClientPanel ();
				CanvasFrame2.delePanel(jj, aRoomClientFrame );
				return;
			}
		});

		CanvasFrame.addPanelRight(this);
        repaint();

	}
  
	/**
	 * 判断日期是否合理
	 */
	public boolean isRational(String first,String last) {
		if(!TimeDeal.isValidDate(first)) {
			return false;
		}
		if(!TimeDeal.isValidDate(last)) {
			return false;
		}
		try {
			if(!TimeDeal.isRational(sdf.parse(first),sdf.parse(last))) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
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
