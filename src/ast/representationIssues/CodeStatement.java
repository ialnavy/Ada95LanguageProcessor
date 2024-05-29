package ast.representationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.QualifiedExpression;
import visitor.Ada95Visitor;

public class CodeStatement extends AbstractAST implements AST {

    private QualifiedExpression qualifiedExpression;

    public CodeStatement(QualifiedExpression qualifiedExpression) {
	super();
	this.qualifiedExpression = qualifiedExpression;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public QualifiedExpression getQualifiedExpression() {
	return qualifiedExpression;
    }

}
