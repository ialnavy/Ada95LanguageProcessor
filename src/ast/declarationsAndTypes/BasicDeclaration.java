package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.exceptions.ExceptionDeclaration;
import ast.genericUnits.GenericDeclaration;
import ast.genericUnits.GenericInstantiation;
import ast.packages.PackageDeclaration;
import ast.subprograms.AbstractSubprogramDeclaration;
import ast.subprograms.SubprogramDeclaration;
import ast.visibilityRules.RenamingDeclaration;
import visitor.Ada95Visitor;

public class BasicDeclaration extends AbstractAST implements AST {

    private TypeDeclaration typeDeclaration;
    private SubtypeDeclaration subtypeDeclaration;
    private ObjectDeclaration objectDeclaration;
    private NumberDeclaration numberDeclaration;
    private SubprogramDeclaration subprogramDeclaration;
    private AbstractSubprogramDeclaration abstractSubprogramDeclaration;
    private PackageDeclaration packageDeclaration;
    private RenamingDeclaration renamingDeclaration;
    private ExceptionDeclaration exceptionDeclaration;
    private GenericDeclaration genericDeclaration;
    private GenericInstantiation genericInstantiation;

    public BasicDeclaration(TypeDeclaration typeDeclaration) {
	super();
	this.typeDeclaration = typeDeclaration;
    }

    public BasicDeclaration(SubtypeDeclaration subtypeDeclaration) {
	super();
	this.subtypeDeclaration = subtypeDeclaration;
    }

    public BasicDeclaration(ObjectDeclaration objectDeclaration) {
	super();
	this.objectDeclaration = objectDeclaration;
    }

    public BasicDeclaration(NumberDeclaration numberDeclaration) {
	super();
	this.numberDeclaration = numberDeclaration;
    }

    public BasicDeclaration(SubprogramDeclaration subprogramDeclaration) {
	super();
	this.subprogramDeclaration = subprogramDeclaration;
    }

    public BasicDeclaration(AbstractSubprogramDeclaration abstractSubprogramDeclaration) {
	super();
	this.abstractSubprogramDeclaration = abstractSubprogramDeclaration;
    }

    public BasicDeclaration(PackageDeclaration packageDeclaration) {
	super();
	this.packageDeclaration = packageDeclaration;
    }

    public BasicDeclaration(RenamingDeclaration renamingDeclaration) {
	super();
	this.renamingDeclaration = renamingDeclaration;
    }

    public BasicDeclaration(ExceptionDeclaration exceptionDeclaration) {
	super();
	this.exceptionDeclaration = exceptionDeclaration;
    }

    public BasicDeclaration(GenericDeclaration genericDeclaration) {
	super();
	this.genericDeclaration = genericDeclaration;
    }

    public BasicDeclaration(GenericInstantiation genericInstantiation) {
	super();
	this.genericInstantiation = genericInstantiation;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public TypeDeclaration getTypeDeclaration() {
	return typeDeclaration;
    }

    public SubtypeDeclaration getSubtypeDeclaration() {
	return subtypeDeclaration;
    }

    public ObjectDeclaration getObjectDeclaration() {
	return objectDeclaration;
    }

    public NumberDeclaration getNumberDeclaration() {
	return numberDeclaration;
    }

    public SubprogramDeclaration getSubprogramDeclaration() {
	return subprogramDeclaration;
    }

    public AbstractSubprogramDeclaration getAbstractSubprogramDeclaration() {
	return abstractSubprogramDeclaration;
    }

    public PackageDeclaration getPackageDeclaration() {
	return packageDeclaration;
    }

    public RenamingDeclaration getRenamingDeclaration() {
	return renamingDeclaration;
    }

    public ExceptionDeclaration getExceptionDeclaration() {
	return exceptionDeclaration;
    }

    public GenericDeclaration getGenericDeclaration() {
	return genericDeclaration;
    }

    public GenericInstantiation getGenericInstantiation() {
	return genericInstantiation;
    }

}
