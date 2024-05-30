package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SubprogramDeclaration extends AbstractAST implements AST {

    private SubprogramSpecification subprogramSpecification;

    public SubprogramDeclaration(SubprogramSpecification subprogramSpecification) {
	super();
	this.subprogramSpecification = subprogramSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public SubprogramSpecification getSubprogramSpecification() {
	return subprogramSpecification;
    }

}
