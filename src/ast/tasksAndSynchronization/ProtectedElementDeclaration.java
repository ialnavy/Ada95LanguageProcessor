package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.ComponentDeclaration;
import visitor.Ada95Visitor;

public class ProtectedElementDeclaration extends AbstractAST implements AST {

    private ProtectedOperationDeclaration protectedOperationDeclaration;
    private ComponentDeclaration componentDeclaration;

    public ProtectedElementDeclaration(ProtectedOperationDeclaration protectedOperationDeclaration) {
	super();
	this.protectedOperationDeclaration = protectedOperationDeclaration;
    }

    public ProtectedElementDeclaration(ComponentDeclaration componentDeclaration) {
	super();
	this.componentDeclaration = componentDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ProtectedOperationDeclaration getProtectedOperationDeclaration() {
	return protectedOperationDeclaration;
    }

    public ComponentDeclaration getComponentDeclaration() {
	return componentDeclaration;
    }

}
