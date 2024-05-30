package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.genericUnits.GenericDeclaration;
import ast.genericUnits.GenericInstantiation;
import ast.packages.PackageDeclaration;
import ast.subprograms.SubprogramDeclaration;
import visitor.Ada95Visitor;

public class LibraryUnitDeclaration extends AbstractAST implements AST {

    private SubprogramDeclaration subprogramDeclaration;
    private PackageDeclaration packageDeclaration;
    private GenericDeclaration genericDeclaration;
    private GenericInstantiation genericInstantiation;

    public LibraryUnitDeclaration(SubprogramDeclaration subprogramDeclaration) {
	super();
	this.subprogramDeclaration = subprogramDeclaration;
    }

    public LibraryUnitDeclaration(PackageDeclaration packageDeclaration) {
	super();
	this.packageDeclaration = packageDeclaration;
    }

    public LibraryUnitDeclaration(GenericDeclaration genericDeclaration) {
	super();
	this.genericDeclaration = genericDeclaration;
    }

    public LibraryUnitDeclaration(GenericInstantiation genericInstantiation) {
	super();
	this.genericInstantiation = genericInstantiation;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SubprogramDeclaration getSubprogramDeclaration() {
	return subprogramDeclaration;
    }

    public PackageDeclaration getPackageDeclaration() {
	return packageDeclaration;
    }

    public GenericDeclaration getGenericDeclaration() {
	return genericDeclaration;
    }

    public GenericInstantiation getGenericInstantiation() {
	return genericInstantiation;
    }

}
