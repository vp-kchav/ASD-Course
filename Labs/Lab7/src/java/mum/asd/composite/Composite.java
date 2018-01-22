package mum.asd.composite;

public class Composite extends Component {

	public Composite(String tag) {
		setTag(tag);
	}
	
	@Override
	void print() {
		System.out.println("<"+getTag()+">");
		for(Component com : getList()) {
			com.print();
		}
		System.out.println("</"+getTag()+">" );
	}

}
