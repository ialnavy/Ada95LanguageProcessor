package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RangeAttributeDesignator extends AbstractAST implements AST {

    private Expression expression;

    public RangeAttributeDesignator(Expression expression) {
	super();
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Expression getExpression() {
	return expression;
    }

}
