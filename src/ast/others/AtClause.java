package ast.others;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.DirectName;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class AtClause extends AbstractAST implements AST {

    private DirectName directName;
    private Expression expression;

    public AtClause(DirectName directName, Expression expression) {
	super();
	this.directName = directName;
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DirectName getDirectName() {
	return directName;
    }

    public Expression getExpression() {
	return expression;
    }

}
