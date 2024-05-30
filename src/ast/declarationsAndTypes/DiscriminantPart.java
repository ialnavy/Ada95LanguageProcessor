package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DiscriminantPart extends AbstractAST implements AST {

    private UnknownDiscriminantPart unknownDiscriminantPart;
    private KnownDiscriminantPart knownDiscriminantPart;

    public DiscriminantPart(UnknownDiscriminantPart unknownDiscriminantPart) {
	super();
	this.unknownDiscriminantPart = unknownDiscriminantPart;
    }

    public DiscriminantPart(KnownDiscriminantPart knownDiscriminantPart) {
	super();
	this.knownDiscriminantPart = knownDiscriminantPart;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public UnknownDiscriminantPart getUnknownDiscriminantPart() {
	return unknownDiscriminantPart;
    }

    public KnownDiscriminantPart getKnownDiscriminantPart() {
	return knownDiscriminantPart;
    }

}
