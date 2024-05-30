package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DiscriminantPart;
import visitor.Ada95Visitor;

public class FormalTypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscriminantPart discriminantPart;
    private FormalTypeDefinition formalTypeDefinition;

    public FormalTypeDeclaration(DefiningIdentifier definingIdentifier, DiscriminantPart discriminantPart,
	    FormalTypeDefinition formalTypeDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discriminantPart = discriminantPart;
	this.formalTypeDefinition = formalTypeDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public DiscriminantPart getDiscriminantPart() {
	return discriminantPart;
    }

    public FormalTypeDefinition getFormalTypeDefinition() {
	return formalTypeDefinition;
    }

}
