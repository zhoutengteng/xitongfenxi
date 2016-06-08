package com.zhoutengteng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Scroll extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scroll $ = new Scroll();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Scroll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		Scroll $ = this;
		$.setVisible(true);
		$.getContentPane().setLayout(null);
        $.setSize(800, 600);
        $.setVisible(true);
        $.setResizable(false);
        $.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList list = new JList();
        list.setListData(new String[]{"1", "2" ,"3", "3" ,"5","1", "2" ,"3", "3" ,"6"});
        JScrollPane jScrollPane = new JScrollPane(list);
        jScrollPane.setLocation(0, 0);
        jScrollPane.setSize(100, 100);
 
        //list.setSelectedValue("5", true); //多个值相同时会导致无响应
        //索引
        int index = 9;
        list.setSelectedIndex(index);
        Point p = list.indexToLocation(index);
        JScrollBar jScrollBar = jScrollPane.getVerticalScrollBar();//获得垂直滚动条  
        jScrollBar.setValue(p.y);//设置垂直滚动条位置  
        $.getContentPane().add(jScrollPane);
	}

}
