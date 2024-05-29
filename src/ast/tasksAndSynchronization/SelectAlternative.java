package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SelectAlternative extends AbstractAST implements AST {

    private AcceptAlternative acceptAlternative;
    private DelayAlternative delayAlternative;
    private TerminateAlternative terminateAlternative;

    public SelectAlternative(AcceptAlternative acceptAlternative) {
	super();
	this.acceptAlternative = acceptAlternative;
    }

    public SelectAlternative(DelayAlternative delayAlternative) {
	super();
	this.delayAlternative = delayAlternative;
    }

    public SelectAlternative(TerminateAlternative terminateAlternative) {
	super();
	this.terminateAlternative = terminateAlternative;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public AcceptAlternative getAcceptAlternative() {
	return acceptAlternative;
    }

    public DelayAlternative getDelayAlternative() {
	return delayAlternative;
    }

    public TerminateAlternative getTerminateAlternative() {
	return terminateAlternative;
    }

}
