package ast.declarationsAndTypes;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RecordTypeDefinition extends AbstractAST implements AST {

    private RecordDefinition recordDefinition;

    private Token abstractToken;
    private Token tagged;
    private Token limited;

    public RecordTypeDefinition(RecordDefinition recordDefinition, Token abstractToken, Token tagged, Token limited) {
	super();
	this.recordDefinition = recordDefinition;
	this.abstractToken = abstractToken;
	this.tagged = tagged;
	this.limited = limited;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public RecordDefinition getRecordDefinition() {
	return recordDefinition;
    }

    public Token getAbstractToken() {
	return abstractToken;
    }

    public Token getTagged() {
	return tagged;
    }

    public Token getLimited() {
	return limited;
    }

}
