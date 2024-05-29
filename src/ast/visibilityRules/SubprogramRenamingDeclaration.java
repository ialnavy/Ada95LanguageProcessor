package ast.visibilityRules;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import ast.subprograms.SubprogramSpecification;
import visitor.Ada95Visitor;

public class SubprogramRenamingDeclaration extends AbstractAST implements AST {

    private SubprogramSpecification subprogramSpecification;
    private Name callableEntityName;

    public SubprogramRenamingDeclaration(SubprogramSpecification subprogramSpecification, Name callableEntityName) {
	super();
	this.subprogramSpecification = subprogramSpecification;
	this.callableEntityName = callableEntityName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubprogramSpecification getSubprogramSpecification() {
	return subprogramSpecification;
    }

    public Name getCallableEntityName() {
	return callableEntityName;
    }

}
