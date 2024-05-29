package ast.genericUnits;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class FormalPrivateTypeDefinition extends AbstractAST implements AST {

    private Token abstractToken;
    private Token taggedToken;
    private Token limitedToken;

    public FormalPrivateTypeDefinition(Token abstractToken, Token taggedToken, Token limitedToken) {
	super();
	this.abstractToken = abstractToken;
	this.taggedToken = taggedToken;
	this.limitedToken = limitedToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Token getAbstractToken() {
	return abstractToken;
    }

    public Token getTaggedToken() {
	return taggedToken;
    }

    public Token getLimitedToken() {
	return limitedToken;
    }

}
