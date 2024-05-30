package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.exceptions.HandledSequenceOfStatements;
import ast.lexicalElements.Identifier;
import ast.namesAndExpressions.DirectName;
import ast.subprograms.ParameterProfile;
import visitor.Ada95Visitor;

public class AcceptStatement extends AbstractAST implements AST {

    private DirectName entryDirectName;
    private EntryIndex entryIndex;
    private ParameterProfile parameterProfile;
    private HandledSequenceOfStatements handledSequenceOfStatements;
    private Identifier entryIdentifier;

    public AcceptStatement(DirectName entryDirectName, EntryIndex entryIndex, ParameterProfile parameterProfile,
	    HandledSequenceOfStatements handledSequenceOfStatements, Identifier entryIdentifier) {
	super();
	this.entryDirectName = entryDirectName;
	this.entryIndex = entryIndex;
	this.parameterProfile = parameterProfile;
	this.handledSequenceOfStatements = handledSequenceOfStatements;
	this.entryIdentifier = entryIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DirectName getEntryDirectName() {
	return entryDirectName;
    }

    public EntryIndex getEntryIndex() {
	return entryIndex;
    }

    public ParameterProfile getParameterProfile() {
	return parameterProfile;
    }

    public HandledSequenceOfStatements getHandledSequenceOfStatements() {
	return handledSequenceOfStatements;
    }

    public Identifier getEntryIdentifier() {
	return entryIdentifier;
    }

}
