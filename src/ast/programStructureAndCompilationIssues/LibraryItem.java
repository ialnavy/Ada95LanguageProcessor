package ast.programStructureAndCompilationIssues;

import org.antlr.v4.runtime.Token;

import ast.AST;
import ast.AbstractAST;
import visitor.Ada95Visitor;

public class LibraryItem extends AbstractAST implements AST {

    private LibraryUnitDeclaration libraryUnitDeclaration;
    private LibraryUnitRenamingDeclaration libraryUnitRenamingDeclaration;
    private LibraryUnitBody libraryUnitBody;

    private Token privateToken;

    public LibraryItem(LibraryUnitDeclaration libraryUnitDeclaration, Token privateToken) {
	super();
	this.libraryUnitDeclaration = libraryUnitDeclaration;
    }

    public LibraryItem(LibraryUnitRenamingDeclaration libraryUnitRenamingDeclaration, Token privateToken) {
	super();
	this.libraryUnitRenamingDeclaration = libraryUnitRenamingDeclaration;
    }

    public LibraryItem(LibraryUnitBody libraryUnitBody) {
	super();
	this.libraryUnitBody = libraryUnitBody;
    }

    @Override
    public Object accept(Ada95Visitor<Object> visitor, Object param) {
	visitor.visit(this, param);
	return null;
    }

    public LibraryUnitDeclaration getLibraryUnitDeclaration() {
	return libraryUnitDeclaration;
    }

    public LibraryUnitRenamingDeclaration getLibraryUnitRenamingDeclaration() {
	return libraryUnitRenamingDeclaration;
    }

    public LibraryUnitBody getLibraryUnitBody() {
	return libraryUnitBody;
    }

    public Token getPrivateToken() {
	return privateToken;
    }

}
