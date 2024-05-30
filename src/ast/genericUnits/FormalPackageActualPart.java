package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class FormalPackageActualPart extends AbstractAST implements AST {

    private GenericActualPart genericActualPart;

    public FormalPackageActualPart() {
	super();
    }

    public FormalPackageActualPart(GenericActualPart genericActualPart) {
	super();
	this.genericActualPart = genericActualPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public GenericActualPart getGenericActualPart() {
	return genericActualPart;
    }

}
