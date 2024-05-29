package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class AssignmentStatement extends AbstractAST implements AST {

    private Name variableName;
    private Expression expression;

    public AssignmentStatement(Name variableName, Expression expression) {
	super();
	this.variableName = variableName;
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Name getVariableName() {
	return variableName;
    }

    public Expression getExpression() {
	return expression;
    }

}
