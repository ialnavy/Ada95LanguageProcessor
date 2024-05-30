package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.subprograms.SubprogramSpecification;
import visitor.Ada95Visitor;

public class FormalSubprogramDeclaration extends AbstractAST implements AST {

    private SubprogramSpecification subprogramSpecification;
    private SubprogramDefault subprogramDefault;

    public FormalSubprogramDeclaration(SubprogramSpecification subprogramSpecification,
	    SubprogramDefault subprogramDefault) {
	super();
	this.subprogramSpecification = subprogramSpecification;
	this.subprogramDefault = subprogramDefault;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SubprogramSpecification getSubprogramSpecification() {
	return subprogramSpecification;
    }

    public SubprogramDefault getSubprogramDefault() {
	return subprogramDefault;
    }

}
