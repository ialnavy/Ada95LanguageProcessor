package ast.declarationsAndTypes;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ComponentDefinition extends AbstractAST implements AST {

    private SubtypeIndication subtypeIndication;

    private Token aliased;

    public ComponentDefinition(SubtypeIndication subtypeIndication, Token aliased) {
	super();
	this.subtypeIndication = subtypeIndication;
	this.aliased = aliased;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubtypeIndication getSubtypeIndication() {
	return subtypeIndication;
    }

    public Token getAliased() {
	return aliased;
    }

}
