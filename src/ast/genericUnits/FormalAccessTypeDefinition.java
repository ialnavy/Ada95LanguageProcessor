package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.AccessTypeDefinition;
import visitor.Ada95Visitor;

public class FormalAccessTypeDefinition extends AbstractAST implements AST {

    private AccessTypeDefinition accessTypeDefinition;

    public FormalAccessTypeDefinition(AccessTypeDefinition accessTypeDefinition) {
	super();
	this.accessTypeDefinition = accessTypeDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public AccessTypeDefinition getAccessTypeDefinition() {
	return accessTypeDefinition;
    }

}
