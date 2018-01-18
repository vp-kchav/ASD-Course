package mum.asd.lab3_1;

public class Adaptee {

	private String[] data = new String[100];
	private int start;
	private int end;

	public String startString() {
		return data[start];
	}

	public String endString() {
		return data[end];
	}

	public boolean empty() {
		return (end == -1);
	}

	public void add(String str) {
		data[end] = str;
		end++;
	}

	public void remove(int pos) {
		// remove the String object at position 'pos' and bring //forward all
		// items after it
		for (int i = pos; i < end; i++) {
			data[i] = data[i + 1];
		}
	}

	public String get(int pos) {
		return data[pos];
	}
	
	public int size() {
		return data.length;
	}

}
