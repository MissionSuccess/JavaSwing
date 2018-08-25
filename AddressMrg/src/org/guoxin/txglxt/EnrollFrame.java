package org.guoxin.txglxt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 注册窗口
 * 
 * @author GuoXin
 */
public class EnrollFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 画布 */
	private JPanel jp = new JPanel();
	/** 标题标签 */
	private JLabel label1 = new JLabel("账号注册");
	/** 用户名标签 */
	private JLabel label2 = new JLabel("用  户  名 ");
	/** 密码标签 */
	private JLabel label3 = new JLabel("密         码 ");
	/** 密码标签 */
	private JLabel label4 = new JLabel("确认密码");
	/** 用户名文本框 */
	private JTextField jt = new JTextField();
	/** 密码文本框 */
	JPasswordField passWordField = new JPasswordField();
	/** 确认密码文本框 */
	JPasswordField passWordField1 = new JPasswordField();
	/** 注册按钮 */
	private JButton enroll = new JButton("注册");
	/** 登录按钮 */
	private JButton back = new JButton("返回");
	/** 创建文件夹 */
	private File dirFile;
	/** 读 */
	private BufferedReader in = null;
	/** 写 */
	private BufferedWriter out = null;

	public EnrollFrame(JFrame jf) {
		this.setTitle("通讯管理系统");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);
		// 标题
		label1.setFont(new Font("楷体", Font.BOLD, 32));
		label1.setBounds(140, 20, 230, 60);
		// 用户名
		label2.setBounds(90, 90, 90, 30);
		jt.setBounds(150, 90, 160, 30);
		// 密码
		label3.setBounds(90, 130, 90, 30);
		passWordField.setBounds(150, 130, 160, 30);
		// 确认密码
		label4.setBounds(90, 170, 90, 30);
		passWordField1.setBounds(150, 170, 160, 30);
		// 注册按钮
		enroll.setFont(new Font("楷体", Font.BOLD, 14));
		enroll.setBounds(130, 220, 70, 30);
		enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodEnroll(jf);
			}
		});
		enroll.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodEnroll(jf);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// 返回按钮
		back.setFont(new Font("楷体", Font.BOLD, 14));
		back.setBounds(230, 220, 70, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodBack(jf);
			}
		});
		// 加入键盘监听
		jt.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodEnroll(jf);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		passWordField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodEnroll(jf);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		passWordField1.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodEnroll(jf);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		// 添加到画布
		jp.add(jt);
		jp.add(passWordField);
		jp.add(passWordField1);
		jp.add(label1);
		jp.add(label2);
		jp.add(label3);
		jp.add(label4);
		jp.add(enroll);
		jp.add(back);
		this.add(jp);

		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	/**
	 * 注册
	 * 
	 * @param jf
	 *            上一级窗口
	 * @throws IOException
	 */
	public void methodEnroll(JFrame jf) {
		// 创建系统文件夹及文件
		try {
			dirFile = new File("C://AddressMrgData");
			if (dirFile.exists() == false) {
				dirFile = new File("C://AddressMrgData//user");
				dirFile.mkdirs();
				dirFile = new File("C://AddressMrgData//data");
				dirFile.mkdirs();
				dirFile = new File("C://AddressMrgData//user//userInf.txt");
				dirFile.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 注册
		String user = jt.getText();
		String pw1 = new String(passWordField.getPassword());
		String pw2 = new String(passWordField1.getPassword());
		// 判断输入是否合法
		if (user.equals("") || pw1.equals("") || pw2.equals("")) {
			JOptionPane.showMessageDialog(null, "内容不能为空！", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!pw1.equals(pw2)) {
			JOptionPane.showMessageDialog(null, "密码不一致，请重新确认！", "提示", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (2 > user.length()) {
			JOptionPane.showMessageDialog(null, "用户名至少两个字符！", "提示", JOptionPane.CANCEL_OPTION);
			return;
		} else if (8 < user.length()) {
			JOptionPane.showMessageDialog(null, "用户名过长！", "提示", JOptionPane.CANCEL_OPTION);
			return;
		} else if (pw1.length() < 6) {
			JOptionPane.showMessageDialog(null, "密码至少6位!", "提示", JOptionPane.CANCEL_OPTION);
			return;
		}

		try {
			in = new BufferedReader(new FileReader("C://AddressMrgData//user//userInf.txt"));
			String s = null;
			// 判断用户名是否被使用
			while ((s = in.readLine()) != null) {
				if (s.equals(user)) {
					JOptionPane.showMessageDialog(null, "该用户已存在，请重新输入！", "提示", JOptionPane.ERROR_MESSAGE);
					return;
				}
				for (int i = 1; i <= 1; i++) {
					s = in.readLine();
				}
			}
			// 录入文件存档
			out = new BufferedWriter(new FileWriter("C://AddressMrgData//user//userInf.txt", true));
			out.write(user);
			out.newLine();
			out.write(pw1);
			out.newLine();
			JOptionPane.showMessageDialog(null, "注册成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
			new MenuFrame();
			jf.dispose();
			this.dispose();
		} catch (IOException e) {
			System.out.println(e.getMessage());
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

	/**
	 * 返回上一级
	 * 
	 * @param jf
	 *            上一级窗口
	 */
	public void methodBack(JFrame jf) {
		jf.setVisible(true);
		this.dispose();
	}
}
