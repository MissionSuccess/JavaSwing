package org.guoxin.feiji;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Score {
	private int score;
	private int num;
	Image img;
	public Score(){}
	public Score(int score){
		this.score = score;
	}
	//¢ñ ¢ò ¢ó  ¢ô  ¢õ
	public String toString(){
		String s = null;
		if(score <=400) s = "Ó¢ÓÂ»ÆÍ­ ¢õ";
		else if(score>400 && score<=800) s = "Ó¢ÓÂ»ÆÍ­ ¢ô";
		else if(score>800 && score<=1200) s = "Ó¢ÓÂ»ÆÍ­  ¢ó";
		else if(score>1200 && score<=1600) s = "Ó¢ÓÂ»ÆÍ­  ¢ò";
		else if(score>1600 && score<=2000) s = "Ó¢ÓÂ»ÆÍ­ ¢ñ";
		
		else if(score>2000 && score<=2400) s = "²»Çü°×Òø¢õ";
		else if(score>2400 && score<=2800) s = "²»Çü°×Òø ¢ô";
		else if(score>2800 && score<=3200) s = "²»Çü°×Òø  ¢ó";
		else if(score>3200 && score<=3600) s = "²»Çü°×Òø ¢ò";
		else if(score>3600 && score<=4000) s = "²»Çü°×Òø¢ñ";
		
		else if(score>4000 && score<=4500) s = "ÈÙÒ«»Æ½ð¢õ";
		else if(score>4500 && score<=5000) s = "ÈÙÒ«»Æ½ð ¢ô";
		else if(score>5000 && score<=5500) s = "ÈÙÒ«»Æ½ð  ¢ó";
		else if(score>5500 && score<=6000) s = "ÈÙÒ«»Æ½ð ¢ò";
		else if(score>6000 && score<=6500) s = "ÈÙÒ«»Æ½ð¢ñ";
		
		else if(score>6500 && score<=7200) s = "»ª¹ó²¬½ð¢õ";
		else if(score>7200 && score<=7900) s = "»ª¹ó²¬½ð ¢ô";
		else if(score>7900 && score<=8600) s = "»ª¹ó²¬½ð  ¢ó";
		else if(score>8600 && score<=9300) s = "»ª¹ó²¬½ð ¢ò";
		else if(score>9300 && score<=10000) s = "»ª¹ó²¬½ð¢ñ";
		
		else if(score>10000 && score<=11500) s = "è­è²×êÊ¯¢õ";
		else if(score>11500 && score<=13000) s = "è­è²×êÊ¯ ¢ô";
		else if(score>13000 && score<=14500) s = "è­è²×êÊ¯  ¢ó";
		else if(score>14500 && score<=16000) s = "è­è²×êÊ¯ ¢ò";
		else if(score>16000 && score<=17500) s = "è­è²×êÊ¯¢ñ";
		
		else if(score>17500 && score<=25000) s = "³¬·²´óÊ¦";
		else if(score>25000) s = "×îÇ¿ÍõÕß";
		return s;
	}
	
	public void draw(Graphics g){
		if(score<=2000) num = 1;
		else if(score>2000 && score<=4000) num = 2;
		else if(score>4000 && score<=6500) num = 3;
		else if(score>6500 && score<=10000) num = 4;
		else if(score>10000 && score<=17500) num = 5;
		else if(score>17500 && score<=25000) num = 6;
		else if(score>25000) num = 7;
		img = new ImageIcon("duan/"+num+".png").getImage();
		g.drawImage(img, 50, 50, null);
	}
}
