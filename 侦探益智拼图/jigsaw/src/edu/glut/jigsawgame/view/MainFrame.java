package edu.glut.jigsawgame.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


import edu.glut.jigsawgame.service.Level;

/**
 * 游戏主窗口
 * @author GuoX
 *
 */
public class MainFrame extends JFrame {
	private JFrame ff = this;
	private JFrame ff1;

	public MainFrame(int size, String str, JFrame ff1) {

		this.setTitle("侦探益智拼图(" + str + ")");
		this.setSize(956, 459);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		new Level();
		this.ff1 = ff1;

		/**
		 * 添加画布进行布局
		 * */
		JPanel jpLeft = new JPanel();
		JPanel jpRight = new JPanel();
		JPanel jpMid = new JPanel();

		GamePanel gp = new GamePanel(size);
		MidPanel mp = new MidPanel();
		GraPanel gp1 = new GraPanel();

		jpLeft.setSize(420, 420);
		jpMid.setSize(100, 420);
		jpRight.setSize(420, 420);

		jpLeft.setLocation(0, 0);
		jpMid.setLocation(420, 0);
		jpRight.setLocation(520, 0);

		jpLeft.setLayout(null);
		jpRight.setLayout(null);
		jpMid.setLayout(null);

		jpLeft.add(gp1);
		jpMid.add(mp);
		jpRight.add(gp);

		this.add(jpLeft);
		this.add(jpMid);
		this.add(jpRight);

		this.setVisible(true);
		
		/**
		 * 添加窗口关闭监听
		 */
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				ff1.setVisible(true);
				ff.dispose();
				mp.timer.stop();
				mp.timeInit();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
