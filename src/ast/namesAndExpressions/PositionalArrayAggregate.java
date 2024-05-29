package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class PositionalArrayAggregate extends AbstractAST implements AST {

    private List<Expression> expressions = new ArrayList<>();
    private Expression expressionForOthersClause;

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<Expression> getExpressions() {
	return new ArrayList<>(expressions);
    }

    public void addExpression(Expression expression) {
	expressions.add(expression);
    }

    public Expression getExpressionForOthersClause() {
	return expressionForOthersClause;
    }

    public void setExpressionForOthersClause(Expression expressionForOthersClause) {
	this.expressionForOthersClause = expressionForOthersClause;
    }

}
