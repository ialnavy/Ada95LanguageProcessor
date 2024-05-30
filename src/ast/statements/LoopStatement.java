package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class LoopStatement extends AbstractAST implements AST {

    private StatementIdentifier loopStatementIdentifier;
    private IterationScheme iterationScheme;
    private SequenceOfStatements sequenceOfStatements;
    private Identifier loopIdentifier;

    public LoopStatement(StatementIdentifier loopStatementIdentifier, IterationScheme iterationScheme,
	    SequenceOfStatements sequenceOfStatements, Identifier loopIdentifier) {
	super();
	this.loopStatementIdentifier = loopStatementIdentifier;
	this.iterationScheme = iterationScheme;
	this.sequenceOfStatements = sequenceOfStatements;
	this.loopIdentifier = loopIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public StatementIdentifier getLoopStatementIdentifier() {
	return loopStatementIdentifier;
    }

    public IterationScheme getIterationScheme() {
	return iterationScheme;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

    public Identifier getLoopIdentifier() {
	return loopIdentifier;
    }

}
