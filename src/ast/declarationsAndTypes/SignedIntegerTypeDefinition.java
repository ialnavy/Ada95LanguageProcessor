package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.SimpleExpression;
import visitor.Ada95Visitor;

public class SignedIntegerTypeDefinition extends AbstractAST implements AST {

    private SimpleExpression leftStaticSimpleExpression;
    private SimpleExpression rightStaticSimpleExpression;

    public SignedIntegerTypeDefinition(SimpleExpression leftStaticSimpleExpression,
	    SimpleExpression rightStaticSimpleExpression) {
	super();
	this.leftStaticSimpleExpression = leftStaticSimpleExpression;
	this.rightStaticSimpleExpression = rightStaticSimpleExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SimpleExpression getLeftStaticSimpleExpression() {
	return leftStaticSimpleExpression;
    }

    public SimpleExpression getRightStaticSimpleExpression() {
	return rightStaticSimpleExpression;
    }

}
