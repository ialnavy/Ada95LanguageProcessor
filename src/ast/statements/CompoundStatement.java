package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.tasksAndSynchronization.AcceptStatement;
import ast.tasksAndSynchronization.SelectStatement;
import visitor.Ada95Visitor;

public class CompoundStatement extends AbstractAST implements AST {

    private IfStatement ifStatement;
    private CaseStatement caseStatement;
    private LoopStatement loopStatement;
    private BlockStatement blockStatement;
    private AcceptStatement acceptStatement;
    private SelectStatement selectStatement;

    public CompoundStatement(IfStatement ifStatement) {
	super();
	this.ifStatement = ifStatement;
    }

    public CompoundStatement(CaseStatement caseStatement) {
	super();
	this.caseStatement = caseStatement;
    }

    public CompoundStatement(LoopStatement loopStatement) {
	super();
	this.loopStatement = loopStatement;
    }

    public CompoundStatement(BlockStatement blockStatement) {
	super();
	this.blockStatement = blockStatement;
    }

    public CompoundStatement(AcceptStatement acceptStatement) {
	super();
	this.acceptStatement = acceptStatement;
    }

    public CompoundStatement(SelectStatement selectStatement) {
	super();
	this.selectStatement = selectStatement;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public IfStatement getIfStatement() {
	return ifStatement;
    }

    public CaseStatement getCaseStatement() {
	return caseStatement;
    }

    public LoopStatement getLoopStatement() {
	return loopStatement;
    }

    public BlockStatement getBlockStatement() {
	return blockStatement;
    }

    public AcceptStatement getAcceptStatement() {
	return acceptStatement;
    }

    public SelectStatement getSelectStatement() {
	return selectStatement;
    }

}
