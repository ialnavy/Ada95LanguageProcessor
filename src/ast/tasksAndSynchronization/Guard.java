package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.statements.Condition;
import visitor.Ada95Visitor;

public class Guard extends AbstractAST implements AST {

    private Condition condition;

    public Guard(Condition condition) {
	super();
	this.condition = condition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Condition getCondition() {
	return condition;
    }

}
