package ast.tasksAndSynchronization;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class AbortStatement extends AbstractAST implements AST {

    private List<Name> taskNames = new ArrayList<>();

    public AbortStatement(List<Name> taskNames) {
	super();
	this.taskNames = taskNames;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<Name> getTaskNames() {
	return new ArrayList<>(taskNames);
    }

}
