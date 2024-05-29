package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DiscreteChoiceList;
import visitor.Ada95Visitor;

public class ArrayComponentAssociation extends AbstractAST implements AST {

    private DiscreteChoiceList discreteChoiceList;
    private Expression expression;

    public ArrayComponentAssociation(DiscreteChoiceList discreteChoiceList, Expression expression) {
	super();
	this.discreteChoiceList = discreteChoiceList;
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DiscreteChoiceList getDiscreteChoiceList() {
	return discreteChoiceList;
    }

    public Expression getExpression() {
	return expression;
    }

}
