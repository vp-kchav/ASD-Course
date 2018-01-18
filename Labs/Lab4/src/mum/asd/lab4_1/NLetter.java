package mum.asd.lab4_1;

public class NLetter extends Letter {

	public NLetter(char[][] data) {
		super(data);
	}

	@Override
	protected void process() {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				result[i][j] = data[i][j];
			}
		}
	}
	
}
