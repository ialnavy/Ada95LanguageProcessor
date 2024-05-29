package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Constraint extends AbstractAST implements AST {

    private ScalarConstraint scalarConstraint;
    private CompositeConstraint compositeConstraint;

    public Constraint(ScalarConstraint scalarConstraint) {
	super();
	this.scalarConstraint = scalarConstraint;
    }

    public Constraint(CompositeConstraint compositeConstraint) {
	super();
	this.compositeConstraint = compositeConstraint;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ScalarConstraint getScalarConstraint() {
	return scalarConstraint;
    }

    public CompositeConstraint getCompositeConstraint() {
	return compositeConstraint;
    }

}
