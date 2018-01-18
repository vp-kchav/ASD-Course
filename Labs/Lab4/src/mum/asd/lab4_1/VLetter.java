package mum.asd.lab4_1;

public class VLetter extends Letter {

	public VLetter(char[][] data) {
		super(data);
	}

	@Override
	protected void process() {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				result[i][j] = data[i][j];
			}
		}
		
		for(int i = 0; i < data.length; i++) {
			for(int j = data[i].length - 2; j >= 0; j--) {
				result[i][8 - j] = data[i][j];
			}
		}
	}

}
