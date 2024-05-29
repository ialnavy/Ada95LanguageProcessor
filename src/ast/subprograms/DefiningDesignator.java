package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DefiningDesignator extends AbstractAST implements AST {

    private DefiningProgramUnitName definingProgramUnitName;
    private DefiningOperatorSymbol definingOperatorSymbol;

    public DefiningDesignator(DefiningProgramUnitName definingProgramUnitName) {
	super();
	this.definingProgramUnitName = definingProgramUnitName;
    }

    public DefiningDesignator(DefiningOperatorSymbol definingOperatorSymbol) {
	super();
	this.definingOperatorSymbol = definingOperatorSymbol;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public DefiningOperatorSymbol getDefiningOperatorSymbol() {
	return definingOperatorSymbol;
    }

}
