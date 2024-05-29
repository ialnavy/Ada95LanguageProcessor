package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.packages.PrivateExtensionDeclaration;
import ast.packages.PrivateTypeDeclaration;
import visitor.Ada95Visitor;

public class TypeDeclaration extends AbstractAST implements AST {

    private FullTypeDeclaration fullTypeDeclaration;
    private IncompleteTypeDeclaration incompleteTypeDeclaration;
    private PrivateTypeDeclaration privateTypeDeclaration;
    private PrivateExtensionDeclaration privateExtensionDeclaration;

    public TypeDeclaration(FullTypeDeclaration fullTypeDeclaration) {
	super();
	this.fullTypeDeclaration = fullTypeDeclaration;
    }

    public TypeDeclaration(IncompleteTypeDeclaration incompleteTypeDeclaration) {
	super();
	this.incompleteTypeDeclaration = incompleteTypeDeclaration;
    }

    public TypeDeclaration(PrivateTypeDeclaration privateTypeDeclaration) {
	super();
	this.privateTypeDeclaration = privateTypeDeclaration;
    }

    public TypeDeclaration(PrivateExtensionDeclaration privateExtensionDeclaration) {
	super();
	this.privateExtensionDeclaration = privateExtensionDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public FullTypeDeclaration getFullTypeDeclaration() {
	return fullTypeDeclaration;
    }

    public IncompleteTypeDeclaration getIncompleteTypeDeclaration() {
	return incompleteTypeDeclaration;
    }

    public PrivateTypeDeclaration getPrivateTypeDeclaration() {
	return privateTypeDeclaration;
    }

    public PrivateExtensionDeclaration getPrivateExtensionDeclaration() {
	return privateExtensionDeclaration;
    }

}
