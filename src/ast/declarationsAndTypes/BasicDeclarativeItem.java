package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.representationIssues.AspectClause;
import ast.visibilityRules.UseClause;
import visitor.Ada95Visitor;

public class BasicDeclarativeItem extends AbstractAST implements AST {

    private BasicDeclaration basicDeclaration;
    private AspectClause aspectClause;
    private UseClause useClause;

    public BasicDeclarativeItem(BasicDeclaration basicDeclaration) {
	super();
	this.basicDeclaration = basicDeclaration;
    }

    public BasicDeclarativeItem(AspectClause aspectClause) {
	super();
	this.aspectClause = aspectClause;
    }

    public BasicDeclarativeItem(UseClause useClause) {
	super();
	this.useClause = useClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public BasicDeclaration getBasicDeclaration() {
	return basicDeclaration;
    }

    public AspectClause getAspectClause() {
	return aspectClause;
    }

    public UseClause getUseClause() {
	return useClause;
    }

}
