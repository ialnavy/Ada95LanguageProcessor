package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ExitStatement extends AbstractAST implements AST {

    private Name loopName;
    private Condition condition;

    public ExitStatement(Name loopName, Condition condition) {
	super();
	this.loopName = loopName;
	this.condition = condition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getLoopName() {
	return loopName;
    }

    public Condition getCondition() {
	return condition;
    }

}
