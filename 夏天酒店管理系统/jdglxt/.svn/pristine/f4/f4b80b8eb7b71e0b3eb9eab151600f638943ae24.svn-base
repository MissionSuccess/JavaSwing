package org.lanqiao.jdmrg.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.bean.RoomBtn;
import org.lanqiao.jdmrg.common.TimeDeal;
import org.lanqiao.jdmrg.dao.RoomerViewDao;

/**
 * 查询房间状态
 * 
 * @author 9组
 *
 */
public class QueryRoomState0 extends JPanel implements MouseListener{
	/** 房间楼层 */
	private int row = 6;
	/** 单层房间个数 */
	private int col = 8;
	/** 按钮宽度 */
	private int btnWidth = 105;
	/** 按钮高度 */
	private int btnHeight = 80;
	/** 房间按钮组 */
	private RoomBtn[][] rb = new RoomBtn[row][col];
	/** 时间格式 */
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	private RoomerViewDao rvdao = new RoomerViewDao();
	

	public QueryRoomState0() {
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		showRoomBnt();
		showGraLabel();
		showTime();
		setBtn();

		// 添加画布到窗口画布
		// TestFrame.addPanelRight(this);
		// repaint();
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
		for (int i = 0; i < 4; i++) {
			mark[i] = new JLabel();
			mark[i].setSize(70, 30);
			mark[i].setLocation(50 + i * 2 * btnWidth, 500);
			mark[i].setOpaque(true);
			this.add(mark[i]);
		}
		mark[0].setBackground(Color.GREEN);
		mark[1].setBackground(Color.ORANGE);
		mark[2].setBackground(Color.RED);
		mark[3].setBackground(Color.GRAY);

		for (int i = 4; i < 8; i++) {
			mark[i] = new JLabel();
			mark[i].setSize(70, 30);
			mark[i].setLocation(130 + (i - 4) * 2 * btnWidth, 500);
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
		// JLabel
		JLabel jlb = new JLabel("预订时间段：");
		JLabel jlb1 = new JLabel(sdf.format(new Date()) + "-" + sdf.format(TimeDeal.addAndSubtractDaysByGetTime(new Date(), 1)));

		jlb.setSize(150, 50);
		jlb1.setSize(300, 50);

		jlb.setLocation(250, 570);
		jlb1.setLocation(400, 570);

		jlb.setFont(new Font("黑体", Font.BOLD, 20));
		jlb1.setFont(new Font("黑体", Font.BOLD, 20));

		this.add(jlb);
		this.add(jlb1);
	}

	/** 重画按钮 */
	public void setBtn() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				switch (rb[j][i].getRoomState()) {
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
		JOptionPane.showMessageDialog(null, "订房请转至预订房间！", "提示", JOptionPane.ERROR_MESSAGE);
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
}
