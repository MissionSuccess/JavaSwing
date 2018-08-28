package edu.glut.jigsawgame.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.glut.jigsawgame.dao.UserDao;

/**
 * ��¼����
 * 
 * @author GuoXin
 */
public class MenuFrame extends JFrame {
	
	/** ���� */
	private JPanel jp = new JPanel();
	/** �����ǩ */
	private JLabel label1 = new JLabel("��̽����ƴͼ");
	/** �û�����ǩ */
	private JLabel label2 = new JLabel("�û���");
	/** �����ǩ */
	private JLabel label3 = new JLabel("��     ��");
	/** �û����ı��� */
	private JTextField jt = new JTextField();
	/** �����ı��� */
	JPasswordField passWordField = new JPasswordField();
	/** ע�ᰴť */
	private JButton enroll = new JButton("ע��");
	/** ��¼��ť */
	private JButton login = new JButton("��¼");

	public MenuFrame() {
		this.setTitle("��̽����ƴͼ");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);
		// ����
		label1.setFont(new Font("����", Font.BOLD, 32));
		label1.setBounds(95, 20, 230, 60);
		// �û���
		label2.setBounds(90, 90, 50, 30);
		jt.setBounds(145, 90, 160, 30);
		// ����
		label3.setBounds(90, 130, 50, 30);
		passWordField.setBounds(145, 130, 160, 30);
		// ע�ᰴť
		enroll.setFont(new Font("����", Font.BOLD, 14));
		enroll.setBounds(130, 180, 70, 30);
		enroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodEnroll();
			}
		});
		// ��¼��ť
		login.setFont(new Font("����", Font.BOLD, 14));
		login.setBounds(230, 180, 70, 30);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodLogin();
			}
		});
		/*
		 * ������̼���
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

		// ��ӵ�����
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
	 * ע��
	 */
	public void methodEnroll() {
		new EnrollFrame(this);
		this.setVisible(false);
	}

	/**
	 * ��¼
	 */
	public void methodLogin() {
		/*
		 * �ж��Ƿ��¼�ɹ�
		 */
		String user = jt.getText();
		String passWord = new String(passWordField.getPassword());

		// �ж��Ƿ�Ϊ���ı���
		if (user.equals("") || passWord.equals("")) {
			JOptionPane.showMessageDialog(null, "���ݲ���Ϊ�գ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// ��֤�û����������Ƿ�һ��
		String pwd = null;
		try {
			pwd = new UserDao().findPwd(user);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL���ݿ�δ���ӳɹ�,��¼ʧ�ܣ�\n���ݿ�����jigsaw\n������user_pwd(username �ַ���,pwd �ַ���)", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		if(passWord.equals(pwd)) {
			this.dispose();
			new FunctionFrame(this, user);
		}else {
			JOptionPane.showMessageDialog(null, "�û��������벻��ȷ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
			passWordField.setText("");
			return;
		}
	}
}
