package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.subprograms.SubprogramSpecification;
import visitor.Ada95Visitor;

public class GenericSubprogramDeclaration extends AbstractAST implements AST {

    private GenericFormalPart genericFormalPart;
    private SubprogramSpecification subprogramSpecification;

    public GenericSubprogramDeclaration(GenericFormalPart genericFormalPart,
	    SubprogramSpecification subprogramSpecification) {
	super();
	this.genericFormalPart = genericFormalPart;
	this.subprogramSpecification = subprogramSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public GenericFormalPart getGenericFormalPart() {
	return genericFormalPart;
    }

    public SubprogramSpecification getSubprogramSpecification() {
	return subprogramSpecification;
    }

}
