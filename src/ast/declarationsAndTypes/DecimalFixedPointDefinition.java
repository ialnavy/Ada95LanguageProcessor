package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class DecimalFixedPointDefinition extends AbstractAST implements AST {

    private Expression deltaStaticExpression;
    private Expression digitsStaticExpression;
    private RealRangeSpecification realRangeSpecification;

    public DecimalFixedPointDefinition(Expression deltaStaticExpression, Expression digitsStaticExpression,
	    RealRangeSpecification realRangeSpecification) {
	super();
	this.deltaStaticExpression = deltaStaticExpression;
	this.digitsStaticExpression = digitsStaticExpression;
	this.realRangeSpecification = realRangeSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getDeltaStaticExpression() {
	return deltaStaticExpression;
    }

    public Expression getDigitsStaticExpression() {
	return digitsStaticExpression;
    }

    public RealRangeSpecification getRealRangeSpecification() {
	return realRangeSpecification;
    }

}
