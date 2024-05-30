package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RangeAttributeReference extends AbstractAST implements AST {

    private Name prefix;
    private RangeAttributeDesignator rangeAttributeDesignator;

    public RangeAttributeReference(Name prefix, RangeAttributeDesignator rangeAttributeDesignator) {
	super();
	this.prefix = prefix;
	this.rangeAttributeDesignator = rangeAttributeDesignator;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getPrefix() {
	return prefix;
    }

    public RangeAttributeDesignator getRangeAttributeDesignator() {
	return rangeAttributeDesignator;
    }

}
