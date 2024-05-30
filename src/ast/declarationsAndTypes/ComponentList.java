package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ComponentList extends AbstractAST implements AST {

    private List<ComponentItem> componentItems = new ArrayList<>();
    private VariantPart variantPart;

    public ComponentList(VariantPart variantPart) {
	super();
	this.variantPart = variantPart;
    }

    public ComponentList() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<ComponentItem> getComponentItems() {
	return new ArrayList<>(componentItems);
    }

    public void addComponentItem(ComponentItem componentItem) {
	componentItems.add(componentItem);
    }

    public VariantPart getVariantPart() {
	return variantPart;
    }

}
