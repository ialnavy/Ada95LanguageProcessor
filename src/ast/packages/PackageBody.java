package ast.packages;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.DeclarativePart;
import ast.exceptions.HandledSequenceOfStatements;
import ast.lexicalElements.Identifier;
import ast.programStructureAndCompilationIssues.ParentUnitName;
import ast.subprograms.DefiningProgramUnitName;
import visitor.Ada95Visitor;

public class PackageBody extends AbstractAST implements AST {

    private DefiningProgramUnitName definingProgramUnitName;
    private DeclarativePart declarativePart;
    private HandledSequenceOfStatements handledSequenceOfStatements;
    private ParentUnitName parentUnitName;
    private Identifier identifier;

    public PackageBody(DefiningProgramUnitName definingProgramUnitName, DeclarativePart declarativePart,
	    HandledSequenceOfStatements handledSequenceOfStatements, ParentUnitName parentUnitName,
	    Identifier identifier) {
	super();
	this.definingProgramUnitName = definingProgramUnitName;
	this.declarativePart = declarativePart;
	this.handledSequenceOfStatements = handledSequenceOfStatements;
	this.parentUnitName = parentUnitName;
	this.identifier = identifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public DeclarativePart getDeclarativePart() {
	return declarativePart;
    }

    public HandledSequenceOfStatements getHandledSequenceOfStatements() {
	return handledSequenceOfStatements;
    }

    public ParentUnitName getParentUnitName() {
	return parentUnitName;
    }

    public Identifier getIdentifier() {
	return identifier;
    }

}
