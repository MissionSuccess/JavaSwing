package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Mybullet {
	int x;
	int y;
	int speed;
	Image img;
	
	public Mybullet(int x,int y){
		this.x = x+20;
		this.y = y;
		speed = (int)(Math.random()*10+30);
		img = new ImageIcon("plane/bullet.png").getImage();
	}
	
	public void draw(Graphics g){
		g.drawImage(img, x, y, null);
	}
	
	public void move(){
		y -= speed;
	}
}
