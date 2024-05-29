package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class AbstractSubprogramDeclaration extends AbstractAST implements AST {

    private SubprogramSpecification subprogramSpecification;

    public AbstractSubprogramDeclaration(SubprogramSpecification subprogramSpecification) {
	super();
	this.subprogramSpecification = subprogramSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubprogramSpecification getSubprogramSpecification() {
	return subprogramSpecification;
    }

}
