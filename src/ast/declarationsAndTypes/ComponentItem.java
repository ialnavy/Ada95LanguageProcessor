package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.representationIssues.AspectClause;
import visitor.Ada95Visitor;

public class ComponentItem extends AbstractAST implements AST {

    private ComponentDeclaration componentDeclaration;
    private AspectClause aspectClause;

    public ComponentItem(ComponentDeclaration componentDeclaration) {
	super();
	this.componentDeclaration = componentDeclaration;
    }

    public ComponentItem(AspectClause aspectClause) {
	super();
	this.aspectClause = aspectClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ComponentDeclaration getComponentDeclaration() {
	return componentDeclaration;
    }

    public AspectClause getAspectClause() {
	return aspectClause;
    }

}
