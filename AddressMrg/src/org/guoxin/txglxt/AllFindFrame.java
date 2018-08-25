package org.guoxin.txglxt;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * 查找全部窗口
 * 
 * @author GuoXin
 *
 */
public class AllFindFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 画布 */
	private JPanel jp = new JPanel();
	/** 读 */
	private BufferedReader in = null;
	/** 用户名 */
	private String nameStr = null;
	/***/
	private JTable table = null;
	/***/
	private DefaultTableModel model = null;
	/***/
	private JScrollPane js = null;

	public AllFindFrame(JFrame jf, String str) {
		nameStr = str;
		this.setTitle("通讯管理系统(" + str + ")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);
		String[] columNames = new String[] { "姓名", "手机号", "" };
		model = new DefaultTableModel(null, columNames);
		// 读取文件
		try {
			in = new BufferedReader(new FileReader("C://AddressMrgData//data//" + nameStr + ".txt"));
			String s;
			while ((s = in.readLine()) != null) {
				model.addRow(new String[] { s, in.readLine() });
				for (int i = 1; i <= 5; i++) {
					s = in.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 设置table属性
		table = new JTable(model) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column == 0 || column == 1) {
					return false;
				}
				return true;
			}
		};
		table.setRowHeight(20);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getColumnModel().getColumn(2).setCellEditor(new MyRender(str));// 设置编辑器
		table.getColumnModel().getColumn(2).setCellRenderer(new MyRender(str));
		js = new JScrollPane(table);
		this.add(js);
		// 设置关闭监听
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				jf.setVisible(true);
			}
		});
		this.setVisible(true);
	}

	class MyRender extends AbstractCellEditor implements TableCellRenderer, ActionListener, TableCellEditor {
		private static final long serialVersionUID = 1L;
		private JButton button = null;
		/** 读 */
		private BufferedReader in = null;
		private String nameStr;

		public MyRender(String str) {
			nameStr = str;
			button = new JButton("详情");
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
			String aim = table.getValueAt(row, 0).toString();
			try {
				in = new BufferedReader(new FileReader("C://AddressMrgData//data//" + nameStr + ".txt"));
				String s;
				while ((s = in.readLine()) != null) {
					if (aim.equals(s)) {
						JFrame jf = new JFrame("查询结果");
						jf.setSize(250, 165);
						jf.setLocationRelativeTo(null);
						jf.setAlwaysOnTop(true);
						JTextArea area = new JTextArea();
						area.append("姓名：" + s + "\n");
						area.append("手机：" + in.readLine() + "\n");
						area.append("电话：" + in.readLine() + "\n");
						area.append("E-mail：" + in.readLine() + "\n");
						area.append("QQ：" + in.readLine() + "\n");
						area.append("工作：" + in.readLine() + "\n");
						area.append("地址:" + in.readLine() + "\n");
						area.setEditable(false);
						area.setBackground(null);
						jf.add(area);
						jf.setVisible(true);
						return;
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return button;
		}

	}
}