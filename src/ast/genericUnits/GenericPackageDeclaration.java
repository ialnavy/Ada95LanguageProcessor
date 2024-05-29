package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.packages.PackageSpecification;
import visitor.Ada95Visitor;

public class GenericPackageDeclaration extends AbstractAST implements AST {

    private GenericFormalPart genericFormalPart;
    private PackageSpecification packageSpecification;

    public GenericPackageDeclaration(GenericFormalPart genericFormalPart, PackageSpecification packageSpecification) {
	super();
	this.genericFormalPart = genericFormalPart;
	this.packageSpecification = packageSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public GenericFormalPart getGenericFormalPart() {
	return genericFormalPart;
    }

    public PackageSpecification getPackageSpecification() {
	return packageSpecification;
    }

}
