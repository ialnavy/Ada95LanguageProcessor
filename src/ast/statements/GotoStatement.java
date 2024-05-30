package ast.statements;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class GotoStatement extends AbstractAST implements AST {

    private Name labelName;

    public GotoStatement(Name labelName) {
	super();
	this.labelName = labelName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getLabelName() {
	return labelName;
    }

}
