package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class FloatingPointDefinition extends AbstractAST implements AST {

    private Expression staticExpression;
    private RealRangeSpecification realRangeSpecification;

    public FloatingPointDefinition(Expression staticExpression, RealRangeSpecification realRangeSpecification) {
	super();
	this.staticExpression = staticExpression;
	this.realRangeSpecification = realRangeSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getStaticExpression() {
	return staticExpression;
    }

    public RealRangeSpecification getRealRangeSpecification() {
	return realRangeSpecification;
    }

}
