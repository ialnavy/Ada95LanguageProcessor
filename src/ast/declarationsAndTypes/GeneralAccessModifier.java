package ast.declarationsAndTypes;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class GeneralAccessModifier extends AbstractAST implements AST {

    private Token token;

    public GeneralAccessModifier(Token token) {
	super();
	this.token = token;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Token getToken() {
	return token;
    }

}
