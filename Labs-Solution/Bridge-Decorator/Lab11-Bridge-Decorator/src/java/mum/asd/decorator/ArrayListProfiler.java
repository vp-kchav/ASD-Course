package mum.asd.decorator;

import java.util.ArrayList;



public class ArrayListProfiler implements Profiler {

	private ArrayList<Object> decorator;
	
	public ArrayListProfiler(){
		this.decorator = new ArrayList<Object>();
	}

	@Override
	public boolean add(Object e) {

		long startTime = System.currentTimeMillis();

		boolean isTrue = decorator.add(e);

		System.err.println("ArrayListProfiler Add() : " + (System.currentTimeMillis() - startTime));

		return isTrue;

	}

	@Override
	public boolean remove(Object o) {

		long startTime = System.currentTimeMillis();

		boolean isTrue = decorator.remove(o);

		System.err.println("ArrayListProfiler Remove() : " + (System.currentTimeMillis() - startTime));

		return isTrue;
	}

	@Override
	public boolean contains(Object o) {

		long startTime = System.currentTimeMillis();

		boolean isTrue = decorator.contains(0);

		System.err.println("ArrayListProfiler Contains() : " + (System.currentTimeMillis() - startTime));

		return isTrue;
	}

	@Override
	public int size() {

		long startTime = System.currentTimeMillis();

		int isTrue = decorator.size();

		System.err.println("ArrayListProfiler Size() : " + (System.currentTimeMillis() - startTime));

		return isTrue;
	}

}
