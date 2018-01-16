package mum.edu.asd.lab3_1;

public interface Queue<T> {
	void poll();
	void offer(T t);
	T peek();
}
