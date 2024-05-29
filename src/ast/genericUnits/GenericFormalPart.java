package ast.genericUnits;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.visibilityRules.UseClause;
import visitor.Ada95Visitor;

public class GenericFormalPart extends AbstractAST implements AST {

    private List<GenericFormalParameterDeclaration> genericFormalParameterDeclarations = new ArrayList<>();
    private List<UseClause> useClauses = new ArrayList<>();

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<GenericFormalParameterDeclaration> getGenericFormalParameterDeclarations() {
	return new ArrayList<>(genericFormalParameterDeclarations);
    }

    public void addGenericFormalParameterDeclaration(
	    GenericFormalParameterDeclaration genericFormalParameterDeclaration) {
	genericFormalParameterDeclarations.add(genericFormalParameterDeclaration);
    }

    public List<UseClause> getUseClauses() {
	return new ArrayList<>(useClauses);
    }

    public void addUseClause(UseClause useClause) {
	useClauses.add(useClause);
    }

}
