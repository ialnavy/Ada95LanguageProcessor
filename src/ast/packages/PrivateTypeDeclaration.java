package ast.packages;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DiscriminantPart;
import visitor.Ada95Visitor;

public class PrivateTypeDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscriminantPart discriminantPart;

    private Token abstractToken;
    private Token tagged;
    private Token limited;

    public PrivateTypeDeclaration(DefiningIdentifier definingIdentifier, DiscriminantPart discriminantPart,
	    Token abstractToken, Token tagged, Token limited) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discriminantPart = discriminantPart;
	this.abstractToken = abstractToken;
	this.tagged = tagged;
	this.limited = limited;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public DiscriminantPart getDiscriminantPart() {
	return discriminantPart;
    }

    public Token getAbstractToken() {
	return abstractToken;
    }

    public Token getTagged() {
	return tagged;
    }

    public Token getLimited() {
	return limited;
    }

}
