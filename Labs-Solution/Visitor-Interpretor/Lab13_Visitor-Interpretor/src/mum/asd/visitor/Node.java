package mum.asd.visitor;

public class Node extends Composite {
	
	public Node(String text) {
		setText(text);
	}
	
	public Node(String text,Side side) {
		setText(text);
		setSide(side);
	}
	
	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
		
	}

	@Override
	public void addChild(Composite child) {
		child.setSide(getSide());
		getChildren().add(child);
	}

}
