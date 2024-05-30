package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class IncompleteTypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscriminantPart discriminantPart;

    public IncompleteTypeDeclaration(DefiningIdentifier definingIdentifier, DiscriminantPart discriminantPart) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discriminantPart = discriminantPart;
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

}
