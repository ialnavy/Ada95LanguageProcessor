package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class AncestorPart extends AbstractAST implements AST {

    private Expression expression;
    private Name subtypeMark;

    public AncestorPart(Expression expression) {
	super();
	this.expression = expression;
    }

    public AncestorPart(Name subtypeMark) {
	super();
	this.subtypeMark = subtypeMark;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getExpression() {
	return expression;
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

}
