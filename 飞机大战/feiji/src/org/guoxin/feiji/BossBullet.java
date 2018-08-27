package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BossBullet {
	int x;
	int y;
	int x1;
	int y1;
	int speed;
	Image img;
	
	public BossBullet(int x1,int y1){
		this.x = x1;
		this.y = y1;
		speed = (int)(Math.random()*5+10);
		img = new ImageIcon("plane/bossbullet10.png").getImage();
	}
	
	public void draw(Graphics g,int xx, int yy){
		x1 = x+xx/2-25;
		y1 = y+yy-30;
		g.drawImage(img, x1, y1, null);
	}
	
	public void move(){
		y += speed;
	}
}
