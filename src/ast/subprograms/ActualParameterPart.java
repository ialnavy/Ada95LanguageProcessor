package ast.subprograms;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class ActualParameterPart extends AbstractAST implements AST {

    private List<ParameterAssociation> parameterAssociations = new ArrayList<>();

    public ActualParameterPart(List<ParameterAssociation> parameterAssociations) {
	super();
	this.parameterAssociations = parameterAssociations;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<ParameterAssociation> getParameterAssociations() {
	return new ArrayList<>(parameterAssociations);
    }

}
