package ast.namesAndExpressions;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class MultiplyingOperator extends AbstractAST implements AST {

    private String operator;
    private Token operatorToken;

    public MultiplyingOperator(String operator) {
	super();
	this.operator = operator;
    }

    public MultiplyingOperator(Token operatorToken) {
	super();
	this.operatorToken = operatorToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public String getOperator() {
	return operator;
    }

    public Token getOperatorToken() {
	return operatorToken;
    }

}
