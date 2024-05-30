package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class AsynchronousSelect extends AbstractAST implements AST {

    private TriggeringAlternative triggeringAlternative;
    private AbortablePart abortablePart;

    public AsynchronousSelect(TriggeringAlternative triggeringAlternative, AbortablePart abortablePart) {
	super();
	this.triggeringAlternative = triggeringAlternative;
	this.abortablePart = abortablePart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public TriggeringAlternative getTriggeringAlternative() {
	return triggeringAlternative;
    }

    public AbortablePart getAbortablePart() {
	return abortablePart;
    }

}
