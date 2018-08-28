package edu.glut.jigsawgame.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.glut.jigsawgame.bean.Direction;
import edu.glut.jigsawgame.bean.PicBtn;
import edu.glut.jigsawgame.service.Level;

/**
 * ��Ϸ������
 * @author GuoX
 *
 */
public class GamePanel extends JPanel implements MouseListener, KeyListener{
	/**�հ׿鰴ť*/
	private static PicBtn blankBtn = null;
	/**�п���Ŀ*/
    private static int row = 3;
    /**�п���Ŀ*/
    private static int col = 3;//�������ƴͼ������
    /**�鰴ť*/
    private static PicBtn pb[] = new PicBtn[6*6];
    /**ͼƬ���*/
    private static int imageWidth;
    /**ͼƬ�߶�*/
    private static int imageHeight;
	
    public GamePanel(int size) {
    	row = size;
    	col = size;
		this.setLayout(null);
		this.setSize(420, 420);
		this.setLocation(0, 0);
		init();
		OutOfOrder();
	}
    
    public void init()//��ʼ��������¹���--���ͼ����и���ͼ��ͼ���ת������ɰ�ťͼ�����ӣ�����ť��ӵ�����ϣ����Ҹ�ÿһ����ť��Ӽ�������
    {
        int num = 0;
        BufferedImage buf = null;
        BufferedImage bufnew = null;
        ImageIcon icon = null;
        int width = 0;
        int height = 0;
        try
        {
            buf = ImageIO.read(new File("src/images/"+Level.level+".jpg"));//��ȡ�ļ�ͼ��
            imageWidth = buf.getWidth();
            imageHeight = buf.getHeight();
            width = imageWidth/col;
            height = imageHeight/row;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                num = i*col+j;//��ʾ��ǰ���ͼ�������id���������е��±�
                if(num < row*col-1)
                {
                    bufnew = buf.getSubimage(width*j, height*i, width, height);
                    icon = new ImageIcon(bufnew);//��ͼ��ת����ͼ��
                }
                else//ʹ���һ��ͼ��Ϊ�հ�ͼ��
                {
                    icon = new ImageIcon("src/images/kong.jpg");//һ�ſհ�ͼ��
                }
                pb[num] = new PicBtn(icon, num, width, height);//���ͼ�굽ÿһ��BUTTON��ť����
                pb[num].setLocation(width*j, height*i);
            }
        }
        blankBtn = pb[row*col-1];//��ʼ���հ׸�
    	for(int i = 0; i < row*col; i++)
        {
            this.add(pb[i]);//��ÿһ����ť��ӵ���ǰ����������
            if(i < row*col-1)
                pb[i].addMouseListener(this);//�հ׸���Ӽ�������
        }
    }
    
    /**
     * �������ð�ťͼ�����ﵽ�л�ͼƬЧ��
     */
    public static void setImg() {
    	int num = 0;
        BufferedImage buf = null;
        BufferedImage bufnew = null;
        ImageIcon icon = null;
        int width = 0;
        int height = 0;
        try
        {
            buf = ImageIO.read(new File("src/images/"+Level.level+".jpg"));//��ȡ�ļ�ͼ��
            imageWidth = buf.getWidth();
            imageHeight = buf.getHeight();
            width = imageWidth/col;
            height = imageHeight/row;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                num = i*col+j;//��ʾ��ǰ���ͼ�������id���������е��±�
                if(num < row*col-1)
                {
                    bufnew = buf.getSubimage(width*j, height*i, width, height);
                    icon = new ImageIcon(bufnew);//��ͼ��ת����ͼ��
                }
                else//ʹ���һ��ͼ��Ϊ�հ�ͼ��
                {
                    icon = new ImageIcon("src/images/kong.jpg");//һ�ſհ�ͼ��
                }
                pb[num].setImg(icon);
            }
        }
    }

    
    public static void OutOfOrder()//����----����ͼƬ���Ų�˳��
    {
    	Random random = new Random();
    	for(int i = 0 ; i < row*col*1000 ; i++)
    	{
    		int m = random.nextInt(row*col);
    		PicBtn t = pb[m];
            int x = blankBtn.getX();
            int y = blankBtn.getY();
            if(t.getY() == y && t.getX() + imageWidth/col == x)//ͼ��������
            {
                t.move(Direction.RIGHT);
                blankBtn.move(Direction.LEFT);
            }
            else if(t.getY() == y && t.getX() - imageWidth/col == x)//ͼ��������
            {
                t.move(Direction.LEFT);
                blankBtn.move(Direction.RIGHT);
            }
            else if(t.getX() == x && t.getY() + imageHeight/row == y)//ͼ��������
            {
                t.move(Direction.UP);
                blankBtn.move(Direction.DOWN);
            }
            else if(t.getX() == x && t.getY() - imageHeight/row == y)//ͼ��������
            {
                t.move(Direction.DOWN);
                blankBtn.move(Direction.UP);
            }		
    	}
    } 
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * �ƶ�����
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		PicBtn t = (PicBtn) e.getSource();
        int x = blankBtn.getX();
        int y = blankBtn.getY();
        MidPanel.timer.start();
        MidPanel.jbPause.setIcon(new ImageIcon("src/images/��ͣ.png"));
        MidPanel.b = true;
        if(t.getY() == y && t.getX() + imageWidth/col == x)//ͼ��������
        {
            t.move(Direction.RIGHT);
            blankBtn.move(Direction.LEFT);
        }
        else if(t.getY() == y && t.getX() - imageWidth/col == x)//ͼ��������
        {
            t.move(Direction.LEFT);
            blankBtn.move(Direction.RIGHT);
        }
        else if(t.getX() == x && t.getY() + imageHeight/row == y)//ͼ��������
        {
            t.move(Direction.UP);
            blankBtn.move(Direction.DOWN);
        }
        else if(t.getX() == x && t.getY() - imageHeight/row == y)//ͼ��������
        {
            t.move(Direction.DOWN);
            blankBtn.move(Direction.UP);
        }		
        if(isWin()) {
        	 MidPanel.timer.stop();
             MidPanel.jbPause.setIcon(new ImageIcon("src/images/��ʼ.png"));
             MidPanel.b = false;
        	JOptionPane.showMessageDialog(null, "�����ˣ�\n�����ʱΪ��"+MidPanel.nowStr, "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        }
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * �ж��Ƿ��ʤ
	 * @return
	 */
	public boolean isWin() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				int num = i*col+j;
				int bntX = pb[num].getX();
				int bntY = pb[num].getY();
				int nowX = 420/col*j;
				int nowY = 420/row*i;
				
				if(bntX != nowX || bntY != nowY) {
					return false;
				}
			}
		}
		return true;
	}
	
}
