package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class CompilationUnit extends AbstractAST implements AST {

    private ContextClause contextClause;
    private LibraryItem libraryItem;
    private Subunit subunit;

    public CompilationUnit(ContextClause contextClause, LibraryItem libraryItem) {
	super();
	this.contextClause = contextClause;
	this.libraryItem = libraryItem;
    }

    public CompilationUnit(ContextClause contextClause, Subunit subunit) {
	super();
	this.contextClause = contextClause;
	this.subunit = subunit;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ContextClause getContextClause() {
	return contextClause;
    }

    public LibraryItem getLibraryItem() {
	return libraryItem;
    }

    public Subunit getSubunit() {
	return subunit;
    }

}
