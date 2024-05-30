package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefaultExpression;
import ast.declarationsAndTypes.DefiningIdentifierList;
import ast.namesAndExpressions.Name;
import ast.subprograms.Mode;
import visitor.Ada95Visitor;

public class FormalObjectDeclaration extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;
    private Mode mode;
    private Name subtypeMark;
    private DefaultExpression defaultExpression;

    public FormalObjectDeclaration(DefiningIdentifierList definingIdentifierList, Mode mode, Name subtypeMark,
	    DefaultExpression defaultExpression) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.mode = mode;
	this.subtypeMark = subtypeMark;
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

    public DefaultExpression getDefaultExpression() {
	return defaultExpression;
    }

}
