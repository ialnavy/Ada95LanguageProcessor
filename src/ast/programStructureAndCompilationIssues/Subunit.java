package ast.programStructureAndCompilationIssues;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.ProperBody;
import visitor.Ada95Visitor;

public class Subunit extends AbstractAST implements AST {

    private ParentUnitName parentUnitName;
    private ProperBody properBody;

    public Subunit(ParentUnitName parentUnitName, ProperBody properBody) {
	super();
	this.parentUnitName = parentUnitName;
	this.properBody = properBody;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public ParentUnitName getParentUnitName() {
	return parentUnitName;
    }

    public ProperBody getProperBody() {
	return properBody;
    }

}
