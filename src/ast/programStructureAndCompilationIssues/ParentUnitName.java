package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ParentUnitName extends AbstractAST implements AST {

    private Name name;

    public ParentUnitName(Name name) {
	super();
	this.name = name;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getName() {
	return name;
    }

}
