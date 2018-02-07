package mum.asd.interpreter;

public class AddExpression extends Expression{

	Expression leftExpression;
	Expression rightExpression;
	
	public AddExpression(Expression left, Expression right){
		leftExpression = left;
		rightExpression= right;
	}
	
	@Override
	public int Interpret() {
		return leftExpression.Interpret() + rightExpression.Interpret();
	}

}
