package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class EnumerationLiteralSpecification extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DefiningCharacterLiteral definingCharacterLiteral;

    public EnumerationLiteralSpecification(DefiningIdentifier definingIdentifier) {
	super();
	this.definingIdentifier = definingIdentifier;
    }

    public EnumerationLiteralSpecification(DefiningCharacterLiteral definingCharacterLiteral) {
	super();
	this.definingCharacterLiteral = definingCharacterLiteral;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public DefiningCharacterLiteral getDefiningCharacterLiteral() {
	return definingCharacterLiteral;
    }

}
