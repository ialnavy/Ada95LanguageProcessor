package ast.declarationsAndTypes;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DeclarativePart extends AbstractAST implements AST {

    private List<DeclarativeItem> declarativeItems = new ArrayList<>();

    public DeclarativePart(List<DeclarativeItem> declarativeItems) {
	super();
	this.declarativeItems = declarativeItems;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<DeclarativeItem> getDeclarativeItems() {
	return new ArrayList<>(declarativeItems);
    }

}
