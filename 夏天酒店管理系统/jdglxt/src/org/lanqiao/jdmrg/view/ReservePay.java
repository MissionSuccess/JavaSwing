package org.lanqiao.jdmrg.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.common.TimeDeal;
import org.lanqiao.jdmrg.dao.RoomerDao;

/**
 * 订单支付
 * @author 9组
 *
 */
public class ReservePay extends JPanel{
	
	/**上一级画布*/
	private JPanel superP;
	/**本级画布*/
	private JPanel thisP;
	/***/
	private String[] ss;
	
	public ReservePay(String[] ss, JPanel superP) {
		this.thisP = this;
		this.superP = superP;
		this.ss = ss;
		
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		showTileLabel();
		showButton();
		showPriceLabel();
		
		// 添加画布到窗口画布
//		TestFrame.addPanelRight(this);
//		repaint();
	}
	
	/**
	 * 绘制标题
	 */
	private void showTileLabel() {
		/**订单信息标签*/
		JLabel title = new JLabel();
		/**房号、价格标签*/
		JLabel[] noPrice = new JLabel[2];
		/**姓名、联系方式、到店时间标签*/
		JLabel[] jlb = new JLabel[3];
		
		title.setSize(200,50);
		title.setLocation(345, 10);
		title.setFont(new Font("黑体",Font.BOLD,36));
		title.setText("支付金额");
		this.add(title);
	}
	
	/**
	 * 绘制价格标签
	 */
	private void showPriceLabel(){
		JLabel title = new JLabel();
		title.setSize(200,50);
		title.setLocation(360, 430);
		title.setFont(new Font("黑体",Font.BOLD,36));
		title.setText("￥"+ss[4]);
		this.add(title);
	}
	
	/**
	 * 绘制二维码
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image imgLeft = null;
		Image imgRight = null;
		try {
			imgLeft = new ImageIcon("src/images/二维码.png").getImage();
			imgRight = new ImageIcon("src/images/二维码.png").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(imgLeft, 100, 100, 300, 300,null);
		g.drawImage(imgLeft, 440, 100, 300, 300,null);
		repaint();
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
		jb[0].setIcon(new ImageIcon("src/images/已支付.png"));
		jb[1].setIcon(new ImageIcon("src/images/返回.png"));
		
		jb[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ss变量表示：0、入住时间；1、离开时间；2、房型；3、房号；4、价格
				//5、姓名；6、联系方式；7、到店时间；
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				long t = 0;
				try {
					t = TimeDeal.dayNum(sdf.parse(ss[0]), sdf.parse(ss[1]));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Roomer r = new Roomer(RoomerAccount.accountNum,ss[5],ss[6],ss[3],ss[2],ss[4],ss[0],ss[1],(int)t,ss[7],null,"待确认");
				
				if(!new RoomerDao().isRe(r)) {
					new RoomerDao().add(r);
					JOptionPane.showMessageDialog(null, "下单完成！");
				}else {
					JOptionPane.showMessageDialog(null, "下单失败，订单已存在！", "提示", JOptionPane.ERROR_MESSAGE);
				}
				TestFrame.hidePanelRight(thisP, new RoomerIndent());
				TestFrame.deletePanelRight(thisP);
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
