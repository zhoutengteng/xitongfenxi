package com.zhoutengteng.message;


public class MyGenericResponse implements MyResponse {

	private Object obj = null;

	public MyGenericResponse(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object getResult() {
		return obj;
	}
}
