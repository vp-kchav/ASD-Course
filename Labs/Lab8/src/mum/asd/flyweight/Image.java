package mum.asd.flyweight;

public class Image {
	private String image;
	public Image(String i) {
		image = i;
	}
	
	@Override
	public String toString() {
		return image;
	}
}
