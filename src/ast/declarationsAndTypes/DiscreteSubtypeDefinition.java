package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DiscreteSubtypeDefinition extends AbstractAST implements AST {

    private SubtypeIndication discreteSubtypeIndication;
    private Range range;

    public DiscreteSubtypeDefinition(SubtypeIndication discreteSubtypeIndication) {
	super();
	this.discreteSubtypeIndication = discreteSubtypeIndication;
    }

    public DiscreteSubtypeDefinition(Range range) {
	super();
	this.range = range;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubtypeIndication getDiscreteSubtypeIndication() {
	return discreteSubtypeIndication;
    }

    public Range getRange() {
	return range;
    }

}
