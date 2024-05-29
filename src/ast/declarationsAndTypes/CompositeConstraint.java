package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class CompositeConstraint extends AbstractAST implements AST {

    private IndexConstraint indexConstraint;
    private DiscriminantConstraint discriminantConstraint;

    public CompositeConstraint(IndexConstraint indexConstraint) {
	super();
	this.indexConstraint = indexConstraint;
    }

    public CompositeConstraint(DiscriminantConstraint discriminantConstraint) {
	super();
	this.discriminantConstraint = discriminantConstraint;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public IndexConstraint getIndexConstraint() {
	return indexConstraint;
    }

    public DiscriminantConstraint getDiscriminantConstraint() {
	return discriminantConstraint;
    }

}
