package ast;

import org.antlr.v4.runtime.RuleContext;

import visitor.Ada95Visitor;

public interface AST {

    public Object accept(Ada95Visitor<Object> visitor, Object param);

    Position getStart();

    Position getEnd();

    RuleContext getContext();

    public void setPositions(Object... children);

}
