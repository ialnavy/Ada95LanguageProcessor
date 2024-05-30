package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.visibilityRules.UseClause;
import visitor.Ada95Visitor;

public class ContextItem extends AbstractAST implements AST {

    private UseClause useClause;
    private WithClause withClause;

    public ContextItem(UseClause useClause) {
	super();
	this.useClause = useClause;
    }

    public ContextItem(WithClause withClause) {
	super();
	this.withClause = withClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public UseClause getUseClause() {
	return useClause;
    }

    public WithClause getWithClause() {
	return withClause;
    }

}
