package edu.glut.jigsawgame.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import edu.glut.jigsawgame.service.Level;

/**
 * �в���ť����
 * 
 * @author GuoX
 *
 */
public class MidPanel extends JPanel {
	/**��������*/
	private Font f = new Font("����", Font.BOLD, 20);
	/**ʱ���ǩ*/
	private static JLabel jlTime = new JLabel("00:00");
	/**ͼƬ���*/
	private JLabel jlCount = new JLabel("", JLabel.CENTER);
	/**ʱ���ʽ*/
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	/**��ǰʱ��*/
	private static Date now = new Date();
	/**��ʱ��*/
	public static Timer timer;
	/**��ͣ��ť*/
	public static JButton jbPause = new JButton();
	/**���ʱ��*/
	public static String nowStr = "00:00";
	/**��¼��ͣ��ť״̬*/
	static boolean b = false;

	/**
	 * ��ʼ����ʱ���ͱ�ǩ
	 */
	{
		timeInit();
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date now2 = new Date(now.getTime() + 1000);
				now = now2;
				SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
				nowStr = formatter.format(now);
				jlTime.setText(formatter.format(now));
			}
		});
	}

	public MidPanel() {
		this.setLayout(null);
		this.setSize(100, 420);
		this.setLocation(0, 0);
		button();
		setlable();
	}

	/**
	 * ��ť����ʵ��
	 */
	public void button() {

		JButton jbUp = new JButton();
		JButton jbDown = new JButton();

		jbUp.setIcon(new ImageIcon("src/images/��.png"));
		jbPause.setIcon(new ImageIcon("src/images/��ʼ.png"));
		jbDown.setIcon(new ImageIcon("src/images/��.png"));

		jbUp.setSize(100, 100);
		jbPause.setSize(100, 100);
		jbDown.setSize(100, 100);

		jbUp.setLocation(0, 0);
		jbPause.setLocation(0, 160);
		jbDown.setLocation(0, 320);

		jbPause.setBorderPainted(false);

		/**
		 * �ϼ�
		 * */
		jbUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Level.level > 1) {
					Level.level--;
					GamePanel.setImg();
					GamePanel.OutOfOrder();
					setlable();
					timeInit();
					timer.stop();
					jbPause.setIcon(new ImageIcon("src/images/��ʼ.png"));
				}
			}
		});

		/**
		 * �м�
		 * */
		jbPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (b) {
					timer.stop();
					jbPause.setIcon(new ImageIcon("src/images/��ʼ.png"));
					b = false;
				} else {
					timer.start();
					jbPause.setIcon(new ImageIcon("src/images/��ͣ.png"));
					b = true;
				}

			}
		});

		/**
		 * �¼�	
		 * */
		jbDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Level.level < 20) {
					Level.level++;
					GamePanel.setImg();
					GamePanel.OutOfOrder();
					setlable();
					timeInit();
					timer.stop();
					jbPause.setIcon(new ImageIcon("src/images/��ʼ.png"));
				}
			}
		});

		this.add(jbUp);
		this.add(jbPause);
		this.add(jbDown);
	}

	/**
	 * ���ñ�ǩ����
	 * */
	public void setlable() {
		int count = Level.level;

		jlTime.setSize(100, 50);
		jlCount.setSize(100, 50);

		jlTime.setFont(f);
		jlCount.setFont(f);

		jlTime.setLocation(25, 110);
		jlCount.setLocation(0, 265);

		jlCount.setText(count + "");

		this.add(jlTime);
		this.add(jlCount);
	}

	/**
	 * ��ʼ����ʱ��
	 * */
	@SuppressWarnings("deprecation")
	public static void timeInit() {
		now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
		jlTime.setText("00:00");
	}

}
