package ast.visibilityRules;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.namesAndExpressions.Name;
import visitor.Ada95Visitor;

public class ObjectRenamingDeclaration extends AbstractAST implements AST {

    private DefiningIdentifier definingIdentifier;
    private Name subtypeMark;
    private Name objectName;

    public ObjectRenamingDeclaration(DefiningIdentifier definingIdentifier, Name subtypeMark, Name objectName) {
	super();
	this.definingIdentifier = definingIdentifier;
	this.subtypeMark = subtypeMark;
	this.objectName = objectName;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningIdentifier getDefiningIdentifier() {
	return definingIdentifier;
    }

    public Name getSubtypeMark() {
	return subtypeMark;
    }

    public Name getObjectName() {
	return objectName;
    }

}
