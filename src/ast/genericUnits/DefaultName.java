package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class DefaultName extends AbstractAST implements AST {

    private Name name;

    public DefaultName(Name name) {
	super();
	this.name = name;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Name getName() {
	return name;
    }

}
