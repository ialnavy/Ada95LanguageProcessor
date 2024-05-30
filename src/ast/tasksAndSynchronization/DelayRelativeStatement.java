package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class DelayRelativeStatement extends AbstractAST implements AST {

    private Expression delayExpression;

    public DelayRelativeStatement(Expression delayExpression) {
	super();
	this.delayExpression = delayExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getDelayExpression() {
	return delayExpression;
    }

}
