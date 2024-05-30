package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class Restriction extends AbstractAST implements AST {

    private Identifier identifier;
    private Expression expression;

    public Restriction(Identifier identifier) {
	super();
	this.identifier = identifier;
    }

    public Restriction(Identifier identifier, Expression expression) {
	super();
	this.identifier = identifier;
	this.expression = expression;
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

}
