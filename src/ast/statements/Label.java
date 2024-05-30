package ast.statements;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Label extends AbstractAST implements AST {

    private StatementIdentifier labelStatementIdentifier;

    public Label(StatementIdentifier labelStatementIdentifier) {
	super();
	this.labelStatementIdentifier = labelStatementIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public StatementIdentifier getLabelStatementIdentifier() {
	return labelStatementIdentifier;
    }

}
