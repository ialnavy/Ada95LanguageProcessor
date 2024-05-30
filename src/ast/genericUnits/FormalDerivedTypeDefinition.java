package ast.genericUnits;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class FormalDerivedTypeDefinition extends AbstractAST implements AST {

    private Name subtypeMark;

    private Token abstractToken;
    private Token withToken;
    private Token privateToken;

    public FormalDerivedTypeDefinition(Name subtypeMark, Token abstractToken, Token withToken, Token privateToken) {
	super();
	this.subtypeMark = subtypeMark;
	this.abstractToken = abstractToken;
	this.withToken = withToken;
	this.privateToken = privateToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

    public Token getAbstractToken() {
	return abstractToken;
    }

    public Token getWithToken() {
	return withToken;
    }

    public Token getPrivateToken() {
	return privateToken;
    }

}
