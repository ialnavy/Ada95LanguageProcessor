package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Term extends AbstractAST implements AST {

    private Factor factor;
    private List<MultiplyingOperator> multiplyingOperators = new ArrayList<>();
    private List<Factor> multiplyingOperatorFactors = new ArrayList<>();

    public Term(Factor factor) {
	super();
	this.factor = factor;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Factor getFactor() {
	return factor;
    }

    public List<MultiplyingOperator> getMultiplyingOperators() {
	return new ArrayList<>(multiplyingOperators);
    }

    public void addMultiplyingOperator(MultiplyingOperator multiplyingOperator) {
	multiplyingOperators.add(multiplyingOperator);
    }

    public List<Factor> getMultiplyingOperatorFactors() {
	return new ArrayList<>(multiplyingOperatorFactors);
    }

    public void addMultiplyingOperatorFactor(Factor multiplyingOperatorFactor) {
	multiplyingOperatorFactors.add(multiplyingOperatorFactor);
    }

}
