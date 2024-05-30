package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.SimpleExpression;
import visitor.Ada95Visitor;

public class RealRangeSpecification extends AbstractAST implements AST {

    private Range range;
    private SimpleExpression leftStaticSimpleExpression;
    private SimpleExpression rightStaticSimpleExpression;

    public RealRangeSpecification(Range range, SimpleExpression leftStaticSimpleExpression,
	    SimpleExpression rightStaticSimpleExpression) {
	super();
	this.range = range;
	this.leftStaticSimpleExpression = leftStaticSimpleExpression;
	this.rightStaticSimpleExpression = rightStaticSimpleExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Range getRange() {
	return range;
    }

    public SimpleExpression getLeftStaticSimpleExpression() {
	return leftStaticSimpleExpression;
    }

    public SimpleExpression getRightStaticSimpleExpression() {
	return rightStaticSimpleExpression;
    }

}
