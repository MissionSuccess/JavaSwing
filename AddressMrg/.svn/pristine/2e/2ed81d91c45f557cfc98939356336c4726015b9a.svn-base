package org.guoxin.txglxt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 主菜单窗口
 * 
 * @author GuoXin
 */
public class MenuFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 画布 */
	private JPanel jp = new JPanel();
	/** 标题标签 */
	private JLabel label1 = new JLabel("通讯管理系统");
	/** 用户名标签 */
	private JLabel label2 = new JLabel("用户名");
	/** 密码标签 */
	private JLabel label3 = new JLabel("密     码");
	/** 用户名文本框 */
	private JTextField jt = new JTextField();
	/** 密码文本框 */
	JPasswordField passWordField = new JPasswordField();
	/** 注册按钮 */
	private JButton enroll = new JButton("注册");
	/** 登录按钮 */
	private JButton login = new JButton("登录");
	/** 读 */
	private BufferedReader in = null;

	public MenuFrame() {
		this.setTitle("通讯管理系统");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);
		// 标题
		label1.setFont(new Font("楷体", Font.BOLD, 32));
		label1.setBounds(95, 20, 230, 60);
		// 用户名
		label2.setBounds(90, 90, 50, 30);
		jt.setBounds(145, 90, 160, 30);
		// 密码
		label3.setBounds(90, 130, 50, 30);
		passWordField.setBounds(145, 130, 160, 30);
		// 注册按钮
		enroll.setFont(new Font("楷体", Font.BOLD, 14));
		enroll.setBounds(130, 180, 70, 30);
		enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodEnroll();
			}
		});
		// 登录按钮
		login.setFont(new Font("楷体", Font.BOLD, 14));
		login.setBounds(230, 180, 70, 30);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodLogin();
			}
		});
		/*
		 * 加入键盘监听
		 */
		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		passWordField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		login.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodLogin();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});

		// 添加到画布
		jp.add(jt);
		jp.add(passWordField);
		jp.add(label1);
		jp.add(label2);
		jp.add(label3);
		jp.add(enroll);
		jp.add(login);
		this.add(jp);

		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	/**
	 * 注册
	 */
	public void methodEnroll() {
		new EnrollFrame(this);
		this.setVisible(false);
	}

	/**
	 * 登录
	 */
	public void methodLogin() {
		/*
		 * 判断是否登录成功
		 */
		String user = jt.getText();
		String passWord = new String(passWordField.getPassword());

		// 判断是否为空文本框
		if (user.equals("") || passWord.equals("")) {
			JOptionPane.showMessageDialog(null, "内容不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 读取文件验证
		try {
			in = new BufferedReader(new FileReader("C://AddressMrgData//user//userInf.txt"));
			String ss = null;
			String sss = null;
			while ((ss = in.readLine()) != null) {
				if (user.equals(ss)) {
					sss = ss;
					ss = in.readLine();
					if (passWord.equals(ss)) {
						File dataFile = new File("C://AddressMrgData//data//" + sss + ".txt");
						try {
							if (!dataFile.exists()) {
								dataFile.createNewFile();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						new FunctionFrame(this, sss);
						this.setVisible(false);
						return;
					} else {
						JOptionPane.showMessageDialog(null, "密码不正确！", "提示", JOptionPane.ERROR_MESSAGE);
						passWordField.setText("");
						return;
					}
				}
				ss = in.readLine();
			}
			JOptionPane.showMessageDialog(null, "该用户不存在！", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
