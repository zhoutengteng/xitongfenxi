package com.zhoutengteng.message;

public interface MyResponseHandler<T> {
	T handle(MyResponse response);
}

