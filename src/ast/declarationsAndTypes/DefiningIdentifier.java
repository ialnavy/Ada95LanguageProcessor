package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class DefiningIdentifier extends AbstractAST implements AST {

    private Identifier identifier;

    public DefiningIdentifier(Identifier identifier) {
	super();
	this.identifier = identifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Identifier getIdentifier() {
	return identifier;
    }

}
