package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.visibilityRules.GenericRenamingDeclaration;
import ast.visibilityRules.PackageRenamingDeclaration;
import ast.visibilityRules.SubprogramRenamingDeclaration;
import visitor.Ada95Visitor;

public class LibraryUnitRenamingDeclaration extends AbstractAST implements AST {

    private PackageRenamingDeclaration packageRenamingDeclaration;
    private GenericRenamingDeclaration genericRenamingDeclaration;
    private SubprogramRenamingDeclaration subprogramRenamingDeclaration;

    public LibraryUnitRenamingDeclaration(PackageRenamingDeclaration packageRenamingDeclaration) {
	super();
	this.packageRenamingDeclaration = packageRenamingDeclaration;
    }

    public LibraryUnitRenamingDeclaration(GenericRenamingDeclaration genericRenamingDeclaration) {
	super();
	this.genericRenamingDeclaration = genericRenamingDeclaration;
    }

    public LibraryUnitRenamingDeclaration(SubprogramRenamingDeclaration subprogramRenamingDeclaration) {
	super();
	this.subprogramRenamingDeclaration = subprogramRenamingDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public PackageRenamingDeclaration getPackageRenamingDeclaration() {
	return packageRenamingDeclaration;
    }

    public GenericRenamingDeclaration getGenericRenamingDeclaration() {
	return genericRenamingDeclaration;
    }

    public SubprogramRenamingDeclaration getSubprogramRenamingDeclaration() {
	return subprogramRenamingDeclaration;
    }

}
