package ast.visibilityRules;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RenamingDeclaration extends AbstractAST implements AST {

    private ObjectRenamingDeclaration objectRenamingDeclaration;
    private ExceptionRenamingDeclaration exceptionRenamingDeclaration;
    private PackageRenamingDeclaration packageRenamingDeclaration;
    private SubprogramRenamingDeclaration subprogramRenamingDeclaration;
    private GenericRenamingDeclaration genericRenamingDeclaration;

    public RenamingDeclaration(ObjectRenamingDeclaration objectRenamingDeclaration) {
	super();
	this.objectRenamingDeclaration = objectRenamingDeclaration;
    }

    public RenamingDeclaration(ExceptionRenamingDeclaration exceptionRenamingDeclaration) {
	super();
	this.exceptionRenamingDeclaration = exceptionRenamingDeclaration;
    }

    public RenamingDeclaration(PackageRenamingDeclaration packageRenamingDeclaration) {
	super();
	this.packageRenamingDeclaration = packageRenamingDeclaration;
    }

    public RenamingDeclaration(SubprogramRenamingDeclaration subprogramRenamingDeclaration) {
	super();
	this.subprogramRenamingDeclaration = subprogramRenamingDeclaration;
    }

    public RenamingDeclaration(GenericRenamingDeclaration genericRenamingDeclaration) {
	super();
	this.genericRenamingDeclaration = genericRenamingDeclaration;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ObjectRenamingDeclaration getObjectRenamingDeclaration() {
	return objectRenamingDeclaration;
    }

    public ExceptionRenamingDeclaration getExceptionRenamingDeclaration() {
	return exceptionRenamingDeclaration;
    }

    public PackageRenamingDeclaration getPackageRenamingDeclaration() {
	return packageRenamingDeclaration;
    }

    public SubprogramRenamingDeclaration getSubprogramRenamingDeclaration() {
	return subprogramRenamingDeclaration;
    }

    public GenericRenamingDeclaration getGenericRenamingDeclaration() {
	return genericRenamingDeclaration;
    }

}
