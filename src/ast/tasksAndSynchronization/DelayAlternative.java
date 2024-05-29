package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class DelayAlternative extends AbstractAST implements AST {

    private DelayStatement delayStatement;
    private SequenceOfStatements sequenceOfStatements;

    public DelayAlternative(DelayStatement delayStatement, SequenceOfStatements sequenceOfStatements) {
	super();
	this.delayStatement = delayStatement;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DelayStatement getDelayStatement() {
	return delayStatement;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
