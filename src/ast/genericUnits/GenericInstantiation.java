package ast.genericUnits;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import ast.subprograms.DefiningDesignator;
import ast.subprograms.DefiningProgramUnitName;
import visitor.Ada95Visitor;

public class GenericInstantiation extends AbstractAST implements AST {

    private Token unitToInstantiate;
    private DefiningProgramUnitName definingProgramUnitName;
    private DefiningDesignator definingDesignator;
    private Name genericUnitName;
    private GenericActualPart genericActualPart;

    public GenericInstantiation(Token unitToInstantiate, DefiningProgramUnitName definingProgramUnitName,
	    Name genericUnitName, GenericActualPart genericActualPart) {
	super();
	this.unitToInstantiate = unitToInstantiate;
	this.definingProgramUnitName = definingProgramUnitName;
	this.genericUnitName = genericUnitName;
	this.genericActualPart = genericActualPart;
    }

    public GenericInstantiation(Token unitToInstantiate, DefiningDesignator definingDesignator, Name genericUnitName,
	    GenericActualPart genericActualPart) {
	super();
	this.unitToInstantiate = unitToInstantiate;
	this.definingDesignator = definingDesignator;
	this.genericUnitName = genericUnitName;
	this.genericActualPart = genericActualPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Token getUnitToInstantiate() {
	return unitToInstantiate;
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public DefiningDesignator getDefiningDesignator() {
	return definingDesignator;
    }

    public Name getGenericUnitName() {
	return genericUnitName;
    }

    public GenericActualPart getGenericActualPart() {
	return genericActualPart;
    }

}
