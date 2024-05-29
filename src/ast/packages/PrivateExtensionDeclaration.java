package ast.packages;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DiscriminantPart;
import ast.declarationsAndTypes.SubtypeIndication;
import visitor.Ada95Visitor;

public class PrivateExtensionDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscriminantPart discriminantPart;
    private SubtypeIndication ancestorSubtypeIndication;

    private Token abstractToken;

    public PrivateExtensionDeclaration(DefiningIdentifier definingIdentifier, DiscriminantPart discriminantPart,
	    SubtypeIndication ancestorSubtypeIndication, Token abstractToken) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discriminantPart = discriminantPart;
	this.ancestorSubtypeIndication = ancestorSubtypeIndication;
	this.abstractToken = abstractToken;
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

    public SubtypeIndication getAncestorSubtypeIndication() {
	return ancestorSubtypeIndication;
    }

    public Token getAbstractToken() {
	return abstractToken;
    }

}
