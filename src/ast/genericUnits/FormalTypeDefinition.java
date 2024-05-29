package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class FormalTypeDefinition extends AbstractAST implements AST {

    private FormalPrivateTypeDefinition formalPrivateTypeDefinition;
    private FormalDerivedTypeDefinition formalDerivedTypeDefinition;
    private FormalDiscreteTypeDefinition formalDiscreteTypeDefinition;
    private FormalSignedIntegerTypeDefinition formalSignedIntegerTypeDefinition;
    private FormalModularTypeDefinition formalModularTypeDefinition;
    private FormalFloatingPointDefinition formalFloatingPointDefinition;
    private FormalOrdinaryFixedPointDefinition formalOrdinaryFixedPointDefinition;
    private FormalDecimalFixedPointDefinition formalDecimalFixedPointDefinition;
    private FormalArrayTypeDefinition formalArrayTypeDefinition;
    private FormalAccessTypeDefinition formalAccessTypeDefinition;

    public FormalTypeDefinition(FormalPrivateTypeDefinition formalPrivateTypeDefinition) {
	super();
	this.formalPrivateTypeDefinition = formalPrivateTypeDefinition;
    }

    public FormalTypeDefinition(FormalDerivedTypeDefinition formalDerivedTypeDefinition) {
	super();
	this.formalDerivedTypeDefinition = formalDerivedTypeDefinition;
    }

    public FormalTypeDefinition(FormalDiscreteTypeDefinition formalDiscreteTypeDefinition) {
	super();
	this.formalDiscreteTypeDefinition = formalDiscreteTypeDefinition;
    }

    public FormalTypeDefinition(FormalSignedIntegerTypeDefinition formalSignedIntegerTypeDefinition) {
	super();
	this.formalSignedIntegerTypeDefinition = formalSignedIntegerTypeDefinition;
    }

    public FormalTypeDefinition(FormalModularTypeDefinition formalModularTypeDefinition) {
	super();
	this.formalModularTypeDefinition = formalModularTypeDefinition;
    }

    public FormalTypeDefinition(FormalFloatingPointDefinition formalFloatingPointDefinition) {
	super();
	this.formalFloatingPointDefinition = formalFloatingPointDefinition;
    }

    public FormalTypeDefinition(FormalOrdinaryFixedPointDefinition formalOrdinaryFixedPointDefinition) {
	super();
	this.formalOrdinaryFixedPointDefinition = formalOrdinaryFixedPointDefinition;
    }

    public FormalTypeDefinition(FormalDecimalFixedPointDefinition formalDecimalFixedPointDefinition) {
	super();
	this.formalDecimalFixedPointDefinition = formalDecimalFixedPointDefinition;
    }

    public FormalTypeDefinition(FormalArrayTypeDefinition formalArrayTypeDefinition) {
	super();
	this.formalArrayTypeDefinition = formalArrayTypeDefinition;
    }

    public FormalTypeDefinition(FormalAccessTypeDefinition formalAccessTypeDefinition) {
	super();
	this.formalAccessTypeDefinition = formalAccessTypeDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public FormalPrivateTypeDefinition getFormalPrivateTypeDefinition() {
	return formalPrivateTypeDefinition;
    }

    public FormalDerivedTypeDefinition getFormalDerivedTypeDefinition() {
	return formalDerivedTypeDefinition;
    }

    public FormalDiscreteTypeDefinition getFormalDiscreteTypeDefinition() {
	return formalDiscreteTypeDefinition;
    }

    public FormalSignedIntegerTypeDefinition getFormalSignedIntegerTypeDefinition() {
	return formalSignedIntegerTypeDefinition;
    }

    public FormalModularTypeDefinition getFormalModularTypeDefinition() {
	return formalModularTypeDefinition;
    }

    public FormalFloatingPointDefinition getFormalFloatingPointDefinition() {
	return formalFloatingPointDefinition;
    }

    public FormalOrdinaryFixedPointDefinition getFormalOrdinaryFixedPointDefinition() {
	return formalOrdinaryFixedPointDefinition;
    }

    public FormalDecimalFixedPointDefinition getFormalDecimalFixedPointDefinition() {
	return formalDecimalFixedPointDefinition;
    }

    public FormalArrayTypeDefinition getFormalArrayTypeDefinition() {
	return formalArrayTypeDefinition;
    }

    public FormalAccessTypeDefinition getFormalAccessTypeDefinition() {
	return formalAccessTypeDefinition;
    }
}
