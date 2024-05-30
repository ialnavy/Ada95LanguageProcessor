package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ComponentDeclaration extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;
    private ComponentDefinition componentDefinition;
    private DefaultExpression defaultExpression;

    public ComponentDeclaration(DefiningIdentifierList definingIdentifierList, ComponentDefinition componentDefinition,
	    DefaultExpression defaultExpression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.componentDefinition = componentDefinition;
	this.defaultExpression = defaultExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifierList getDefiningIdentifierList() {
	return definingIdentifierList;
    }

    public ComponentDefinition getComponentDefinition() {
	return componentDefinition;
    }

    public DefaultExpression getDefaultExpression() {
	return defaultExpression;
    }

}
