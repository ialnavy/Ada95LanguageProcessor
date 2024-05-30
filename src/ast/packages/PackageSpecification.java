package ast.packages;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import ast.declarationsAndTypes.BasicDeclarativeItem;
import ast.lexicalElements.Identifier;
import ast.programStructureAndCompilationIssues.ParentUnitName;
import ast.subprograms.DefiningProgramUnitName;
import visitor.Ada95Visitor;

public class PackageSpecification extends AbstractAST implements AST {

    private DefiningProgramUnitName definingProgramUnitName;
    private List<BasicDeclarativeItem> mainBasicDeclarativeItems = new ArrayList<>();
    private List<BasicDeclarativeItem> privateBasicDeclarativeItems = new ArrayList<>();
    private ParentUnitName parentUnitName;
    private Identifier identifier;

    public PackageSpecification(DefiningProgramUnitName definingProgramUnitName,
	    List<BasicDeclarativeItem> mainBasicDeclarativeItems,
	    List<BasicDeclarativeItem> privateBasicDeclarativeItems, ParentUnitName parentUnitName,
	    Identifier identifier) {
	super();
	this.definingProgramUnitName = definingProgramUnitName;
	this.mainBasicDeclarativeItems = mainBasicDeclarativeItems;
	this.privateBasicDeclarativeItems = privateBasicDeclarativeItems;
	this.parentUnitName = parentUnitName;
	this.identifier = identifier;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public DefiningProgramUnitName getDefiningProgramUnitName() {
	return definingProgramUnitName;
    }

    public List<BasicDeclarativeItem> getMainBasicDeclarativeItems() {
	return mainBasicDeclarativeItems;
    }

    public List<BasicDeclarativeItem> getPrivateBasicDeclarativeItems() {
	return privateBasicDeclarativeItems;
    }

    public ParentUnitName getParentUnitName() {
	return parentUnitName;
    }

    public Identifier getIdentifier() {
	return identifier;
    }

}
