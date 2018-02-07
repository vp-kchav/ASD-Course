package controller;

public class Test {
	private String col1;
	private String col2;
	private String col3;
	private String col4;
	private String col5;
	private Double col6;

	public Test(String col1, String col2, String col3, String col4, String col5, Double col6) {
		this.col1 = new String(col1);
		this.col2 = new String(col2);
		this.col3 = new String(col3);
		this.col4 = new String(col4);
		this.col5 = new String(col5);
		this.col6 = new Double(col6);
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol4() {
		return col4;
	}

	public void setCol4(String col4) {
		this.col4 = col4;
	}

	public String getCol5() {
		return col5;
	}

	public void setCol5(String col5) {
		this.col5 = col5;
	}

	public Double getCol6() {
		return col6;
	}

	public Test setCol6(Double col6) {
		this.col6 = col6;
		return this;
	}

	@Override
	public String toString() {
		return "Test [col1=" + col1 + ", col2=" + col2 + ", col3=" + col3 + ", col4=" + col4 + ", col5=" + col5
				+ ", col6=" + col6 + "]";
	}
}
