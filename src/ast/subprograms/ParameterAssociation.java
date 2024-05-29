package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.SelectorName;
import visitor.Ada95Visitor;

public class ParameterAssociation extends AbstractAST implements AST {

    private SelectorName selectorName;
    private ExplicitActualParameter explicitActualParameter;

    public ParameterAssociation(SelectorName selectorName, ExplicitActualParameter explicitActualParameter) {
	super();
	this.selectorName = selectorName;
	this.explicitActualParameter = explicitActualParameter;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SelectorName getSelectorName() {
	return selectorName;
    }

    public ExplicitActualParameter getExplicitActualParameter() {
	return explicitActualParameter;
    }

}
