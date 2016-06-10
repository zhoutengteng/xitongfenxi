package com.zhoutengteng.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.zhoutengteng.control.loginControl;
import com.zhoutengteng.control.registerControl;
import com.zhoutengteng.message.Config;
import com.zhoutengteng.message.MyClient;
import com.zhoutengteng.message.MyClientNIOImpl;
import com.zhoutengteng.message.MyGenericRequest;
import com.zhoutengteng.message.MyGenericResponseHandler;
import com.zhoutengteng.message.MyRequest;

import javax.swing.JRadioButton;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JLabel nameLabel;
	private JTextArea inputName;
	private JTextArea inputPassword2;
	private JTextArea telephone;
	private JTextArea mail;
	private JTextArea inputPassword;
	private JRadioButton sex;
	private JRadioButton radioButton;
	private JButton submit;
	private JLabel re;

	/**
	 * Launch the application.
	 */
	public void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		nameLabel = new JLabel("账号:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		inputName = new JTextArea();
		
		JLabel passwordLabel1 = new JLabel("密码：");
		passwordLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		
		inputPassword = new JTextArea();
		
		inputPassword2 = new JTextArea();
		
		JLabel passwordLabel2 = new JLabel("确认密码：");
		passwordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("邮箱:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		mail = new JTextArea();
		
		JLabel label_3 = new JLabel("性别：");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel tel = new JLabel("电话:");
		tel.setHorizontalAlignment(SwingConstants.CENTER);
		
		telephone = new JTextArea();
		
		sex = new JRadioButton("男");
		
		radioButton = new JRadioButton("女");
		
		submit = new JButton("提交");
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel label = new JLabel("New label");
		
		JLabel label_2 = new JLabel("New label");
		
		JLabel label_4 = new JLabel("New label");
		
		re = new JLabel("New label");
		
		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_6 = new JLabel("*");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_7 = new JLabel("*");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(radioButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sex)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
													.addComponent(passwordLabel1, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
												.addComponent(tel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(21)
													.addComponent(passwordLabel2)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(telephone)
												.addComponent(inputPassword2)
												.addComponent(inputPassword)
												.addComponent(inputName, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(1)
													.addComponent(mail))))
										.addComponent(submit, Alignment.TRAILING))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
											.addGap(12))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
											.addGap(13))))
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(re, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
							.addGap(24))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordLabel1)
						.addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(inputPassword2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel2)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(telephone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(tel)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(mail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(re, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(sex)
						.addComponent(radioButton)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(submit)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	void setListener() {
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
				String name = inputName.getText();
				String password = inputPassword.getText();
				String password2 = inputPassword2.getText();
				String tel = telephone.getText();
				String mail = telephone.getText();
				int sex2 = 0;
				if (sex.isSelected()) {
					sex2 = 0;
				} else {
					sex2 = 1;
				}
//				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
//				MyRequest request = new MyGenericRequest(registerControl.class, "login", new Class<?>[]{String.class, String.class}, new Object[]{name, password});
//				System.out.println(request);
//				boolean res = myClient.execute(request, new MyGenericResponseHandler<Boolean>("loginControl_login"));
				
			}
		});

	
	}
	
}
