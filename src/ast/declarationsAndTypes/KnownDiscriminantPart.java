package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class KnownDiscriminantPart extends AbstractAST implements AST {

    private List<DiscriminantSpecification> discriminantSpecifications = new ArrayList<>();

    public KnownDiscriminantPart(List<DiscriminantSpecification> discriminantSpecifications) {
	super();
	this.discriminantSpecifications = discriminantSpecifications;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<DiscriminantSpecification> getDiscriminantSpecifications() {
	return discriminantSpecifications;
    }

}
