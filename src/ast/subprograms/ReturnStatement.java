package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class ReturnStatement extends AbstractAST implements AST {

    private Expression expression;

    public ReturnStatement(Expression expression) {
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
