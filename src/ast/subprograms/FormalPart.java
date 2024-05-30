package ast.subprograms;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class FormalPart extends AbstractAST implements AST {

    private List<ParameterSpecification> parameterSpecifications = new ArrayList<>();

    public FormalPart(List<ParameterSpecification> parameterSpecifications) {
	super();
	this.parameterSpecifications = parameterSpecifications;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<ParameterSpecification> getParameterSpecifications() {
	return new ArrayList<>(parameterSpecifications);
    }

}
