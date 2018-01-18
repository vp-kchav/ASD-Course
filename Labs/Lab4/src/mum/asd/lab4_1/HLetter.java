package mum.asd.lab4_1;

public class HLetter extends Letter {

	public HLetter(char[][] data) {
		super(data);
	}

	@Override
	protected void process() {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				result[i][j] = data[i][j];
			}
		}
		for(int i = 1; i < data.length - 1; i++) {
			for(int j = 0; j < data[i].length; j++) {
				result[result.length - i][j] = data[i][j];
			}
		}
	}
	
}
