package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class DeclarativeItem extends AbstractAST implements AST {

    private BasicDeclarativeItem basicDeclarativeItem;
    private Body body;

    public DeclarativeItem(BasicDeclarativeItem basicDeclarativeItem) {
	super();
	this.basicDeclarativeItem = basicDeclarativeItem;
    }

    public DeclarativeItem(Body body) {
	super();
	this.body = body;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public BasicDeclarativeItem getBasicDeclarativeItem() {
	return basicDeclarativeItem;
    }

    public Body getBody() {
	return body;
    }

}
