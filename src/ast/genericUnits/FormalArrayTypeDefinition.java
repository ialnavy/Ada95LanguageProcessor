package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.ArrayTypeDefinition;
import visitor.Ada95Visitor;

public class FormalArrayTypeDefinition extends AbstractAST implements AST {

    private ArrayTypeDefinition arrayTypeDefinition;

    public FormalArrayTypeDefinition(ArrayTypeDefinition arrayTypeDefinition) {
	super();
	this.arrayTypeDefinition = arrayTypeDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ArrayTypeDefinition getArrayTypeDefinition() {
	return arrayTypeDefinition;
    }

}
