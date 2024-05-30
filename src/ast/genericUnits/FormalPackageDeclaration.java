package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class FormalPackageDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private Name genericPackageName;
    private FormalPackageActualPart formalPackageActualPart;

    public FormalPackageDeclaration(DefiningIdentifier definingIdentifier, Name genericPackageName,
	    FormalPackageActualPart formalPackageActualPart) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.genericPackageName = genericPackageName;
	this.formalPackageActualPart = formalPackageActualPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public Name getGenericPackageName() {
	return genericPackageName;
    }

    public FormalPackageActualPart getFormalPackageActualPart() {
	return formalPackageActualPart;
    }

}
