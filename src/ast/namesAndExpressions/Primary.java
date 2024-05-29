package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.NumericLiteral;
import ast.lexicalElements.StringLiteral;
import visitor.Ada95Visitor;

public class Primary extends AbstractAST implements AST {

    private NumericLiteral numericLiteral;
    private StringLiteral stringLiteral;
    private Aggregate aggregate;
    private Name name;
    private QualifiedExpression qualifiedExpression;
    private Allocator allocator;
    private Expression expression;

    public Primary(NumericLiteral numericLiteral) {
	super();
	this.numericLiteral = numericLiteral;
    }

    public Primary() {
	super();
    }

    public Primary(StringLiteral stringLiteral) {
	super();
	this.stringLiteral = stringLiteral;
    }

    public Primary(Aggregate aggregate) {
	super();
	this.aggregate = aggregate;
    }

    public Primary(Name name) {
	super();
	this.name = name;
    }

    public Primary(QualifiedExpression qualifiedExpression) {
	super();
	this.qualifiedExpression = qualifiedExpression;
    }

    public Primary(Allocator allocator) {
	super();
	this.allocator = allocator;
    }

    public Primary(Expression expression) {
	super();
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public NumericLiteral getNumericLiteral() {
	return numericLiteral;
    }

    public StringLiteral getStringLiteral() {
	return stringLiteral;
    }

    public Aggregate getAggregate() {
	return aggregate;
    }

    public Name getName() {
	return name;
    }

    public QualifiedExpression getQualifiedExpression() {
	return qualifiedExpression;
    }

    public Allocator getAllocator() {
	return allocator;
    }

    public Expression getExpression() {
	return expression;
    }

}
