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

public class showOneRecord extends JPanel {

	/**
	 * Create the panel.
	 */
	public showOneRecord() {
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel label = new JLabel("主题");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("一起去跑内环了");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 255, 204)));
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(label_1)
							.addGap(37)
							.addComponent(label_2)
							.addGap(64)
							.addComponent(lblZhou, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(lblZhou, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
