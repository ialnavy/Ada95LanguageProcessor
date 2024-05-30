package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SequenceOfStatements extends AbstractAST implements AST {

    private List<Statement> statements = new ArrayList<>();

    public SequenceOfStatements(List<Statement> statements) {
	super();
	this.statements = statements;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<Statement> getStatements() {
	return new ArrayList<>(statements);
    }

}
