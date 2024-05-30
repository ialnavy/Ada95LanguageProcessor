package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class QualifiedExpression extends AbstractAST implements AST {

    private Name subtypeMark;
    private Expression expression;
    private Aggregate aggregate;

    public QualifiedExpression(Name subtypeMark, Expression expression) {
	super();
	this.subtypeMark = subtypeMark;
	this.expression = expression;
    }

    public QualifiedExpression(Name subtypeMark, Aggregate aggregate) {
	super();
	this.subtypeMark = subtypeMark;
	this.aggregate = aggregate;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

    public Expression getExpression() {
	return expression;
    }

    public Aggregate getAggregate() {
	return aggregate;
    }

}
