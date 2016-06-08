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

	/**
	 * Create the panel.
	 */
	public RecordDetail() {
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label = new JLabel("主题");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("一起去跑内环了");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_1 = new JLabel("赞：0");
		label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label_2 = new JLabel("踩：0");
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblZhou = new JLabel();
		lblZhou.setHorizontalAlignment(SwingConstants.LEFT);
		lblZhou.setHorizontalTextPosition(SwingConstants.LEFT);
		lblZhou.setVerticalTextPosition(SwingConstants.TOP);
		lblZhou.setText("zhou\nkelly");
		lblZhou.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
					.addGap(197))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(lblZhou, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
					.addGap(66))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
					.addGap(41)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(label_2)
						.addComponent(label_1)
						.addComponent(lblZhou, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(6))
		);
		setLayout(groupLayout);

	}
}
