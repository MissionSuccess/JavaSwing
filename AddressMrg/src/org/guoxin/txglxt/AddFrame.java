package org.guoxin.txglxt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 添加联系人窗口
 * @author GuoXin
 */
public class AddFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**画布*/
	private JPanel jp = new JPanel();
	/**标题1标签*/
	private JLabel label1 = new JLabel("添加"); 
	/**标题2标签*/
	private JLabel label2= new JLabel("联系人"); 
	/**信息标签*/
	private JLabel[] info = new JLabel[7]; 
	/**信息文本*/
	private JTextField[]  text = new JTextField[7]; 
	/**确定按钮*/
	private JButton b1 = new JButton("确定");
	/**返回按钮*/
	private JButton b2 = new JButton("返回");
	/**字体*/
	private Font f = new Font("黑体",Font.BOLD,14);
	/**文本框高度*/
	private int hight = 25;
	/**读*/
	private BufferedReader in = null;
	/**写*/
	private BufferedWriter out = null;
	/**用户名*/
	private String nameStr = null;
	
	public AddFrame(JFrame jf,String str) {
		nameStr = str;
		this.setTitle("通讯管理系统("+str+")");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		jp.setLayout(null);
		
		//标题
		label1.setFont(new Font("楷体",Font.BOLD,24));
		label1.setBounds(35, 30, 200, 50);
		label2.setFont(new Font("楷体",Font.BOLD,24));
		label2.setBounds(20, 60, 200, 50);
		//姓名
		info[0] = new JLabel("*姓名");
		text[0] = new JTextField("");
		info[0].setFont(f);
		info[0].setBounds(120, 20, 50, hight);
		text[0].setBounds(175,20,160,hight);
		//手机号
		info[1] = new JLabel("*手机");
		text[1] = new JTextField("");
		info[1].setFont(f);
		info[1].setBounds(120, 55, 50, hight);
		text[1].setBounds(175,55,160,hight);
		//固定电话
		info[2] = new JLabel("电话");
		text[2] = new JTextField("");
		info[2].setFont(f);
		info[2].setBounds(120, 90, 50, hight);
		text[2].setBounds(175,90,160,hight);
		//E-mail
		info[3] = new JLabel("E-mail");
		text[3] = new JTextField("");
		info[3].setFont(f);
		info[3].setBounds(120, 125, 50, hight);
		text[3].setBounds(175,125,160,hight);
		//QQ
		info[4] = new JLabel("QQ");
		text[4] = new JTextField("");
		info[4].setFont(f);
		info[4].setBounds(120, 160, 50, hight);
		text[4].setBounds(175,160,160,hight);
		//工作
		info[5] = new JLabel("工作");
		text[5] = new JTextField("");
		info[5].setFont(f);
		info[5].setBounds(120, 195, 50, hight);
		text[5].setBounds(175,195,160,hight);
		//通讯地址
		info[6] = new JLabel("地址");
		text[6] = new JTextField("");
		info[6].setFont(f);
		info[6].setBounds(120, 230, 50, hight);
		text[6].setBounds(175,230,160,hight);
		
		//确定按钮
		b1.setFont(f);
		b1.setBounds(20, 150, 80, 40);
		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                methodB1(jf);
            }
        });
		b1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER) {
					methodB1(jf);
				}
			}
		});
		//返回按钮
		b2.setFont(f);
		b2.setBounds(20, 200, 80, 40);
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                methodB2(jf);
            }
        });
		//加入键盘监听
		for(int i = 0; i < 7; i++) {
			text[i].addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == KeyEvent.VK_ENTER) {
						methodB1(jf);
					}
				}
			});
		}
		//添加到画布
		jp.add(label1);
		jp.add(label2);
		jp.add(b1);
		jp.add(b2);
		for(int i = 0; i <= 6; i++) {
			jp.add(info[i]);
			jp.add(text[i]);
		}
		this.add(jp);
		
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
	
	public void methodB1(JFrame jf) {
		//判断姓名和手机号是否符合要求
		if(text[0].getText().equals("")|| text[1].getText().equals("")) {
			JOptionPane.showMessageDialog(null, "姓名和手机号不能为空！","提示",JOptionPane.ERROR_MESSAGE);
			return;
		}else if(text[0].getText().length() < 2 || text[0].getText().length() > 6) {
			JOptionPane.showMessageDialog(null, "姓名至少2个字符，但不能超过6个字符！","提示",JOptionPane.ERROR_MESSAGE);
			return;
		}else if(text[1].getText().length() != 11) {
			JOptionPane.showMessageDialog(null, "手机号必须为11位!","提示",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//存数据
		try{
			in = new BufferedReader(new FileReader("C://AddressMrgData//data//"+nameStr+".txt"));
			out = new BufferedWriter(new FileWriter("C://AddressMrgData//data//"+nameStr+".txt",true));
			String s = null;
			while((s = in.readLine()) != null) {
				if(text[0].getText().equals(s)) {
					JOptionPane.showMessageDialog(null, "该联系人已存在！","提示",JOptionPane.CANCEL_OPTION);
					return;
				}
				for(int i = 1; i <= 6; i++) {
					s = in.readLine();
				}
			}
			for(int i = 0; i < 7; i++) {
				out.write(text[i].getText());
				out.newLine();
			}
			JOptionPane.showMessageDialog(null, "添加成功！","提示",JOptionPane.INFORMATION_MESSAGE);
			for(int i = 0; i < 7; i++) {
				text[i].setText("");
			}
			text[0].requestFocus();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null) {
					in.close();
				}
				if(out != null) {
					out.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void methodB2(JFrame jf) {
		jf.setVisible(true);
		this.dispose();
	}
}
