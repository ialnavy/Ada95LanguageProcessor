package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import visitor.Ada95Visitor;

public class TaskBodyStub extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;

    public TaskBodyStub(DefiningIdentifier definingIdentifier) {
	super();
	this.definingIdentifier = definingIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

}
