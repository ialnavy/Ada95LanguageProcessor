package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class UnconstrainedArrayDefinition extends AbstractAST implements AST {

    private List<IndexSubtypeDefinition> indexSubtypeDefinitions = new ArrayList<>();
    private ComponentDefinition componentDefinition;

    public UnconstrainedArrayDefinition(List<IndexSubtypeDefinition> indexSubtypeDefinitions,
	    ComponentDefinition componentDefinition) {
	super();
	this.indexSubtypeDefinitions = indexSubtypeDefinitions;
	this.componentDefinition = componentDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<IndexSubtypeDefinition> getIndexSubtypeDefinitions() {
	return new ArrayList<>(indexSubtypeDefinitions);
    }

    public ComponentDefinition getComponentDefinition() {
	return componentDefinition;
    }

}
