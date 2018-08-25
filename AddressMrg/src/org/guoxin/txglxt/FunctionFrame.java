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
 * ����ѡ�񴰿�
 * 
 * @author GuoXin
 */
public class FunctionFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ���� */
	private JPanel jp = new JPanel();
	/** �����ǩ */
	private JLabel label1 = new JLabel("����ѡ��");
	/** �����ϵ�˰�ť */
	private JButton addButton = new JButton("�����ϵ��");
	/** ɾ����ϵ�˰�ť */
	private JButton delectButton = new JButton("ɾ����ϵ��");
	/** �޸���ϵ�˰�ť */
	private JButton updateButton = new JButton("�޸���ϵ��");
	/** ��ʾȫ����ϵ�˰�ť */
	private JButton findButton = new JButton("��ѯ��ϵ��");
	/** ע����ť */
	private JButton backButton = new JButton("ע��");
	/** �������� */
	private Font f = new Font("����", Font.BOLD, 12);

	public FunctionFrame(JFrame jf, String str) {
		this.setTitle("ͨѶ����ϵͳ(" + str + ")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);

		// ����
		label1.setFont(new Font("����", Font.BOLD, 32));
		label1.setBounds(130, 20, 230, 60);
		// ��Ӱ�ť
		addButton.setBounds(90, 90, 100, 40);
		addButton.setFont(f);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodAddButton(jf, str);
			}
		});
		// ɾ����ť
		delectButton.setBounds(210, 90, 100, 40);
		delectButton.setFont(f);
		delectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodDelectButton(jf, str);
			}
		});
		// �޸İ�ť
		updateButton.setBounds(90, 140, 100, 40);
		updateButton.setFont(f);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodUpdateButton(jf, str);
			}
		});
		// ���Ұ�ť
		findButton.setBounds(210, 140, 100, 40);
		findButton.setFont(f);
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodFindButton(jf, str);
			}
		});
		// ע����ť
		backButton.setBounds(90, 200, 220, 40);
		backButton.setFont(f);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodBackButton(jf);
			}
		});
		this.add(jp);

		// ��ӵ�����
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
	 * �����ϵ��
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodAddButton(JFrame jf, String str) {
		new AddFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * ɾ����ϵ��
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodDelectButton(JFrame jf, String str) {
		new DelectFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * �޸���ϵ��
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodUpdateButton(JFrame jf, String str) {
		new UpdateFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * ������ϵ��
	 * 
	 * @param jf
	 * @param str
	 */
	public void methodFindButton(JFrame jf, String str) {
		new FindFrame(this, str);
		this.setVisible(false);
	}

	/**
	 * ע��
	 * 
	 * @param jf
	 */
	public void methodBackButton(JFrame jf) {
		int act = JOptionPane.showConfirmDialog(null, "���Ƿ�ȷ��Ҫע����", "��ʾ", JOptionPane.YES_NO_OPTION);
		if (act == JOptionPane.YES_OPTION) {
			new MenuFrame();
			jf.dispose();
			this.dispose();
		}
	}

}
