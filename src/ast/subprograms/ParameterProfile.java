package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ParameterProfile extends AbstractAST implements AST {

    private FormalPart formalPart;

    public ParameterProfile(FormalPart formalPart) {
	super();
	this.formalPart = formalPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public FormalPart getFormalPart() {
	return formalPart;
    }

}
