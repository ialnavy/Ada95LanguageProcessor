package ast.tasksAndSynchronization;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class ProtectedDefinition extends AbstractAST implements AST {

    private List<ProtectedOperationDeclaration> protectedOperationDeclarations = new ArrayList<>();
    private List<ProtectedElementDeclaration> protectedElementDeclarations = new ArrayList<>();
    private Identifier protectedIdentifier;

    public ProtectedDefinition(List<ProtectedOperationDeclaration> protectedOperationDeclarations,
	    List<ProtectedElementDeclaration> protectedElementDeclarations, Identifier protectedIdentifier) {
	super();
	this.protectedOperationDeclarations = protectedOperationDeclarations;
	this.protectedElementDeclarations = protectedElementDeclarations;
	this.protectedIdentifier = protectedIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<ProtectedOperationDeclaration> getProtectedOperationDeclarations() {
	return new ArrayList<>(protectedOperationDeclarations);
    }

    public List<ProtectedElementDeclaration> getProtectedElementDeclarations() {
	return new ArrayList<>(protectedElementDeclarations);
    }

    public Identifier getProtectedIdentifier() {
	return protectedIdentifier;
    }

}
