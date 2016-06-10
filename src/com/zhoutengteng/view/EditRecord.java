package com.zhoutengteng.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.zhoutengteng.control.catRecordControl;
import com.zhoutengteng.message.Config;
import com.zhoutengteng.message.MyClient;
import com.zhoutengteng.message.MyClientNIOImpl;
import com.zhoutengteng.message.MyGenericRequest;
import com.zhoutengteng.message.MyGenericResponseHandler;
import com.zhoutengteng.message.MyRequest;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class EditRecord extends JPanel {
	private JLabel username;
	private JLabel titleLabel;
	private JTextArea titlel;
	private JTextArea content;
	private JButton submit;

	/**
	 * Create the panel.
	 */
	
	public EditRecord(String us) {
		username = new JLabel(us);
		username.setBorder(new LineBorder(new Color(0, 0, 0)));
		titleLabel = new JLabel("主题");
		titleLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		titlel = new JTextArea("title");
		titlel.setBorder(new LineBorder(new Color(0, 0, 0)));
		content = new JTextArea("New label");
		content.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		submit = new JButton("submit");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(titlel, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(197))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(username, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
					.addComponent(submit)
					.addGap(15))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(content, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
					.addGap(66))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(submit))
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(titlel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
					.addGap(41)
					.addComponent(content, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(25))
		);
		setLayout(groupLayout);

	}
	
	public  void setListener() {
		submit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String titl = titlel.getText();
				String cont = content.getText();
				Date date = new Date();
				int year = date.getYear();
				int month = date.getMonth();
				int day = date.getDay();
				
//				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
//				MyRequest request = new MyGenericRequest(catRecordControl.class, "getAfterTimeRecords", new Class<?>[]{int.class, int.class, int.class}, new Object[]{year, month, day});
//				String[] va2  = myClient.execute(request, new MyGenericResponseHandler<String[]>("catRecordControl_getBeingTimeRecords"));

				
			}
		});
	}
}
