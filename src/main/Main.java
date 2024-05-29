package main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ast.AST;
import parser.Ada95Lexer;
import parser.Ada95Parser;
import parser.Ada95Parser.CompilationContext;
import visitor.Ada95Visitor;
import visitor.DefaultVisitor;

/**
 * Style code analyser
 * 
 * @author ialvarezl@indra.es
 */
public class Main {

    /*
     * This option determines whether the Concrete Syntax Tree must be shown or not.
     */
    static final boolean SHOW_CST = false;

    /*
     * Directory of input files.
     */
    static final String DIRECTORY_OF_INPUT_FILES = "./programs/";

    public static void main(String[] args) throws Exception {
	File directory = new File(DIRECTORY_OF_INPUT_FILES);
	if (!directory.exists())
	    directory.mkdir();

	for (String fileName : directory.list()) {
	    File file = new File(directory.getAbsolutePath() + "\\" + fileName);
	    if (!file.isFile())
		continue;

	    System.out.println("BEGIN OF PROCESSING OF FILE: " + fileName);

	    // Lexical and syntactic analysis
	    AST astRoot = lexicalAndSyntacticAnalysis(file.getAbsolutePath());
	    if (astRoot == null) {
		System.err.println("Error in lexical and syntactic analysis of file: " + fileName);
		continue;
	    }

	    // Default visitor, which makes just an iteration through the AST tree
	    Ada95Visitor<Object> starter = new DefaultVisitor();
	    astRoot.accept(starter, null);

	    System.out.println("END OF PROCESSING OF FILE: " + fileName + "\n");
	}
    }

    private static AST lexicalAndSyntacticAnalysis(String inputFileAbsolutePath) throws IOException {
	Ada95Lexer lexer = new Ada95Lexer(CharStreams.fromFileName(inputFileAbsolutePath));
	Ada95Parser parser = new Ada95Parser(new CommonTokenStream(lexer));

	CompilationContext ctx = parser.compilation();
	if (SHOW_CST) {
	    TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), ctx);
	    viewer.open();
	}

	if (parser.getNumberOfSyntaxErrors() > 0)
	    return null;

	// Return AST root node
	return ctx.ast;
    }
}
