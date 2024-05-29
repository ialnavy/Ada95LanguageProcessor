package ast.visibilityRules;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class UsePackageClause extends AbstractAST implements AST {

    private List<Name> packageNames = new ArrayList<>();

    public UsePackageClause(List<Name> packageNames) {
	super();
	this.packageNames = packageNames;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public List<Name> getPackageNames() {
	return new ArrayList<>(packageNames);
    }

}
