package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.packages.PackageBody;
import ast.subprograms.SubprogramBody;
import ast.tasksAndSynchronization.ProtectedBody;
import ast.tasksAndSynchronization.TaskBody;
import visitor.Ada95Visitor;

public class ProperBody extends AbstractAST implements AST {

    private SubprogramBody subprogramBody;
    private PackageBody packageBody;
    private TaskBody taskBody;
    private ProtectedBody protectedBody;

    public ProperBody(SubprogramBody subprogramBody) {
	super();
	this.subprogramBody = subprogramBody;
    }

    public ProperBody(PackageBody packageBody) {
	super();
	this.packageBody = packageBody;
    }

    public ProperBody(TaskBody taskBody) {
	super();
	this.taskBody = taskBody;
    }

    public ProperBody(ProtectedBody protectedBody) {
	super();
	this.protectedBody = protectedBody;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubprogramBody getSubprogramBody() {
	return subprogramBody;
    }

    public PackageBody getPackageBody() {
	return packageBody;
    }

    public TaskBody getTaskBody() {
	return taskBody;
    }

    public ProtectedBody getProtectedBody() {
	return protectedBody;
    }

}
