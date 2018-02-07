package mum.asd.decorator;

import java.util.LinkedList;


public class LinkedListProfiler implements Profiler {

	private LinkedList<Object> decorator;
	
	public LinkedListProfiler(){
		this.decorator = new LinkedList<Object>();
	}

	@Override
	public boolean add(Object e) {

		long startTime = System.currentTimeMillis();

		boolean isTrue = decorator.add(e);

		System.err.println("LinkedListProfiler Add() : " + (System.currentTimeMillis() - startTime));

		return isTrue;

		// return BiFunctionalInterface.printProfilerTime(decorator,
		// decorator.add(e));
	}

	@Override
	public boolean remove(Object o) {

		long startTime = System.currentTimeMillis();

		boolean isTrue = decorator.remove(o);

		System.err.println("LinkedListProfiler Remove() : " + (System.currentTimeMillis() - startTime));

		return isTrue;
	}

	@Override
	public boolean contains(Object o) {

		long startTime = System.currentTimeMillis();

		boolean isTrue = decorator.contains(0);

		System.err.println("LinkedListProfiler Contains() : " + (System.currentTimeMillis() - startTime));

		return isTrue;
	}

	@Override
	public int size() {

		long startTime = System.currentTimeMillis();

		int isTrue = decorator.size();

		System.err.println("LinkedListProfiler Size() : " + (System.currentTimeMillis() - startTime));

		return isTrue;
	}

}
