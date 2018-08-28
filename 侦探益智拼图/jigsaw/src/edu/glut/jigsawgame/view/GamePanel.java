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
 * 游戏主画布
 * @author GuoX
 *
 */
public class GamePanel extends JPanel implements MouseListener, KeyListener{
	/**空白块按钮*/
	private static PicBtn blankBtn = null;
	/**行块数目*/
    private static int row = 3;
    /**列块数目*/
    private static int col = 3;//设置这个拼图的行列
    /**块按钮*/
    private static PicBtn pb[] = new PicBtn[6*6];
    /**图片宽度*/
    private static int imageWidth;
    /**图片高度*/
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
    
    public void init()//初始化完成以下功能--完成图像的切割，完成图像到图标的转换，完成按钮图标的添加，将按钮添加到面板上，并且给每一个按钮添加监听机制
    {
        int num = 0;
        BufferedImage buf = null;
        BufferedImage bufnew = null;
        ImageIcon icon = null;
        int width = 0;
        int height = 0;
        try
        {
            buf = ImageIO.read(new File("src/images/"+Level.level+".jpg"));//读取文件图像
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
                num = i*col+j;//表示当前这个图像的坐标id，在数组中的下标
                if(num < row*col-1)
                {
                    bufnew = buf.getSubimage(width*j, height*i, width, height);
                    icon = new ImageIcon(bufnew);//将图像转化成图标
                }
                else//使最后一张图像为空白图像
                {
                    icon = new ImageIcon("src/images/kong.jpg");//一张空白图像
                }
                pb[num] = new PicBtn(icon, num, width, height);//添加图标到每一个BUTTON按钮上面
                pb[num].setLocation(width*j, height*i);
            }
        }
        blankBtn = pb[row*col-1];//初始化空白格
    	for(int i = 0; i < row*col; i++)
        {
            this.add(pb[i]);//将每一个按钮添加到当前这个面板上面
            if(i < row*col-1)
                pb[i].addMouseListener(this);//空白格不添加监听机制
        }
    }
    
    /**
     * 重新设置按钮图案，达到切换图片效果
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
            buf = ImageIO.read(new File("src/images/"+Level.level+".jpg"));//读取文件图像
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
                num = i*col+j;//表示当前这个图像的坐标id，在数组中的下标
                if(num < row*col-1)
                {
                    bufnew = buf.getSubimage(width*j, height*i, width, height);
                    icon = new ImageIcon(bufnew);//将图像转化成图标
                }
                else//使最后一张图像为空白图像
                {
                    icon = new ImageIcon("src/images/kong.jpg");//一张空白图像
                }
                pb[num].setImg(icon);
            }
        }
    }

    
    public static void OutOfOrder()//乱序----打乱图片的排布顺序
    {
    	Random random = new Random();
    	for(int i = 0 ; i < row*col*1000 ; i++)
    	{
    		int m = random.nextInt(row*col);
    		PicBtn t = pb[m];
            int x = blankBtn.getX();
            int y = blankBtn.getY();
            if(t.getY() == y && t.getX() + imageWidth/col == x)//图像向右走
            {
                t.move(Direction.RIGHT);
                blankBtn.move(Direction.LEFT);
            }
            else if(t.getY() == y && t.getX() - imageWidth/col == x)//图像向左走
            {
                t.move(Direction.LEFT);
                blankBtn.move(Direction.RIGHT);
            }
            else if(t.getX() == x && t.getY() + imageHeight/row == y)//图像向上走
            {
                t.move(Direction.UP);
                blankBtn.move(Direction.DOWN);
            }
            else if(t.getX() == x && t.getY() - imageHeight/row == y)//图像向下走
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
	 * 移动操作
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		PicBtn t = (PicBtn) e.getSource();
        int x = blankBtn.getX();
        int y = blankBtn.getY();
        MidPanel.timer.start();
        MidPanel.jbPause.setIcon(new ImageIcon("src/images/暂停.png"));
        MidPanel.b = true;
        if(t.getY() == y && t.getX() + imageWidth/col == x)//图像向右走
        {
            t.move(Direction.RIGHT);
            blankBtn.move(Direction.LEFT);
        }
        else if(t.getY() == y && t.getX() - imageWidth/col == x)//图像向左走
        {
            t.move(Direction.LEFT);
            blankBtn.move(Direction.RIGHT);
        }
        else if(t.getX() == x && t.getY() + imageHeight/row == y)//图像向上走
        {
            t.move(Direction.UP);
            blankBtn.move(Direction.DOWN);
        }
        else if(t.getX() == x && t.getY() - imageHeight/row == y)//图像向下走
        {
            t.move(Direction.DOWN);
            blankBtn.move(Direction.UP);
        }		
        if(isWin()) {
        	 MidPanel.timer.stop();
             MidPanel.jbPause.setIcon(new ImageIcon("src/images/开始.png"));
             MidPanel.b = false;
        	JOptionPane.showMessageDialog(null, "厉害了！\n你的用时为："+MidPanel.nowStr, "提示", JOptionPane.INFORMATION_MESSAGE);
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
	 * 判断是否获胜
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
