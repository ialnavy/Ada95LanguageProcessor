package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DiscreteChoiceList;
import visitor.Ada95Visitor;

public class CaseStatementAlternative extends AbstractAST implements AST {

    private DiscreteChoiceList discreteChoiceList;
    private SequenceOfStatements sequenceOfStatements;

    public CaseStatementAlternative(DiscreteChoiceList discreteChoiceList, SequenceOfStatements sequenceOfStatements) {
	super();
	this.discreteChoiceList = discreteChoiceList;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DiscreteChoiceList getDiscreteChoiceList() {
	return discreteChoiceList;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
