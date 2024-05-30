package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class DiscreteChoice extends AbstractAST implements AST {

    private Expression expression;
    private DiscreteRange discreteRange;

    public DiscreteChoice(Expression expression) {
	super();
	this.expression = expression;
    }

    public DiscreteChoice(DiscreteRange discreteRange) {
	super();
	this.discreteRange = discreteRange;
    }

    public DiscreteChoice() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getExpression() {
	return expression;
    }

    public DiscreteRange getDiscreteRange() {
	return discreteRange;
    }

}
