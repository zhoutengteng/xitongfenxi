package com.zhoutengteng.message;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.stream.events.StartDocument;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class RunServer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int port = Config.port;
	private  String host = Config.host;
	private JTextField ip;
	private JTextField portnum;
	private JButton start;
	private JTextArea suggest;

	public RunServer() {
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start = new JButton("开启服务");
		start.setForeground(Color.black);
		start.setBackground(Color.RED);
		JLabel lblIp = new JLabel("ip");
		JLabel lblPort = new JLabel("port");
		ip = new JTextField();
		ip.setEditable(false);
		// ip.add
		ip.setColumns(10);

		portnum = new JTextField();
		portnum.setEditable(false);
		portnum.setColumns(10);
		ip.setText(host);
		portnum.setText("" + port);
		suggest = new JTextArea("");
		suggest.setRows(4);
		suggest.setLineWrap(true);
		suggest.setEditable(false);
		suggest.setBackground(Color.WHITE);
		suggest.setFont(new Font("Letter Gothic Std", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblIp)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(suggest, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(lblPort)
									.addGap(18)
									.addComponent(portnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(start, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIp)
						.addComponent(ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPort)
						.addComponent(portnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(83)
					.addComponent(start, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(suggest, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	public void go() {
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(ip.getText());
				MyServer myServer = new MyServerNIOImpl(ip.getText(), Integer.parseInt(portnum.getText()));
				suggest.setText("server is runnig in\n ip:" + ip.getText() + " port:" + portnum.getText());
				if (start.getText().equals("开启服务")) {
					try {
						myServer.startup();
						Thread.sleep(3000);
					} catch (IllegalArgumentException e1) {
						suggest.setText("argument is error");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						System.out.println("close");
					}
					suggest.setForeground(Color.white);
					suggest.setBackground(Color.orange);
					start.setText("关闭服务");
				} else {
					
					suggest.setText("");
					suggest.setForeground(Color.black);
					suggest.setBackground(Color.white);
					start.setText("开启服务");
					
				}


			}

		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunServer frame = new RunServer();
					frame.setVisible(true);
					frame.setSize(950 / 2, 650 / 2);
					int winW = frame.getSize().width;
					int winH = frame.getSize().height;
					int screenW = frame.getToolkit().getScreenSize().width;// 宽度
					int screenH = frame.getToolkit().getScreenSize().height;// 高度
					frame.setLocation(new Point((screenW - winW) / 2, (screenH - winW) / 2));
					frame.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
