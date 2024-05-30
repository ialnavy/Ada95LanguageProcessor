package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class RecordComponentAssociationList extends AbstractAST implements AST {

    private List<RecordComponentAssociation> recordComponentAssociations = new ArrayList<>();

    public RecordComponentAssociationList(List<RecordComponentAssociation> recordComponentAssociations) {
	super();
	this.recordComponentAssociations = recordComponentAssociations;
    }

    public RecordComponentAssociationList() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<RecordComponentAssociation> getRecordComponentAssociations() {
	return new ArrayList<>(recordComponentAssociations);
    }

}
