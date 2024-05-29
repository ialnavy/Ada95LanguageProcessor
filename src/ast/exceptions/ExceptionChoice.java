package ast.exceptions;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ExceptionChoice extends AbstractAST implements AST {

    private Name exceptionName;

    public ExceptionChoice(Name exceptionName) {
	super();
	this.exceptionName = exceptionName;
    }

    public ExceptionChoice() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Name getExceptionName() {
	return exceptionName;
    }

}
