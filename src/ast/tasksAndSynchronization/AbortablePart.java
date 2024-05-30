package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class AbortablePart extends AbstractAST implements AST {

    private SequenceOfStatements sequenceOfStatements;

    public AbortablePart(SequenceOfStatements sequenceOfStatements) {
	super();
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
