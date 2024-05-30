package ast.statements;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DiscreteSubtypeDefinition;
import visitor.Ada95Visitor;

public class LoopParameterSpecification extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscreteSubtypeDefinition discreteSubtypeDefinition;

    private Token reverse;

    public LoopParameterSpecification(DefiningIdentifier definingIdentifier,
	    DiscreteSubtypeDefinition discreteSubtypeDefinition, Token reverse) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discreteSubtypeDefinition = discreteSubtypeDefinition;
	this.reverse = reverse;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public DiscreteSubtypeDefinition getDiscreteSubtypeDefinition() {
	return discreteSubtypeDefinition;
    }

    public Token getReverse() {
	return reverse;
    }

}
