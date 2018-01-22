package mum.asd.composite;

public class Leaf extends Component {
	private String text;
	
	public Leaf(String tag,String text) {
		setTag(tag);
		setText(text);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	void print() {
		System.out.println("<"+getTag()+">" + getText() + "</"+getTag()+">");
	}

}
