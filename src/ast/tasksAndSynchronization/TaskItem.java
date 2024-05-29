package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.representationIssues.AspectClause;
import visitor.Ada95Visitor;

public class TaskItem extends AbstractAST implements AST {

    private EntryDeclaration entryDeclaration;
    private AspectClause aspectClause;

    public TaskItem(EntryDeclaration entryDeclaration) {
	super();
	this.entryDeclaration = entryDeclaration;
    }

    public TaskItem(AspectClause aspectClause) {
	super();
	this.aspectClause = aspectClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public EntryDeclaration getEntryDeclaration() {
	return entryDeclaration;
    }

    public AspectClause getAspectClause() {
	return aspectClause;
    }

}
