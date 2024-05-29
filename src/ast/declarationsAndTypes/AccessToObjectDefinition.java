package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class AccessToObjectDefinition extends AbstractAST implements AST {

    private GeneralAccessModifier generalAccessModifier;
    private SubtypeIndication subtypeIndication;

    public AccessToObjectDefinition(GeneralAccessModifier generalAccessModifier, SubtypeIndication subtypeIndication) {
	super();
	this.generalAccessModifier = generalAccessModifier;
	this.subtypeIndication = subtypeIndication;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public GeneralAccessModifier getGeneralAccessModifier() {
	return generalAccessModifier;
    }

    public SubtypeIndication getSubtypeIndication() {
	return subtypeIndication;
    }

}
