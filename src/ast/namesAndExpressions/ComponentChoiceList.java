package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ComponentChoiceList extends AbstractAST implements AST {

    private List<SelectorName> componentSelectorNames = new ArrayList<>();

    public ComponentChoiceList(List<SelectorName> componentSelectorNames) {
	super();
	this.componentSelectorNames = componentSelectorNames;
    }

    public ComponentChoiceList() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<SelectorName> getComponentSelectorNames() {
	return new ArrayList<>(componentSelectorNames);
    }

}
