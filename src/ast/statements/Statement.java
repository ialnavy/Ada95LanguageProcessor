package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Statement extends AbstractAST implements AST {

    private List<Label> labels = new ArrayList<>();
    private SimpleStatement simpleStatement;
    private CompoundStatement compoundStatement;

    public Statement(List<Label> labels, SimpleStatement simpleStatement) {
	super();
	this.labels = labels;
	this.simpleStatement = simpleStatement;
    }

    public Statement(List<Label> labels, CompoundStatement compoundStatement) {
	super();
	this.labels = labels;
	this.compoundStatement = compoundStatement;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<Label> getLabels() {
	return new ArrayList<>(labels);
    }

    public SimpleStatement getSimpleStatement() {
	return simpleStatement;
    }

    public CompoundStatement getCompoundStatement() {
	return compoundStatement;
    }

}
