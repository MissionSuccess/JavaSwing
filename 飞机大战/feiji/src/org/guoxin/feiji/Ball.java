package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball {
	 int r=20;
	 int speed;
	 int ballx;
	 int bally;
	 Image img;
	 int dir;
	
	public Ball(int num){
		ballx = (int) (Math.random()*400);
		bally = (int) (Math.random()*600);
		speed = (int) (Math.random()*10+10);
		dir = (int)(Math.random()*4+1);
		img = new ImageIcon("plane/firstboss"+num+".png").getImage();
	}
	
	public void draw(Graphics g){
		g.drawImage(img, ballx, bally, null);	
	}
	
	public void move(){				//Ð¡Çò·´µ¯
		if(dir == 1){
			ballx += 10;
			bally -= 10;
		}
		if(dir == 2){
			ballx += 10;
			bally += 10;
		}
		if(dir == 3){
			ballx -= 10;
			bally += 10;
		}
		if(dir == 4){
			ballx -= 10;
			bally -= 10;
		}
		if(ballx > 360){
			if(dir == 2) dir = 3;
			else dir = 4;
		}
		if(ballx < 0){
			if(dir == 4) dir = 1;
			else dir = 2;
		}
		if(bally > 540){
			if(dir == 3) dir = 4;
			else dir = 1;
		}
		if(bally < 0){
			if(dir == 1) dir = 2;
			else dir = 3;
		}
		
		/*try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
	
}
