package com.zhoutengteng.view;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import org.omg.CORBA.portable.ValueInputStream;

public class RenderForListModel<String> implements ListModel<String> {
	private String values[];
	
	public  RenderForListModel(String values[]) {
		// TODO Auto-generated constructor stub
		this.values = values;
	}
	
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return values.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return values[index];
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

}
