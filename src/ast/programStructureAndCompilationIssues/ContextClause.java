package ast.programStructureAndCompilationIssues;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ContextClause extends AbstractAST implements AST {

    private List<ContextItem> contextItems = new ArrayList<>();

    public ContextClause(List<ContextItem> contextItems) {
	super();
	this.contextItems = contextItems;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<ContextItem> getContextItems() {
	return new ArrayList<>(contextItems);
    }

}
