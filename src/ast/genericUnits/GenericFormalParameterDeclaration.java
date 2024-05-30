package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class GenericFormalParameterDeclaration extends AbstractAST implements AST {

    private FormalObjectDeclaration formalObjectDeclaration;
    private FormalTypeDeclaration formalTypeDeclaration;
    private FormalSubprogramDeclaration formalSubprogramDeclaration;
    private FormalPackageDeclaration formalPackageDeclaration;

    public GenericFormalParameterDeclaration(FormalObjectDeclaration formalObjectDeclaration) {
	super();
	this.formalObjectDeclaration = formalObjectDeclaration;
    }

    public GenericFormalParameterDeclaration(FormalTypeDeclaration formalTypeDeclaration) {
	super();
	this.formalTypeDeclaration = formalTypeDeclaration;
    }

    public GenericFormalParameterDeclaration(FormalSubprogramDeclaration formalSubprogramDeclaration) {
	super();
	this.formalSubprogramDeclaration = formalSubprogramDeclaration;
    }

    public GenericFormalParameterDeclaration(FormalPackageDeclaration formalPackageDeclaration) {
	super();
	this.formalPackageDeclaration = formalPackageDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public FormalObjectDeclaration getFormalObjectDeclaration() {
	return formalObjectDeclaration;
    }

    public FormalTypeDeclaration getFormalTypeDeclaration() {
	return formalTypeDeclaration;
    }

    public FormalSubprogramDeclaration getFormalSubprogramDeclaration() {
	return formalSubprogramDeclaration;
    }

    public FormalPackageDeclaration getFormalPackageDeclaration() {
	return formalPackageDeclaration;
    }

}
