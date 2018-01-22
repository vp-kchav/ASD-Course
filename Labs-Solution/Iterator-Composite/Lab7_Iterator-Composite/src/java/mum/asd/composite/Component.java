package mum.asd.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
	private String tag;
	
	private List<Component> list = new ArrayList<Component>();
	abstract void print();
	
	public void addItem(Component component) {
		list.add(component);
	}

	public List<Component> getList() {
		return list;
	}

	public void setList(List<Component> list) {
		this.list = list;
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
