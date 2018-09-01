package org.lanqiao.jdmrg.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.lanqiao.jdmrg.view.*;
//import bean.Roomer;
//import dao.AddClient;
//import dao.FindClient;
//import dao.UpdateClient;
//import view.CanvasFrame;
//import view.QTFrame;

import javax.swing.JLabel;
import javax.swing.JButton;
/**
 * 主程序(前台界面)
 * 
 * @author why
 */

public class CanvasFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	/**画布*/
	private JPanel jp = new JPanel();
	
	public static JPanel p2=new JPanel();
	
	public static JPanel p1=new JPanel();
	
	public static JFrame jfff;
	
    public CanvasFrame() {
    	jfff = this;
    	this.setSize(1056, 668);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
    	this.setLayout(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	p1.setLayout(null);
    	p2.setLayout(null);
    	
    	p1.setSize(210, 640);
    	p2.setSize(840, 640);
    	
    	p1.setLocation(0, 0);
    	p2.setLocation(210, 0);
    	
    	this.add(p1);
    	this.add(p2);
    	this.setVisible(true);
    }
    
    public static void  addPanelLeft(JPanel p) {
    	p1.add(p);
    	p1.repaint();
    }
    
    public static void delePanelRight(JPanel p) {
    	p2.removeAll();
    	p2.add(p);
    	p2.repaint();
    }
    
    public static void addPanelRight(JPanel p) {
    	p2.add(p);
    	p2.repaint();
    }
    
    public static void delePanel(JPanel p,JPanel p3) {
    	p2.remove(p);
    	p2.add(p3);
    	p2.repaint();
    }
    
//    public static void main(String[] args) {
//    	
//    	    new CanvasFrame();
//    	   
//              addPanelLeft(new QTFrame());
//    	      //addPanel(new FindClient(new Roomer("", "", "", "", "","", "", 1,"","")));;
//             
//	}
}
