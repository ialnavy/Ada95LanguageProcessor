package ast.visibilityRules;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class UseClause extends AbstractAST implements AST {

    private UsePackageClause usePackageClause;
    private UseTypeClause useTypeClause;

    public UseClause(UsePackageClause usePackageClause) {
	super();
	this.usePackageClause = usePackageClause;
    }

    public UseClause(UseTypeClause useTypeClause) {
	super();
	this.useTypeClause = useTypeClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public UsePackageClause getUsePackageClause() {
	return usePackageClause;
    }

    public UseTypeClause getUseTypeClause() {
	return useTypeClause;
    }

}
