package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class DiscriminantSpecification extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;
    private Name subtypeMark;
    private AccessDefinition accessDefinition;
    private DefaultExpression defaultExpression;

    public DiscriminantSpecification(DefiningIdentifierList definingIdentifierList, Name subtypeMark,
	    DefaultExpression defaultExpression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.subtypeMark = subtypeMark;
	this.defaultExpression = defaultExpression;
    }

    public DiscriminantSpecification(DefiningIdentifierList definingIdentifierList, AccessDefinition accessDefinition,
	    DefaultExpression defaultExpression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.accessDefinition = accessDefinition;
	this.defaultExpression = defaultExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifierList getDefiningIdentifierList() {
	return definingIdentifierList;
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

    public AccessDefinition getAccessDefinition() {
	return accessDefinition;
    }

    public DefaultExpression getDefaultExpression() {
	return defaultExpression;
    }

}
