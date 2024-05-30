package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.AttributeDesignator;
import ast.namesAndExpressions.Expression;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class AttributeDefinitionClause extends AbstractAST implements AST {

    private LocalName localName;
    private AttributeDesignator attributeDesignator;
    private Expression expression;
    private Name name;

    public AttributeDefinitionClause(LocalName localName, AttributeDesignator attributeDesignator,
	    Expression expression) {
	super();
	this.localName = localName;
	this.attributeDesignator = attributeDesignator;
	this.expression = expression;
    }

    public AttributeDefinitionClause(LocalName localName, AttributeDesignator attributeDesignator, Name name) {
	super();
	this.localName = localName;
	this.attributeDesignator = attributeDesignator;
	this.name = name;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public LocalName getLocalName() {
	return localName;
    }

    public AttributeDesignator getAttributeDesignator() {
	return attributeDesignator;
    }

    public Expression getExpression() {
	return expression;
    }

    public Name getName() {
	return name;
    }

}
