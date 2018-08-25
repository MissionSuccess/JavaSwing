package org.guoxin.txglxt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 删除联系人窗口
 * 
 * @author GuoXin
 */
public class DelectFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 画布 */
	private JPanel jp = new JPanel();
	/** 标题1标签 */
	private JLabel label1 = new JLabel("删除");
	/** 标题2标签 */
	private JLabel label2 = new JLabel("联系人");
	/** 信息标签 */
	private JLabel[] info = new JLabel[7];
	/** 信息文本 */
	private JTextField[] text = new JTextField[7];
	/** 确定按钮 */
	private JButton b1 = new JButton("确定");
	/** 返回按钮 */
	private JButton b2 = new JButton("返回");
	/** 字体 */
	private Font f = new Font("黑体", Font.BOLD, 14);
	/** 文本框高度 */
	private int hight = 25;
	/** 读 */
	private BufferedReader in = null;
	/** 写 */
	private BufferedWriter out = null;
	/** 用户名 */
	private String nameStr = null;

	public DelectFrame(JFrame jf, String str) {
		nameStr = str;
		this.setTitle("通讯管理系统(" + str + ")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);

		// 标题
		label1.setFont(new Font("楷体", Font.BOLD, 24));
		label1.setBounds(35, 30, 200, 50);
		label2.setFont(new Font("楷体", Font.BOLD, 24));
		label2.setBounds(20, 60, 200, 50);
		// 姓名
		info[0] = new JLabel("姓名");
		text[0] = new JTextField("请输入需要删除的用户姓名");
		info[0].setFont(f);
		info[0].setBounds(120, 20, 50, hight);
		text[0].setBounds(175, 20, 160, hight);
		// 手机号
		info[1] = new JLabel("手机号");
		text[1] = new JTextField("");
		info[1].setFont(f);
		info[1].setBounds(120, 55, 50, hight);
		text[1].setBounds(175, 55, 160, hight);
		// 固定电话
		info[2] = new JLabel("电话");
		text[2] = new JTextField("");
		info[2].setFont(f);
		info[2].setBounds(120, 90, 50, hight);
		text[2].setBounds(175, 90, 160, hight);
		// E-mail
		info[3] = new JLabel("E-mail");
		text[3] = new JTextField("");
		info[3].setFont(f);
		info[3].setBounds(120, 125, 50, hight);
		text[3].setBounds(175, 125, 160, hight);
		// QQ
		info[4] = new JLabel("QQ");
		text[4] = new JTextField("");
		info[4].setFont(f);
		info[4].setBounds(120, 160, 50, hight);
		text[4].setBounds(175, 160, 160, hight);
		// 工作
		info[5] = new JLabel("工作");
		text[5] = new JTextField("");
		info[5].setFont(f);
		info[5].setBounds(120, 195, 50, hight);
		text[5].setBounds(175, 195, 160, hight);
		// 通讯地址
		info[6] = new JLabel("地址");
		text[6] = new JTextField("");
		info[6].setFont(f);
		info[6].setBounds(120, 230, 50, hight);
		text[6].setBounds(175, 230, 160, hight);

		// 确定按钮
		b1.setFont(f);
		b1.setBounds(20, 150, 80, 40);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodB1(jf);
			}
		});
		b1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodB1(jf);
				}
			}
		});
		// 返回按钮
		b2.setFont(f);
		b2.setBounds(20, 200, 80, 40);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodB2(jf);
			}
		});
		// 加入键盘监听
		for (int i = 0; i < 7; i++) {
			text[i].addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER && text[0].getText().equals("请输入需要删除的用户姓名")) {
						text[0].setText("");
						text[0].requestFocus();
					}
					if (e.getKeyChar() == KeyEvent.VK_ENTER) {
						methodB1(jf);
					}
				}
			});
		}
		// 姓名框加入鼠标监听
		text[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (text[0].getText().equals("请输入需要删除的用户姓名")) {
					text[0].setText("");
				}
				if (b1.getText().equals("删除")) {
					for (int i = 0; i < 7; i++) {
						text[i].setText("");
					}
					b1.setText("确定");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (text[0].getText().equals("请输入需要删除的用户姓名")) {
					text[0].setText("");
				}
				if (b1.getText().equals("删除")) {
					for (int i = 0; i <= 6; i++) {
						text[i].setText("");
					}
					b1.setText("确定");
				}
			}
		});
		// 添加到画布
		jp.add(label1);
		jp.add(label2);
		jp.add(b1);
		jp.add(b2);
		for (int i = 0; i <= 6; i++) {
			jp.add(info[i]);
			jp.add(text[i]);
		}
		this.add(jp);
		// 设置文本框不可输入
		for (int i = 1; i < 7; i++) {
			text[i].setEditable(false);
		}

		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	/**
	 * 确认删除
	 * 
	 * @param jf
	 */
	public void methodB1(JFrame jf) {
		if (b1.getText().equals("确定")) {
			if (text[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "联系人姓名不能空！", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (text[0].getText().length() < 2 || text[0].getText().length() > 6) {
				JOptionPane.showMessageDialog(null, "姓名至少2个字符，但不超过6个字符！", "提示", JOptionPane.ERROR_MESSAGE);
				return;

			}
			try {
				in = new BufferedReader(new FileReader("C://AddressMrgData//data//" + nameStr + ".txt"));
				out = new BufferedWriter(new FileWriter("C://AddressMrgData//data//" + nameStr + ".txt", true));
				String s = null;
				while ((s = in.readLine()) != null) {
					if (text[0].getText().equals(s)) {
						for (int i = 1; i < 7; i++) {
							s = in.readLine();
							text[i].setText(s);
						}
						b1.setText("删除");
						b1.requestFocus();
						return;
					}
					for (int i = 1; i <= 6; i++) {
						s = in.readLine();
					}
				}
				JOptionPane.showMessageDialog(null, "该联系人不存在！", "提示", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
					if (out != null) {
						out.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (b1.getText().equals("删除")) {
			try {
				in = new BufferedReader(new FileReader("C://AddressMrgData//data//" + nameStr + ".txt"));
				StringBuilder sb = new StringBuilder();
				String s = null;
				String ss = text[0].getText();
				while ((s = in.readLine()) != null) {
					if (ss.equals(s)) {
						for (int i = 1; i <= 6; i++) {
							s = in.readLine();
						}
						continue;
					}
					sb.append(s + "\r\n");

				}
				out = new BufferedWriter(new FileWriter("C://AddressMrgData//data//" + nameStr + ".txt"));
				out.write(sb.toString());
				JOptionPane.showMessageDialog(null, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < 7; i++) {
					text[i].setText("");
				}
				b1.setText("确定");
				text[0].requestFocus();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
					if (out != null) {
						out.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 返回
	 * 
	 * @param jf
	 */
	public void methodB2(JFrame jf) {
		jf.setVisible(true);
		this.dispose();
	}
}
