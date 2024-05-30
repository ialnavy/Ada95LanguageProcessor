package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class GenericDeclaration extends AbstractAST implements AST {

    private GenericSubprogramDeclaration genericSubprogramDeclaration;
    private GenericPackageDeclaration genericPackageDeclaration;

    public GenericDeclaration(GenericSubprogramDeclaration genericSubprogramDeclaration) {
	super();
	this.genericSubprogramDeclaration = genericSubprogramDeclaration;
    }

    public GenericDeclaration(GenericPackageDeclaration genericPackageDeclaration) {
	super();
	this.genericPackageDeclaration = genericPackageDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public GenericSubprogramDeclaration getGenericSubprogramDeclaration() {
	return genericSubprogramDeclaration;
    }

    public GenericPackageDeclaration getGenericPackageDeclaration() {
	return genericPackageDeclaration;
    }

}
