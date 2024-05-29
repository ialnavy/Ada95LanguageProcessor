package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class TypeDefinition extends AbstractAST implements AST {

    private EnumerationTypeDefinition enumerationTypeDefinition;
    private IntegerTypeDefinition integerTypeDefinition;
    private RealTypeDefinition realTypeDefinition;
    private ArrayTypeDefinition arrayTypeDefinition;
    private RecordTypeDefinition recordTypeDefinition;
    private AccessTypeDefinition accessTypeDefinition;
    private DerivedTypeDefinition derivedTypeDefinition;

    public TypeDefinition(EnumerationTypeDefinition enumerationTypeDefinition) {
	super();
	this.enumerationTypeDefinition = enumerationTypeDefinition;
    }

    public TypeDefinition(IntegerTypeDefinition integerTypeDefinition) {
	super();
	this.integerTypeDefinition = integerTypeDefinition;
    }

    public TypeDefinition(RealTypeDefinition realTypeDefinition) {
	super();
	this.realTypeDefinition = realTypeDefinition;
    }

    public TypeDefinition(ArrayTypeDefinition arrayTypeDefinition) {
	super();
	this.arrayTypeDefinition = arrayTypeDefinition;
    }

    public TypeDefinition(RecordTypeDefinition recordTypeDefinition) {
	super();
	this.recordTypeDefinition = recordTypeDefinition;
    }

    public TypeDefinition(AccessTypeDefinition accessTypeDefinition) {
	super();
	this.accessTypeDefinition = accessTypeDefinition;
    }

    public TypeDefinition(DerivedTypeDefinition derivedTypeDefinition) {
	super();
	this.derivedTypeDefinition = derivedTypeDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public EnumerationTypeDefinition getEnumerationTypeDefinition() {
	return enumerationTypeDefinition;
    }

    public IntegerTypeDefinition getIntegerTypeDefinition() {
	return integerTypeDefinition;
    }

    public RealTypeDefinition getRealTypeDefinition() {
	return realTypeDefinition;
    }

    public ArrayTypeDefinition getArrayTypeDefinition() {
	return arrayTypeDefinition;
    }

    public RecordTypeDefinition getRecordTypeDefinition() {
	return recordTypeDefinition;
    }

    public AccessTypeDefinition getAccessTypeDefinition() {
	return accessTypeDefinition;
    }

    public DerivedTypeDefinition getDerivedTypeDefinition() {
	return derivedTypeDefinition;
    }

}
