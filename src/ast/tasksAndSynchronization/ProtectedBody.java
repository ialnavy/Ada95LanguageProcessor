package ast.tasksAndSynchronization;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.lexicalElements.Identifier;
import visitor.Ada95Visitor;

public class ProtectedBody extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private List<ProtectedOperationItem> protectedOperationItems = new ArrayList<>();
    private Identifier protectedIdentifier;

    public ProtectedBody(DefiningIdentifier definingIdentifier, List<ProtectedOperationItem> protectedOperationItems,
	    Identifier protectedIdentifier) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.protectedOperationItems = protectedOperationItems;
	this.protectedIdentifier = protectedIdentifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public List<ProtectedOperationItem> getProtectedOperationItems() {
	return new ArrayList<>(protectedOperationItems);
    }

    public Identifier getProtectedIdentifier() {
	return protectedIdentifier;
    }

}
