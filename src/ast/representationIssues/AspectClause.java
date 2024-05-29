package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.others.AtClause;
import visitor.Ada95Visitor;

public class AspectClause extends AbstractAST implements AST {

    private AttributeDefinitionClause attributeDefinitionClause;
    private EnumerationRepresentationClause enumerationRepresentationClause;
    private RecordRepresentationClause recordRepresentationClause;
    private AtClause atClause;

    public AspectClause(AttributeDefinitionClause attributeDefinitionClause) {
	super();
	this.attributeDefinitionClause = attributeDefinitionClause;
    }

    public AspectClause(EnumerationRepresentationClause enumerationRepresentationClause) {
	super();
	this.enumerationRepresentationClause = enumerationRepresentationClause;
    }

    public AspectClause(RecordRepresentationClause recordRepresentationClause) {
	super();
	this.recordRepresentationClause = recordRepresentationClause;
    }

    public AspectClause(AtClause atClause) {
	super();
	this.atClause = atClause;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public AttributeDefinitionClause getAttributeDefinitionClause() {
	return attributeDefinitionClause;
    }

    public EnumerationRepresentationClause getEnumerationRepresentationClause() {
	return enumerationRepresentationClause;
    }

    public RecordRepresentationClause getRecordRepresentationClause() {
	return recordRepresentationClause;
    }

    public AtClause getAtClause() {
	return atClause;
    }

}
