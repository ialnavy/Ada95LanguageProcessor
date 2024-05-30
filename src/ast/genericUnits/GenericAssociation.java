package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.SelectorName;
import visitor.Ada95Visitor;

public class GenericAssociation extends AbstractAST implements AST {

    private SelectorName genericFormalParameterSelectorName;
    private ExplicitGenericActualParameter explicitGenericActualParameter;

    public GenericAssociation(SelectorName genericFormalParameterSelectorName,
	    ExplicitGenericActualParameter explicitGenericActualParameter) {
	super();
	this.genericFormalParameterSelectorName = genericFormalParameterSelectorName;
	this.explicitGenericActualParameter = explicitGenericActualParameter;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SelectorName getGenericFormalParameterSelectorName() {
	return genericFormalParameterSelectorName;
    }

    public ExplicitGenericActualParameter getExplicitGenericActualParameter() {
	return explicitGenericActualParameter;
    }

}
