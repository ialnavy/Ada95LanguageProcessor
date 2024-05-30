package ast.visibilityRules;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ExceptionRenamingDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private Name exceptionName;

    public ExceptionRenamingDeclaration(DefiningIdentifier definingIdentifier, Name exceptionName) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.exceptionName = exceptionName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public Name getExceptionName() {
	return exceptionName;
    }

}
