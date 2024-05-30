package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ComponentClause extends AbstractAST implements AST {

    private Name componentLocalName;
    private Position position;
    private FirstBit firstBit;
    private LastBit lastBit;

    public ComponentClause(Name componentLocalName, Position position, FirstBit firstBit, LastBit lastBit) {
	super();
	this.componentLocalName = componentLocalName;
	this.position = position;
	this.firstBit = firstBit;
	this.lastBit = lastBit;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getComponentLocalName() {
	return componentLocalName;
    }

    public Position getPosition() {
	return position;
    }

    public FirstBit getFirstBit() {
	return firstBit;
    }

    public LastBit getLastBit() {
	return lastBit;
    }

}
