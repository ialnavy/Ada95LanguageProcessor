package ast.exceptions;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class RaiseStatement extends AbstractAST implements AST {

    private Name exceptionName;

    public RaiseStatement(Name exceptionName) {
	super();
	this.exceptionName = exceptionName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getExceptionName() {
	return exceptionName;
    }

}
