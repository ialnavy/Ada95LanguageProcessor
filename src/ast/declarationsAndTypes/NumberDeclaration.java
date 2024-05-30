package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class NumberDeclaration extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;
    private Expression expression;

    public NumberDeclaration(DefiningIdentifierList definingIdentifierList, Expression expression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifierList getDefiningIdentifierList() {
	return definingIdentifierList;
    }

    public Expression getExpression() {
	return expression;
    }

}
