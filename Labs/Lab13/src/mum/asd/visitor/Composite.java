package mum.asd.visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite implements Component{
	private String text;
	private Side side;
	
	private List<Composite> children = new ArrayList<Composite>();
	
	public List<Composite> getChildren() {
		return children;
	}

	public void setChildren(List<Composite> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public Side getSide() {
		return side;
	}

	public void setSide(Side side) {
		this.side = side;
	}
	public abstract void accept(NodeVisitor nodeVisitor);
	
	public abstract void addChild(Composite child);
}
