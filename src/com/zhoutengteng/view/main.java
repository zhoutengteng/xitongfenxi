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
import java.util.Vector;

import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import java.awt.Point;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class main extends JFrame implements MouseListener, ListSelectionListener {

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
//        System.out.println("First index: " + e.getFirstIndex());
//        System.out.println(", Last index: " + e.getLastIndex());
        boolean adjust = e.getValueIsAdjusting();
//        System.out.println(", Adjusting? " + adjust);
        if (!adjust) {
            JList<String> list = (JList<String>) e.getSource();
            int selections[] = list.getSelectedIndices();
            Object selectionValues[] = list.getSelectedValues();
//            System.out.println(selectionValues.length + " " + selections.length);
            for (int i = 0, n = selections.length; i < n; i++) {
              if (i == 0) {
                System.out.print(" Selections: ");
              }
              System.out.println(selections[i] + "/" + selectionValues[i] + " ");
            }
            JFrame other = new JFrame("item");
            other.setContentPane(new showOneRecord()); 
            other.setVisible(true);
            other.setSize(this.getSize().width, this.getSize().height);
//            other.setMaximumSize(new Dimension(400, 200));//设置最大值
//            other.setMinimumSize(new Dimension(200, 100));//设置最小值
            //other.getContentPane();
        }
	}


	private JPanel contentPane;
	private JLabel usernameLabel;
	private JLabel afterRecord;
	private JLabel beforeRecord;
	private JLabel allRecord;
	private JLabel beingRecord;
	private JLabel hotRecord;
	private JLabel googPeopleLabel;
	private JList<JLabel> goodList;
	private JList<String> recordList;
	private JScrollPane peopellistScroll;
	private JScrollPane recordScroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
					frame.setSize(1000-50, 700-50);
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
		
		afterRecord = new JLabel("已结束活动");
		beforeRecord = new JLabel("未开始活动");
		allRecord = new JLabel("全部活动");
		beingRecord = new JLabel("正在进行活动");
		usernameLabel = new JLabel("zhoutengteng");
		hotRecord = new JLabel("最热门活动");
		googPeopleLabel = new JLabel("好友列表");
		goodList = new JList<JLabel>();
		peopellistScroll = new JScrollPane(goodList);
		
		
		//设置左边滚动栏
		recordList = new JList<String>();
		recordList.addListSelectionListener(this);
		recordList.setVisibleRowCount(2);
		recordList.setSize(new Dimension(10, 10));
		recordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		recordList.setSelectedIndex(0);
		recordList.setEnabled(true);
		recordList.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		recordList.setOpaque(false);
		recordList.setRequestFocusEnabled(false);
		recordScroll = new JScrollPane(recordList);
		
//		scrollPane.setPreferredSize(new Dimension(100, 100));
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//      int index = 9;
//      list.setSelectedIndex(index);
//      Point p = list.indexToLocation(index);
//		JScrollBar  jScrollBar = scrollPane.getVerticalScrollBar();
//		jScrollBar.setValue(p.y);
//		scrollPane.setPreferredSize(new Dimension(180,2000));
//		scrollPane.setBounds(8, 8, 310, 220);
		recordList.setModel(new  ListModel<String>() {
			String[] values = new String[] {"dfsdfsdf", "2", "", "", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s",};	
			@Override
			public void addListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				System.out.println("ddddddddddd");
				
			}
			@Override
			public void removeListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}

		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(allRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(beingRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(beforeRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(afterRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hotRecord))
						.addComponent(recordScroll, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
					.addGap(53)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(peopellistScroll, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(googPeopleLabel))
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
						.addComponent(allRecord)
						.addComponent(afterRecord)
						.addComponent(hotRecord)
						.addComponent(beingRecord)
						.addComponent(beforeRecord)
						.addComponent(googPeopleLabel))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(recordScroll, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(peopellistScroll, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
					.addContainerGap())
		);
		

		contentPane.setLayout(gl_contentPane);
//		contentPane.setPreferredSize(new Dimension(100, 700));
		


		allRecord.addMouseListener(this);
		allRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		allRecord.setHorizontalAlignment(SwingConstants.CENTER);
		allRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		allRecord.setForeground(new Color(153, 102, 0));
		beingRecord.addMouseListener(this);
		beingRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		beingRecord.setHorizontalAlignment(SwingConstants.CENTER);
		beingRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		beingRecord.setForeground(new Color(153, 102, 0));
		beforeRecord.addMouseListener(this);
		beforeRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		beforeRecord.setHorizontalAlignment(SwingConstants.CENTER);
		beforeRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		beforeRecord.setForeground(new Color(153, 102, 0));
		afterRecord.addMouseListener(this);
		afterRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		afterRecord.setHorizontalAlignment(SwingConstants.CENTER);
		afterRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		afterRecord.setForeground(new Color(153, 102, 0));
		hotRecord.addMouseListener(this);
		hotRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		hotRecord.setHorizontalAlignment(SwingConstants.CENTER);
		hotRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		hotRecord.setForeground(new Color(153, 102, 0));
		googPeopleLabel.addMouseListener(this);
		googPeopleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		googPeopleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		googPeopleLabel.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		googPeopleLabel.setForeground(new Color(153, 102, 0));
		usernameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		


		
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
