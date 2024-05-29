package ast.packages;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class PackageDeclaration extends AbstractAST implements AST {

    private PackageSpecification packageSpecification;

    public PackageDeclaration(PackageSpecification packageSpecification) {
	super();
	this.packageSpecification = packageSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public PackageSpecification getPackageSpecification() {
	return packageSpecification;
    }

}
