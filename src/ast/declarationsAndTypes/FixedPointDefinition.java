package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class FixedPointDefinition extends AbstractAST implements AST {

    private OrdinaryFixedPointDefinition ordinaryFixedPointDefinition;
    private DecimalFixedPointDefinition decimalFixedPointDefinition;

    public FixedPointDefinition(OrdinaryFixedPointDefinition ordinaryFixedPointDefinition) {
	super();
	this.ordinaryFixedPointDefinition = ordinaryFixedPointDefinition;
    }

    public FixedPointDefinition(DecimalFixedPointDefinition decimalFixedPointDefinition) {
	super();
	this.decimalFixedPointDefinition = decimalFixedPointDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public OrdinaryFixedPointDefinition getOrdinaryFixedPointDefinition() {
	return ordinaryFixedPointDefinition;
    }

    public DecimalFixedPointDefinition getDecimalFixedPointDefinition() {
	return decimalFixedPointDefinition;
    }

}
