package com.zhoutengteng.message;

import com.zhoutengteng.control.catRecordControl;
import com.zhoutengteng.control.editRecordControl;

public class MyGenericRequest implements MyRequest {

	private static final long serialVersionUID = 1L;

	private Class<?> requestClass;
	private String requestMethod;
	private Class<?>[] requestParameterTypes;
	private Object[] requestParameterValues;

	public MyGenericRequest(Class<?> requestClass, String requestMethod, Class<?>[] requestParameterTypes, Object[] requestParameterValues) {
		
//		if (requestClass.equals("catRecordControl")) {
//			this.requestClass = catRecordControl.class;
//		} else if (requestClass.equals("editRecordControl")) {
//			this.requestClass = editRecordControl.class;
//		}
		this.requestClass = requestClass;
		this.requestMethod = requestMethod;
		this.requestParameterTypes = requestParameterTypes;
		this.requestParameterValues = requestParameterValues;
	}

	@Override
	public Class<?> getRequestClass() {
		return requestClass;
	}

	@Override
	public String getRequestMethod() {
		return requestMethod;
	}

	@Override
	public Class<?>[] getRequestParameterTypes() {
		return requestParameterTypes;
	}

	@Override
	public Object[] getRequestParameterValues() {
		return requestParameterValues;
	}
}
