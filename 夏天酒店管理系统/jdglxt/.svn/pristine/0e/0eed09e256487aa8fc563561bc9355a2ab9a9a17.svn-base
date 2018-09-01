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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import org.lanqiao.jdmrg.bean.Room;
import org.lanqiao.jdmrg.bean.Roomer;
import org.lanqiao.jdmrg.common.RoomerAccount;
import org.lanqiao.jdmrg.dao.RoomerDao;
import org.lanqiao.jdmrg.dao.RoomerViewDao;

/**
 * 前台订单处理
 * 
 * @author 9组
 *
 */
public class RecepIndent extends JPanel {
	/** 列表 */
	private JTable table = null;
	/***/
	private DefaultTableModel model = null;
	/***/
	private JScrollPane js = null;
	/** 字体 */
	private Font f = new Font("楷体", Font.PLAIN, 20);
	/** 订单信息 */
	private ArrayList<Roomer> rls;
	/** 当前画布 */
	private JPanel thisP;

	private RoomerViewDao rvdao = new RoomerViewDao();
	
	private ArrayList<Roomer> selectRooer = new ArrayList<Roomer>();

	public RecepIndent() {
		this.thisP = this;
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);

		// 调用方法
		init();

		// 添加画布到窗口画布
		// TestFrame.addPanelRight(this);
		// repaint();
	}

	public void init() {
		String[] columNames = new String[] { "订单状态", "客户", "姓名", "联系方式", "房间号", "到店时间", "" };
		model = new DefaultTableModel(null, columNames);

		// 读取文件
		rls = new RoomerDao().findAll();
		for (Roomer ro : rls) {
			if(ro.getRoomerState().equals("待确认") || ro.getRoomerState().equals("申请取消")) {
				model.addRow(new String[] { ro.getRoomerState(), ro.getAccountNum(), ro.getName(), ro.getContact(),
						ro.getRoomNo(), ro.getInTime() });
				selectRooer.add(ro);
			}
		}

		// 设置table属性
		table = new JTable(model) {

			public boolean isCellEditable(int row, int column) {
				switch (column) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
					return false;
				}
				return true;
			}
		};
		table.setFont(f);
		table.setRowHeight(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(columNames.length - 1).setCellEditor(new MyRender());// 设置编辑器
		table.getColumnModel().getColumn(columNames.length - 1).setCellRenderer(new MyRender());
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
			Roomer r = selectRooer.get(row);
			JFrame jf = new JFrame("查询结果");
			jf.setSize(300, 310);
			jf.setLocationRelativeTo(null);
//			jf.setAlwaysOnTop(true);
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
			jb[0].setText("同意");
			jb[1].setText("拒绝");
			
			if(!("待确认".equals(r.getRoomerState()) || "申请取消".equals(r.getRoomerState()))) {
				jb[0].setEnabled(false);
				jb[1].setEnabled(false);
			}
			
			jb[0].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Room rr = rvdao.findById(r.getRoomNo());
					
					if ("已预订".equals(rr.getRoomState()) && "申请取消".equals(r.getRoomerState())) {
						r.setRoomerState("取消成功");
						rvdao.update("可预订", r.getRoomNo());
						new RoomerDao().update(r);
						jf.dispose();
						TestFrame.hidePanelRight(thisP, new RecepIndent());
						TestFrame.deletePanelRight(thisP);
						repaint();
						return ;
					} else if("申请取消".equals(r.getRoomerState())){
						r.setRoomerState("取消成功");
						new RoomerDao().update(r);
						jf.dispose();
						TestFrame.hidePanelRight(thisP, new RecepIndent());
						TestFrame.deletePanelRight(thisP);
						repaint();
						return ;
					}
					
					if ("可预订".equals(rr.getRoomState()) && "待确认".equals(r.getRoomerState())) {
						r.setRoomerState("预订成功");
						rvdao.update("已预订", r.getRoomNo());
						new RoomerDao().update(r);
						jf.dispose();
						TestFrame.hidePanelRight(thisP, new RecepIndent());
						TestFrame.deletePanelRight(thisP);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null, "该房间不可预约！", "提示", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});

			jb[1].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if("申请取消".equals(r.getRoomerState())){
						r.setRoomerState("取消失败");
						new RoomerDao().update(r);
						jf.dispose();
						TestFrame.hidePanelRight(thisP, new RecepIndent());
						TestFrame.deletePanelRight(thisP);
						repaint();
					}
					
					if ("待确认".equals(r.getRoomerState())) {
						r.setRoomerState("预订失败");
						new RoomerDao().update(r);
						jf.dispose();
						TestFrame.hidePanelRight(thisP, new RecepIndent());
						TestFrame.deletePanelRight(thisP);
						repaint();
					} 
					
				}
			});

			jf.setResizable(false);
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
