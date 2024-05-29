package ast.tasksAndSynchronization;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import ast.subprograms.ActualParameterPart;
import visitor.Ada95Visitor;

public class EntryCallStatement extends AbstractAST implements AST {

    private Name entryName;
    private ActualParameterPart actualParameterPart;

    public EntryCallStatement(Name entryName, ActualParameterPart actualParameterPart) {
	super();
	this.entryName = entryName;
	this.actualParameterPart = actualParameterPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Name getEntryName() {
	return entryName;
    }

    public ActualParameterPart getActualParameterPart() {
	return actualParameterPart;
    }

}
