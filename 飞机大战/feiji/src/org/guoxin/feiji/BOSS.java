package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BOSS {
	int x=0;		//BossX坐标
	int y=50;		//BossY坐标	
	int speed;   //Boss速度
	int dir=1;	//Boss方向
	Image img;
	ArrayList<BossBullet> list;
	public BOSS(){
		list = new ArrayList<BossBullet>();
		speed = (int) (Math.random()*5+5);
		img = new ImageIcon("plane/BOSS.png").getImage();
		addB();
	}
	
	public void draw(Graphics g){			//绘制BOSS
			g.drawImage(img, x, y,242,150,null);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).draw(g,img.getWidth(null),img.getHeight(null));
			}
	}
	
	public void move() {					//移动BOSS
		if(dir == 1){
			x += speed;
		}
		if(dir == 2){
			x -= speed;
		}
		if(x < -30) 
			dir = 1;
		if(x > 170) 
			dir = 2;
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move();
		}
	}
	
	public void addB(){
		new Thread(){
			public void run() {
				int count = 0;
				while(true){
					if(count%30 == 0){
						BossBullet B = new BossBullet(x,y);
						list.add(B);
						
					}
					try {
						Thread.sleep((int)(Math.random()*200+700));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	
}
