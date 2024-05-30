package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DiscreteSubtypeDefinition;
import visitor.Ada95Visitor;

public class EntryIndexSpecification extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscreteSubtypeDefinition discreteSubtypeDefinition;

    public EntryIndexSpecification(DefiningIdentifier definingIdentifier,
	    DiscreteSubtypeDefinition discreteSubtypeDefinition) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discreteSubtypeDefinition = discreteSubtypeDefinition;
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

}
