package mum.asd.composite;

public class App {

	public static void main(String[] args) {
		Component root = new Composite("HTML");
		Component head = new Composite("Head");
		Component title = new Leaf("title", "your title here");
		head.addItem(title);
		Component body = new Composite("Body");
		Component center = new Leaf("Center","the text of body");
		Component h1 = new Leaf("h1","the text H1");
		Component h2 = new Leaf("h2","the text H2");
		Component b1 = new Leaf("b","the text B1");
		Component b2 = new Leaf("b","the text B2");
		body.addItem(center);
		body.addItem(h1);
		body.addItem(h2);
		body.addItem(b1);
		body.addItem(b2);
		root.addItem(head);
		root.addItem(body);
		root.print();
	}

}
