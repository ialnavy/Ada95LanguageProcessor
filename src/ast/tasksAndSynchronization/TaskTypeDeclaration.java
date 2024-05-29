package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.KnownDiscriminantPart;
import visitor.Ada95Visitor;

public class TaskTypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private KnownDiscriminantPart knownDiscriminantPart;
    private TaskDefinition taskDefinition;

    public TaskTypeDeclaration(DefiningIdentifier definingIdentifier, KnownDiscriminantPart knownDiscriminantPart,
	    TaskDefinition taskDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.knownDiscriminantPart = knownDiscriminantPart;
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

    public KnownDiscriminantPart getKnownDiscriminantPart() {
	return knownDiscriminantPart;
    }

    public TaskDefinition getTaskDefinition() {
	return taskDefinition;
    }

}
