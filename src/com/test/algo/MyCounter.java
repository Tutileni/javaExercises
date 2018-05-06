package com.test.algo;

import java.util.concurrent.atomic.AtomicInteger;

class MyCounter {
	private static int counter = 0;
	//Another form
	public static synchronized int getCount() {
		return counter++;
	}
	//Another form
	private static AtomicInteger counter1 = new AtomicInteger(0);
	 
	public static int getCount1() {
		return counter1.getAndIncrement();
	}
}