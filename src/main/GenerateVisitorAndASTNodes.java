package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Scaffolding for Ada95 Visitor
 * 
 * @author ialvarezl@indra.es
 */
public class GenerateVisitorAndASTNodes {

    public static void main(String[] args) throws Exception {
	File sourceDir = new File("astScaffolding/source/");
	if (!sourceDir.exists())
	    sourceDir.mkdir();
	File[] sources = sourceDir.listFiles();
	if (sources == null || sources.length == 0) {
	    System.out.println("The source directory is empty: " + sourceDir.getAbsolutePath());
	    return;
	}

	Map<String, List<String>> subpackagesWithClasses = new HashMap<String, List<String>>();
	for (File source : sources) {
	    String subpackageName = getSubpackageNameFromFileName(source.getName());
	    List<String> classNames = generateSubpackage(source, subpackageName);
	    subpackagesWithClasses.put(subpackageName, classNames);
	}

	try {
	    generateVisitor(subpackagesWithClasses);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private static void generateVisitor(Map<String, List<String>> subpackagesWithClasses) throws IOException {
	File visitorFile = new File("astScaffolding/Ada95Visitor.java");
	if (!visitorFile.exists())
	    visitorFile.createNewFile();
	Writer out = new FileWriter(visitorFile);

	out.append("package visitor;\n\n");

	for (Entry<String, List<String>> entry : subpackagesWithClasses.entrySet())
	    out.append("import ast." + entry.getKey().substring(0, 1).toLowerCase() + entry.getKey().substring(1)
		    + ".*;\n");

	out.append('\n');
	out.append("/**\n" + //
		" * Ada95Visitor auto-generated\n" + //
		" * \n" + //
		" * @author ial.navy@protonmail.ch\n" + //
		" * @version " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n" + //
		" */\n");
	out.append("public interface Ada95Visitor<T> {\n");
	out.flush();

	for (Entry<String, List<String>> entry : subpackagesWithClasses.entrySet()) {
	    out.append("\n\t// " + entry.getKey() + '\n');
	    for (String className : entry.getValue())
		out.append("\tpublic T visit(" + className + " astNode, T parameter);\n");
	    out.flush();
	}

	out.append("}\n");

	out.flush();
	out.close();
    }

    private static void generateASTNodeClass(String className, File classFile, String subpackageName)
	    throws IOException {
	System.out.println("- " + classFile.getPath());
	if (!classFile.exists())
	    classFile.createNewFile();
	Writer out = new FileWriter(classFile);

	out.append("package ast." + subpackageName + ";\n\n");
	out.append("import ast.AbstractAST;\n");
	out.append("import ast.AST;\n");
	out.append("import visitor.Ada95Visitor;\n\n");
	out.flush();

	out.append("/**\n" + //
		" * AST node auto-generated\n" + //
		" * \n" + //
		" * @author ial.navy@protonmail.ch\n" + //
		" * @version " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n" + //
		" */\n");
	out.append("public class " + className + " extends AbstractAST implements AST {\n\n");
	out.append("\t@Override\n");
	out.append("\tpublic Object accept(Ada95Visitor<Object> visitor, Object param) {\n");
	out.append("\t\tvisitor.visit(this, param);\n");
	out.append("\t\treturn null;\n");
	out.append("\t}\n\n");
	out.append("}\n");
	out.flush();

	out.close();
    }

    private static List<String> generateSubpackage(File source, String subpackageName) {
	File subpackageDir = new File("astScaffolding/generated/" + subpackageName);
	if (!subpackageDir.exists())
	    subpackageDir.mkdir();
	System.out.println("\nGenerating: " + subpackageDir.getPath());

	List<String> classNames = new LinkedList<String>();
	try (BufferedReader br = new BufferedReader(new FileReader(source))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		String className = normalizeName(line.trim());
		File classFile = new File(subpackageDir.getPath() + "\\" + className + ".java");
		try {
		    generateASTNodeClass(className, classFile, subpackageName);
		    classNames.add(className);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return classNames;
    }

    private static String getSubpackageNameFromFileName(String name) {
	String subpackageName = name;

	// Remove file extension
	String[] partsOfOriginalFileNameWithExtension = subpackageName.split("\\.");
	subpackageName = partsOfOriginalFileNameWithExtension[0];

	// Remove components delimited by "-"
	String[] partsOfOriginalFileName = subpackageName.split("-");
	subpackageName = partsOfOriginalFileName[partsOfOriginalFileName.length - 1];

	// Transform name to camel case
	subpackageName = normalizeName(subpackageName);

	// Decapitalize name
	subpackageName = subpackageName.substring(0, 1).toLowerCase() + subpackageName.substring(1);

	return subpackageName;
    }

    private static String normalizeName(String name) {
	String normalizedName = "";
	String[] partsOfNormalizedName = name.split("_");
	for (String partOfNormalizedName : partsOfNormalizedName) {
	    normalizedName += partOfNormalizedName.substring(0, 1).toUpperCase()
		    + partOfNormalizedName.substring(1).toLowerCase();
	}
	return normalizedName;
    }

}
