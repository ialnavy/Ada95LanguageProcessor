package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.SimpleExpression;
import visitor.Ada95Visitor;

public class LastBit extends AbstractAST implements AST {

    private SimpleExpression simpleExpression;

    public LastBit(SimpleExpression simpleExpression) {
	super();
	this.simpleExpression = simpleExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SimpleExpression getSimpleExpression() {
	return simpleExpression;
    }

}
