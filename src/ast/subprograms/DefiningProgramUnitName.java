package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.programStructureAndCompilationIssues.ParentUnitName;
import visitor.Ada95Visitor;

public class DefiningProgramUnitName extends AbstractAST implements AST {

    private ParentUnitName parentUnitName;
    private DefiningIdentifier definingIdentifier;

    public DefiningProgramUnitName(ParentUnitName parentUnitName, DefiningIdentifier definingIdentifier) {
	super();
	this.parentUnitName = parentUnitName;
	this.definingIdentifier = definingIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ParentUnitName getParentUnitName() {
	return parentUnitName;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

}
