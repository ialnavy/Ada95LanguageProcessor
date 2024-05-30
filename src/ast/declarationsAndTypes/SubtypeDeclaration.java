package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SubtypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private SubtypeIndication subtypeIndication;

    public SubtypeDeclaration(DefiningIdentifier definingIdentifier, SubtypeIndication subtypeIndication) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.subtypeIndication = subtypeIndication;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public SubtypeIndication getSubtypeIndication() {
	return subtypeIndication;
    }

}
