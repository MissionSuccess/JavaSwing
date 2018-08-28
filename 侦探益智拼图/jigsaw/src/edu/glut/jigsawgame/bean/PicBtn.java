package edu.glut.jigsawgame.bean;

import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JButton;

public class PicBtn extends JButton{
	/**��ť���*/
	private static int width;
	/**��ť�߶�*/
	private static int height;
	/**��ťλ��*/
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
	 * �ƶ�
	 * @param dir
	 */
	public void move(Direction dir) {
		Rectangle rec = this.getBounds();
		switch(dir)
        {
        case UP://�����ƶ����ı�����
            this.setLocation(rec.x, rec.y + height);
            break;
        case DOWN://�����ƶ�
            this.setLocation(rec.x, rec.y - height);
            break;
        case LEFT://�����ƶ�
            this.setLocation(rec.x - width, rec.y);
            break;
        case RIGHT://�����ƶ�
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
	 * ���ð�ťͼ��
	 * @param icon
	 */
	public void setImg(Icon icon) {
		this.setIcon(icon);
	}
}
