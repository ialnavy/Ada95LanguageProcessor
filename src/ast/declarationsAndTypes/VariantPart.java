package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.DirectName;
import visitor.Ada95Visitor;

public class VariantPart extends AbstractAST implements AST {

    private DirectName discriminantDirectName;
    private List<Variant> variants = new ArrayList<>();

    public VariantPart(DirectName discriminantDirectName, List<Variant> variants) {
	super();
	this.discriminantDirectName = discriminantDirectName;
	this.variants = variants;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DirectName getDiscriminantDirectName() {
	return discriminantDirectName;
    }

    public List<Variant> getVariants() {
	return new ArrayList<>(variants);
    }

}
