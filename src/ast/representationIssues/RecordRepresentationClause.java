package ast.representationIssues;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import ast.others.ModClause;
import visitor.Ada95Visitor;

public class RecordRepresentationClause extends AbstractAST implements AST {

    private Name firstSubtypeLocalName;
    private ModClause modClause;
    private List<ComponentClause> componentClauses = new ArrayList<>();

    public RecordRepresentationClause(Name firstSubtypeLocalName, ModClause modClause,
	    List<ComponentClause> componentClauses) {
	super();
	this.firstSubtypeLocalName = firstSubtypeLocalName;
	this.modClause = modClause;
	this.componentClauses = componentClauses;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public Name getFirstSubtypeLocalName() {
	return firstSubtypeLocalName;
    }

    public ModClause getModClause() {
	return modClause;
    }

    public List<ComponentClause> getComponentClauses() {
	return new ArrayList<>(componentClauses);
    }

}
