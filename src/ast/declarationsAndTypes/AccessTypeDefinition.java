package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class AccessTypeDefinition extends AbstractAST implements AST {

    private AccessToObjectDefinition accessToObjectDefinition;
    private AccessToSubprogramDefinition accessToSubprogramDefinition;

    public AccessTypeDefinition(AccessToObjectDefinition accessToObjectDefinition) {
	super();
	this.accessToObjectDefinition = accessToObjectDefinition;
    }

    public AccessTypeDefinition(AccessToSubprogramDefinition accessToSubprogramDefinition) {
	super();
	this.accessToSubprogramDefinition = accessToSubprogramDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public AccessToObjectDefinition getAccessToObjectDefinition() {
	return accessToObjectDefinition;
    }

    public AccessToSubprogramDefinition getAccessToSubprogramDefinition() {
	return accessToSubprogramDefinition;
    }

}
