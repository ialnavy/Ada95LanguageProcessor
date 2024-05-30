package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class SubtypeIndication extends AbstractAST implements AST {

    private Name name;
    private Constraint constraint;

    public SubtypeIndication(Name name, Constraint constraint) {
	super();
	this.name = name;
	this.constraint = constraint;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getName() {
	return name;
    }

    public Constraint getConstraint() {
	return constraint;
    }

}
