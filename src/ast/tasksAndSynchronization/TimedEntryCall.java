package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class TimedEntryCall extends AbstractAST implements AST {

    private EntryCallAlternative entryCallAlternative;
    private DelayAlternative delayAlternative;

    public TimedEntryCall(EntryCallAlternative entryCallAlternative, DelayAlternative delayAlternative) {
	super();
	this.entryCallAlternative = entryCallAlternative;
	this.delayAlternative = delayAlternative;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public EntryCallAlternative getEntryCallAlternative() {
	return entryCallAlternative;
    }

    public DelayAlternative getDelayAlternative() {
	return delayAlternative;
    }

}
