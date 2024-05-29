package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class IndexConstraint extends AbstractAST implements AST {

    private List<DiscreteRange> discreteRanges = new ArrayList<>();

    public IndexConstraint(List<DiscreteRange> discreteRanges) {
	super();
	this.discreteRanges = discreteRanges;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<DiscreteRange> getDiscreteRanges() {
	return new ArrayList<>(discreteRanges);
    }

}
