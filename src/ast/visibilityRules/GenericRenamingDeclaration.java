package ast.visibilityRules;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import ast.subprograms.DefiningProgramUnitName;
import visitor.Ada95Visitor;

public class GenericRenamingDeclaration extends AbstractAST implements AST {

    private Token unitToRename;
    private DefiningProgramUnitName definingProgramUnitName;
    private Name genericUnitName;

    public GenericRenamingDeclaration(Token unitToRename, DefiningProgramUnitName definingProgramUnitName,
	    Name genericUnitName) {
	super();
	this.unitToRename = unitToRename;
	this.definingProgramUnitName = definingProgramUnitName;
	this.genericUnitName = genericUnitName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Token getUnitToRename() {
	return unitToRename;
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public Name getGenericUnitName() {
	return genericUnitName;
    }

}
