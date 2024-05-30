package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.AccessDefinition;
import ast.declarationsAndTypes.DefaultExpression;
import ast.declarationsAndTypes.DefiningIdentifierList;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ParameterSpecification extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;
    private Mode mode;
    private Name subtypeMark;
    private AccessDefinition accessDefinition;
    private DefaultExpression defaultExpression;

    public ParameterSpecification(DefiningIdentifierList definingIdentifierList, Mode mode, Name subtypeMark,
	    DefaultExpression defaultExpression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.mode = mode;
	this.subtypeMark = subtypeMark;
	this.defaultExpression = defaultExpression;
    }

    public ParameterSpecification(DefiningIdentifierList definingIdentifierList, AccessDefinition accessDefinition,
	    DefaultExpression defaultExpression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.accessDefinition = accessDefinition;
	this.defaultExpression = defaultExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifierList getDefiningIdentifierList() {
	return definingIdentifierList;
    }

    public Mode getMode() {
	return mode;
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
