package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ExplicitActualParameter extends AbstractAST implements AST {

    private Expression expression;
    private Name variableName;

    public ExplicitActualParameter(Expression expression) {
	super();
	this.expression = expression;
    }

    public ExplicitActualParameter(Name variableName) {
	super();
	this.variableName = variableName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getExpression() {
	return expression;
    }

    public Name getVariableName() {
	return variableName;
    }

}
