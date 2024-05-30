package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DiscreteSubtypeDefinition;
import ast.subprograms.ParameterProfile;
import visitor.Ada95Visitor;

public class EntryDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private DiscreteSubtypeDefinition discreteSubtypeDefinition;
    private ParameterProfile parameterProfile;

    public EntryDeclaration(DefiningIdentifier definingIdentifier, DiscreteSubtypeDefinition discreteSubtypeDefinition,
	    ParameterProfile parameterProfile) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.discreteSubtypeDefinition = discreteSubtypeDefinition;
	this.parameterProfile = parameterProfile;
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

    public ParameterProfile getParameterProfile() {
	return parameterProfile;
    }

}
