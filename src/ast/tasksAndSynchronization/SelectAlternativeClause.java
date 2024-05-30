package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SelectAlternativeClause extends AbstractAST implements AST {

    private Guard guard;
    private SelectAlternative selectAlternative;

    public SelectAlternativeClause(Guard guard, SelectAlternative selectAlternative) {
	super();
	this.guard = guard;
	this.selectAlternative = selectAlternative;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Guard getGuard() {
	return guard;
    }

    public SelectAlternative getSelectAlternative() {
	return selectAlternative;
    }

}
