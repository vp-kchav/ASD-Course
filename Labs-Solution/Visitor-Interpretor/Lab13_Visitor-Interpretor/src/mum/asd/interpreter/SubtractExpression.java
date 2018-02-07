package mum.asd.interpreter;

public class SubtractExpression extends Expression{

	Expression leftExpression;
	Expression rightExpression;
	
	public SubtractExpression(Expression left, Expression right){
		leftExpression = left;
		rightExpression= right;
	}
	
	@Override
	public int Interpret() {
		return leftExpression.Interpret() - rightExpression.Interpret();
	}

}
