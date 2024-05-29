package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DeclarativePart;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.exceptions.HandledSequenceOfStatements;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class TaskBody extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DeclarativePart declarativePart;
    private HandledSequenceOfStatements handledSequenceOfStatements;
    private Identifier taskIdentifier;

    public TaskBody(DefiningIdentifier definingIdentifier, DeclarativePart declarativePart,
	    HandledSequenceOfStatements handledSequenceOfStatements, Identifier taskIdentifier) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.declarativePart = declarativePart;
	this.handledSequenceOfStatements = handledSequenceOfStatements;
	this.taskIdentifier = taskIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public DeclarativePart getDeclarativePart() {
	return declarativePart;
    }

    public HandledSequenceOfStatements getHandledSequenceOfStatements() {
	return handledSequenceOfStatements;
    }

    public Identifier getTaskIdentifier() {
	return taskIdentifier;
    }

}
