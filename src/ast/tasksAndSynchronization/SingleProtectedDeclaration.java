package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import visitor.Ada95Visitor;

public class SingleProtectedDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private ProtectedDefinition protectedDefinition;

    public SingleProtectedDeclaration(DefiningIdentifier definingIdentifier, ProtectedDefinition protectedDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.protectedDefinition = protectedDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public ProtectedDefinition getProtectedDefinition() {
	return protectedDefinition;
    }

}
