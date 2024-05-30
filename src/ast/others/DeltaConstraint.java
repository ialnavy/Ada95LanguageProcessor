package ast.others;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.RangeConstraint;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class DeltaConstraint extends AbstractAST implements AST {

    private Expression expression;
    private RangeConstraint rangeConstraint;

    public DeltaConstraint(Expression expression, RangeConstraint rangeConstraint) {
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
