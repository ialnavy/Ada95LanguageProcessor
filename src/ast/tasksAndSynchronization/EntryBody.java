package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DeclarativePart;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.exceptions.HandledSequenceOfStatements;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class EntryBody extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private EntryBodyFormalPart entryBodyFormalPart;
    private EntryBarrier entryBarrier;
    private DeclarativePart declarativePart;
    private HandledSequenceOfStatements handledSequenceOfStatements;
    private Identifier entryIdentifier;

    public EntryBody(DefiningIdentifier definingIdentifier, EntryBodyFormalPart entryBodyFormalPart,
	    EntryBarrier entryBarrier, DeclarativePart declarativePart,
	    HandledSequenceOfStatements handledSequenceOfStatements, Identifier entryIdentifier) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.entryBodyFormalPart = entryBodyFormalPart;
	this.entryBarrier = entryBarrier;
	this.declarativePart = declarativePart;
	this.handledSequenceOfStatements = handledSequenceOfStatements;
	this.entryIdentifier = entryIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public EntryBodyFormalPart getEntryBodyFormalPart() {
	return entryBodyFormalPart;
    }

    public EntryBarrier getEntryBarrier() {
	return entryBarrier;
    }

    public DeclarativePart getDeclarativePart() {
	return declarativePart;
    }

    public HandledSequenceOfStatements getHandledSequenceOfStatements() {
	return handledSequenceOfStatements;
    }

    public Identifier getEntryIdentifier() {
	return entryIdentifier;
    }

}
