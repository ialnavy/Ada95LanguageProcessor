package ast.namesAndExpressions;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Expression extends AbstractAST implements AST {

    private List<Relation> relations = new ArrayList<>();
    private Token token1;
    private Token token2;

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<Relation> getRelations() {
	return new ArrayList<>(relations);
    }

    public void addRelation(Relation relation) {
	relations.add(relation);
    }

    public Token getToken1() {
	return token1;
    }

    public Token getToken2() {
	return token2;
    }

    public void setToken1(Token token1) {
	this.token1 = token1;
    }

    public void setToken2(Token token2) {
	this.token2 = token2;
    }

}
