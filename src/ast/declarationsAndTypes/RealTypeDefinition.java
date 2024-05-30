package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RealTypeDefinition extends AbstractAST implements AST {

    private FloatingPointDefinition floatingPointDefinition;
    private FixedPointDefinition fixedPointDefinition;

    public RealTypeDefinition(FloatingPointDefinition floatingPointDefinition) {
	super();
	this.floatingPointDefinition = floatingPointDefinition;
    }

    public RealTypeDefinition(FixedPointDefinition fixedPointDefinition) {
	super();
	this.fixedPointDefinition = fixedPointDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public FloatingPointDefinition getFloatingPointDefinition() {
	return floatingPointDefinition;
    }

    public FixedPointDefinition getFixedPointDefinition() {
	return fixedPointDefinition;
    }

}
