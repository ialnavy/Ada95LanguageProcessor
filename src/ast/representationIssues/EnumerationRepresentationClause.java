package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class EnumerationRepresentationClause extends AbstractAST implements AST {

    private Name firstSubtypeLocalName;
    private EnumerationAggregate enumerationAggregate;

    public EnumerationRepresentationClause(Name firstSubtypeLocalName, EnumerationAggregate enumerationAggregate) {
	super();
	this.firstSubtypeLocalName = firstSubtypeLocalName;
	this.enumerationAggregate = enumerationAggregate;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getFirstSubtypeLocalName() {
	return firstSubtypeLocalName;
    }

    public EnumerationAggregate getEnumerationAggregate() {
	return enumerationAggregate;
    }

}
