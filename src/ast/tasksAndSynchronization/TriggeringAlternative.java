package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class TriggeringAlternative extends AbstractAST implements AST {

    private TriggeringStatement triggeringStatement;
    private SequenceOfStatements sequenceOfStatements;

    public TriggeringAlternative(TriggeringStatement triggeringStatement, SequenceOfStatements sequenceOfStatements) {
	super();
	this.triggeringStatement = triggeringStatement;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public TriggeringStatement getTriggeringStatement() {
	return triggeringStatement;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
