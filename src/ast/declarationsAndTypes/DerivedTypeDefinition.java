package ast.declarationsAndTypes;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DerivedTypeDefinition extends AbstractAST implements AST {

    private SubtypeIndication parentSubtypeIndication;
    private RecordExtensionPart recordExtensionPart;

    private Token abstractToken;

    public DerivedTypeDefinition(SubtypeIndication parentSubtypeIndication, RecordExtensionPart recordExtensionPart,
	    Token abstractToken) {
	super();
	this.parentSubtypeIndication = parentSubtypeIndication;
	this.recordExtensionPart = recordExtensionPart;
	this.abstractToken = abstractToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubtypeIndication getParentSubtypeIndication() {
	return parentSubtypeIndication;
    }

    public RecordExtensionPart getRecordExtensionPart() {
	return recordExtensionPart;
    }

    public Token getAbstractToken() {
	return abstractToken;
    }

}
