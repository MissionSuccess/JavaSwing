package org.guoxin.txglxt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 功能选择窗口
 * 
 * @author GuoXin
 */
public class FunctionFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 画布 */
	private JPanel jp = new JPanel();
	/** 标题标签 */
	private JLabel label1 = new JLabel("功能选择");
	/** 添加联系人按钮 */
	private JButton addButton = new JButton("添加联系人");
	/** 删除联系人按钮 */
	private JButton delectButton = new JButton("删除联系人");
	/** 修改联系人按钮 */
	private JButton updateButton = new JButton("修改联系人");
	/** 显示全部联系人按钮 */
	private JButton findButton = new JButton("查询联系人");
	/** 注销按钮 */
	private JButton backButton = new JButton("注销");
	/** 设置字体 */
	private Font f = new Font("黑体", Font.BOLD, 12);

	public FunctionFrame(JFrame jf, String str) {
		this.setTitle("通讯管理系统(" + str + ")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);

		// 标题
		label1.setFont(new Font("楷体", Font.BOLD, 32));
		label1.setBounds(130, 20, 230, 60);
		// 添加按钮
		addButton.setBounds(90, 90, 100, 40);
		addButton.setFont(f);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodAddButton(jf, str);
			}
		});
		// 删除按钮
		delectButton.setBounds(210, 90, 100, 40);
		delectButton.setFont(f);
		delectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodDelectButton(jf, str);
			}
		});
		// 修改按钮
		updateButton.setBounds(90, 140, 100, 40);
		updateButton.setFont(f);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodUpdateButton(jf, str);
			}
		});
		// 查找按钮
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
	 * 添加联系人
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodAddButton(JFrame jf, String str) {
		new AddFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * 删除联系人
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodDelectButton(JFrame jf, String str) {
		new DelectFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * 修改联系人
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodUpdateButton(JFrame jf, String str) {
		new UpdateFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * 查找联系人
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodFindButton(JFrame jf, String str) {
		new FindFrame(this, str);
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
