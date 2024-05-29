package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DiscreteChoiceList extends AbstractAST implements AST {

    private List<DiscreteChoice> discreteChoices = new ArrayList<>();

    public DiscreteChoiceList(List<DiscreteChoice> discreteChoices) {
	super();
	this.discreteChoices = discreteChoices;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<DiscreteChoice> getDiscreteChoices() {
	return new ArrayList<>(discreteChoices);
    }

}
