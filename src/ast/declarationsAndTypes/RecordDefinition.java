package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RecordDefinition extends AbstractAST implements AST {

    private ComponentList componentList;

    public RecordDefinition(ComponentList componentList) {
	super();
	this.componentList = componentList;
    }

    public RecordDefinition() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ComponentList getComponentList() {
	return componentList;
    }

}
