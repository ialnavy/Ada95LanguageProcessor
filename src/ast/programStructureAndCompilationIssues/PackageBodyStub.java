package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import visitor.Ada95Visitor;

public class PackageBodyStub extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;

    public PackageBodyStub(DefiningIdentifier definingIdentifier) {
	super();
	this.definingIdentifier = definingIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

}
