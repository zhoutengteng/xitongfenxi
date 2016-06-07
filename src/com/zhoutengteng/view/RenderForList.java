package com.zhoutengteng.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class RenderForList  extends DefaultListCellRenderer{
    private Font font1;  
    private Font font2;  
    private Color rowcolor;  
    private int row;  
    private int[] rows;  
    private String option = new String("default");
    
    
    public RenderForList() {  
        this.font1 = getFont();  
        this.font2 = font1.deriveFont((float) (font1.getSize() + 10));  
    }  
  
    public RenderForList(int row, Color color) {  
        this.rowcolor = color;  
        this.row = row;  
    }  
  
    public RenderForList(int[] rows, Color color) {  
        this.rowcolor = color;  
        this.rows = rows;  
    }
    
    public RenderForList(String option) {
    	this.option = option;
    }
  
    public Component getListCellRendererComponent(JList list, Object value,  int index, boolean isSelected, boolean cellHasFocus) {  
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);  
        if (option.equals("default")) {
	        if (rows==null) {  
	            if (index == row) {  
	                setBackground(this.rowcolor);  
	                setFont(getFont().deriveFont((float) (getFont().getSize() + 2)));  
	            }  
	        } else {  
	            for (int i = 0; i < rows.length; i++) {  
	                if (index == rows[i]) {  
	                    setBackground(this.rowcolor);  
	                    setFont(getFont().deriveFont((float) (getFont().getSize() + 2)));  
	                }  
	            }  
	        }  
        } else if (option.equals("FORRECORD")) {
        	int length = list.getModel().getSize();
        	for (int i = 0; i < length; i++) {
        		if (index % 2 == 0) {
        			
        			setBackground(new Color(0xCC9999));
        			setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        		} else {
        			setText("--------from " + value);
					setBackground(Color.white);
					setForeground(Color.orange);
                    setFont(getFont().deriveFont((float) (getFont().getSize())));
                    setSize(new Dimension(20, 20));
				}
        	}
        } else if (option.equals("FORHOT")) {
        	int length = list.getModel().getSize();
        	for (int i = 0; i < length; i++) {
        		if (index % 2 == 0) {
        			
        			setBackground(new Color(0x009999));
        			setFont(new Font("Lucida Grande", Font.PLAIN, 25));
        		} else {
        			setText("--------from " + value);
					setBackground(Color.white);
					setForeground(Color.orange);
                    setFont(getFont().deriveFont((float) (getFont().getSize())));
                    setSize(new Dimension(20, 20));
				}
        	}
        	
        } else if(option.equals("FORGOOD")) {
			setBackground(Color.white);
			setForeground(Color.orange);
            setFont(getFont().deriveFont((float) (getFont().getSize())));
            setSize(new Dimension(20, 20));
		}
  
        return this;  
    }  
}
