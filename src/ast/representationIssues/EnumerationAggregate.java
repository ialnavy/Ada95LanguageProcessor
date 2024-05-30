package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.ArrayAggregate;
import visitor.Ada95Visitor;

public class EnumerationAggregate extends AbstractAST implements AST {

    private ArrayAggregate arrayAggregate;

    public EnumerationAggregate(ArrayAggregate arrayAggregate) {
	super();
	this.arrayAggregate = arrayAggregate;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ArrayAggregate getArrayAggregate() {
	return arrayAggregate;
    }

}
