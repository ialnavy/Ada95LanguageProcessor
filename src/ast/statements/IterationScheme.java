package ast.statements;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class IterationScheme extends AbstractAST implements AST {

    private Condition whileCondition;
    private LoopParameterSpecification loopParameterSpecification;

    public IterationScheme(Condition whileCondition) {
	super();
	this.whileCondition = whileCondition;
    }

    public IterationScheme(LoopParameterSpecification loopParameterSpecification) {
	super();
	this.loopParameterSpecification = loopParameterSpecification;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Condition getWhileCondition() {
	return whileCondition;
    }

    public LoopParameterSpecification getLoopParameterSpecification() {
	return loopParameterSpecification;
    }

}
