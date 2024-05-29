package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class IntegerTypeDefinition extends AbstractAST implements AST {

    private SignedIntegerTypeDefinition signedIntegerTypeDefinition;
    private ModularTypeDefinition modularTypeDefinition;

    public IntegerTypeDefinition(SignedIntegerTypeDefinition signedIntegerTypeDefinition) {
	super();
	this.signedIntegerTypeDefinition = signedIntegerTypeDefinition;
    }

    public IntegerTypeDefinition(ModularTypeDefinition modularTypeDefinition) {
	super();
	this.modularTypeDefinition = modularTypeDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SignedIntegerTypeDefinition getSignedIntegerTypeDefinition() {
	return signedIntegerTypeDefinition;
    }

    public ModularTypeDefinition getModularTypeDefinition() {
	return modularTypeDefinition;
    }

}
