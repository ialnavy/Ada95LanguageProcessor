package ast.others;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class BooleanExpression extends AbstractAST implements AST {

    private Expression expression;

    public BooleanExpression(Expression expression) {
	super();
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getExpression() {
	return expression;
    }

}
