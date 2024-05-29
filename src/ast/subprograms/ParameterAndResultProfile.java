package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ParameterAndResultProfile extends AbstractAST implements AST {

    private FormalPart formalPart;
    private Name subtypeMark;

    public ParameterAndResultProfile(FormalPart formalPart, Name subtypeMark) {
	super();
	this.formalPart = formalPart;
	this.subtypeMark = subtypeMark;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public FormalPart getFormalPart() {
	return formalPart;
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

}
