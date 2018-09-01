package org.lanqiao.jdmrg.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.lanqiao.jdmrg.common.RoomerAccount;

public class EmptyBg extends JPanel{
	
	private static JPanel thisP;
	
	public EmptyBg() {
		thisP = this;
		// 设置画布属性
		this.setLayout(null);
		this.setSize(840, 640);
		this.setLocation(0, 0);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image img = null;
		try {
			img = new ImageIcon(RoomerAccount.bg).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 840,640,null);
		repaint();
	}
}
