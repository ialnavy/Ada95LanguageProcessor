package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.StringLiteral;
import visitor.Ada95Visitor;

public class OperatorSymbol extends AbstractAST implements AST {

    private StringLiteral literal;

    public OperatorSymbol(StringLiteral literal) {
	super();
	this.literal = literal;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public StringLiteral getLiteral() {
	return literal;
    }

}
