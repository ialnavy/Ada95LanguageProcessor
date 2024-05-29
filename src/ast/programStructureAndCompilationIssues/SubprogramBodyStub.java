package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.subprograms.SubprogramSpecification;
import visitor.Ada95Visitor;

public class SubprogramBodyStub extends AbstractAST implements AST {

    private SubprogramSpecification subprogramSpecification;

    public SubprogramBodyStub(SubprogramSpecification subprogramSpecification) {
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
