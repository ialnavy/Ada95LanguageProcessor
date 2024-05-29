package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RelationalOperator extends AbstractAST implements AST {

    private String operator;

    public RelationalOperator(String operator) {
	super();
	this.operator = operator;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public String getOperator() {
	return operator;
    }

}
