package ast.exceptions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class HandledSequenceOfStatements extends AbstractAST implements AST {

    private SequenceOfStatements sequenceOfStatements;
    private List<ExceptionHandler> exceptionHandlers = new ArrayList<>();

    public HandledSequenceOfStatements(SequenceOfStatements sequenceOfStatements,
	    List<ExceptionHandler> exceptionHandlers) {
	super();
	this.sequenceOfStatements = sequenceOfStatements;
	this.exceptionHandlers = exceptionHandlers;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

    public List<ExceptionHandler> getExceptionHandlers() {
	return new ArrayList<>(exceptionHandlers);
    }

}
