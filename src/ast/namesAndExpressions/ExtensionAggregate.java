package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ExtensionAggregate extends AbstractAST implements AST {

    private AncestorPart ancestorPart;
    private RecordComponentAssociationList recordComponentAssociationList;

    public ExtensionAggregate(AncestorPart ancestorPart,
	    RecordComponentAssociationList recordComponentAssociationList) {
	super();
	this.ancestorPart = ancestorPart;
	this.recordComponentAssociationList = recordComponentAssociationList;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public AncestorPart getAncestorPart() {
	return ancestorPart;
    }

    public RecordComponentAssociationList getRecordComponentAssociationList() {
	return recordComponentAssociationList;
    }

}
