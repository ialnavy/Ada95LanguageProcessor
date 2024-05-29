package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DefiningIdentifierList extends AbstractAST implements AST {

    private List<DefiningIdentifier> definingIdentifiers = new ArrayList<>();

    public DefiningIdentifierList(List<DefiningIdentifier> definingIdentifiers) {
	super();
	this.definingIdentifiers = definingIdentifiers;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<DefiningIdentifier> getDefiningIdentifiers() {
	return new ArrayList<>(definingIdentifiers);
    }

}
