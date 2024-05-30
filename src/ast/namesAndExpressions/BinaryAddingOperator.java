package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class BinaryAddingOperator extends AbstractAST implements AST {

    private String operator;

    public BinaryAddingOperator(String operator) {
	super();
	this.operator = operator;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public String getOperator() {
	return operator;
    }

}
