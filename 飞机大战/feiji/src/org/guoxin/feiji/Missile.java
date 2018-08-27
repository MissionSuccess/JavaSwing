package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Missile {
	int x;
	int y;
	int speed;
	Image img;
	
	public Missile(){
		this.x = (int)(Math.random()*400+1);
		this.y = (int)(Math.random()*200+1);
		speed = (int)(Math.random()*5+5);
		img = new ImageIcon("plane/beebullet.png").getImage();
	}
	
	public void draw(Graphics g){
		g.drawImage(img, x+5+img.getWidth(null)/2, y+img.getHeight(null), null);
	}
	
	public void move(){
		y += speed;
	}
}
