package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class BodyStub extends AbstractAST implements AST {

    private SubprogramBodyStub subprogramBodyStub;
    private PackageBodyStub packageBodyStub;
    private TaskBodyStub taskBodyStub;
    private ProtectedBodyStub protectedBodyStub;

    public BodyStub(SubprogramBodyStub subprogramBodyStub) {
	super();
	this.subprogramBodyStub = subprogramBodyStub;
    }

    public BodyStub(PackageBodyStub packageBodyStub) {
	super();
	this.packageBodyStub = packageBodyStub;
    }

    public BodyStub(TaskBodyStub taskBodyStub) {
	super();
	this.taskBodyStub = taskBodyStub;
    }

    public BodyStub(ProtectedBodyStub protectedBodyStub) {
	super();
	this.protectedBodyStub = protectedBodyStub;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SubprogramBodyStub getSubprogramBodyStub() {
	return subprogramBodyStub;
    }

    public PackageBodyStub getPackageBodyStub() {
	return packageBodyStub;
    }

    public TaskBodyStub getTaskBodyStub() {
	return taskBodyStub;
    }

    public ProtectedBodyStub getProtectedBodyStub() {
	return protectedBodyStub;
    }

}
