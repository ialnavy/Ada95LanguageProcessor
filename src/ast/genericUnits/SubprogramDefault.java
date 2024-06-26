package ast.genericUnits;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class SubprogramDefault extends AbstractAST implements AST {

    private DefaultName defaultName;

    public SubprogramDefault(DefaultName defaultName) {
	super();
	this.defaultName = defaultName;
    }

    public SubprogramDefault() {
	super();
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefaultName getDefaultName() {
	return defaultName;
    }

}
