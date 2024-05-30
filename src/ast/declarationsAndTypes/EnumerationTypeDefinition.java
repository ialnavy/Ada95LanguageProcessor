package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class EnumerationTypeDefinition extends AbstractAST implements AST {

    private List<EnumerationLiteralSpecification> enumerationLiteralSpecifications = new ArrayList<>();

    public EnumerationTypeDefinition(List<EnumerationLiteralSpecification> enumerationLiteralSpecifications) {
	super();
	this.enumerationLiteralSpecifications = enumerationLiteralSpecifications;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<EnumerationLiteralSpecification> getEnumerationLiteralSpecifications() {
	return enumerationLiteralSpecifications;
    }

}
