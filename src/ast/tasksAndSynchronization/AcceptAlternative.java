package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class AcceptAlternative extends AbstractAST implements AST {

    private AcceptStatement acceptStatement;
    private SequenceOfStatements sequenceOfStatements;

    public AcceptAlternative(AcceptStatement acceptStatement, SequenceOfStatements sequenceOfStatements) {
	super();
	this.acceptStatement = acceptStatement;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public AcceptStatement getAcceptStatement() {
	return acceptStatement;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
