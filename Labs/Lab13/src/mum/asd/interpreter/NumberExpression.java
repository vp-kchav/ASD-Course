package mum.asd.interpreter;

public class NumberExpression extends Expression{
	int number;
    public NumberExpression(int number)
    {
        this.number = number;
    }
	@Override
	public int Interpret() {
		return number;
	}
	@Override 
	public String toString() {
		return number+"";
	}
}
