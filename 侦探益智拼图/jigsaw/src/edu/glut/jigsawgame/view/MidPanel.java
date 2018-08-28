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
 * 中部按钮画布
 * 
 * @author GuoX
 *
 */
public class MidPanel extends JPanel {
	/**设置字体*/
	private Font f = new Font("黑体", Font.BOLD, 20);
	/**时间标签*/
	private static JLabel jlTime = new JLabel("00:00");
	/**图片序号*/
	private JLabel jlCount = new JLabel("", JLabel.CENTER);
	/**时间格式*/
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	/**当前时间*/
	private static Date now = new Date();
	/**计时器*/
	public static Timer timer;
	/**暂停按钮*/
	public static JButton jbPause = new JButton();
	/**清空时间*/
	public static String nowStr = "00:00";
	/**记录暂停按钮状态*/
	static boolean b = false;

	/**
	 * 初始化计时器和标签
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
	 * 按钮功能实现
	 */
	public void button() {

		JButton jbUp = new JButton();
		JButton jbDown = new JButton();

		jbUp.setIcon(new ImageIcon("src/images/上.png"));
		jbPause.setIcon(new ImageIcon("src/images/开始.png"));
		jbDown.setIcon(new ImageIcon("src/images/下.png"));

		jbUp.setSize(100, 100);
		jbPause.setSize(100, 100);
		jbDown.setSize(100, 100);

		jbUp.setLocation(0, 0);
		jbPause.setLocation(0, 160);
		jbDown.setLocation(0, 320);

		jbPause.setBorderPainted(false);

		/**
		 * 上键
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
					jbPause.setIcon(new ImageIcon("src/images/开始.png"));
				}
			}
		});

		/**
		 * 中键
		 * */
		jbPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (b) {
					timer.stop();
					jbPause.setIcon(new ImageIcon("src/images/开始.png"));
					b = false;
				} else {
					timer.start();
					jbPause.setIcon(new ImageIcon("src/images/暂停.png"));
					b = true;
				}

			}
		});

		/**
		 * 下键	
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
					jbPause.setIcon(new ImageIcon("src/images/开始.png"));
				}
			}
		});

		this.add(jbUp);
		this.add(jbPause);
		this.add(jbDown);
	}

	/**
	 * 设置标签属性
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
	 * 初始化计时器
	 * */
	@SuppressWarnings("deprecation")
	public static void timeInit() {
		now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
		jlTime.setText("00:00");
	}

}
