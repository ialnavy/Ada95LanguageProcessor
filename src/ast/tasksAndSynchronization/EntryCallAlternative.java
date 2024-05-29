package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class EntryCallAlternative extends AbstractAST implements AST {

    private EntryCallStatement entryCallStatement;
    private SequenceOfStatements sequenceOfStatements;

    public EntryCallAlternative(EntryCallStatement entryCallStatement, SequenceOfStatements sequenceOfStatements) {
	super();
	this.entryCallStatement = entryCallStatement;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public EntryCallStatement getEntryCallStatement() {
	return entryCallStatement;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
