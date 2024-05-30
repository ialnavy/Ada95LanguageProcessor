package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SimpleExpression extends AbstractAST implements AST {

    private UnaryAddingOperator unaryAddingOperator;
    private Term unaryAddingOperatorTerm;
    private List<BinaryAddingOperator> binaryAddingOperators = new ArrayList<>();
    private List<Term> binaryAddingOperatorTerms = new ArrayList<>();

    public SimpleExpression(UnaryAddingOperator unaryAddingOperator, Term unaryAddingOperatorTerm) {
	super();
	this.unaryAddingOperator = unaryAddingOperator;
	this.unaryAddingOperatorTerm = unaryAddingOperatorTerm;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public UnaryAddingOperator getUnaryAddingOperator() {
	return unaryAddingOperator;
    }

    public Term getUnaryAddingOperatorTerm() {
	return unaryAddingOperatorTerm;
    }

    public List<BinaryAddingOperator> getBinaryAddingOperators() {
	return new ArrayList<>(binaryAddingOperators);
    }

    public void addBinaryAddingOperator(BinaryAddingOperator binaryAddingOperator) {
	binaryAddingOperators.add(binaryAddingOperator);
    }

    public List<Term> getBinaryAddingOperatorTerms() {
	return new ArrayList<>(binaryAddingOperatorTerms);
    }

    public void addBinaryAddingOperatorTerm(Term binaryAddingOperatorTerm) {
	binaryAddingOperatorTerms.add(binaryAddingOperatorTerm);
    }

}
