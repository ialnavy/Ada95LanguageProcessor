package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DelayStatement extends AbstractAST implements AST {

    private DelayUntilStatement delayUntilStatement;
    private DelayRelativeStatement delayRelativeStatement;

    public DelayStatement(DelayUntilStatement delayUntilStatement) {
	super();
	this.delayUntilStatement = delayUntilStatement;
    }

    public DelayStatement(DelayRelativeStatement delayRelativeStatement) {
	super();
	this.delayRelativeStatement = delayRelativeStatement;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DelayUntilStatement getDelayUntilStatement() {
	return delayUntilStatement;
    }

    public DelayRelativeStatement getDelayRelativeStatement() {
	return delayRelativeStatement;
    }

}
