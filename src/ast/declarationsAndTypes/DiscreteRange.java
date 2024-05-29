package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DiscreteRange extends AbstractAST implements AST {

    private SubtypeIndication subtypeIndication;
    private Range range;

    public DiscreteRange(SubtypeIndication subtypeIndication) {
	super();
	this.subtypeIndication = subtypeIndication;
    }

    public DiscreteRange(Range range) {
	super();
	this.range = range;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubtypeIndication getSubtypeIndication() {
	return subtypeIndication;
    }

    public Range getRange() {
	return range;
    }

}
