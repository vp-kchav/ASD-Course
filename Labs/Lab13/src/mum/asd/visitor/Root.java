package mum.asd.visitor;


public class Root extends Composite{
	
	public Root(String text) {
		setText(text);
	}
	
	@Override
	public Side getSide() {
		return Side.NONE;
	}

	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
	
	@Override
	public void addChild(Composite child) {
		getChildren().add(child);
	}
}
