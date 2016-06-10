package com.zhoutengteng.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PeopleDetail extends JPanel {
	private JList recordList;
	private JScrollPane scrollPaneforRecord;
	private JLabel lblNewLabel_1;
	private JList chatList;
	private JLabel lblNewLabel;
	private JScrollPane scrollPaneforChat;
	private JSeparator separator;
	private JLabel chatPeople;
	private String[] valueForChat;
	private String[] valueForRecord;

	/**
	 * Create the panel.
	 */
	public PeopleDetail(String thePeopeleName) {
		
		chatPeople = new JLabel(thePeopeleName);
		chatPeople.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		

		scrollPaneforChat = new JScrollPane();
		chatList = new JList();
		scrollPaneforChat.setViewportView(chatList);
		lblNewLabel = new JLabel(" 聊天纪录");
		scrollPaneforChat.setColumnHeaderView(lblNewLabel);
		chatList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chatList.addListSelectionListener(new RenderForListListener("FORGOOD", MaimView.FRAMEWIDTH, MaimView.FRAMEHEIGHT));
		chatList.setVisibleRowCount(2);
		chatList.setSize(new Dimension(10, 10));
		chatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chatList.setSelectedIndex(0);
		chatList.setEnabled(true);
		chatList.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		chatList.setOpaque(false);
		chatList.setRequestFocusEnabled(false);
		chatList.setCellRenderer(new RenderForList(new String("FORGOOD")));
		valueForChat = new String[] {"dfsdfsdf", "2", "11", "11", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s",};	
		chatList.setModel(new  RenderForListModel<String>(valueForChat));
		
		
		scrollPaneforRecord = new JScrollPane();
		recordList = new JList();
		scrollPaneforRecord.setViewportView(recordList);
		lblNewLabel_1 = new JLabel("活动记录");
		scrollPaneforRecord.setColumnHeaderView(lblNewLabel_1);
		recordList.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		recordList.addListSelectionListener(new RenderForListListener("FORRECORD", MaimView.FRAMEWIDTH, MaimView.FRAMEHEIGHT));
		recordList.setVisibleRowCount(2);
		recordList.setSize(new Dimension(10, 10));
		recordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		recordList.setSelectedIndex(0);
		recordList.setEnabled(true);
		recordList.setBorder(new LineBorder(new Color(51, 153, 153), 2));
		recordList.setOpaque(false);
		recordList.setRequestFocusEnabled(false);
		recordList.setCellRenderer(new RenderForList(new String("FORRECORD")));
		valueForRecord = new String[] {"dfsdfsdf", "2", "11", "11", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s", "ds", "d", "s", "d", "sd", "s", "d", "sd", "s", "ds", "ds", "ds", "ds", "d", "sd", "s",};	
		recordList.setModel(new  RenderForListModel<String>(valueForChat));
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.DARK_GRAY);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(chatPeople, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneforRecord, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
					.addGap(43)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(scrollPaneforChat, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(chatPeople)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(scrollPaneforRecord, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(scrollPaneforChat, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
					.addContainerGap())
		);

		setLayout(groupLayout);
		
	}
}
