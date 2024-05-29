package ast.tasksAndSynchronization;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class TaskDefinition extends AbstractAST implements AST {

    private List<TaskItem> mainTaskItems = new ArrayList<>();
    private List<TaskItem> privateTaskItems = new ArrayList<>();
    private Identifier taskIdentifier;

    public TaskDefinition(List<TaskItem> mainTaskItems, List<TaskItem> privateTaskItems, Identifier taskIdentifier) {
	super();
	this.mainTaskItems = mainTaskItems;
	this.privateTaskItems = privateTaskItems;
	this.taskIdentifier = taskIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<TaskItem> getMainTaskItems() {
	return new ArrayList<>(mainTaskItems);
    }

    public List<TaskItem> getPrivateTaskItems() {
	return new ArrayList<>(privateTaskItems);
    }

    public Identifier getTaskIdentifier() {
	return taskIdentifier;
    }

}
