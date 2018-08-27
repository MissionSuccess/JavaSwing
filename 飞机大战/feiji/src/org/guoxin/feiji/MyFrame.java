package org.guoxin.feiji;

import javax.swing.JFrame;

public class MyFrame {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Mypanel p = new Mypanel();
		f.add(p);
		
		f.setSize(400, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setUndecorated(true);
		f.setVisible(true);
		f.addMouseListener(p);
		f.addMouseMotionListener(p);
		f.addKeyListener(p);
		p.Move();
		
	}

}
