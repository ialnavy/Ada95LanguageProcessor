package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DefiningOperatorSymbol extends AbstractAST implements AST {

    private OperatorSymbol operatorSymbol;

    public DefiningOperatorSymbol(OperatorSymbol operatorSymbol) {
	super();
	this.operatorSymbol = operatorSymbol;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public OperatorSymbol getOperatorSymbol() {
	return operatorSymbol;
    }

}
