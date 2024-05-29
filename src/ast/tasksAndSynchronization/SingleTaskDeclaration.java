package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import visitor.Ada95Visitor;

public class SingleTaskDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private TaskDefinition taskDefinition;

    public SingleTaskDeclaration(DefiningIdentifier definingIdentifier, TaskDefinition taskDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.taskDefinition = taskDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public TaskDefinition getTaskDefinition() {
	return taskDefinition;
    }

}
