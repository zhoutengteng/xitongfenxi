package com.zhoutengteng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Point;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class main extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JLabel usernameLabel;
	private JLabel record4;
	private JLabel record3;
	private JLabel record1;
	private JLabel record2;
	private JLabel record5;
	private JLabel record6;
	private JList<JLabel> list_1;
	private JList<JLabel> list;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	/**
	 * Create the frame.
	 */
	public main() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		record4 = new JLabel("已结束活动");

		
		record3 = new JLabel("未开始活动");

		
		record1 = new JLabel("全部活动");

		record2 = new JLabel("正在进行活动");

		
		usernameLabel = new JLabel("zhoutengteng");

		
		record5 = new JLabel("最热门活动");

		
		record6 = new JLabel("好友列表");
		list_1 = new JList<JLabel>();	
		scrollPane_1 = new JScrollPane(list_1);
		list = new JList<JLabel>();
		list.setVisibleRowCount(2);
		list.setSize(new Dimension(10, 10));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"dfsdfsdf", "2", "", "", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(1);
		list.setEnabled(false);
		list.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		list.setOpaque(false);
		list.setRequestFocusEnabled(false);
		list.setPreferredSize(new Dimension(10, 10));
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

//		JScrollBar  jScrollBar = scrollPane.getVerticalScrollBar();
//		jScrollBar.setValue(5);
//		scrollPane.setPreferredSize(new Dimension(180,2000));
//		scrollPane.setBounds(8, 8, 310, 220);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(record1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(record2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(record3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(record4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(record5))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(record6))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(512, Short.MAX_VALUE)
					.addComponent(usernameLabel)
					.addGap(37))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(usernameLabel)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(record1)
						.addComponent(record4)
						.addComponent(record5)
						.addComponent(record2)
						.addComponent(record3)
						.addComponent(record6))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
					.addContainerGap())
		);
		

		contentPane.setLayout(gl_contentPane);
		record1.addMouseListener(this);
		record1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		record1.setHorizontalAlignment(SwingConstants.CENTER);
		record1.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		record1.setForeground(new Color(153, 102, 0));
		record2.addMouseListener(this);
		record2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		record2.setHorizontalAlignment(SwingConstants.CENTER);
		record2.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		record2.setForeground(new Color(153, 102, 0));
		record3.addMouseListener(this);
		record3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		record3.setHorizontalAlignment(SwingConstants.CENTER);
		record3.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		record3.setForeground(new Color(153, 102, 0));
		record4.addMouseListener(this);
		record4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		record4.setHorizontalAlignment(SwingConstants.CENTER);
		record4.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		record4.setForeground(new Color(153, 102, 0));
		record5.addMouseListener(this);
		record5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		record5.setHorizontalAlignment(SwingConstants.CENTER);
		record5.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		record5.setForeground(new Color(153, 102, 0));
		record6.addMouseListener(this);
		record6.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		record6.setHorizontalAlignment(SwingConstants.CENTER);
		record6.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		record6.setForeground(new Color(153, 102, 0));
		usernameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel  jTextField = new JLabel("title0");
		jTextField.setSize(new Dimension(100, 20));
		jTextField.setLocation(new Point(1, 1));
		list.add(jTextField);
		addRecordItem();
		

		
	}


	public boolean addRecordItem() {
		for (int i = 0;i < 30; i++) {
			JLabel  jTextField = new JLabel("title" + i);
			jTextField.setSize(new Dimension(100, 20));
			jTextField.setLocation(new Point(1, 1 * 20 * (i + 1)));
			list.add(jTextField);
		}
		
		return true;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JLabel) { 
			((JLabel)(e.getSource())).setForeground(new Color(255,0,0));;
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() instanceof JLabel) { 
			((JLabel)(e.getSource())).setForeground(new Color(153, 102, 0));;
		}
		
	}
}
