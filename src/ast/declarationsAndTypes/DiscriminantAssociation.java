package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import ast.namesAndExpressions.SelectorName;
import visitor.Ada95Visitor;

public class DiscriminantAssociation extends AbstractAST implements AST {

    private List<SelectorName> selectorNames = new ArrayList<>();
    private Expression expression;

    public DiscriminantAssociation(List<SelectorName> selectorNames, Expression expression) {
	super();
	this.selectorNames = selectorNames;
	this.expression = expression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<SelectorName> getSelectorNames() {
	return new ArrayList<>(selectorNames);
    }

    public Expression getExpression() {
	return expression;
    }

}
