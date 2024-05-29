package ast.lexicalElements;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class StringLiteral extends AbstractAST implements AST {

    private Token value;

    public StringLiteral(Token value) {
	super();
	this.value = value;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Token getValue() {
	return value;
    }

}
