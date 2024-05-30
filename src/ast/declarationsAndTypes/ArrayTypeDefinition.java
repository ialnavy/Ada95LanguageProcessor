package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ArrayTypeDefinition extends AbstractAST implements AST {

    private UnconstrainedArrayDefinition unconstrainedArrayDefinition;
    private ConstrainedArrayDefinition constrainedArrayDefinition;

    public ArrayTypeDefinition(UnconstrainedArrayDefinition unconstrainedArrayDefinition) {
	super();
	this.unconstrainedArrayDefinition = unconstrainedArrayDefinition;
    }

    public ArrayTypeDefinition(ConstrainedArrayDefinition constrainedArrayDefinition) {
	super();
	this.constrainedArrayDefinition = constrainedArrayDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public UnconstrainedArrayDefinition getUnconstrainedArrayDefinition() {
	return unconstrainedArrayDefinition;
    }

    public ConstrainedArrayDefinition getConstrainedArrayDefinition() {
	return constrainedArrayDefinition;
    }

}
