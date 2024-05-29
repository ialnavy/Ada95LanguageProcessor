package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Factor extends AbstractAST implements AST {

    private Primary primary;
    private Primary primaryExp;

    public Factor(Primary primary, Primary primaryExp) {
	super();
	this.primary = primary;
	this.primaryExp = primaryExp;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Primary getPrimary() {
	return primary;
    }

    public Primary getPrimaryExp() {
	return primaryExp;
    }

}
