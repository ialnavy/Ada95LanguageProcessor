package ast.programStructureAndCompilationIssues;

import java.util.ArrayList;
import java.util.List;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class Compilation extends AbstractAST implements AST {

    private List<CompilationUnit> compilationUnits = new ArrayList<>();

    public Compilation(List<CompilationUnit> compilationUnits) {
	super();
	this.compilationUnits = compilationUnits;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	return visitor.visit(this, param);
	
    }

    public List<CompilationUnit> getCompilationUnits() {
	return new ArrayList<>(compilationUnits);
    }

}
