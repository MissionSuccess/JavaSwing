package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Ebullet {
	int x;
	int y;
	int speed;
	Image img;
	
	public Ebullet(int x1,int y1){
		this.x = x1;
		this.y = y1;
		speed = (int)(Math.random()*5+10);
		img = new ImageIcon("plane/bullet3456.png").getImage();
	}
	
	public void draw(Graphics g,int xx, int yy){
		g.drawImage(img, x+xx/2, y+yy, null);
	}
	
	public void move(){
		y += speed;
	}
}
