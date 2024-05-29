package ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;

public abstract class AbstractAST implements AST {

    private Position start, end;
    private RuleContext context;

    public AbstractAST() {
	super();
    }

    public AbstractAST(RuleContext context) {
	this();
	this.context = context;
    }

    @Override
    public Position getStart() {
	return start;
    }

    @Override
    public Position getEnd() {
	return end;
    }

    @Override
    public RuleContext getContext() {
	return context;
    }

    @Override
    public void setPositions(Object... children) {
	List<Object> childrenList = Arrays.asList(children);
	this.start = findStart(childrenList);
	this.end = findEnd(childrenList);
	invariant();
    }

    protected AST getAST(ParserRuleContext node) {
	try {
	    return (AST) node.getClass().getField("ast").get(node);
	} catch (Exception e) {
	    throw new IllegalArgumentException("No 'ast' attribute present");
	}
    }

    protected AST getAST(Object node) {
	if (node == null)
	    return null;
	if (node instanceof ParserRuleContext)
	    return getAST((ParserRuleContext) node);
	if (node instanceof AST)
	    return (AST) node;
	throw new IllegalArgumentException("Object must be `AST` or `ParserRuleContext`");
    }

    @SuppressWarnings("unchecked")
    protected <T> List<T> getAstFromContexts(Object definiciones) {
	if (definiciones == null)
	    return null;

	if (!(definiciones instanceof List))
	    throw new IllegalArgumentException("Argument must be a `List`");

	List<T> result = new ArrayList<T>();
	for (Object element : (List<?>) definiciones)
	    result.add((T) getAST(element));
	return result;
    }

    protected List<String> getStringFromTokens(Object objectList) {
	if (objectList == null)
	    return null;

	if (!(objectList instanceof List))
	    throw new IllegalArgumentException("Argument must be a `List`");

	List<String> strings = new ArrayList<String>();
	for (Object o : (List<?>) objectList)
	    strings.add((o instanceof Token) ? ((Token) o).getText() : (String) o);
	return strings;
    }

    private Position findStart(Object node) {
	if (node instanceof AST)
	    return ((AST) node).getStart();
	if (node instanceof ParserRuleContext)
	    return findStart(getAST(node));
	if (node instanceof List)
	    return findStart((List<?>) node);
	if (node instanceof Token) {
	    Token token = (Token) node;
	    return new Position(token.getLine(), token.getCharPositionInLine() + 1);
	}
	return null;
    }

    private Position findStart(List<?> nodes) {
	Position start = this.start;
	for (Object node : nodes) {
	    Position nodeStart = findStart(node);
	    if (start == null)
		start = nodeStart;
	    else
		start = (nodeStart != null && nodeStart.lessThan(start)) ? nodeStart : start;
	}
	return start;
    }

    private Position findEnd(Object node) {
	if (node instanceof AST)
	    return ((AST) node).getEnd();
	if (node instanceof ParserRuleContext)
	    return findEnd(getAST(node));
	if (node instanceof List)
	    return findEnd((List<?>) node);
	if (node instanceof Token) {
	    Token token = (Token) node;
	    return new Position(token.getLine(), token.getCharPositionInLine() + token.getText().length());
	}
	return null;
    }

    private Position findEnd(List<?> nodes) {
	Position end = this.end;
	for (Object node : nodes) {
	    Position nodeEnd = findEnd(node);
	    if (end == null)
		end = nodeEnd;
	    else
		end = (nodeEnd != null && nodeEnd.greaterThan(end)) ? nodeEnd : end;
	}
	return end;
    }

    private void invariant() {
	if ((getStart() != null || getEnd() != null) && getStart().greaterThan(getEnd()))
	    throw new IllegalStateException(
		    "Incorrect position, they must be: (start = null and end = null) or (start <= end)");
    }
}
