package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RecordExtensionPart extends AbstractAST implements AST {

    private RecordDefinition recordDefinition;

    public RecordExtensionPart(RecordDefinition recordDefinition) {
	super();
	this.recordDefinition = recordDefinition;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public RecordDefinition getRecordDefinition() {
	return recordDefinition;
    }

}
