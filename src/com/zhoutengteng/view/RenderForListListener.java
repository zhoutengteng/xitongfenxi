package com.zhoutengteng.view;

import java.awt.Dimension;
import java.awt.Point;
import java.nio.channels.NonWritableChannelException;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RenderForListListener implements ListSelectionListener{
	private String option = null;
	private int width = 200;
	private int height = 200;
	
	public RenderForListListener(String option, int width, int height) {
		// TODO Auto-generated constructor stub
		this.option =  option; 
		this.width = width;
		this.height = height;
	}
	
	
	public  Dimension getSize() {
		return new Dimension(width, height);
	}
	


	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (option.equals("FORRECORD") || option.equals("FORHOT")) {
			// TODO Auto-generated method stub
	//        System.out.println("First index: " + e.getFirstIndex());
	//        System.out.println(", Last index: " + e.getLastIndex());
	        boolean adjust = e.getValueIsAdjusting();
	//        System.out.println(", Adjusting? " + adjust);
	        if (!adjust) {
	            JList<String> list = (JList<String>) e.getSource();
	            int selections[] = list.getSelectedIndices();
	            Object selectionValues[] = list.getSelectedValues();
	//          System.out.println(selectionValues.length + " " + selections.length);
	            for (int i = 0, n = selections.length; i < n; i++) {
	              if (i == 0) {
	                System.out.print(" Selections: ");
	              }
	              System.out.println(selections[i] + "/" + selectionValues[i] + " ");
	            }
	            int titleId = 0;
	            int peopleNameId = 0;
	            if (selections[0] % 2 == 0) {
	            	titleId = selections[0];
	            	peopleNameId = titleId + 1;
	            } else {
	            	peopleNameId = selections[0];
	            	titleId = peopleNameId - 1;
	            }
	            String title = list.getModel().getElementAt(titleId);
	            String peopleName = list.getModel().getElementAt(peopleNameId);
	            		
	            JFrame other = new JFrame(title + "  from  " + peopleName);
	            other.setContentPane(new RecordDetail(peopleName, title)); 
	            other.setVisible(true);
	            other.setSize(this.getSize().width * 3 / 4, this.getSize().height * 3 / 4);
				int winW = other.getSize().width;
				int winH = other.getSize().height;
				int screenW = other.getToolkit().getScreenSize().width;//宽度
				int screenH = other.getToolkit().getScreenSize().height;//高度
				other.setLocation(new Point((screenW - winW)/2, (screenH - winW)/2));
	        }
		} else if (option.equals("FORGOOD")) {
	        boolean adjust = e.getValueIsAdjusting();
	        if (!adjust) {
	            JList<String> list = (JList<String>) e.getSource();
	            int selections[] = list.getSelectedIndices();
	            Object selectionValues[] = list.getSelectedValues();
	            for (int i = 0, n = selections.length; i < n; i++) {
	              if (i == 0) {
	                System.out.print(" Selections: ");
	              }
	              System.out.println(selections[i] + "/" + selectionValues[i] + " ");
	            }
	            JFrame other = new JFrame("chatting");
	            other.setContentPane(new PeopleDetail(list.getModel().getElementAt(selections[0]))); 
	            other.setVisible(true);
	            other.setSize(this.getSize().width * 3 / 4, this.getSize().height * 3 / 4);
				int winW = other.getSize().width;
				int winH = other.getSize().height;
				int screenW = other.getToolkit().getScreenSize().width;//宽度
				int screenH = other.getToolkit().getScreenSize().height;//高度
				other.setLocation(new Point((screenW - winW)/2, (screenH - winW)/2));
	        }
		}

	}
}
