package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class ConditionalEntryCall extends AbstractAST implements AST {

    private EntryCallAlternative entryCallAlternative;
    private SequenceOfStatements sequenceOfStatements;

    public ConditionalEntryCall(EntryCallAlternative entryCallAlternative, SequenceOfStatements sequenceOfStatements) {
	super();
	this.entryCallAlternative = entryCallAlternative;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public EntryCallAlternative getEntryCallAlternative() {
	return entryCallAlternative;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
