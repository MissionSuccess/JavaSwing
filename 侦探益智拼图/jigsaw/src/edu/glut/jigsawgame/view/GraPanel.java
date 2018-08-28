package edu.glut.jigsawgame.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.glut.jigsawgame.service.Level;

/**
 * »­²Î¿¼Í¼»­²¼
 * @author GuoX
 *
 */
public class GraPanel extends JPanel{
	
	public GraPanel() {
		this.setSize(420,420);
		this.setLocation(0, 0);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image img = null;
		try {
			img = new ImageIcon("src/images/"+Level.level+".jpg").getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 420,420,null);
		repaint();
	}

}
