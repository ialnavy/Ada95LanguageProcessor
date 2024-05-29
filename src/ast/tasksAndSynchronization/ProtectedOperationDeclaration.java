package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.representationIssues.AspectClause;
import ast.subprograms.SubprogramDeclaration;
import visitor.Ada95Visitor;

public class ProtectedOperationDeclaration extends AbstractAST implements AST {

    private SubprogramDeclaration subprogramDeclaration;
    private EntryDeclaration entryDeclaration;
    private AspectClause aspectClause;

    public ProtectedOperationDeclaration(SubprogramDeclaration subprogramDeclaration) {
	super();
	this.subprogramDeclaration = subprogramDeclaration;
    }

    public ProtectedOperationDeclaration(EntryDeclaration entryDeclaration) {
	super();
	this.entryDeclaration = entryDeclaration;
    }

    public ProtectedOperationDeclaration(AspectClause aspectClause) {
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

    public EntryDeclaration getEntryDeclaration() {
	return entryDeclaration;
    }

    public AspectClause getAspectClause() {
	return aspectClause;
    }

}
