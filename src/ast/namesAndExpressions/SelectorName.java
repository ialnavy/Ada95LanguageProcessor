package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.CharacterLiteral;
import ast.lexicalElements.Identifier;
import ast.subprograms.OperatorSymbol;
import visitor.Ada95Visitor;

public class SelectorName extends AbstractAST implements AST {

    private Identifier identifier;
    private CharacterLiteral literal;
    private OperatorSymbol operatorSymbol;

    public SelectorName(Identifier identifier) {
	super();
	this.identifier = identifier;
    }

    public SelectorName(CharacterLiteral literal) {
	super();
	this.literal = literal;
    }

    public SelectorName(OperatorSymbol operatorSymbol) {
	super();
	this.operatorSymbol = operatorSymbol;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Identifier getIdentifier() {
	return identifier;
    }

    public CharacterLiteral getLiteral() {
	return literal;
    }

    public OperatorSymbol getOperatorSymbol() {
	return operatorSymbol;
    }

}
