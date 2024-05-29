package ast.statements;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class NullStatement extends AbstractAST implements AST {

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

}
