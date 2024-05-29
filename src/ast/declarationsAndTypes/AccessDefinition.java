package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class AccessDefinition extends AbstractAST implements AST {

    private Name subtypeMark;

    public AccessDefinition(Name subtypeMark) {
	super();
	this.subtypeMark = subtypeMark;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

}
