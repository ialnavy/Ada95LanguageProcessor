package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RecordAggregate extends AbstractAST implements AST {

    private RecordComponentAssociationList recordComponentAssociationList;

    public RecordAggregate(RecordComponentAssociationList recordComponentAssociationList) {
	super();
	this.recordComponentAssociationList = recordComponentAssociationList;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public RecordComponentAssociationList getRecordComponentAssociationList() {
	return recordComponentAssociationList;
    }

}
