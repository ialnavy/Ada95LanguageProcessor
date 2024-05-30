package ast.subprograms;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.Identifier;
import ast.programStructureAndCompilationIssues.ParentUnitName;
import visitor.Ada95Visitor;

public class Designator extends AbstractAST implements AST {

    private ParentUnitName parentUnitName;
    private Identifier identifier;
    private OperatorSymbol operatorSymbol;

    public Designator(ParentUnitName parentUnitName, Identifier identifier) {
	super();
	this.parentUnitName = parentUnitName;
	this.identifier = identifier;
    }

    public Designator(OperatorSymbol operatorSymbol) {
	super();
	this.operatorSymbol = operatorSymbol;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ParentUnitName getParentUnitName() {
	return parentUnitName;
    }

    public Identifier getIdentifier() {
	return identifier;
    }

    public OperatorSymbol getOperatorSymbol() {
	return operatorSymbol;
    }

}
