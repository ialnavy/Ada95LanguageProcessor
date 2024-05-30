package ast.statements;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Expression;
import visitor.Ada95Visitor;

public class CaseStatement extends AbstractAST implements AST {

    private Expression expression;
    private List<CaseStatementAlternative> caseStatementAlternatives = new ArrayList<>();

    public CaseStatement(Expression expression, List<CaseStatementAlternative> caseStatementAlternatives) {
	super();
	this.expression = expression;
	this.caseStatementAlternatives = caseStatementAlternatives;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Expression getExpression() {
	return expression;
    }

    public List<CaseStatementAlternative> getCaseStatementAlternatives() {
	return caseStatementAlternatives;
    }

}
