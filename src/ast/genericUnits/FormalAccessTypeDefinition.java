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
	return visitor.visit(this, param);
	
    }

    public AccessTypeDefinition getAccessTypeDefinition() {
	return accessTypeDefinition;
    }

}
