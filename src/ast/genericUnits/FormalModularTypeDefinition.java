package ast.genericUnits;

import ast.AbstractAST;
import ast.AST;
import visitor.Ada95Visitor;

public class FormalModularTypeDefinition extends AbstractAST implements AST {

	@Override
	public Object accept(Ada95Visitor<Object> visitor, Object param) {
		visitor.visit(this, param);
		return null;
	}

}
