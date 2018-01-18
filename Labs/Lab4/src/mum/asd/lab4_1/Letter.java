package mum.asd.lab4_1;

public abstract class Letter {
	
	protected char[][] data;
	protected char[][] result;
	
	public Letter(char[][] d) {
		data = d;
		if(check(data) != ' ') {
			result = new char[14][9];
			process();
		}
	}

	public final void print() {
		if(result != null) {
			for(int i = 0; i < result.length; i++) {
				for(int j = 0; j < result[i].length; j++) {
					System.out.print(result[i][j]);
				}
				if(i < result.length - 1) System.out.println("");
			}
		}
	}
	

	protected abstract void process();
	
	private static char check(char[][] data) {
		if(data.length == 14) {
			if(data[0].length == 9) return 'N';
			else if(data[0].length == 5) return 'V';
			else return ' ';
		} else {
			if(data.length == 8 && data[0].length == 9) return 'H';
			else return ' ';
		}
	}
}
