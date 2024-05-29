package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SubprogramSpecification extends AbstractAST implements AST {

    private DefiningProgramUnitName definingProgramUnitName;
    private ParameterProfile parameterProfile;
    private DefiningDesignator definingDesignator;
    private ParameterAndResultProfile parameterAndResultProfile;

    public SubprogramSpecification(DefiningProgramUnitName definingProgramUnitName, ParameterProfile parameterProfile) {
	super();
	this.definingProgramUnitName = definingProgramUnitName;
	this.parameterProfile = parameterProfile;
    }

    public SubprogramSpecification(DefiningDesignator definingDesignator,
	    ParameterAndResultProfile parameterAndResultProfile) {
	super();
	this.definingDesignator = definingDesignator;
	this.parameterAndResultProfile = parameterAndResultProfile;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public ParameterProfile getParameterProfile() {
	return parameterProfile;
    }

    public DefiningDesignator getDefiningDesignator() {
	return definingDesignator;
    }

    public ParameterAndResultProfile getParameterAndResultProfile() {
	return parameterAndResultProfile;
    }

}
