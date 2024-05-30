package ast.namesAndExpressions;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class AttributeDesignator extends AbstractAST implements AST {

    private Identifier identifier;
    private Expression expression;
    private Token token;

    public AttributeDesignator(Identifier identifier, Expression expression) {
	super();
	this.identifier = identifier;
	this.expression = expression;
    }

    public AttributeDesignator(Token token) {
	super();
	this.token = token;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Identifier getIdentifier() {
	return identifier;
    }

    public Expression getExpression() {
	return expression;
    }

    public Token getToken() {
	return token;
    }

}
