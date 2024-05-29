package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.tasksAndSynchronization.ProtectedTypeDeclaration;
import ast.tasksAndSynchronization.TaskTypeDeclaration;
import visitor.Ada95Visitor;

public class FullTypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private KnownDiscriminantPart knownDiscriminantPart;
    private TypeDefinition typeDefinition;
    private TaskTypeDeclaration taskTypeDeclaration;
    private ProtectedTypeDeclaration protectedTypeDeclaration;

    public FullTypeDeclaration(DefiningIdentifier definingIdentifier, KnownDiscriminantPart knownDiscriminantPart,
	    TypeDefinition typeDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.knownDiscriminantPart = knownDiscriminantPart;
	this.typeDefinition = typeDefinition;
    }

    public FullTypeDeclaration(TaskTypeDeclaration taskTypeDeclaration) {
	super();
	this.taskTypeDeclaration = taskTypeDeclaration;
    }

    public FullTypeDeclaration(ProtectedTypeDeclaration protectedTypeDeclaration) {
	super();
	this.protectedTypeDeclaration = protectedTypeDeclaration;
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

    public TypeDefinition getTypeDefinition() {
	return typeDefinition;
    }

    public TaskTypeDeclaration getTaskTypeDeclaration() {
	return taskTypeDeclaration;
    }

    public ProtectedTypeDeclaration getProtectedTypeDeclaration() {
	return protectedTypeDeclaration;
    }

}
