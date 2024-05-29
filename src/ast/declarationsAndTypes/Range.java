package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.RangeAttributeReference;
import ast.namesAndExpressions.SimpleExpression;
import visitor.Ada95Visitor;

public class Range extends AbstractAST implements AST {

    private RangeAttributeReference rangeAttributeReference;
    private SimpleExpression leftSimpleExpression;
    private SimpleExpression rightSimpleExpression;

    public Range(RangeAttributeReference rangeAttributeReference) {
	super();
	this.rangeAttributeReference = rangeAttributeReference;
    }

    public Range(SimpleExpression leftSimpleExpression, SimpleExpression rightSimpleExpression) {
	super();
	this.leftSimpleExpression = leftSimpleExpression;
	this.rightSimpleExpression = rightSimpleExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public RangeAttributeReference getRangeAttributeReference() {
	return rangeAttributeReference;
    }

    public SimpleExpression getLeftSimpleExpression() {
	return leftSimpleExpression;
    }

    public SimpleExpression getRightSimpleExpression() {
	return rightSimpleExpression;
    }

}
