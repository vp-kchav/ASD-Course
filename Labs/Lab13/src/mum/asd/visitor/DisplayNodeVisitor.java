package mum.asd.visitor;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DisplayNodeVisitor implements NodeVisitor {
	String rootText;
	Set<String> leftSide = new TreeSet<String>();
	Set<String> rightSide = new TreeSet<String>();
	
	@Override
	public void visit(Root root) {
		rootText = root.getText();
		
	}

	@Override
	public void visit(Node node) {
		if(node.getSide().equals(Side.LEFT)) {
			leftSide.add(node.getText());
		}else if(node.getSide().equals(Side.RIGHT)) {
			rightSide.add(node.getText());
		}
	}

	public String getRootText() {
		return rootText;
	}
	
	public Set<String> getRightSide() {
		return rightSide;
	}
	
	public Set<String> getLeftSide() {
		return rightSide;
	}
	
}
