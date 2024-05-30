package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.KnownDiscriminantPart;
import visitor.Ada95Visitor;

public class ProtectedTypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private KnownDiscriminantPart knownDiscriminantPart;
    private ProtectedDefinition protectedDefinition;

    public ProtectedTypeDeclaration(DefiningIdentifier definingIdentifier, KnownDiscriminantPart knownDiscriminantPart,
	    ProtectedDefinition protectedDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.knownDiscriminantPart = knownDiscriminantPart;
	this.protectedDefinition = protectedDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public KnownDiscriminantPart getKnownDiscriminantPart() {
	return knownDiscriminantPart;
    }

    public ProtectedDefinition getProtectedDefinition() {
	return protectedDefinition;
    }

}
