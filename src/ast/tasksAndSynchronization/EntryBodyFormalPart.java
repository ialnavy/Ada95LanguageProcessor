package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.subprograms.ParameterProfile;
import visitor.Ada95Visitor;

public class EntryBodyFormalPart extends AbstractAST implements AST {

    private EntryIndexSpecification entryIndexSpecification;
    private ParameterProfile parameterProfile;

    public EntryBodyFormalPart(EntryIndexSpecification entryIndexSpecification, ParameterProfile parameterProfile) {
	super();
	this.entryIndexSpecification = entryIndexSpecification;
	this.parameterProfile = parameterProfile;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public EntryIndexSpecification getEntryIndexSpecification() {
	return entryIndexSpecification;
    }

    public ParameterProfile getParameterProfile() {
	return parameterProfile;
    }

}
