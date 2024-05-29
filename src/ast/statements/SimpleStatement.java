package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.exceptions.RaiseStatement;
import ast.representationIssues.CodeStatement;
import ast.subprograms.ProcedureCallStatement;
import ast.subprograms.ReturnStatement;
import ast.tasksAndSynchronization.AbortStatement;
import ast.tasksAndSynchronization.DelayStatement;
import ast.tasksAndSynchronization.EntryCallStatement;
import ast.tasksAndSynchronization.RequeueStatement;
import visitor.Ada95Visitor;

public class SimpleStatement extends AbstractAST implements AST {

    private NullStatement nullStatement;
    private AssignmentStatement assignmentStatement;
    private ExitStatement exitStatement;
    private GotoStatement gotoStatement;
    private ProcedureCallStatement procedureCallStatement;
    private ReturnStatement returnStatement;
    private EntryCallStatement entryCallStatement;
    private RequeueStatement requeueStatement;
    private DelayStatement delayStatement;
    private AbortStatement abortStatement;
    private RaiseStatement raiseStatement;
    private CodeStatement codeStatement;

    public SimpleStatement(NullStatement nullStatement) {
	super();
	this.nullStatement = nullStatement;
    }

    public SimpleStatement(AssignmentStatement assignmentStatement) {
	super();
	this.assignmentStatement = assignmentStatement;
    }

    public SimpleStatement(ExitStatement exitStatement) {
	super();
	this.exitStatement = exitStatement;
    }

    public SimpleStatement(GotoStatement gotoStatement) {
	super();
	this.gotoStatement = gotoStatement;
    }

    public SimpleStatement(ProcedureCallStatement procedureCallStatement) {
	super();
	this.procedureCallStatement = procedureCallStatement;
    }

    public SimpleStatement(ReturnStatement returnStatement) {
	super();
	this.returnStatement = returnStatement;
    }

    public SimpleStatement(EntryCallStatement entryCallStatement) {
	super();
	this.entryCallStatement = entryCallStatement;
    }

    public SimpleStatement(RequeueStatement requeueStatement) {
	super();
	this.requeueStatement = requeueStatement;
    }

    public SimpleStatement(DelayStatement delayStatement) {
	super();
	this.delayStatement = delayStatement;
    }

    public SimpleStatement(AbortStatement abortStatement) {
	super();
	this.abortStatement = abortStatement;
    }

    public SimpleStatement(RaiseStatement raiseStatement) {
	super();
	this.raiseStatement = raiseStatement;
    }

    public SimpleStatement(CodeStatement codeStatement) {
	super();
	this.codeStatement = codeStatement;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public NullStatement getNullStatement() {
	return nullStatement;
    }

    public AssignmentStatement getAssignmentStatement() {
	return assignmentStatement;
    }

    public ExitStatement getExitStatement() {
	return exitStatement;
    }

    public GotoStatement getGotoStatement() {
	return gotoStatement;
    }

    public ProcedureCallStatement getProcedureCallStatement() {
	return procedureCallStatement;
    }

    public ReturnStatement getReturnStatement() {
	return returnStatement;
    }

    public EntryCallStatement getEntryCallStatement() {
	return entryCallStatement;
    }

    public RequeueStatement getRequeueStatement() {
	return requeueStatement;
    }

    public DelayStatement getDelayStatement() {
	return delayStatement;
    }

    public AbortStatement getAbortStatement() {
	return abortStatement;
    }

    public RaiseStatement getRaiseStatement() {
	return raiseStatement;
    }

    public CodeStatement getCodeStatement() {
	return codeStatement;
    }

}
