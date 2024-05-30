package ast.genericUnits;

import ast.AbstractAST;
import ast.AST;
import visitor.Ada95Visitor;

public class FormalFloatingPointDefinition extends AbstractAST implements AST {

	@Override
	public Object accept(Ada95Visitor<Object> visitor, Object param) {
		return visitor.visit(this, param);
		
	}

}
