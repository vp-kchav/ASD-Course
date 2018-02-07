package mum.asd.interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Client {
	public static void main(String[] args) {
		String tokenString = "+ + 10 5 - 8 2";
        List<String> tokenList = new ArrayList<String>(Arrays.asList(tokenString.split(" ")));
        TokenReader tokenReader = new TokenReader();
        Expression expression = tokenReader.ReadToken(tokenList);
        System.out.println(expression.Interpret());
	} 
}
