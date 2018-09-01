package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.lanqiao.jdmrg.common.Check;
import org.lanqiao.jdmrg.common.RoomerAccount;

/**
 * 预订信息(姓名、联系方式、到店时间)
 * 
 * @author 9组
 *
 */
public class ReserveInfo extends JPanel {

	/**上一级画布*/
	private JPanel superP;
	/**本级画布*/
	private JPanel thisP;
	/***/
	private String[] ss;
	/**时间格式*/
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	private JTextField[] jt = new JTextField[3];
	
	private String timeS = "08:00";
	
	public ReserveInfo(String[] ss, JPanel superP) {
		this.ss = ss;
		thisP = this;
		this.superP = superP;
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		showLabel();
		showText();
		showCombox();
		showButton();
		
		// 添加画布到窗口画布
//		TestFrame.addPanelRight(this);
//		repaint();
	}
	
	private void showLabel() {
		/**订单信息标签*/
		JLabel title = new JLabel();
		/**房号、价格标签*/
		JLabel[] noPrice = new JLabel[2];
		/**姓名、联系方式、到店时间标签*/
		JLabel[] jlb = new JLabel[3];
		
		title.setSize(200,50);
		title.setLocation(345, 10);
		title.setFont(new Font("黑体",Font.BOLD,36));
		title.setText("订房信息");
		this.add(title);
		
		for(int i = 0; i < 2; i++) {
			noPrice[i] = new JLabel();
			noPrice[i].setSize(200, 50);
			noPrice[i].setLocation(150+i*400, 100);
			noPrice[i].setFont(new Font("黑体",Font.BOLD,36));
			this.add(noPrice[i]);
		}
		noPrice[0].setText("房间号:");
		noPrice[1].setText("价格:");
		
		for(int i = 0; i < 3; i++) {
			jlb[i] = new JLabel();
			jlb[i].setSize(200, 50);
			jlb[i].setLocation(150, 200+i*100);
			jlb[i].setFont(new Font("黑体",Font.BOLD,36));
			this.add(jlb[i]);
		}
		jlb[0].setText("姓名");
		jlb[1].setText("联系方式");
		jlb[2].setText("到店时间");
	}
	
	private void showText() {
		//房间号、价格文本框
		JLabel[] jt1 = new JLabel[2];
		for(int i = 0; i < 2; i++) {
			jt1[i] = new JLabel();
			jt1[i].setSize(100, 50);
			jt1[i].setLocation(300+i*350, 100);
			jt1[i].setFont(new Font("黑体",Font.BOLD,36));
			jt1[i].setEnabled(false);
			this.add(jt1[i]);
		}
		jt1[0].setText(ss[3]);
		jt1[1].setText(ss[4]);
		
		//姓名、联系方式、到店时间文本框
		for(int i = 0; i < 2; i++) {
			jt[i] = new JTextField();
			jt[i].setSize(350, 50);
			jt[i].setLocation(350, i*100+200);
			jt[i].setFont(new Font("黑体",Font.BOLD,36));
			this.add(jt[i]);
		}
	}
	
	/**
	 * 到店时间下拉框
	 */
	public void showCombox() {
		String str1[] = {"08:00", "12:00", "14:00", "18:00", "20:00", "23:59"};  
		JComboBox<String> jcb = new JComboBox<String>(str1);  
		jcb.setSize(350, 50);
		jcb.setLocation(350, 400);
		jcb.setFont(new Font("黑体",Font.BOLD,24));
		jcb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
//				System.out.println(e.getItem());
				timeS =  (String) e.getItem();
			}});
		this.validate();
		this.add(jcb);
		this.repaint();
	}
	
	/**
	 * 绘制按钮
	 */
	private void showButton() {
		JButton[] jb = new JButton[2];
		for(int i = 0; i < 2; i++) {
			jb[i] = new JButton();
			jb[i].setSize(200, 50);
			jb[i].setLocation(170+i*320, 530);
			jb[i].setFont(new Font("黑体",Font.BOLD,24));
			this.add(jb[i]);
		}
		jb[0].setIcon(new ImageIcon("src/images/确认.png"));
		jb[1].setIcon(new ImageIcon("src/images/返回.png"));
		
		jb[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = jt[1].getText();
				if(0 == jt[0].getText().length()) {
					JOptionPane.showMessageDialog(null, "姓名不为空！", "提示", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				if(!Check.checkphone(s)) {
					JOptionPane.showMessageDialog(null, "联系方式不合法，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				ss[5] = jt[0].getText();
				ss[6] = jt[1].getText();
				ss[7] = timeS;
				TestFrame.hidePanelRight(thisP, new ReservePay(ss,thisP));
			}
		});
		
		jb[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestFrame.deletePanelRight(thisP);
				superP.setVisible(true);
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
