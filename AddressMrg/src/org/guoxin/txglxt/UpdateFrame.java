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
 * �޸���ϵ�˴���
 * 
 * @author GuoXin
 */
public class UpdateFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ���� */
	private JPanel jp = new JPanel();
	/** ����1��ǩ */
	private JLabel label1 = new JLabel("�޸�");
	/** ����2��ǩ */
	private JLabel label2 = new JLabel("��ϵ��");
	/** ��Ϣ��ǩ */
	private JLabel[] info = new JLabel[7];
	/** ��Ϣ�ı� */
	private JTextField[] text = new JTextField[7];
	/** ȷ����ť */
	private JButton b1 = new JButton("ȷ��");
	/** ���ذ�ť */
	private JButton b2 = new JButton("����");
	/** ���� */
	private Font f = new Font("����", Font.BOLD, 14);
	/** �ı���߶� */
	private int hight = 25;
	/** �� */
	private BufferedReader in = null;
	/** д */
	private BufferedWriter out = null;
	/** �û��� */
	private String nameStr = null;

	public UpdateFrame(JFrame jf, String str) {
		nameStr = str;
		this.setTitle("ͨѶ����ϵͳ(" + str + ")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);

		// ����
		label1.setFont(new Font("����", Font.BOLD, 24));
		label1.setBounds(35, 30, 200, 50);
		label2.setFont(new Font("����", Font.BOLD, 24));
		label2.setBounds(20, 60, 200, 50);
		// ����
		info[0] = new JLabel("����");
		text[0] = new JTextField("��������Ҫ�޸ĵ��û�����");
		info[0].setFont(f);
		info[0].setBounds(120, 20, 50, hight);
		text[0].setBounds(175, 20, 160, hight);
		// �ֻ���
		info[1] = new JLabel("�ֻ���");
		text[1] = new JTextField("");
		info[1].setFont(f);
		info[1].setBounds(120, 55, 50, hight);
		text[1].setBounds(175, 55, 160, hight);
		// �̶��绰
		info[2] = new JLabel("�绰");
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
		// ����
		info[5] = new JLabel("����");
		text[5] = new JTextField("");
		info[5].setFont(f);
		info[5].setBounds(120, 195, 50, hight);
		text[5].setBounds(175, 195, 160, hight);
		// ͨѶ��ַ
		info[6] = new JLabel("��ַ");
		text[6] = new JTextField("");
		info[6].setFont(f);
		info[6].setBounds(120, 230, 50, hight);
		text[6].setBounds(175, 230, 160, hight);

		// ȷ����ť
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
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodB1(jf);
				}
			}
		});
		// ���ذ�ť
		b2.setFont(f);
		b2.setBounds(20, 200, 80, 40);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodB2(jf);
			}
		});
		// ������̼���
		for (int i = 0; i < 7; i++) {
			text[i].addKeyListener(new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {
				}

				@Override
				public void keyReleased(KeyEvent e) {
				}

				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() != KeyEvent.VK_ENTER && text[0].getText().equals("��������Ҫ�޸ĵ��û�����")) {
						text[0].setText("");
						text[0].requestFocus();
					}
					if (e.getKeyChar() == KeyEvent.VK_ENTER) {
						methodB1(jf);
					}
				}
			});
		}
		// ���������������
		text[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (text[0].getText().equals("��������Ҫ�޸ĵ��û�����")) {
					text[0].setText("");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (text[0].getText().equals("��������Ҫ�޸ĵ��û�����")) {
					text[0].setText("");
				}
			}
		});
		// ��ӵ�����
		jp.add(label1);
		jp.add(label2);
		jp.add(b1);
		jp.add(b2);
		for (int i = 0; i <= 6; i++) {
			jp.add(info[i]);
			jp.add(text[i]);
		}
		this.add(jp);
		// �����ı��򲻿�����
		for (int i = 1; i < 7; i++) {
			text[i].setEditable(false);
		}

		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	/**
	 * ȷ���޸�
	 * 
	 * @param jf
	 */
	public void methodB1(JFrame jf) {
		if (b1.getText().equals("ȷ��")) {
			if (text[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��ϵ���������ܿգ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (text[0].getText().length() < 2 || text[0].getText().length() > 6) {
				JOptionPane.showMessageDialog(null, "��������2���ַ�����������6���ַ���", "��ʾ", JOptionPane.ERROR_MESSAGE);
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
							text[i].setEditable(true);
						}
						b1.setText("�޸�");
						b1.requestFocus();
						return;
					}
					for (int i = 1; i <= 6; i++) {
						s = in.readLine();
					}
				}
				JOptionPane.showMessageDialog(null, "����ϵ�˲����ڣ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
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
		if (b1.getText().equals("�޸�")) {
			if (text[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "��ϵ���������ܿգ�", "��ʾ", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (text[0].getText().length() < 2 || text[0].getText().length() > 6) {
				JOptionPane.showMessageDialog(null, "��������2���ַ�����������6���ַ���", "��ʾ", JOptionPane.ERROR_MESSAGE);
				return;
			} else if (text[1].getText().length() != 11) {
				JOptionPane.showMessageDialog(null, "�ֻ��ű���Ϊ11λ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {
				in = new BufferedReader(new FileReader("C://AddressMrgData//data//" + nameStr + ".txt"));
				StringBuilder sb = new StringBuilder();
				String s = null;
				String ss = text[0].getText();
				while ((s = in.readLine()) != null) {
					if (ss.equals(s)) {
						for (int i = 0; i < 7; i++) {
							sb.append(text[i].getText() + "\r\n");
						}
						for (int i = 1; i <= 6; i++) {
							s = in.readLine();
						}
						continue;
					}
					sb.append(s + "\r\n");

				}
				out = new BufferedWriter(new FileWriter("C://AddressMrgData//data//" + nameStr + ".txt"));
				out.write(sb.toString());
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				for (int i = 0; i < 7; i++) {
					text[i].setText("");
					if (0 != i) {
						text[i].setEditable(false);
					}
				}
				b1.setText("ȷ��");
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
	 * ����
	 * 
	 * @param jf
	 */
	public void methodB2(JFrame jf) {
		jf.setVisible(true);
		this.dispose();
	}
}
