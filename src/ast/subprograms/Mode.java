package ast.subprograms;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Mode extends AbstractAST implements AST {

    private Token in;
    private Token out;

    public Mode(Token in, Token out) {
	super();
	this.in = in;
	this.out = out;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Token getIn() {
	return in;
    }

    public Token getOut() {
	return out;
    }

}
