package org.guoxin.feiji;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Mypanel extends JPanel implements MouseListener,MouseMotionListener,KeyListener{
	
	int state = START;														//状态
	public static final int START = 0;										//开始
	public static final int RUNNING = 1;									//运行
	public static final int PAUST = 2;										//暂停
	public static final int GAMEOVER = 3;									//游戏结束
	
	public static final int grade = 100;
	int bkx=0,bky=-5400;
	int mousex=180, mousey=500;
	int mousexx=180, mouseyy=500;
	int ballx=200,bally=400;
	int bossx=100,bossy=0;
	int r=30;
	int score = 0;
	int life = 5;
	int bosslife = 500;
	int herostate = 0;
	
	Eplane s = new Eplane();
	ArrayList<Eplane> Eplanes = new ArrayList<Eplane>();					//敌机容器
	ArrayList<Mybullet> bullets = new ArrayList<Mybullet>();				//英雄机子弹容器
	ArrayList<Missile> Missiles = new ArrayList<Missile>();					//导弹子弹容器
	ArrayList<Ball> Balls = new ArrayList<Ball>();							//小球容器
	ArrayList<BOSS> BOSS1 = new ArrayList<BOSS>();							//BOSS容器
	ArrayList<Ball> Balla = new ArrayList<Ball>();							//彩球容器
	public void paint(Graphics g) {
		super.paint(g);
		
		Image bk = new ImageIcon("plane/bk.jpg").getImage();				//背景
		Image me = new ImageIcon("plane/hero.GIF").getImage();				//英雄机
		Image heroover = new ImageIcon("plane/hero1.png").getImage();	
		Image state0 = new ImageIcon("plane/start.png").getImage();			//开始
		Image state2 = new ImageIcon("plane/pause.png").getImage();			//暂停
		Image state3 = new ImageIcon("plane/gameover.png").getImage();		//游戏结束
		g.drawImage(bk, bkx, bky, null);									//绘制背景
		g.drawImage(me, mousex, mousey, null);								//绘制英雄机
		
		if(state == START){													//游戏准备
			g.drawImage(state0, 0, 0, null);
			g.setColor(Color.green);										//字体颜色
			Font f = new Font("黑体", Font.BOLD, 20);							//字体属性
			g.setFont(f);
			g.drawString("...按  空格  开始游戏！...", 40, 400);
			g.drawString("鼠标：移动", 120, 90);
			g.drawString("空格：长按连发子弹", 120, 110);
			g.drawString("绿球：回复血量", 120, 130);
			g.drawString("彩球：干扰视线", 120, 150);
		}
		if(state == PAUST){													//游戏暂停
			g.drawImage(state2, 0, 0, null);
		}
		if(state == GAMEOVER){												//游戏结束
				Score S = new Score(score);
				bullets.clear();
				Eplanes.clear();
				Missiles.clear();
				Balls.clear();
				BOSS1.clear();
				Balla.clear();
				g.drawImage(state3, 0, 0, null);
				g.setColor(Color.black);									//字体颜色
				Font f = new Font("黑体", Font.BOLD, 24);						//字体属性
				g.setFont(f);
				g.drawString(S.toString(), 220, 130);						//段位
				g.drawString("...扣 1 重新开始！...", 70, 400);
				S.draw(g);
				repaint();
		}
		
		Image lifes = new ImageIcon("greenblood/"+life+".png").getImage();	//绘制血量
		g.drawImage(lifes, 270, 25, null);
		
		if(herostate == 1){													//英雄机状态
			g.drawImage(heroover, mousex, mousey, 100,100,null);
			herostate = 0;
		}
		
		g.setColor(Color.red);												//字体颜色
		Font f = new Font("黑体", Font.BOLD, 26);								//字体属性
		g.setFont(f);
		g.drawString("分数："+score, 20, 35);									//输出分数
		Font f1 = new Font("黑体", Font.BOLD, 20);
		g.setFont(f1);
		g.drawString("生命值：", 190, 40);
		
		if(score >= 10000 && bosslife == 500){								//产生BOSS
			if (BOSS1.size()==0) {
				BOSS eb = new BOSS();
				BOSS1.add(eb);
			}
		}
		if(BOSS1.size()!=0){												//画BOSS
			BOSS1.get(0).draw(g);
		}
		
		for (int i = 0; i < Eplanes.size(); i++) {							//绘制敌机
			Eplanes.get(i).draw(g);
		}
		
		for (int i = 0; i < Missiles.size(); i++) {							//绘制导弹
			Missiles.get(i).draw(g);
		}
		
		for (int i = 0; i < Balls.size(); i++) {							//绘制绿球
			Balls.get(i).draw(g);
		}
		for (int i = 0; i < Balla.size(); i++) {							//绘制彩球
			Balla.get(i).draw(g);
		}
		
		for (int i = 0; i < bullets.size(); i++) {							//绘制英雄机子弹
			bullets.get(i).draw(g);
		}
	
	}// paint
	
	
	public void mouseClicked(MouseEvent e) {
		/*if(state == START){
			state = RUNNING;
		}
		if(state != GAMEOVER){
			Mybullet b = new Mybullet(mousex,mousey);
			bullets.add(b);
		}*/
	}
	public void mousePressed(MouseEvent e) {
				
	}
	public void mouseReleased(MouseEvent e) {
				
	}
	public void mouseEntered(MouseEvent e) {
		if(state == PAUST){
			state = RUNNING;
		}
	}
	public void mouseExited(MouseEvent e) {
		if(state == RUNNING){
			state = PAUST;
		}
	}
	public void mouseDragged(MouseEvent e) {
		
	}
	public void mouseMoved(MouseEvent e) {
		if(state != GAMEOVER && state != START){
			mousex = e.getX()-r;
			mousey = e.getY()-2*r;
			repaint();
		}else{
			mousex = 180; mousey = 450;
			repaint();
		}
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_SPACE == e.getKeyCode()){
			if(state == START){
				state = RUNNING;
			}
			if(state != GAMEOVER){
				Mybullet b = new Mybullet(mousex,mousey);
				bullets.add(b);
			}
		}
		if(state == GAMEOVER){
			if(e.getKeyCode() == KeyEvent.VK_1){
				state = START;
				life = 5;
				bosslife = 500;
				score = 0;
				repaint();
				Move();
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void Move(){
				
		new Thread(){
			public void run() {
				int count = 0, daodan = 0, difficulty=0;
				while(true){
					System.out.println();
					if(state == RUNNING){
						count++; daodan++;
						difficulty = score/1000;
						if(score >= 15000) difficulty = 5;
						if(count%(16-difficulty) == 0){
							Eplane dd = new Eplane();				//生成敌机
							Eplanes.add(dd);	
						}	
						
						if(count%500 == 0){							//生成绿球
							Ball bb = new Ball(0);
							Balls.add(bb);
						}
						
						if(count%400 == 0){							//生成彩球
							Ball bb = new Ball((int)(Math.random()*2+2));
							Balla.add(bb);
						}
						
						for (int i = 0; i < Balls.size(); i++) {  		//移动绿球
							Balls.get(i).move();
							repaint();
						}
						for (int i = 0; i < Balla.size(); i++) {  		//移动彩球
							Balla.get(i).move();
							repaint();
						}
						
						if(BOSS1.size()!=0){							//BOSS移动
							BOSS1.get(0).move();
						}
						for(int i=0; i<Eplanes.size(); i++){			//敌机移动
							Eplane d = Eplanes.get(i);
							d.move();
						}
						if(daodan%(45-score/1000) == 0){						//生成导弹
							Missile eb = new Missile();
							Missiles.add(eb);
						}
						for (int i = 0; i < Missiles.size(); i++) {				//移动导弹
							Missiles.get(i).move();
						}
							
						for (int i = 0; i < bullets.size(); i++) {  			//英雄机子弹移动
							bullets.get(i).move();
						}
							
						for (int j = 0; j < bullets.size(); j++) {				//英雄机子弹攻击敌机
							Mybullet B = bullets.get(j);
							for (int i = 0; i < Eplanes.size(); i++) {
								Eplane E = Eplanes.get(i);
								int xx = E.img.getWidth(null);					//敌机宽度
								int yy = E.img.getHeight(null);					//敌机高度
								int xx1 = B.img.getWidth(null);					//英雄机子弹宽度
								int yy1 = B.img.getHeight(null);				//英雄机子弹高度
								
								if(E.x<B.x && E.x+xx>B.x && E.y<B.y && E.y+yy>B.y || E.x<B.x+xx1 && E.x+xx>B.x+xx1 && E.y<B.y+yy1 && E.y+yy>B.y+yy1){
									score += grade;
									bullets.remove(j);
									Eplanes.remove(i);								
									break;
								}
								
							}
						}
						if(BOSS1.size() != 0){
							for (int j = 0; j < bullets.size(); j++) {				//英雄机子弹攻击BOSS
								Mybullet B = bullets.get(j);
									BOSS E = BOSS1.get(0);
									int xx = E.img.getWidth(null);					//BOSS宽度
									int yy = E.img.getHeight(null);					//BOSS高度
									int xx1 = B.img.getWidth(null);					//英雄机子弹宽度
									int yy1 = B.img.getHeight(null);				//英雄机子弹高度
									
									if(E.x<B.x && E.x+xx>B.x && E.y<B.y && E.y+yy>B.y || E.x<B.x+xx1 && E.x+xx>B.x+xx1 && E.y<B.y+yy1 && E.y+yy>B.y+yy1){
										score += 20;
										bullets.remove(j);
										bosslife--;
										break;
									}
									if(bosslife == 0){
										BOSS1.clear();
										break;
									}
									
							}
						}
						for (int i = 0; i < bullets.size(); i++) {				//清理飞出屏幕英雄机子弹内存
							if(bullets.get(i).y < 0){
								bullets.remove(i);
							}
						}
						
						for (int i = 0; i < Eplanes.size(); i++) {				//清理飞出屏幕敌机子弹内存
							if(Eplanes.get(i).y > 600){
								Eplanes.remove(i);
							}
						}
						if(BOSS1.size() != 0){
							for (int i = 0; i < BOSS1.size(); i++) {			//清理飞出屏幕BOSS子弹内存
								if(BOSS1.get(i).y > 600){
									BOSS1.remove(i);
								}
							}
						}
						for (int i = 0; i < Missiles.size(); i++) {				//导弹与英雄机撞击
							Missile eb = Missiles.get(i);
							int xx = eb.img.getWidth(null);
							int yy = eb.img.getHeight(null);
							if(eb.y > 600) {
								Missiles.remove(i);
								break;
							}
							if(mousex-15<eb.x && mousex+30>eb.x && mousey-30<eb.y && mousey+26>eb.y || mousex-15<eb.x+xx && mousex+35>eb.x+xx && mousey-30<eb.y+yy && mousey+26>eb.y+yy){
								life--;
								Missiles.remove(i);
								herostate = 1;
							}
							
						}
						for (int i = 0; i < Eplanes.size(); i++) {					//敌机子弹与英雄机撞击
							for (int j = 0; j < Eplanes.get(i).list.size(); j++) {
								Ebullet eb = Eplanes.get(i).list.get(j);
								int xx = eb.img.getWidth(null);
								int yy = eb.img.getHeight(null);
								if(eb.y > 600) {									//释放飞出屏幕子弹
									Eplanes.get(i).list.remove(j);
									break;
								}
								
								if(mousex-15<eb.x && mousex+35>eb.x && mousey-15<eb.y && mousey+26>eb.y || mousex-15<eb.x+xx && mousex+30>eb.x+xx && mousey-15<eb.y+yy && mousey+26>eb.y+yy){
									life--;
									Eplanes.get(i).list.remove(j);
									herostate = 1;
								}
							}
						}
						if(BOSS1.size() != 0){
							for (int j = 0; j < BOSS1.get(0).list.size(); j++) {	//BOSS子弹与英雄机撞击
								BossBullet eb = BOSS1.get(0).list.get(j);
								int xx = eb.img.getWidth(null);
								int yy = eb.img.getHeight(null);
								if(eb.y > 600) {
									BOSS1.get(0).list.remove(j);
									break;
								}
								
								if(mousex<eb.x1 && mousex+46>eb.x1 && mousey+20<eb.y1 && mousey+53>eb.y1 || mousex<eb.x1+xx && mousex+46>eb.x1+xx && mousey+20<eb.y1+yy && mousey+53>eb.y1+yy){
									life--;
									score++;
									BOSS1.get(0).list.remove(j);
									herostate = 1;
								}
							}
						}
							
							for (int i = 0; i < Balls.size(); i++) {				//绿球与英雄机撞击
								Ball eb = Balls.get(i);
								int xx = eb.img.getWidth(null);
								int yy = eb.img.getHeight(null);
								if(eb.bally > 600) {
									Balls.remove(i);
									break;
								}
								if(mousex-15<eb.ballx && mousex+30>eb.ballx && mousey-30<eb.bally && mousey+26>eb.bally || mousex-15<eb.ballx+xx && mousex+35>eb.ballx+xx && mousey-30<eb.bally+yy && mousey+26>eb.bally+yy){
									if(life < 5) life++;
									Balls.remove(i);
								}
								
							}
						
						for (int i = 0; i < Eplanes.size(); i++) {				//敌机与英雄机撞击
							Eplane eb = Eplanes.get(i);
							int xx = eb.img.getWidth(null);
							int yy = eb.img.getHeight(null);
							if(eb.y > 600) {
								Eplanes.remove(i);
								break;
							}
							if(mousex-15<eb.x && mousex+30>eb.x && mousey-30<eb.y && mousey+26>eb.y || mousex-15<eb.x+xx && mousex+35>eb.x+xx && mousey-30<eb.y+yy && mousey+26>eb.y+yy){
								life--;
								Eplanes.remove(i);
								herostate = 1;
							}
							
						}
						
						if (life == 0) {
							state = GAMEOVER;
							this.stop();
						}
						
						repaint();
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
			};
		}.start();
		
		new Thread(){										//背景运动线程
			public void run() {
				while(true){
					bky += 1;
					if(bky == 0) 
						bky = -5400;
					repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		
	}	
}
