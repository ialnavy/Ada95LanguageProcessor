package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class IndexSubtypeDefinition extends AbstractAST implements AST {

    private Name subtypeMark;
    private Range range;

    public IndexSubtypeDefinition(Name subtypeMark, Range range) {
	super();
	this.subtypeMark = subtypeMark;
	this.range = range;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

    public Range getRange() {
	return range;
    }

}
