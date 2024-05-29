package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DeclarativePart;
import ast.exceptions.HandledSequenceOfStatements;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class BlockStatement extends AbstractAST implements AST {

    private StatementIdentifier blockStatementIdentifier;
    private DeclarativePart declarativePart;
    private HandledSequenceOfStatements handledSequenceOfStatements;
    private Identifier blockIdentifier;

    public BlockStatement(StatementIdentifier blockStatementIdentifier, DeclarativePart declarativePart,
	    HandledSequenceOfStatements handledSequenceOfStatements, Identifier blockIdentifier) {
	super();
	this.blockStatementIdentifier = blockStatementIdentifier;
	this.declarativePart = declarativePart;
	this.handledSequenceOfStatements = handledSequenceOfStatements;
	this.blockIdentifier = blockIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public StatementIdentifier getBlockStatementIdentifier() {
	return blockStatementIdentifier;
    }

    public DeclarativePart getDeclarativePart() {
	return declarativePart;
    }

    public HandledSequenceOfStatements getHandledSequenceOfStatements() {
	return handledSequenceOfStatements;
    }

    public Identifier getBlockIdentifier() {
	return blockIdentifier;
    }

}
