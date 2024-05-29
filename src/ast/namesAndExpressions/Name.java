package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DiscreteRange;
import ast.lexicalElements.CharacterLiteral;
import ast.subprograms.ActualParameterPart;
import visitor.Ada95Visitor;

public class Name extends AbstractAST implements AST {

    private DirectName directName;
    private Name label;
    private List<Expression> arguments = new ArrayList<>();
    private DiscreteRange discreteRange;
    private SelectorName selectorName;
    private AttributeDesignator attributeDesignator;
    private Expression expression;
    private Name argument;
    private ActualParameterPart actualParameterPart;
    private CharacterLiteral characterLiteral;

    public Name(DirectName directName) {
	super();
	this.directName = directName;
    }

    public Name(Name label) {
	super();
	this.label = label;
    }

    public Name(Name label, List<Expression> arguments) {
	super();
	this.label = label;
	this.arguments = arguments;
    }

    public Name(Name label, DiscreteRange discreteRange) {
	super();
	this.label = label;
	this.discreteRange = discreteRange;
    }

    public Name(Name label, SelectorName selectorName) {
	super();
	this.label = label;
	this.selectorName = selectorName;
    }

    public Name(Name label, AttributeDesignator attributeDesignator) {
	super();
	this.label = label;
	this.attributeDesignator = attributeDesignator;
    }

    public Name(Name label, Expression expression) {
	super();
	this.label = label;
	this.expression = expression;
    }

    public Name(Name label, Name argument) {
	super();
	this.label = label;
	this.argument = argument;
    }

    public Name(Name label, ActualParameterPart actualParameterPart) {
	super();
	this.label = label;
	this.actualParameterPart = actualParameterPart;
    }

    public Name(CharacterLiteral characterLiteral) {
	super();
	this.characterLiteral = characterLiteral;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DirectName getDirectName() {
	return directName;
    }

    public Name getLabel() {
	return label;
    }

    public List<Expression> getArguments() {
	return new ArrayList<>(arguments);
    }

    public DiscreteRange getDiscreteRange() {
	return discreteRange;
    }

    public SelectorName getSelectorName() {
	return selectorName;
    }

    public AttributeDesignator getAttributeDesignator() {
	return attributeDesignator;
    }

    public Expression getExpression() {
	return expression;
    }

    public Name getArgument() {
	return argument;
    }

    public ActualParameterPart getActualParameterPart() {
	return actualParameterPart;
    }

    public CharacterLiteral getCharacterLiteral() {
	return characterLiteral;
    }

}
