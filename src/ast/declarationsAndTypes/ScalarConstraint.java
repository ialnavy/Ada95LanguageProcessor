package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.others.DeltaConstraint;
import visitor.Ada95Visitor;

public class ScalarConstraint extends AbstractAST implements AST {

    private RangeConstraint rangeConstraint;
    private DigitsConstraint digitsConstraint;
    private DeltaConstraint deltaConstraint;

    public ScalarConstraint(RangeConstraint rangeConstraint) {
	super();
	this.rangeConstraint = rangeConstraint;
    }

    public ScalarConstraint(DigitsConstraint digitsConstraint) {
	super();
	this.digitsConstraint = digitsConstraint;
    }

    public ScalarConstraint(DeltaConstraint deltaConstraint) {
	super();
	this.deltaConstraint = deltaConstraint;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public RangeConstraint getRangeConstraint() {
	return rangeConstraint;
    }

    public DigitsConstraint getDigitsConstraint() {
	return digitsConstraint;
    }

    public DeltaConstraint getDeltaConstraint() {
	return deltaConstraint;
    }

}
