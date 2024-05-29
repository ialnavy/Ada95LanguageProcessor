package ast.statements;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class IfStatementElsifClause extends AbstractAST implements AST {

    private Condition condition;
    private SequenceOfStatements sequenceOfStatements;

    public IfStatementElsifClause(Condition condition, SequenceOfStatements sequenceOfStatements) {
	super();
	this.condition = condition;
	this.sequenceOfStatements = sequenceOfStatements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Condition getCondition() {
	return condition;
    }

    public SequenceOfStatements getSequenceOfStatements() {
	return sequenceOfStatements;
    }

}
