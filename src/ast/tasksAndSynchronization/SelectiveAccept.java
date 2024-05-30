package ast.tasksAndSynchronization;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.statements.SequenceOfStatements;
import visitor.Ada95Visitor;

public class SelectiveAccept extends AbstractAST implements AST {

    private List<SelectAlternativeClause> selectAlternativeClauses = new ArrayList<>();
    private SequenceOfStatements sequenceOfStatements;

    public SelectiveAccept(List<SelectAlternativeClause> selectAlternativeClauses,
	    SequenceOfStatements sequenceOfStatements) {
	super();
	this.selectAlternativeClauses = selectAlternativeClauses;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<SelectAlternativeClause> getSelectAlternativeClauses() {
	return new ArrayList<>(selectAlternativeClauses);
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
