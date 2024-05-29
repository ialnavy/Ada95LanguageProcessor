package ast.tasksAndSynchronization;

import ast.AbstractAST;
import ast.AST;
import visitor.Ada95Visitor;

/**
 * AST node auto-generated
 * 
 * @author ial.navy@protonmail.ch
 * @version 2024-05-29 16:35
 */
public class AsynchronousSelect extends AbstractAST implements AST {

	@Override
	public Object accept(Ada95Visitor<Object> visitor, Object param) {
		visitor.visit(this, param);
		return null;
	}

}
