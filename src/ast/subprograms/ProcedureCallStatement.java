package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ProcedureCallStatement extends AbstractAST implements AST {

    private Name name;
    private ActualParameterPart actualParameterPart;

    public ProcedureCallStatement(Name name) {
	super();
	this.name = name;
    }

    public ProcedureCallStatement(Name name, ActualParameterPart actualParameterPart) {
	super();
	this.name = name;
	this.actualParameterPart = actualParameterPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getName() {
	return name;
    }

    public ActualParameterPart getActualParameterPart() {
	return actualParameterPart;
    }

}
