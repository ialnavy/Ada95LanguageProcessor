package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.programStructureAndCompilationIssues.BodyStub;
import visitor.Ada95Visitor;

public class Body extends AbstractAST implements AST {

    private ProperBody properBody;
    private BodyStub bodyStub;

    public Body(ProperBody properBody) {
	super();
	this.properBody = properBody;
    }

    public Body(BodyStub bodyStub) {
	super();
	this.bodyStub = bodyStub;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public ProperBody getProperBody() {
	return properBody;
    }

    public BodyStub getBodyStub() {
	return bodyStub;
    }

}
