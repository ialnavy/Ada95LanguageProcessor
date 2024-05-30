package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SelectStatement extends AbstractAST implements AST {

    private SelectiveAccept selectiveAccept;
    private TimedEntryCall timedEntryCall;
    private ConditionalEntryCall conditionalEntryCall;
    private AsynchronousSelect asynchronousSelect;

    public SelectStatement(SelectiveAccept selectiveAccept) {
	super();
	this.selectiveAccept = selectiveAccept;
    }

    public SelectStatement(TimedEntryCall timedEntryCall) {
	super();
	this.timedEntryCall = timedEntryCall;
    }

    public SelectStatement(ConditionalEntryCall conditionalEntryCall) {
	super();
	this.conditionalEntryCall = conditionalEntryCall;
    }

    public SelectStatement(AsynchronousSelect asynchronousSelect) {
	super();
	this.asynchronousSelect = asynchronousSelect;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SelectiveAccept getSelectiveAccept() {
	return selectiveAccept;
    }

    public TimedEntryCall getTimedEntryCall() {
	return timedEntryCall;
    }

    public ConditionalEntryCall getConditionalEntryCall() {
	return conditionalEntryCall;
    }

    public AsynchronousSelect getAsynchronousSelect() {
	return asynchronousSelect;
    }

}
