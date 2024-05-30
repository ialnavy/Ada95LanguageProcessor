package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class DigitsConstraint extends AbstractAST implements AST {

    private Expression expression;
    private RangeConstraint rangeConstraint;

    public DigitsConstraint(Expression expression, RangeConstraint rangeConstraint) {
	super();
	this.expression = expression;
	this.rangeConstraint = rangeConstraint;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getExpression() {
	return expression;
    }

    public RangeConstraint getRangeConstraint() {
	return rangeConstraint;
    }

}
