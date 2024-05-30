package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RecordComponentAssociation extends AbstractAST implements AST {

    private ComponentChoiceList componentChoiceList;
    private Expression expression;

    public RecordComponentAssociation(ComponentChoiceList componentChoiceList, Expression expression) {
	super();
	this.componentChoiceList = componentChoiceList;
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ComponentChoiceList getComponentChoiceList() {
	return componentChoiceList;
    }

    public Expression getExpression() {
	return expression;
    }

}
