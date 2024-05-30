package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class TriggeringStatement extends AbstractAST implements AST {

    private EntryCallStatement entryCallStatement;
    private DelayStatement delayStatement;

    public TriggeringStatement(EntryCallStatement entryCallStatement) {
	super();
	this.entryCallStatement = entryCallStatement;
    }

    public TriggeringStatement(DelayStatement delayStatement) {
	super();
	this.delayStatement = delayStatement;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public EntryCallStatement getEntryCallStatement() {
	return entryCallStatement;
    }

    public DelayStatement getDelayStatement() {
	return delayStatement;
    }

}
