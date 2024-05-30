package ast.exceptions;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifierList;
import visitor.Ada95Visitor;

public class ExceptionDeclaration extends AbstractAST implements AST {

    private DefiningIdentifierList definingIdentifierList;

    public ExceptionDeclaration(DefiningIdentifierList definingIdentifierList) {
	super();
	this.definingIdentifierList = definingIdentifierList;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifierList getDefiningIdentifierList() {
	return definingIdentifierList;
    }

}
