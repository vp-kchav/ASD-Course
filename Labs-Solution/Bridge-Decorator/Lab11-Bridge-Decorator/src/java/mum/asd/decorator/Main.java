package mum.asd.decorator;

public class Main {
	
	public static void main(String[] args) {
		
		ListDecorator decorator = new ProfilerDecorator(new ArrayListProfiler());
		decorator.add("A");
		
		decorator = new ProfilerDecorator(new LinkedListProfiler());
		decorator.add("A");
		decorator.contains("A");
		
	}

}
