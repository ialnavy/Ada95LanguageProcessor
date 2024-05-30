package ast.tasksAndSynchronization;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class RequeueStatement extends AbstractAST implements AST {

    private Name entryName;

    private Token withToken;
    private Token abortToken;

    public RequeueStatement(Name entryName, Token withToken, Token abortToken) {
	super();
	this.entryName = entryName;
	this.withToken = withToken;
	this.abortToken = abortToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public Name getEntryName() {
	return entryName;
    }

    public Token getWithToken() {
	return withToken;
    }

    public Token getAbortToken() {
	return abortToken;
    }

}
