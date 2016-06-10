package com.zhoutengteng.view;

import com.zhoutengteng.control.catRecordControl;
import com.zhoutengteng.message.*;
import com.zhoutengteng.model.UserModel;

import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import java.awt.List;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.sql.StatementEventListener;
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
import javax.xml.crypto.Data;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

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
import java.awt.Font;
import java.util.Date;
import javax.swing.ImageIcon;

public class MaimView extends JFrame implements MouseListener {
	static final int FRAMEWIDTH = 950;
	static final int FRAMEHEIGHT = 650;
	private JPanel contentPane;
	private JLabel usernameLabel;
	private JLabel afterRecord;
	private JLabel beforeRecord;
	private JLabel allRecord;
	private JLabel beingRecord;
	private JLabel hotRecord;
	private JLabel googPeopleLabel;
	private JList<String> goodList;
	private JList<String> recordList;
	private JScrollPane peopellistScroll;
	private JScrollPane recordScroll;
	private JScrollPane midScroll;
	private JList<String> hotList;
	private String[] valueForgoodList;
	private String[] valueForrecordList;
	private String[] valueForhotList;
	private JLabel add;
	private int id = 1;
	private MaimView that;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MaimView frame = new MaimView();
//					frame.setVisible(true);
//					frame.setSize(1000-50, 700-50);
//					int winW = frame.getSize().width;
//					int winH = frame.getSize().height;
//					int screenW = frame.getToolkit().getScreenSize().width;//宽度
//					int screenH = frame.getToolkit().getScreenSize().height;//高度
//					frame.setLocation(new Point((screenW - winW)/2, (screenH - winW)/2));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public void go(final String owner) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MaimView frame = new MaimView(owner);
				frame.setVisible(true);
				frame.setSize(1000-50, 700-50);
				int winW = frame.getSize().width;
				int winH = frame.getSize().height;
				int screenW = frame.getToolkit().getScreenSize().width;//宽度
				int screenH = frame.getToolkit().getScreenSize().height;//高度
				frame.setLocation(new Point((screenW - winW)/2, (screenH - winW)/2));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}

	


	/**
	 * Create the frame.
	 */
	public MaimView(String owner) {
		that = this;
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//设置用户栏
		usernameLabel = new JLabel(owner);
		usernameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		usernameLabel.setOpaque(true);
		
		//设置标签栏
		afterRecord = new JLabel("已结束活动");
		beforeRecord = new JLabel("未开始活动");
		allRecord = new JLabel("全部活动");
		beingRecord = new JLabel("正在进行活动");
		hotRecord = new JLabel("最热门活动");
		googPeopleLabel = new JLabel("好友列表");
		allRecord.addMouseListener(this);
		allRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		allRecord.setHorizontalAlignment(SwingConstants.CENTER);
		allRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		allRecord.setForeground(new Color(153, 102, 0));
		allRecord.setOpaque(true);
		beingRecord.addMouseListener(this);
		beingRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		beingRecord.setHorizontalAlignment(SwingConstants.CENTER);
		beingRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		beingRecord.setForeground(new Color(153, 102, 0));
		beingRecord.setOpaque(true);
		beforeRecord.addMouseListener(this);
		beforeRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		beforeRecord.setHorizontalAlignment(SwingConstants.CENTER);
		beforeRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		beforeRecord.setForeground(new Color(153, 102, 0));
		beforeRecord.setOpaque(true);
		afterRecord.addMouseListener(this);
		afterRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		afterRecord.setHorizontalAlignment(SwingConstants.CENTER);
		afterRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		afterRecord.setForeground(new Color(153, 102, 0));
		afterRecord.setOpaque(true);
		hotRecord.addMouseListener(this);
		hotRecord.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		hotRecord.setHorizontalAlignment(SwingConstants.CENTER);
		hotRecord.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		hotRecord.setForeground(new Color(153, 102, 0));
		hotRecord.setOpaque(true);
		googPeopleLabel.addMouseListener(this);
		googPeopleLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		googPeopleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		googPeopleLabel.setBorder(new LineBorder(new Color(51, 204, 0), 2, true));
		googPeopleLabel.setForeground(new Color(153, 102, 0));
		googPeopleLabel.setOpaque(true);
		
		
		//设置左边滚动栏
		recordList = new JList<String>();
		recordList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		recordList.addListSelectionListener(new RenderForListListener("FORRECORD", FRAMEWIDTH, FRAMEHEIGHT));
		recordList.setVisibleRowCount(2);
		recordList.setSize(new Dimension(10, 10));
		recordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		recordList.setSelectedIndex(0);
		recordList.setEnabled(true);
		recordList.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		recordList.setOpaque(false);
		recordList.setRequestFocusEnabled(false);
		recordList.setCellRenderer(new RenderForList(new String("FORRECORD")));
		recordScroll = new JScrollPane(recordList);
		valueForrecordList = new String[] {"dfsdfsdf", "2", "11", "11", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s",};	
		recordList.setModel(new  RenderForListModel<String>(valueForrecordList));

	
		//设置中间滚动栏
		hotList = new JList<String>();
		midScroll = new JScrollPane(hotList);
		hotList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		hotList.addListSelectionListener(new RenderForListListener("FORHOT", FRAMEWIDTH, FRAMEHEIGHT));
		hotList.setVisibleRowCount(2);
		hotList.setSize(new Dimension(10, 10));
		hotList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hotList.setSelectedIndex(0);
		hotList.setEnabled(true);
		hotList.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		hotList.setOpaque(false);
		hotList.setRequestFocusEnabled(false);
		hotList.setCellRenderer(new RenderForList(new String("FORHOT")));
		valueForhotList = new String[] {"dfsdfsdf", "2", "11", "11", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s",};	
		hotList.setModel(new  RenderForListModel<String>(valueForhotList));
		
		//设置右边滚动栏
		goodList = new JList<String>();
		peopellistScroll = new JScrollPane(goodList);
		goodList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		goodList.addListSelectionListener(new RenderForListListener("FORGOOD", FRAMEWIDTH, FRAMEHEIGHT));
		goodList.setVisibleRowCount(2);
		goodList.setSize(new Dimension(10, 10));
		goodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		goodList.setSelectedIndex(0);
		goodList.setEnabled(true);
		goodList.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		goodList.setOpaque(false);
		goodList.setRequestFocusEnabled(false);
		goodList.setCellRenderer(new RenderForList(new String("FORGOOD")));
		valueForgoodList = new String[] {"dfsdfsdf", "2", "11", "11", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s",};	
		goodList.setModel(new  RenderForListModel<String>(valueForgoodList));


		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(allRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(beingRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(beforeRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(afterRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(recordScroll, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(midScroll, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(hotRecord, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(30)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(peopellistScroll, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(googPeopleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(6))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(447, Short.MAX_VALUE)
					.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(usernameLabel)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(allRecord)
						.addComponent(afterRecord)
						.addComponent(beingRecord)
						.addComponent(beforeRecord)
						.addComponent(hotRecord)
						.addComponent(googPeopleLabel))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(midScroll, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(peopellistScroll, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
						.addComponent(recordScroll, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		add = new JLabel("+add");
		add.setIcon(new ImageIcon("/Users/zhoutengteng/Desktop/屏幕快照 2016-05-31 22.26.01.png"));
		add.setHorizontalAlignment(SwingConstants.CENTER);
		add.setForeground(Color.GREEN);
		add.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		add.addMouseListener(this);
		recordScroll.setColumnHeaderView(add);
		contentPane.setLayout(gl_contentPane);
//		contentPane.setPreferredSize(new Dimension(100, 700));
		fillThings();
		
	}


	private void fillThings() {
		MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
		MyRequest request = new MyGenericRequest(UserModel.class, "lookOneUserId", new Class<?>[]{String.class}, new Object[]{usernameLabel.getText()});
		System.out.println(request);
		id = myClient.execute(request, new MyGenericResponseHandler<Integer>("UserModel_lookOneUserId"));
		System.out.println(id);
		
		Date date = new Date();
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		
		request = new MyGenericRequest(catRecordControl.class, "getAllRecordsByPeopleId", new Class<?>[]{int.class}, new Object[]{id});
		String[] va  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getAllRecordsByPeopleId"));
		valueForrecordList = va;
		recordList.setModel(new RenderForListModel<String>(valueForrecordList));
		
		request = new MyGenericRequest(catRecordControl.class, "getBeingTimeRecords", new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
		String[] va2  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeingTimeRecords"));
		valueForrecordList = va2;
		recordList.setModel(new RenderForListModel<String>(valueForrecordList));
		
		request = new MyGenericRequest(catRecordControl.class, "getBeforeTimeRecords", new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
		String[] va3  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeforeTimeRecords"));
		valueForrecordList = va3;
		recordList.setModel(new RenderForListModel<String>(valueForrecordList));
		
		request = new MyGenericRequest(catRecordControl.class, "getAfterTimeRecords",new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
		String[] va4  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeingTimeRecords"));
		valueForrecordList = va4;
		recordList.setModel(new RenderForListModel<String>(valueForrecordList));
		
		request = new MyGenericRequest(catRecordControl.class, "getHotRecords", new Class<?>[]{}, new Object[]{});
		String[] va5  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getHotRecords"));
		valueForhotList = va5;
		hotList.setModel(new RenderForListModel<String>(valueForhotList));
	}
	
	
	
	
	
	
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof JLabel) { 
			JLabel jLabel =  ((JLabel)(e.getSource()));
			if (jLabel.getText().equals("全部活动")) {
				jLabel.setForeground(new Color(255,0,0));
				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
				MyRequest request = new MyGenericRequest(catRecordControl.class, "getAllRecordsByPeopleId", new Class<?>[]{int.class}, new Object[]{id});
				String[] va  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getAllRecordsByPeopleId"));
				valueForrecordList = va;
				recordList.setModel(new RenderForListModel<String>(valueForrecordList));
				SwingUtilities.updateComponentTreeUI(recordList);
			}
			
			if (jLabel.getText().equals("正在进行活动")) {
				Date date = new Date();
				int year = date.getYear();
				int month = date.getMonth();
				int day = date.getDay();
				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
				MyRequest request = new MyGenericRequest(catRecordControl.class, "getBeingTimeRecords", new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
				String[] va2  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeingTimeRecords"));
				valueForrecordList = va2;
				recordList.setModel(new RenderForListModel<String>(valueForrecordList));
				SwingUtilities.updateComponentTreeUI(recordList);
			} 
			if (jLabel.getText().equals("未开始活动")) {
				jLabel.setForeground(new Color(255,0,0));
				Date date = new Date();
				int year = date.getYear();
				int month = date.getMonth();
				int day = date.getDay();
				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
				MyRequest request = new MyGenericRequest(catRecordControl.class, "getBeforeTimeRecords", new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
				String[] va2  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeingTimeRecords"));
				valueForrecordList = va2;
				recordList.setModel(new RenderForListModel<String>(valueForrecordList));
				SwingUtilities.updateComponentTreeUI(recordList);
			} 
			if (jLabel.getText().equals("已结束活动")) {
				jLabel.setForeground(new Color(255,0,0));
				Date date = new Date();
				int year = date.getYear();
				int month = date.getMonth();
				int day = date.getDay();
				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
				MyRequest request = new MyGenericRequest(catRecordControl.class, "getAfterTimeRecords", new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
				String[] va2  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeingTimeRecords"));
				valueForrecordList = va2;
				recordList.setModel(new RenderForListModel<String>(valueForrecordList));
				SwingUtilities.updateComponentTreeUI(recordList);
			} 
			if (jLabel.getText().equals("最热门活动")) {
				jLabel.setForeground(new Color(255,0,0));
				Date date = new Date();
				int year = date.getYear();
				int month = date.getMonth();
				int day = date.getDay();
				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
				MyRequest request = new MyGenericRequest(catRecordControl.class, "getHotRecords", new Class<?>[]{}, new Object[]{});
				String[] va5  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getHotRecords"));
				valueForhotList = va5;
				hotList.setModel(new RenderForListModel<String>(valueForhotList));
				SwingUtilities.updateComponentTreeUI(hotList);
			} 
			
			if (jLabel.getText().equals("好友列表")) {
				jLabel.setForeground(new Color(255,0,0));
				String[] va = new String[] {"author11", "author1", "author21", "author1", "author12", "author1" };
				valueForgoodList = va;
				goodList.setModel(new RenderForListModel<String>(valueForgoodList));
				SwingUtilities.updateComponentTreeUI(goodList);
			}

			allRecord.setForeground(new Color(153, 102, 0));
			allRecord.setBackground(Color.WHITE);
			beforeRecord.setForeground(new Color(153, 102, 0));
			beforeRecord.setBackground(Color.WHITE);
			afterRecord.setForeground(new Color(153, 102, 0));
			afterRecord.setBackground(Color.WHITE);
			beingRecord.setForeground(new Color(153, 102, 0));
			beingRecord.setBackground(Color.WHITE);
			hotRecord.setForeground(new Color(153, 102, 0));
			hotRecord.setBackground(Color.WHITE);
			googPeopleLabel.setForeground(new Color(153, 102, 0));
			googPeopleLabel.setBackground(Color.WHITE);
			jLabel.setForeground(Color.WHITE);
			jLabel.setBackground(new Color(153, 102, 0));
			
			
			
			if (jLabel.getText().equals("+add")) {
	            JFrame other = new JFrame("添加活动记录");
	            other.setContentPane(new EditRecord(usernameLabel.getText())); 
	            other.setVisible(true);
	            other.setSize(this.getSize().width * 3 / 4, this.getSize().height * 3 / 4);
				int winW = other.getSize().width;
				int winH = other.getSize().height;
				int screenW = other.getToolkit().getScreenSize().width;//宽度
				int screenH = other.getToolkit().getScreenSize().height;//高度
				other.setLocation(new Point((screenW - winW)/2, (screenH - winW)/2));
				jLabel.setForeground(Color.GREEN);
				
				fillThings();
				SwingUtilities.updateComponentTreeUI(that);
				
			}
		}
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
		JLabel jLabel =  ((JLabel)(e.getSource()));
//		jLabel.setForeground(new Color(255,0,0));

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() instanceof JLabel) { 
//			JLabel jLabel = (JLabel)(e.getSource());
//			jLabel.setForeground(jLabel.getForeground());
//			((JLabel)(e.getSource())).setForeground(new Color(153, 102, 0));;
		}
		
	}
}
