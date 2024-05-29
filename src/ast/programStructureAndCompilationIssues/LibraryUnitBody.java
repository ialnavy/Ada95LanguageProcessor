package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.packages.PackageBody;
import ast.subprograms.SubprogramBody;
import visitor.Ada95Visitor;

public class LibraryUnitBody extends AbstractAST implements AST {

    private SubprogramBody subprogramBody;
    private PackageBody packageBody;

    public LibraryUnitBody(SubprogramBody subprogramBody) {
	super();
	this.subprogramBody = subprogramBody;
    }

    public LibraryUnitBody(PackageBody packageBody) {
	super();
	this.packageBody = packageBody;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubprogramBody getSubprogramBody() {
	return subprogramBody;
    }

    public PackageBody getPackageBody() {
	return packageBody;
    }

}
