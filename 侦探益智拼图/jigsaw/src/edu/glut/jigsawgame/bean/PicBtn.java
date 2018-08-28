package edu.glut.jigsawgame.bean;

import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JButton;

public class PicBtn extends JButton{
	/**按钮宽度*/
	private static int width;
	/**按钮高度*/
	private static int height;
	/**按钮位置*/
	public int index;
	
	public PicBtn() {}
	
	public PicBtn(Icon icon, int index, int width, int height) {
		this.setIcon(icon);
		this.index = index;
		this.width = width;
		this.height = height;
		this.setSize(width, height);
	}
	
	/**
	 * 移动
	 * @param dir
	 */
	public void move(Direction dir) {
		Rectangle rec = this.getBounds();
		switch(dir)
        {
        case UP://向上移动，改变坐标
            this.setLocation(rec.x, rec.y + height);
            break;
        case DOWN://向下移动
            this.setLocation(rec.x, rec.y - height);
            break;
        case LEFT://向左移动
            this.setLocation(rec.x - width, rec.y);
            break;
        case RIGHT://向右移动
            this.setLocation(rec.x + width, rec.y);
            break;
        }
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getX() {
		return this.getBounds().x;
	}
	
	public int getY()
    {
        return this.getBounds().y;
    }
	
	/**
	 * 设置按钮图标
	 * @param icon
	 */
	public void setImg(Icon icon) {
		this.setIcon(icon);
	}
}
