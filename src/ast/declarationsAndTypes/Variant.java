package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Variant extends AbstractAST implements AST {

    private DiscreteChoiceList discreteChoiceList;
    private ComponentList componentList;

    public Variant(DiscreteChoiceList discreteChoiceList, ComponentList componentList) {
	super();
	this.discreteChoiceList = discreteChoiceList;
	this.componentList = componentList;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DiscreteChoiceList getDiscreteChoiceList() {
	return discreteChoiceList;
    }

    public ComponentList getComponentList() {
	return componentList;
    }

}
