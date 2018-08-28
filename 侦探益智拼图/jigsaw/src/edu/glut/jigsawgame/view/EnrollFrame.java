package edu.glut.jigsawgame.view;

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

import edu.glut.jigsawgame.dao.UserDao;

/**
 * ע�ᴰ��
 * 
 * @author GuoXin
 */
public class EnrollFrame extends JFrame {
	/**
	 * 
	 */
	/** ���� */
	private JPanel jp = new JPanel();
	/** �����ǩ */
	private JLabel label1 = new JLabel("�˺�ע��");
	/** �û�����ǩ */
	private JLabel label2 = new JLabel("��  ��  �� ");
	/** �����ǩ */
	private JLabel label3 = new JLabel("��         �� ");
	/** �����ǩ */
	private JLabel label4 = new JLabel("ȷ������");
	/** �û����ı��� */
	private JTextField jt = new JTextField();
	/** �����ı��� */
	JPasswordField passWordField = new JPasswordField();
	/** ȷ�������ı��� */
	JPasswordField passWordField1 = new JPasswordField();
	/** ע�ᰴť */
	private JButton enroll = new JButton("ע��");
	/** ��¼��ť */
	private JButton back = new JButton("����");

	public EnrollFrame(JFrame jf) {
		this.setTitle("��̽����ƴͼ");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);
		// ����
		label1.setFont(new Font("����", Font.BOLD, 32));
		label1.setBounds(140, 20, 230, 60);
		// �û���
		label2.setBounds(90, 90, 90, 30);
		jt.setBounds(150, 90, 160, 30);
		// ����
		label3.setBounds(90, 130, 90, 30);
		passWordField.setBounds(150, 130, 160, 30);
		// ȷ������
		label4.setBounds(90, 170, 90, 30);
		passWordField1.setBounds(150, 170, 160, 30);
		// ע�ᰴť
		enroll.setFont(new Font("����", Font.BOLD, 14));
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
		// ���ذ�ť
		back.setFont(new Font("����", Font.BOLD, 14));
		back.setBounds(230, 220, 70, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodBack(jf);
			}
		});
		// ������̼���
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
		// ��ӵ�����
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
	 * ע��
	 * 
	 * @param jf
	 */
	public void methodEnroll(JFrame jf) {
		// ע��
		String user = jt.getText();
		String pw1 = new String(passWordField.getPassword());
		String pw2 = new String(passWordField1.getPassword());
		// �ж������Ƿ�Ϸ�
		if (user.equals("") || pw1.equals("") || pw2.equals("")) {
			JOptionPane.showMessageDialog(null, "���ݲ���Ϊ�գ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (!pw1.equals(pw2)) {
			JOptionPane.showMessageDialog(null, "���벻һ�£�������ȷ�ϣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (2 > user.length()) {
			JOptionPane.showMessageDialog(null, "�û������������ַ���", "��ʾ", JOptionPane.CANCEL_OPTION);
			return;
		} else if (8 < user.length()) {
			JOptionPane.showMessageDialog(null, "�û���������", "��ʾ", JOptionPane.CANCEL_OPTION);
			return;
		} else if (pw1.length() < 6) {
			JOptionPane.showMessageDialog(null, "��������6λ!", "��ʾ", JOptionPane.CANCEL_OPTION);
			return;
		}

		try {
			UserDao ud = new UserDao();
			// �ж��û����Ƿ�ʹ��
			while ((ud.findUser(user))) {
					JOptionPane.showMessageDialog(null, "���û��Ѵ��ڣ����������룡", "��ʾ", JOptionPane.ERROR_MESSAGE);
					return;
			}
			// ¼���ļ��浵
			ud.addUser(user, pw1);
			JOptionPane.showMessageDialog(null, "ע��ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			new MenuFrame();
			jf.dispose();
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "MySQL���ݿ�δ���ӳɹ�,ע��ʧ�ܣ�\n���ݿ�����jigsaw\n������user_pwd(username �ַ���,pwd �ַ���)", "��ʾ", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * ������һ��
	 * 
	 * @param jf
	 */
	public void methodBack(JFrame jf) {
		jf.setVisible(true);
		this.dispose();
	}
}
