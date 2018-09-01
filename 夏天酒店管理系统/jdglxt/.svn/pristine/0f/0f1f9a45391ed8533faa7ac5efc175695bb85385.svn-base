package org.lanqiao.jdmrg.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame extends JFrame{
	/**左边画布*/
	public static JPanel j1 = new JPanel();
	/**右边画布*/
	public static JPanel j2 = new JPanel();
	
	private static JFrame jff = null;
	public TestFrame() {
//		jff = this;
//		this.setSize(1056, 668);
//		this.setLayout(null);
//		this.setLocationRelativeTo(null);
//		this.setResizable(false);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		j1.setSize(210,640);
//		j2.setSize(840,640);
//		
//		j1.setLayout(null);
//		j2.setLayout(null);
//		
//		j1.setLocation(0, 0);
//		j2.setLocation(210, 0);
////		j2.setLocation(0, 0);
//		
//		j1.setBackground(Color.BLACK);
////		j2.setBackground(Color.yellow);;
//
//		this.add(j1);
//		this.add(j2);
//		
//
//		this.setVisible(true);
		
	}
	
	public static void addPanelLeft(JPanel p) {
		j1.add(p);
		p.repaint();
	}
	
	public static void addPanelRight(JPanel p) {
		j2.add(p);
		p.repaint();
	}
	
	public static void deletePanelRight(JPanel p) {
		j2.remove(p);
		j2.repaint();
	}
	
	public static void hidePanelRight(JPanel p,JPanel p2) {
//		j2.remove(p);
		p.setVisible(false);
		j2.add(p2);
		j2.repaint();
	}
	/**
	 * 订单-入住时间、离开时间、房间类型
	 */
	public void addReserveTimeType() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new ReserveTimeType());
	}
	/**
	 * 订单-查询房间状态
	 */
	public void addQueryRoomState0() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new QueryRoomState0());
	}
	/**
	 * 房客订单
	 */
	public void addRoomerIndent() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new RoomerIndent());
	}
	/**
	 * 前台订单
	 */
	public void addRecepIndent() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new RecepIndent());
	}
	/**
	 * 前台查看房间状态
	 */
	public void addQueryRoomStatePre() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new QueryRoomStatePre());
	}
	/**
	 * 房间维护
	 */
	public void addRoomMaintain() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new RoomMaintain());
	}
	/**
	 * 房间退出
	 */
	public void addRoomExit() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new RoomExit());
	}
	/**
	 * 历史订单
	 */
	public void addHistoryIndent() {
		j2 = new JPanel();
		j2.setSize(840,640);
		j2.setLayout(null);
		j2.setLocation(0, 0);
		addPanelRight(new HistoryIndent());
	}
	
	
	public static void main(String[] args) {
		new TestFrame();
//		addPanelRight(new ReserveTimeType());
//		addPanelRight(new QueryRoomState0());
		addPanelRight(new QueryRoomStatePre());
//		addPanelRight(new RoomerIndent());
//		addPanelRight(new RecepIndent());
//		addPanelRight(new UpdatePwd());
		
	}
}
