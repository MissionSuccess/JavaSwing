package org.lanqiao.jdmrg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.lanqiao.jdmrg.bean.Room;
import org.lanqiao.jdmrg.bean.RoomBtn;
import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.common.TimeDeal;
import org.lanqiao.jdmrg.dao.RoomerDao;
import org.lanqiao.jdmrg.dao.RoomerViewDao;


/**
 * 选择要修改的房客信息
 * @author 9组
 *
 */
public class UpdateRoomerInfo extends JPanel implements MouseListener{
	/**房间楼层*/
	private int row = 6;
	/**单层房间个数*/
	private int col = 8;
	/**按钮宽度*/
	private int btnWidth = 105;
	/**按钮高度*/
	private int btnHeight = 80;
	
	private String[] ss;
	/**本级画布*/
	private JPanel thisP;
	
	private RoomerViewDao rvdao = new RoomerViewDao();
	/**房间按钮*/
	private RoomBtn[][] rb = new RoomBtn[row][col];
	/**字体格式*/
	private Font f = new Font("楷体", Font.PLAIN, 20);
	/** 时间格式 */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	public UpdateRoomerInfo() {
		this.thisP = this;
		//设置画布属性
		this.setLayout(null);
		this.setSize(840,640);
		this.setLocation(0, 0);
		
		//调用方法
		showRoomBnt();
		showGraLabel();
		showTime();
		showBnt();
		setBtn();
		
		//添加画布到窗口画布
//		TestFrame.addPanelRight(this);
//		repaint();
	}
	
	/**
	 * 绘制房间按钮
	 */
	int[][] pri = rvdao.findPriceByNum();
	String[][] state = rvdao.findAllState();
	String[][] type = rvdao.findAllType();
	public void showRoomBnt() {
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++){
				rb[j][i] = new RoomBtn(i*btnWidth, j*btnHeight, ""+(j+1)+"0"+(i+1),"可预订");
				this.add(rb[j][i]);
				//设置房间价格
				rb[j][i].setText(""+(j+1)+"0"+(i+1));
				rb[j][i].setRoomPrice( pri[j+1][i+1]);
				rb[j][i].setRoomState(state[j+1][i+1]);
				rb[j][i].addMouseListener(this);
			}
		}
	}
	
	/**
	 * 绘制图示标签
	 */
	public void showGraLabel() {
		JLabel[] mark = new JLabel[8];
		for(int i = 0; i < 4; i++) {
			mark[i] = new JLabel();
			mark[i].setSize(70, 30);
			mark[i].setLocation(50+i*2*btnWidth, 500);
			mark[i].setOpaque(true);
			this.add(mark[i]);
		}
		mark[0].setBackground(Color.GREEN);
		mark[1].setBackground(Color.ORANGE);
		mark[2].setBackground(Color.RED);
		mark[3].setBackground(Color.GRAY);
		
		for(int i = 4 ; i < 8; i++) {
			mark[i] = new JLabel();
			mark[i].setSize(70, 30);
			mark[i].setLocation(130+(i-4)*2*btnWidth, 500);
			mark[i].setFont(new Font("黑体", Font.BOLD, 16));
			this.add(mark[i]);
		}
		mark[4].setText("可预订");
		mark[5].setText("已预订");
		mark[6].setText("已入住");
		mark[7].setText("维护中");
	}
	
	/**
	 * 绘制日期
	 */
	public void showTime() {
		//备注当前功能
		JLabel func = new JLabel("修改房客信息");
		func.setSize(300, 50);
		func.setLocation(50, 550);
		func.setFont(new Font("黑体", Font.BOLD, 20));
		this.add(func);
		
		// JLabel
		JLabel jlb = new JLabel("当前时间段：");
		JLabel jlb1 = new JLabel(sdf.format(new Date()) + "-" + sdf.format(TimeDeal.addAndSubtractDaysByGetTime(new Date(), 1)));

		jlb.setSize(150, 50);
		jlb1.setSize(300, 50);
		
		jlb.setLocation(50, 580);
		jlb1.setLocation(180, 580);
		
		jlb.setFont(new Font("黑体", Font.BOLD, 20));
		jlb1.setFont(new Font("黑体", Font.BOLD, 20));
		
		this.add(jlb);
		this.add(jlb1);
	}
	
	
	/**
	 * 绘制返回按钮
	 */
	public void showBnt() {
		JButton jb = new JButton();
		jb.setSize(200, 50);
		
		jb.setLocation(505, 562);
		
		jb.setFont(new Font("黑体", Font.BOLD, 20));
		jb.setIcon(new ImageIcon("src/images/返回.png"));
		
		this.add(jb);
		
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RoomClientPanel aRoomClientFrame = new RoomClientPanel();
				CanvasFrame2.delePanel(thisP, aRoomClientFrame);
				return;
			}
		});
	}
	
	/**重画按钮*/
	public void setBtn() {
		for(int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++){
				switch(rb[j][i].getRoomState()) {
				case "可预订":
					rb[j][i].setBackground(Color.GREEN);
					break;
				case "已预订":
					rb[j][i].setBackground(Color.ORANGE);
					break;
				case "已入住":
					rb[j][i].setBackground(Color.RED);
					break;
				case "维护中":
					rb[j][i].setBackground(Color.GRAY);
					break;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		RoomBtn rb = (RoomBtn)e.getSource();
		if("已预订".equals(rb.getRoomState())) {
			Roomer r = new RoomerDao().findById(rb.getRoomNo(), "预订成功");
			JFrame jf = new JFrame("查询结果");
			jf.setSize(300, 310);
			jf.setLocationRelativeTo(null);
			JTextArea area = new JTextArea();
			area.setFont(f);
			area.append("入住人姓名：" + r.getName() + "\n");
			area.append("联系方式：" + r.getContact() + "\n");
			area.append("房间号：" + r.getRoomNo() + "\n");
			area.append("类型：" + r.getRoomType() + "\n");
			area.append("价格：" + "￥"+r.getRoomPrice() + "\n");
			area.append("入住时间：" + r.getFirstTime() + "\n");
			area.append("离开时间:" + r.getLastTime() + "\n");
			area.append("入住天数:" + r.getDayNum() + "\n");
			area.append("到店时间:" + r.getInTime() + "\n");
			area.append("订单状态:" + r.getRoomerState() + "\n");
			area.setEditable(false);
			area.setBackground(null);

			JButton[] jb = new JButton[2];
			for (int i = 0; i < jb.length; i++) {
				jb[i] = new JButton();
				jb[i].setSize(80, 30);
				jb[i].setLocation(50 + i * 100, 245);
				jb[i].setFont(f);
				jf.add(jb[i]);
			}
			jb[0].setText("修改");
			jb[1].setText("返回");
			
			jb[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
					FindClient aRoomClientFrame = new FindClient(r);
					CanvasFrame2.delePanel(thisP, aRoomClientFrame);
					return;
				}
			});
			
			jb[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
				}
			});
			
			
			jf.setResizable(false);
			jf.add(area);
			jf.setVisible(true);
		}else if("已入住".equals(rb.getRoomState())) {
			Roomer r = new RoomerDao().findById(rb.getRoomNo(), "已入住");
			JFrame jf = new JFrame("查询结果");
			jf.setSize(300, 310);
			jf.setLocationRelativeTo(null);
			JTextArea area = new JTextArea();
			area.setFont(f);
			area.append("入住人姓名：" + r.getName() + "\n");
			area.append("联系方式：" + r.getContact() + "\n");
			area.append("房间号：" + r.getRoomNo() + "\n");
			area.append("类型：" + r.getRoomType() + "\n");
			area.append("价格：" + "￥"+r.getRoomPrice() + "\n");
			area.append("入住时间：" + r.getFirstTime() + "\n");
			area.append("离开时间:" + r.getLastTime() + "\n");
			area.append("入住天数:" + r.getDayNum() + "\n");
			area.append("到店时间:" + r.getInTime() + "\n");
			area.append("订单状态:" + r.getRoomerState() + "\n");
			area.setEditable(false);
			area.setBackground(null);

			JButton[] jb = new JButton[2];
			for (int i = 0; i < jb.length; i++) {
				jb[i] = new JButton();
				jb[i].setSize(80, 30);
				jb[i].setLocation(50 + i * 100, 245);
				jb[i].setFont(f);
				jf.add(jb[i]);
			}
			jb[0].setText("修改");
			jb[1].setText("返回");
			
			jb[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
					FindClient aRoomClientFrame = new FindClient(r);
					CanvasFrame2.delePanel(thisP, aRoomClientFrame);
					return;
				}
			});
			
			jb[1].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
				}
			});
			
			
			jf.setResizable(false);
			jf.add(area);
			jf.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "该房间没有信息需要修改！","提示",JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
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
