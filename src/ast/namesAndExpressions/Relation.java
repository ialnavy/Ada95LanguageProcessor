package ast.namesAndExpressions;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.Range;
import visitor.Ada95Visitor;

public class Relation extends AbstractAST implements AST {

    private SimpleExpression leftSimpleExpression;
    private RelationalOperator relationalOperator;
    private SimpleExpression rightSimpleExpression;
    private Range range;
    private Name subtypeMark;

    private Token notToken;

    public Relation(SimpleExpression leftSimpleExpression, RelationalOperator relationalOperator,
	    SimpleExpression rightSimpleExpression) {
	super();
	this.leftSimpleExpression = leftSimpleExpression;
	this.relationalOperator = relationalOperator;
	this.rightSimpleExpression = rightSimpleExpression;
    }

    public Relation(SimpleExpression leftSimpleExpression, Range range, Token notToken) {
	super();
	this.leftSimpleExpression = leftSimpleExpression;
	this.range = range;
	this.notToken = notToken;
    }

    public Relation(SimpleExpression leftSimpleExpression, Name subtypeMark, Token notToken) {
	super();
	this.leftSimpleExpression = leftSimpleExpression;
	this.subtypeMark = subtypeMark;
	this.notToken = notToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SimpleExpression getLeftSimpleExpression() {
	return leftSimpleExpression;
    }

    public RelationalOperator getRelationalOperator() {
	return relationalOperator;
    }

    public SimpleExpression getRightSimpleExpression() {
	return rightSimpleExpression;
    }

    public Range getRange() {
	return range;
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

    public Token getNotToken() {
	return notToken;
    }

}
