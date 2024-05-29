package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ExplicitGenericActualParameter extends AbstractAST implements AST {

    private Expression expression;
    private Name name;

    public ExplicitGenericActualParameter(Expression expression) {
	super();
	this.expression = expression;
    }

    public ExplicitGenericActualParameter(Name name) {
	super();
	this.name = name;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Expression getExpression() {
	return expression;
    }

    public Name getName() {
	return name;
    }

}
