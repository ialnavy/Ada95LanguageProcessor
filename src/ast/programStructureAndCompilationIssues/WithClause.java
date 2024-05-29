package ast.programStructureAndCompilationIssues;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class WithClause extends AbstractAST implements AST {

    private List<Name> libraryUnitNames = new ArrayList<>();

    public WithClause(List<Name> libraryUnitNames) {
	super();
	this.libraryUnitNames = libraryUnitNames;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<Name> getLibraryUnitNames() {
	return new ArrayList<>(libraryUnitNames);
    }

}
