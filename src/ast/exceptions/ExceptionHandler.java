package ast.exceptions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class ExceptionHandler extends AbstractAST implements AST {

    private ChoiceParameterSpecification choiceParameterSpecification;
    private List<ExceptionChoice> exceptionChoices = new ArrayList<>();
    private SequenceOfStatements sequenceOfStatements;

    public ExceptionHandler(ChoiceParameterSpecification choiceParameterSpecification,
	    List<ExceptionChoice> exceptionChoices, SequenceOfStatements sequenceOfStatements) {
	super();
	this.choiceParameterSpecification = choiceParameterSpecification;
	this.exceptionChoices = exceptionChoices;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ChoiceParameterSpecification getChoiceParameterSpecification() {
	return choiceParameterSpecification;
    }

    public List<ExceptionChoice> getExceptionChoices() {
	return new ArrayList<>(exceptionChoices);
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
