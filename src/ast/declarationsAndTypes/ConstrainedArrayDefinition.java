package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ConstrainedArrayDefinition extends AbstractAST implements AST {

    private List<DiscreteSubtypeDefinition> discreteSubtypeDefinitions = new ArrayList<>();
    private ComponentDefinition componentDefinition;

    public ConstrainedArrayDefinition(List<DiscreteSubtypeDefinition> discreteSubtypeDefinitions,
	    ComponentDefinition componentDefinition) {
	super();
	this.discreteSubtypeDefinitions = discreteSubtypeDefinitions;
	this.componentDefinition = componentDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<DiscreteSubtypeDefinition> getDiscreteSubtypeDefinitions() {
	return new ArrayList<>(discreteSubtypeDefinitions);
    }

    public ComponentDefinition getComponentDefinition() {
	return componentDefinition;
    }

}
