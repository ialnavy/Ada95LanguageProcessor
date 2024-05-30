package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Aggregate extends AbstractAST implements AST {

    private RecordAggregate recordAggregate;
    private ExtensionAggregate extensionAggregate;
    private ArrayAggregate arrayAggregate;

    public Aggregate(RecordAggregate recordAggregate) {
	super();
	this.recordAggregate = recordAggregate;
    }

    public Aggregate(ExtensionAggregate extensionAggregate) {
	super();
	this.extensionAggregate = extensionAggregate;
    }

    public Aggregate(ArrayAggregate arrayAggregate) {
	super();
	this.arrayAggregate = arrayAggregate;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public RecordAggregate getRecordAggregate() {
	return recordAggregate;
    }

    public ExtensionAggregate getExtensionAggregate() {
	return extensionAggregate;
    }

    public ArrayAggregate getArrayAggregate() {
	return arrayAggregate;
    }

}
