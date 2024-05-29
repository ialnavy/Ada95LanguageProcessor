package ast.declarationsAndTypes;

import ast.AST;
import ast.AbstractAST;
import ast.lexicalElements.CharacterLiteral;
import visitor.Ada95Visitor;

public class DefiningCharacterLiteral extends AbstractAST implements AST {

    private CharacterLiteral characterLiteral;

    public DefiningCharacterLiteral(CharacterLiteral characterLiteral) {
	super();
	this.characterLiteral = characterLiteral;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public CharacterLiteral getCharacterLiteral() {
	return characterLiteral;
    }

}
