package org.lanqiao.jdmrg.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.util.ArrayList;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.RoomerDao;

/**
 * 房客订单
 * @author 9组
 *
 */
public class RoomerIndent extends JPanel{
	/**列表*/
	private JTable table = null;
	/***/
	private DefaultTableModel model = null;
	/***/
	private JScrollPane js = null;
	/**字体*/
	private Font f = new Font("楷体", Font.PLAIN, 20);
	/**订单信息*/
	private ArrayList<Roomer> rls;
	
	private JPanel thisP;
	
	public RoomerIndent() {
		thisP = this;
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		init();
		
		// 添加画布到窗口画布
//		TestFrame.addPanelRight(this);
//		repaint();
	}
	
	public void init() {
		String[] columNames = new String[] { "订单状态","姓名", "联系方式", "房间号", "到店时间", "" };
		model = new DefaultTableModel(null, columNames);
		
		// 读取文件
		rls = new RoomerDao().findAllById(RoomerAccount.accountNum);
		for (Roomer ro : rls) {
			model.addRow(new  String[] {ro.getRoomerState(),ro.getName(),ro.getContact(),ro.getRoomNo(),ro.getInTime()});
		}
		
		// 设置table属性
		table = new JTable(model) {

			public boolean isCellEditable(int row, int column) {
				switch(column) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:return false;
				}
				return true;
			}
		};
		table.setFont(f);
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(5).setCellEditor(new MyRender());// 设置编辑器
		table.getColumnModel().getColumn(5).setCellRenderer(new MyRender());
		js = new JScrollPane(table);
		js.setBounds(0, 0, 840, 650);
		js.setFont(f);
		js.setViewportView(table);
		add(js);
	}
	
	class MyRender extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {
		private JButton button = null;

		public MyRender() {
			button = new JButton("详情");
			button.setFont(f);
			button.addActionListener(this);
		}

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return button;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			Roomer r = rls.get(row);
			JFrame jf = new JFrame("查询结果");
			jf.setSize(300, 310);
			jf.setLocationRelativeTo(null);
			jf.setAlwaysOnTop(true);
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
			
			JButton jb = new JButton("取消订单");
			jb.setBounds(100, 245, 100, 30);
			if(!("待确认".equals(r.getRoomerState()) || "申请取消".equals(r.getRoomerState()))) {
				jb.setEnabled(false);
			}
			
			jb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					r.setRoomerState("申请取消");
					new RoomerDao().update(r);
					jf.dispose();
					TestFrame.hidePanelRight(thisP, new RoomerIndent());
					TestFrame.deletePanelRight(thisP);
					repaint();
				}
			});
			jf.setResizable(false);
			jf.add(jb);
			jf.add(area);
			jf.setVisible(true);
			return;
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return button;
		}
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


