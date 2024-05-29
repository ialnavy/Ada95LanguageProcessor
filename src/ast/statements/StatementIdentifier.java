package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.DirectName;
import visitor.Ada95Visitor;

public class StatementIdentifier extends AbstractAST implements AST {

    private DirectName directName;

    public StatementIdentifier(DirectName directName) {
	super();
	this.directName = directName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DirectName getDirectName() {
	return directName;
    }

}
