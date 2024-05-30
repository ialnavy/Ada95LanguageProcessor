package ast.declarationsAndTypes;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import ast.tasksAndSynchronization.SingleProtectedDeclaration;
import ast.tasksAndSynchronization.SingleTaskDeclaration;
import visitor.Ada95Visitor;

public class ObjectDeclaration extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;
    private SubtypeIndication subtypeIndication;
    private ArrayTypeDefinition arrayTypeDefinition;
    private Expression expression;
    private SingleTaskDeclaration singleTaskDeclaration;
    private SingleProtectedDeclaration singleProtectedDeclaration;

    private Token aliased;
    private Token constant;

    public ObjectDeclaration(DefiningIdentifierList definingIdentifierList, SubtypeIndication subtypeIndication,
	    Expression expression, Token aliased, Token constant) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.subtypeIndication = subtypeIndication;
	this.expression = expression;
	this.aliased = aliased;
	this.constant = constant;
    }

    public ObjectDeclaration(DefiningIdentifierList definingIdentifierList, ArrayTypeDefinition arrayTypeDefinition,
	    Expression expression, Token aliased, Token constant) {
	super();
	this.definingIdentifierList = definingIdentifierList;
	this.arrayTypeDefinition = arrayTypeDefinition;
	this.expression = expression;
	this.aliased = aliased;
	this.constant = constant;
    }

    public ObjectDeclaration(SingleTaskDeclaration singleTaskDeclaration) {
	super();
	this.singleTaskDeclaration = singleTaskDeclaration;
    }

    public ObjectDeclaration(SingleProtectedDeclaration singleProtectedDeclaration) {
	super();
	this.singleProtectedDeclaration = singleProtectedDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifierList getDefiningIdentifierList() {
	return definingIdentifierList;
    }

    public SubtypeIndication getSubtypeIndication() {
	return subtypeIndication;
    }

    public ArrayTypeDefinition getArrayTypeDefinition() {
	return arrayTypeDefinition;
    }

    public Expression getExpression() {
	return expression;
    }

    public SingleTaskDeclaration getSingleTaskDeclaration() {
	return singleTaskDeclaration;
    }

    public SingleProtectedDeclaration getSingleProtectedDeclaration() {
	return singleProtectedDeclaration;
    }

    public Token getAliased() {
	return aliased;
    }

    public Token getConstant() {
	return constant;
    }

}
