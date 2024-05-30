package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DeclarativePart;
import ast.exceptions.HandledSequenceOfStatements;
import visitor.Ada95Visitor;

public class SubprogramBody extends AbstractAST implements AST {

    private SubprogramSpecification subprogramSpecification;
    private DeclarativePart declarativePart;
    private HandledSequenceOfStatements handledSequenceOfStatements;
    private Designator designator;

    public SubprogramBody(SubprogramSpecification subprogramSpecification, DeclarativePart declarativePart,
	    HandledSequenceOfStatements handledSequenceOfStatements, Designator designator) {
	super();
	this.subprogramSpecification = subprogramSpecification;
	this.declarativePart = declarativePart;
	this.handledSequenceOfStatements = handledSequenceOfStatements;
	this.designator = designator;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SubprogramSpecification getSubprogramSpecification() {
	return subprogramSpecification;
    }

    public DeclarativePart getDeclarativePart() {
	return declarativePart;
    }

    public HandledSequenceOfStatements getHandledSequenceOfStatements() {
	return handledSequenceOfStatements;
    }

    public Designator getDesignator() {
	return designator;
    }

}
