package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class NamedArrayAggregate extends AbstractAST implements AST {

    private List<ArrayComponentAssociation> arrayComponentAssociations = new ArrayList<>();

    public NamedArrayAggregate(List<ArrayComponentAssociation> arrayComponentAssociations) {
	super();
	this.arrayComponentAssociations = arrayComponentAssociations;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<ArrayComponentAssociation> getArrayComponentAssociations() {
	return new ArrayList<>(arrayComponentAssociations);
    }

}
