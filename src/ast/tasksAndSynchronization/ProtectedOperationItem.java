package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.representationIssues.AspectClause;
import ast.subprograms.SubprogramBody;
import ast.subprograms.SubprogramDeclaration;
import visitor.Ada95Visitor;

public class ProtectedOperationItem extends AbstractAST implements AST {

    private SubprogramDeclaration subprogramDeclaration;
    private SubprogramBody subprogramBody;
    private EntryBody entryBody;
    private AspectClause aspectClause;

    public ProtectedOperationItem(SubprogramDeclaration subprogramDeclaration) {
	super();
	this.subprogramDeclaration = subprogramDeclaration;
    }

    public ProtectedOperationItem(SubprogramBody subprogramBody) {
	super();
	this.subprogramBody = subprogramBody;
    }

    public ProtectedOperationItem(EntryBody entryBody) {
	super();
	this.entryBody = entryBody;
    }

    public ProtectedOperationItem(AspectClause aspectClause) {
	super();
	this.aspectClause = aspectClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubprogramDeclaration getSubprogramDeclaration() {
	return subprogramDeclaration;
    }

    public SubprogramBody getSubprogramBody() {
	return subprogramBody;
    }

    public EntryBody getEntryBody() {
	return entryBody;
    }

    public AspectClause getAspectClause() {
	return aspectClause;
    }

}
