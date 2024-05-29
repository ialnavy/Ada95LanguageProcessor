package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RangeConstraint extends AbstractAST implements AST {

    private Range range;

    public RangeConstraint(Range range) {
	super();
	this.range = range;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Range getRange() {
	return range;
    }

}
