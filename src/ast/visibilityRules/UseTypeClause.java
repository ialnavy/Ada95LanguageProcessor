package ast.visibilityRules;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class UseTypeClause extends AbstractAST implements AST {

    private List<Name> subtypeMarks = new ArrayList<>();

    public UseTypeClause(List<Name> subtypeMarks) {
	super();
	this.subtypeMarks = subtypeMarks;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<Name> getSubtypeMarks() {
	return new ArrayList<>(subtypeMarks);
    }

}
