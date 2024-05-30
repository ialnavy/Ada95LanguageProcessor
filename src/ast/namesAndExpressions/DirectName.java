package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import ast.subprograms.OperatorSymbol;
import visitor.Ada95Visitor;

public class DirectName extends AbstractAST implements AST {

    private Identifier identifier;
    private OperatorSymbol operatorSymbol;

    public DirectName(Identifier identifier) {
	super();
	this.identifier = identifier;
    }

    public DirectName(OperatorSymbol operatorSymbol) {
	super();
	this.operatorSymbol = operatorSymbol;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Identifier getIdentifier() {
	return identifier;
    }

    public OperatorSymbol getOperatorSymbol() {
	return operatorSymbol;
    }

}
