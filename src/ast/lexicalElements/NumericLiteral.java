package ast.lexicalElements;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class NumericLiteral extends AbstractAST implements AST {

    private Token value;

    public NumericLiteral(Token value) {
	super();
	this.value = value;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Token getValue() {
	return value;
    }

}
