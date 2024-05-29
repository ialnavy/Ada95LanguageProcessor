package ast.namesAndExpressions;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class HighestPrecedenceOperator extends AbstractAST implements AST {

    private String operator;
    private Token token;

    public HighestPrecedenceOperator(String operator) {
	super();
	this.operator = operator;
    }

    public HighestPrecedenceOperator(Token token) {
	super();
	this.token = token;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public String getOperator() {
	return operator;
    }

    public Token getToken() {
	return token;
    }

}
