package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.others.BooleanExpression;
import visitor.Ada95Visitor;

public class Condition extends AbstractAST implements AST {

    private BooleanExpression booleanExpression;

    public Condition(BooleanExpression booleanExpression) {
	super();
	this.booleanExpression = booleanExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public BooleanExpression getBooleanExpression() {
	return booleanExpression;
    }

}
