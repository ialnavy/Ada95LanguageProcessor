package ast.genericUnits;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class GenericActualPart extends AbstractAST implements AST {

    private List<GenericAssociation> genericAssociations = new ArrayList<>();

    public GenericActualPart(List<GenericAssociation> genericAssociations) {
	super();
	this.genericAssociations = genericAssociations;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<GenericAssociation> getGenericAssociations() {
	return new ArrayList<>(genericAssociations);
    }

}
