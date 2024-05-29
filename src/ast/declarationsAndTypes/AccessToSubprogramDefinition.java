package ast.declarationsAndTypes;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import ast.subprograms.ParameterAndResultProfile;
import ast.subprograms.ParameterProfile;
import visitor.Ada95Visitor;

public class AccessToSubprogramDefinition extends AbstractAST implements AST {

    private ParameterProfile parameterProfile;
    private ParameterAndResultProfile parameterAndResultProfile;

    private Token protectedToken;

    public AccessToSubprogramDefinition(ParameterProfile parameterProfile, Token protectedToken) {
	super();
	this.parameterProfile = parameterProfile;
	this.protectedToken = protectedToken;
    }

    public AccessToSubprogramDefinition(ParameterAndResultProfile parameterAndResultProfile, Token protectedToken) {
	super();
	this.parameterAndResultProfile = parameterAndResultProfile;
	this.protectedToken = protectedToken;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ParameterProfile getParameterProfile() {
	return parameterProfile;
    }

    public ParameterAndResultProfile getParameterAndResultProfile() {
	return parameterAndResultProfile;
    }

    public Token getProtectedToken() {
	return protectedToken;
    }

}
