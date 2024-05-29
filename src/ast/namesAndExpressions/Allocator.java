package ast.namesAndExpressions;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.SubtypeIndication;
import visitor.Ada95Visitor;

public class Allocator extends AbstractAST implements AST {

    private SubtypeIndication subtypeIndication;
    private QualifiedExpression qualifiedExpression;

    public Allocator(SubtypeIndication subtypeIndication) {
	super();
	this.subtypeIndication = subtypeIndication;
    }

    public Allocator(QualifiedExpression qualifiedExpression) {
	super();
	this.qualifiedExpression = qualifiedExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public SubtypeIndication getSubtypeIndication() {
	return subtypeIndication;
    }

    public QualifiedExpression getQualifiedExpression() {
	return qualifiedExpression;
    }

}
