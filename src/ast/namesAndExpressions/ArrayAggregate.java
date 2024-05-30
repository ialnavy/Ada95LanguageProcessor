package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ArrayAggregate extends AbstractAST implements AST {

    private PositionalArrayAggregate positionalArrayAggregate;
    private NamedArrayAggregate namedArrayAggregate;

    public ArrayAggregate(PositionalArrayAggregate positionalArrayAggregate) {
	super();
	this.positionalArrayAggregate = positionalArrayAggregate;
    }

    public ArrayAggregate(NamedArrayAggregate namedArrayAggregate) {
	super();
	this.namedArrayAggregate = namedArrayAggregate;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public PositionalArrayAggregate getPositionalArrayAggregate() {
	return positionalArrayAggregate;
    }

    public NamedArrayAggregate getNamedArrayAggregate() {
	return namedArrayAggregate;
    }

}
