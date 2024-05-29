package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.AttributeDesignator;
import ast.namesAndExpressions.DirectName;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class LocalName extends AbstractAST implements AST {

    private DirectName directName;
    private AttributeDesignator attributeDesignator;
    private Name libraryUnitName;

    public LocalName(DirectName directName) {
	super();
	this.directName = directName;
    }

    public LocalName(DirectName directName, AttributeDesignator attributeDesignator) {
	super();
	this.directName = directName;
	this.attributeDesignator = attributeDesignator;
    }

    public LocalName(Name libraryUnitName) {
	super();
	this.libraryUnitName = libraryUnitName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DirectName getDirectName() {
	return directName;
    }

    public AttributeDesignator getAttributeDesignator() {
	return attributeDesignator;
    }

    public Name getLibraryUnitName() {
	return libraryUnitName;
    }

}
