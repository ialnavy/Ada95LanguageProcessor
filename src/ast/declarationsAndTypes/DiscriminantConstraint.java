package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DiscriminantConstraint extends AbstractAST implements AST {

    private List<DiscriminantAssociation> discriminantAssociations = new ArrayList<>();

    public DiscriminantConstraint(List<DiscriminantAssociation> discriminantAssociations) {
	super();
	this.discriminantAssociations = discriminantAssociations;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<DiscriminantAssociation> getDiscriminantAssociations() {
	return new ArrayList<>(discriminantAssociations);
    }

}
