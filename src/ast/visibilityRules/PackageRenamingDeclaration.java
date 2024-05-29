package ast.visibilityRules;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import ast.subprograms.DefiningProgramUnitName;
import visitor.Ada95Visitor;

public class PackageRenamingDeclaration extends AbstractAST implements AST {

    private DefiningProgramUnitName definingProgramUnitName;
    private Name packageName;

    public PackageRenamingDeclaration(DefiningProgramUnitName definingProgramUnitName, Name packageName) {
	super();
	this.definingProgramUnitName = definingProgramUnitName;
	this.packageName = packageName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public Name getPackageName() {
	return packageName;
    }

}
