package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class IfStatement extends AbstractAST implements AST {

    private Condition condition;
    private SequenceOfStatements ifSequenceOfStatements;
    private List<IfStatementElsifClause> ifStatementElsifClauses = new ArrayList<>();
    private SequenceOfStatements elseSequenceOfStatements;

    public IfStatement(Condition condition, SequenceOfStatements ifSequenceOfStatements,
	    List<IfStatementElsifClause> ifStatementElsifClauses, SequenceOfStatements elseSequenceOfStatements) {
	super();
	this.condition = condition;
	this.ifSequenceOfStatements = ifSequenceOfStatements;
	this.ifStatementElsifClauses = ifStatementElsifClauses;
	this.elseSequenceOfStatements = elseSequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Condition getCondition() {
	return condition;
    }

    public SequenceOfStatements getIfSequenceOfStatements() {
	return ifSequenceOfStatements;
    }

    public List<IfStatementElsifClause> getIfStatementElsifClauses() {
	return new ArrayList<>(ifStatementElsifClauses);
    }

    public SequenceOfStatements getElseSequenceOfStatements() {
	return elseSequenceOfStatements;
    }

}
