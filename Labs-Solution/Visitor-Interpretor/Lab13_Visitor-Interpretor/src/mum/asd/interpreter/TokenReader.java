package mum.asd.interpreter;

import java.util.List;

public class TokenReader {
	public Expression ReadToken(List<String> tokenList){
        return ReadNextToken(tokenList);
    }

    private Expression ReadNextToken(List<String> tokenList){
        int number;
        if (isInteger(tokenList.get(0))){
            number = Integer.parseInt(tokenList.get(0));
            tokenList.remove(0);   //process terminal expression
            return new NumberExpression(number);
        }
        else{
            return ReadNonTerminal(tokenList);  //process nonTerminal expression
        }
    }
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    private Expression ReadNonTerminal(List<String> tokenList){
    	String token = tokenList.get(0);
        tokenList.remove(0);   //read the symbol
        Expression left = ReadNextToken(tokenList); //read left expression
        Expression right = ReadNextToken(tokenList);  //read right expression

        if (token.equals("+")) {
            return new AddExpression(left, right);
        }
        else if (token.equals("-")) {
            return new SubtractExpression(left, right);
        }
        return null;
    }
}
