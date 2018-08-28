package edu.glut.jigsawgame.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 选择难度窗口
 * 
 * @author GuoXin
 */
public class FunctionFrame extends JFrame {
	/**
	 * 
	 */
	/** 画布 */
	private JPanel jp = new JPanel();
	/** 标题标签 */
	private JLabel label1 = new JLabel("选择难度");
	/** 3×3按钮 */
	private JButton addButton = new JButton("3×3");
	/** 4×4按钮 */
	private JButton delectButton = new JButton("4×4");
	/** 5×5按钮 */
	private JButton updateButton = new JButton("5×5");
	/** 6×6按钮 */
	private JButton findButton = new JButton("6×6");
	/** 注销按钮 */
	private JButton backButton = new JButton("注销");
	/** 设置字体 */
	private Font f = new Font("黑体", Font.BOLD, 12);
	/**存储用户名*/
	private String st = "";

	public FunctionFrame(JFrame jf, String str) {
		this.st = str;
		this.setTitle("侦探益智拼图(" + str + ")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);

		// 标题
		label1.setFont(new Font("楷体", Font.BOLD, 32));
		label1.setBounds(130, 20, 230, 60);
		// 3×3
		addButton.setBounds(90, 90, 100, 40);
		addButton.setFont(f);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodAddButton(jf, str);
			}
		});
		// 4×4
		delectButton.setBounds(210, 90, 100, 40);
		delectButton.setFont(f);
		delectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodDelectButton(jf, str);
			}
		});
		// 5×5
		updateButton.setBounds(90, 140, 100, 40);
		updateButton.setFont(f);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodUpdateButton(jf, str);
			}
		});
		// 6×6
		findButton.setBounds(210, 140, 100, 40);
		findButton.setFont(f);
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodFindButton(jf, str);
			}
		});
		// 注销按钮
		backButton.setBounds(90, 200, 220, 40);
		backButton.setFont(f);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodBackButton(jf);
			}
		});
		this.add(jp);

		// 添加到画布
		jp.add(label1);
		jp.add(addButton);
		jp.add(delectButton);
		jp.add(updateButton);
		jp.add(findButton);
		jp.add(backButton);

		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	/**
	 * 3×3
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodAddButton(JFrame jf, String str) {
		new MainFrame(3,st,this);
		this.setVisible(false);
	}

	/**
	 * 4×4
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodDelectButton(JFrame jf, String str) {
		new MainFrame(4,st,this);
		this.setVisible(false);
	}

	/**
	 * 5×5
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodUpdateButton(JFrame jf, String str) {
		new MainFrame(5,st,this);
		this.setVisible(false);
	}

	/**
	 * 6×6
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodFindButton(JFrame jf, String str) {
		new MainFrame(6,st,this);
		this.setVisible(false);
	}

	/**
	 * 注销
	 * 
	 * @param jf
	 */
	public void methodBackButton(JFrame jf) {
		int act = JOptionPane.showConfirmDialog(null, "您是否确定要注销？", "提示", JOptionPane.YES_NO_OPTION);
		if (act == JOptionPane.YES_OPTION) {
			new MenuFrame();
			jf.dispose();
			this.dispose();
		}
	}

}
