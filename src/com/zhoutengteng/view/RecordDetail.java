package com.zhoutengteng.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class RecordDetail extends JPanel {
	private JLabel username;
	private JLabel titleLabel;
	private JLabel titlel;
	private JLabel zan;
	private JLabel cai;
	private JLabel follower;
	private JLabel content;

	/**
	 * Create the panel.
	 */
	
	public RecordDetail(String theUseName, String theTitle) {
		username = new JLabel(theUseName);
		username.setBorder(new LineBorder(new Color(0, 0, 0)));
		titleLabel = new JLabel("主题");
		titleLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		titlel = new JLabel(theTitle);
		titlel.setBorder(new LineBorder(new Color(0, 0, 0)));
		content = new JLabel("New label");
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		zan = new JLabel("赞：0");
		zan.setBorder(new LineBorder(new Color(0, 0, 0)));
		cai = new JLabel("踩：0");
		cai.setBorder(new LineBorder(new Color(0, 0, 0)));
		follower = new JLabel();
		follower.setHorizontalAlignment(SwingConstants.LEFT);
		follower.setHorizontalTextPosition(SwingConstants.LEFT);
		follower.setVerticalTextPosition(SwingConstants.TOP);
		follower.setText("zhou\nkelly");
		follower.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(username, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(titlel, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(197))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(zan, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(cai, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(follower, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(content, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
					.addGap(66))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(username, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(titlel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
					.addGap(41)
					.addComponent(content, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(cai)
						.addComponent(zan)
						.addComponent(follower, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
		);
		setLayout(groupLayout);

	}
}
