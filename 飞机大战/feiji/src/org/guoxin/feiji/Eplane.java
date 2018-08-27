
package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Eplane {
	int x=0;		//敌机X坐标
	int y=0;		//敌机Y坐标	
	int speed;   //敌机速度
	int dir;	//敌机方向
	Image img;
	ArrayList<Ebullet> list;
	public Eplane(){
		list = new ArrayList<Ebullet>();
		x = (int) (Math.random()*400);
		y = (int) (Math.random()*100);
		speed = (int) (Math.random()*5+5);
		dir = (int)(Math.random()*5+1);
		int num = (int) (Math.random()*3)+2;
		img = new ImageIcon("plane/e"+num+".png").getImage();
		addB();
	}
	
	public void draw(Graphics g){			//绘制敌机
			g.drawImage(img, x, y, null);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).draw(g,img.getWidth(null),img.getHeight(null));
			}
	}
	
	public void move() {					//移动敌机
		switch(dir){
			case 1: x += speed; y += 5; break;			
			case 2: x += speed; y += 10; break;
			case 3: y += speed; break;
			case 4: x -= speed; y += 10; break;
			case 5: y += speed; break;
		
		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move();
		}
		
		
	}
	
	public void addB(){
		new Thread(){
			public void run() {
				int count = 0;
				while(true){
					if(count%50 == 0){
						Ebullet B = new Ebullet(x,y);
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
