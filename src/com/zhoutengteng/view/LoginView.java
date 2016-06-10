package com.zhoutengteng.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.zhoutengteng.control.loginControl;
import com.zhoutengteng.message.Config;
import com.zhoutengteng.message.MyClient;
import com.zhoutengteng.message.MyClientNIOImpl;
import com.zhoutengteng.message.MyGenericRequest;
import com.zhoutengteng.message.MyGenericResponseHandler;
import com.zhoutengteng.message.MyRequest;


import java.awt.Color;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel suggestName;
	private JTextArea inputName;
	private JLabel lblQq;
	private JButton login;
	private JTextArea inputPassword;
	private JLabel suggestPassword;
	private JLabel lblWeiin;
	private JLabel register;
	private JLabel result;

	/**
	 * Launch the application.
	 */
	public  void go() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		nameLabel = new JLabel("账号:");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

		inputName = new JTextArea();
		inputName.setText("zhou1");
		suggestName = new JLabel("New label");
		suggestName.setVerticalAlignment(SwingConstants.TOP);
		suggestName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel passwordLabel = new JLabel("密码：");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		inputPassword = new JTextArea();
		inputPassword.setText("1992927zhou");
		suggestPassword = new JLabel("New label");
		suggestPassword.setVerticalAlignment(SwingConstants.TOP);
		suggestPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		login = new JButton("登录");
		
		register = new JLabel("还没有账号？");
		register.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		lblQq = new JLabel("qq");
		lblQq.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblQq.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWeiin = new JLabel("weiin");
		lblWeiin.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblWeiin.setHorizontalAlignment(SwingConstants.CENTER);
		
		result = new JLabel("New label");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
						.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(result, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
						.addComponent(inputName, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(register, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(51)
									.addComponent(login, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblWeiin, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))))
						.addComponent(inputPassword, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(suggestName, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addComponent(suggestPassword, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(suggestName, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(inputName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameLabel))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(passwordLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(inputPassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(suggestPassword, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(result)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(login, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQq, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(register, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblWeiin, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setListener();
	}
	void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	void setListener() {
		login.addMouseListener(new MouseListener() {
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
				String name = inputName.getText();
				String password = inputPassword.getText();
				MyClient myClient = new MyClientNIOImpl(Config.host, Config.port);
				MyRequest request = new MyGenericRequest(loginControl.class, "login", new Class<?>[]{String.class, String.class}, new Object[]{name, password});
				System.out.println(request);
				boolean res = myClient.execute(request, new MyGenericResponseHandler<Boolean>("loginControl_login"));
				if (res) {
					result.setText("Login success");
					new MaimView(name).go(name);
					close();
				} else {
					result.setText("Login failure");
				}
			}
		});
		
		register.addMouseListener(new MouseListener() {
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
				new RegisterView().go();
				close();
				
			}
		});

		
	}
}
