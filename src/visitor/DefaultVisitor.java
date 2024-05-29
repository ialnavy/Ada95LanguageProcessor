package visitor;

import ast.declarationsAndTypes.AccessDefinition;
import ast.declarationsAndTypes.AccessToObjectDefinition;
import ast.declarationsAndTypes.AccessToSubprogramDefinition;
import ast.declarationsAndTypes.AccessTypeDefinition;
import ast.declarationsAndTypes.ArrayTypeDefinition;
import ast.declarationsAndTypes.BasicDeclaration;
import ast.declarationsAndTypes.BasicDeclarativeItem;
import ast.declarationsAndTypes.Body;
import ast.declarationsAndTypes.ComponentDeclaration;
import ast.declarationsAndTypes.ComponentDefinition;
import ast.declarationsAndTypes.ComponentItem;
import ast.declarationsAndTypes.ComponentList;
import ast.declarationsAndTypes.CompositeConstraint;
import ast.declarationsAndTypes.ConstrainedArrayDefinition;
import ast.declarationsAndTypes.Constraint;
import ast.declarationsAndTypes.DecimalFixedPointDefinition;
import ast.declarationsAndTypes.DeclarativeItem;
import ast.declarationsAndTypes.DeclarativePart;
import ast.declarationsAndTypes.DefaultExpression;
import ast.declarationsAndTypes.DefiningCharacterLiteral;
import ast.declarationsAndTypes.DefiningIdentifier;
import ast.declarationsAndTypes.DefiningIdentifierList;
import ast.declarationsAndTypes.DerivedTypeDefinition;
import ast.declarationsAndTypes.DigitsConstraint;
import ast.declarationsAndTypes.DiscreteChoice;
import ast.declarationsAndTypes.DiscreteChoiceList;
import ast.declarationsAndTypes.DiscreteRange;
import ast.declarationsAndTypes.DiscreteSubtypeDefinition;
import ast.declarationsAndTypes.DiscriminantAssociation;
import ast.declarationsAndTypes.DiscriminantConstraint;
import ast.declarationsAndTypes.DiscriminantPart;
import ast.declarationsAndTypes.DiscriminantSpecification;
import ast.declarationsAndTypes.EnumerationLiteralSpecification;
import ast.declarationsAndTypes.EnumerationTypeDefinition;
import ast.declarationsAndTypes.FixedPointDefinition;
import ast.declarationsAndTypes.FloatingPointDefinition;
import ast.declarationsAndTypes.FullTypeDeclaration;
import ast.declarationsAndTypes.GeneralAccessModifier;
import ast.declarationsAndTypes.IncompleteTypeDeclaration;
import ast.declarationsAndTypes.IndexConstraint;
import ast.declarationsAndTypes.IndexSubtypeDefinition;
import ast.declarationsAndTypes.IntegerTypeDefinition;
import ast.declarationsAndTypes.KnownDiscriminantPart;
import ast.declarationsAndTypes.ModularTypeDefinition;
import ast.declarationsAndTypes.NumberDeclaration;
import ast.declarationsAndTypes.ObjectDeclaration;
import ast.declarationsAndTypes.OrdinaryFixedPointDefinition;
import ast.declarationsAndTypes.ProperBody;
import ast.declarationsAndTypes.Range;
import ast.declarationsAndTypes.RangeConstraint;
import ast.declarationsAndTypes.RealRangeSpecification;
import ast.declarationsAndTypes.RealTypeDefinition;
import ast.declarationsAndTypes.RecordDefinition;
import ast.declarationsAndTypes.RecordExtensionPart;
import ast.declarationsAndTypes.RecordTypeDefinition;
import ast.declarationsAndTypes.ScalarConstraint;
import ast.declarationsAndTypes.SignedIntegerTypeDefinition;
import ast.declarationsAndTypes.SubtypeDeclaration;
import ast.declarationsAndTypes.SubtypeIndication;
import ast.declarationsAndTypes.TypeDeclaration;
import ast.declarationsAndTypes.TypeDefinition;
import ast.declarationsAndTypes.UnconstrainedArrayDefinition;
import ast.declarationsAndTypes.UnknownDiscriminantPart;
import ast.declarationsAndTypes.Variant;
import ast.declarationsAndTypes.VariantPart;
import ast.exceptions.ChoiceParameterSpecification;
import ast.exceptions.ExceptionChoice;
import ast.exceptions.ExceptionDeclaration;
import ast.exceptions.ExceptionHandler;
import ast.exceptions.HandledSequenceOfStatements;
import ast.exceptions.RaiseStatement;
import ast.genericUnits.DefaultName;
import ast.genericUnits.ExplicitGenericActualParameter;
import ast.genericUnits.FormalAccessTypeDefinition;
import ast.genericUnits.FormalArrayTypeDefinition;
import ast.genericUnits.FormalDecimalFixedPointDefinition;
import ast.genericUnits.FormalDerivedTypeDefinition;
import ast.genericUnits.FormalDiscreteTypeDefinition;
import ast.genericUnits.FormalFloatingPointDefinition;
import ast.genericUnits.FormalModularTypeDefinition;
import ast.genericUnits.FormalObjectDeclaration;
import ast.genericUnits.FormalOrdinaryFixedPointDefinition;
import ast.genericUnits.FormalPackageActualPart;
import ast.genericUnits.FormalPackageDeclaration;
import ast.genericUnits.FormalPrivateTypeDefinition;
import ast.genericUnits.FormalSignedIntegerTypeDefinition;
import ast.genericUnits.FormalSubprogramDeclaration;
import ast.genericUnits.FormalTypeDeclaration;
import ast.genericUnits.FormalTypeDefinition;
import ast.genericUnits.GenericActualPart;
import ast.genericUnits.GenericAssociation;
import ast.genericUnits.GenericDeclaration;
import ast.genericUnits.GenericFormalParameterDeclaration;
import ast.genericUnits.GenericFormalPart;
import ast.genericUnits.GenericInstantiation;
import ast.genericUnits.GenericPackageDeclaration;
import ast.genericUnits.GenericSubprogramDeclaration;
import ast.genericUnits.SubprogramDefault;
import ast.lexicalElements.CharacterLiteral;
import ast.lexicalElements.Identifier;
import ast.lexicalElements.NumericLiteral;
import ast.lexicalElements.StringLiteral;
import ast.namesAndExpressions.Aggregate;
import ast.namesAndExpressions.Allocator;
import ast.namesAndExpressions.AncestorPart;
import ast.namesAndExpressions.ArrayAggregate;
import ast.namesAndExpressions.ArrayComponentAssociation;
import ast.namesAndExpressions.AttributeDesignator;
import ast.namesAndExpressions.BinaryAddingOperator;
import ast.namesAndExpressions.ComponentChoiceList;
import ast.namesAndExpressions.DirectName;
import ast.namesAndExpressions.Expression;
import ast.namesAndExpressions.ExtensionAggregate;
import ast.namesAndExpressions.Factor;
import ast.namesAndExpressions.HighestPrecedenceOperator;
import ast.namesAndExpressions.LogicalOperator;
import ast.namesAndExpressions.MultiplyingOperator;
import ast.namesAndExpressions.Name;
import ast.namesAndExpressions.NamedArrayAggregate;
import ast.namesAndExpressions.PositionalArrayAggregate;
import ast.namesAndExpressions.Primary;
import ast.namesAndExpressions.QualifiedExpression;
import ast.namesAndExpressions.RangeAttributeDesignator;
import ast.namesAndExpressions.RangeAttributeReference;
import ast.namesAndExpressions.RecordAggregate;
import ast.namesAndExpressions.RecordComponentAssociation;
import ast.namesAndExpressions.RecordComponentAssociationList;
import ast.namesAndExpressions.Relation;
import ast.namesAndExpressions.RelationalOperator;
import ast.namesAndExpressions.SelectorName;
import ast.namesAndExpressions.SimpleExpression;
import ast.namesAndExpressions.Term;
import ast.namesAndExpressions.UnaryAddingOperator;
import ast.others.AtClause;
import ast.others.BooleanExpression;
import ast.others.DeltaConstraint;
import ast.others.ModClause;
import ast.packages.PackageBody;
import ast.packages.PackageDeclaration;
import ast.packages.PackageSpecification;
import ast.packages.PrivateExtensionDeclaration;
import ast.packages.PrivateTypeDeclaration;
import ast.programStructureAndCompilationIssues.BodyStub;
import ast.programStructureAndCompilationIssues.Compilation;
import ast.programStructureAndCompilationIssues.CompilationUnit;
import ast.programStructureAndCompilationIssues.ContextClause;
import ast.programStructureAndCompilationIssues.ContextItem;
import ast.programStructureAndCompilationIssues.LibraryItem;
import ast.programStructureAndCompilationIssues.LibraryUnitBody;
import ast.programStructureAndCompilationIssues.LibraryUnitDeclaration;
import ast.programStructureAndCompilationIssues.LibraryUnitRenamingDeclaration;
import ast.programStructureAndCompilationIssues.PackageBodyStub;
import ast.programStructureAndCompilationIssues.ParentUnitName;
import ast.programStructureAndCompilationIssues.ProtectedBodyStub;
import ast.programStructureAndCompilationIssues.SubprogramBodyStub;
import ast.programStructureAndCompilationIssues.Subunit;
import ast.programStructureAndCompilationIssues.TaskBodyStub;
import ast.programStructureAndCompilationIssues.WithClause;
import ast.representationIssues.AspectClause;
import ast.representationIssues.AttributeDefinitionClause;
import ast.representationIssues.CodeStatement;
import ast.representationIssues.ComponentClause;
import ast.representationIssues.EnumerationAggregate;
import ast.representationIssues.EnumerationRepresentationClause;
import ast.representationIssues.FirstBit;
import ast.representationIssues.LastBit;
import ast.representationIssues.LocalName;
import ast.representationIssues.Position;
import ast.representationIssues.RecordRepresentationClause;
import ast.representationIssues.Restriction;
import ast.statements.AssignmentStatement;
import ast.statements.BlockStatement;
import ast.statements.CaseStatement;
import ast.statements.CaseStatementAlternative;
import ast.statements.CompoundStatement;
import ast.statements.Condition;
import ast.statements.ExitStatement;
import ast.statements.GotoStatement;
import ast.statements.IfStatement;
import ast.statements.IfStatementElsifClause;
import ast.statements.IterationScheme;
import ast.statements.Label;
import ast.statements.LoopParameterSpecification;
import ast.statements.LoopStatement;
import ast.statements.NullStatement;
import ast.statements.SequenceOfStatements;
import ast.statements.SimpleStatement;
import ast.statements.Statement;
import ast.statements.StatementIdentifier;
import ast.subprograms.AbstractSubprogramDeclaration;
import ast.subprograms.ActualParameterPart;
import ast.subprograms.DefiningDesignator;
import ast.subprograms.DefiningOperatorSymbol;
import ast.subprograms.DefiningProgramUnitName;
import ast.subprograms.Designator;
import ast.subprograms.ExplicitActualParameter;
import ast.subprograms.FormalPart;
import ast.subprograms.Mode;
import ast.subprograms.OperatorSymbol;
import ast.subprograms.ParameterAndResultProfile;
import ast.subprograms.ParameterAssociation;
import ast.subprograms.ParameterProfile;
import ast.subprograms.ParameterSpecification;
import ast.subprograms.ProcedureCallStatement;
import ast.subprograms.ReturnStatement;
import ast.subprograms.SubprogramBody;
import ast.subprograms.SubprogramDeclaration;
import ast.subprograms.SubprogramSpecification;
import ast.tasksAndSynchronization.AbortStatement;
import ast.tasksAndSynchronization.AbortablePart;
import ast.tasksAndSynchronization.AcceptAlternative;
import ast.tasksAndSynchronization.AcceptStatement;
import ast.tasksAndSynchronization.AsynchronousSelect;
import ast.tasksAndSynchronization.ConditionalEntryCall;
import ast.tasksAndSynchronization.DelayAlternative;
import ast.tasksAndSynchronization.DelayRelativeStatement;
import ast.tasksAndSynchronization.DelayStatement;
import ast.tasksAndSynchronization.DelayUntilStatement;
import ast.tasksAndSynchronization.EntryBarrier;
import ast.tasksAndSynchronization.EntryBody;
import ast.tasksAndSynchronization.EntryBodyFormalPart;
import ast.tasksAndSynchronization.EntryCallAlternative;
import ast.tasksAndSynchronization.EntryCallStatement;
import ast.tasksAndSynchronization.EntryDeclaration;
import ast.tasksAndSynchronization.EntryIndex;
import ast.tasksAndSynchronization.EntryIndexSpecification;
import ast.tasksAndSynchronization.Guard;
import ast.tasksAndSynchronization.ProtectedBody;
import ast.tasksAndSynchronization.ProtectedDefinition;
import ast.tasksAndSynchronization.ProtectedElementDeclaration;
import ast.tasksAndSynchronization.ProtectedOperationDeclaration;
import ast.tasksAndSynchronization.ProtectedOperationItem;
import ast.tasksAndSynchronization.ProtectedTypeDeclaration;
import ast.tasksAndSynchronization.RequeueStatement;
import ast.tasksAndSynchronization.SelectAlternative;
import ast.tasksAndSynchronization.SelectAlternativeClause;
import ast.tasksAndSynchronization.SelectStatement;
import ast.tasksAndSynchronization.SelectiveAccept;
import ast.tasksAndSynchronization.SingleProtectedDeclaration;
import ast.tasksAndSynchronization.SingleTaskDeclaration;
import ast.tasksAndSynchronization.TaskBody;
import ast.tasksAndSynchronization.TaskDefinition;
import ast.tasksAndSynchronization.TaskItem;
import ast.tasksAndSynchronization.TaskTypeDeclaration;
import ast.tasksAndSynchronization.TerminateAlternative;
import ast.tasksAndSynchronization.TimedEntryCall;
import ast.tasksAndSynchronization.TriggeringAlternative;
import ast.tasksAndSynchronization.TriggeringStatement;
import ast.visibilityRules.ExceptionRenamingDeclaration;
import ast.visibilityRules.GenericRenamingDeclaration;
import ast.visibilityRules.ObjectRenamingDeclaration;
import ast.visibilityRules.PackageRenamingDeclaration;
import ast.visibilityRules.RenamingDeclaration;
import ast.visibilityRules.SubprogramRenamingDeclaration;
import ast.visibilityRules.UseClause;
import ast.visibilityRules.UsePackageClause;
import ast.visibilityRules.UseTypeClause;

public class DefaultVisitor implements Ada95Visitor<Object> {

    @Override
    public Object visit(Identifier astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(NumericLiteral astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(CharacterLiteral astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(StringLiteral astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(Name astNode, Object parameter) {
	if (astNode.getDirectName() != null)
	    astNode.getDirectName().accept(this, null);
	if (astNode.getLabel() != null)
	    astNode.getLabel().accept(this, null);
	for (Expression astChild : astNode.getArguments())
	    astChild.accept(this, null);
	if (astNode.getDiscreteRange() != null)
	    astNode.getDiscreteRange().accept(this, null);
	if (astNode.getSelectorName() != null)
	    astNode.getSelectorName().accept(this, null);
	if (astNode.getAttributeDesignator() != null)
	    astNode.getAttributeDesignator().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getArgument() != null)
	    astNode.getArgument().accept(this, null);
	if (astNode.getActualParameterPart() != null)
	    astNode.getActualParameterPart().accept(this, null);
	if (astNode.getCharacterLiteral() != null)
	    astNode.getCharacterLiteral().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DirectName astNode, Object parameter) {
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	if (astNode.getOperatorSymbol() != null)
	    astNode.getOperatorSymbol().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SelectorName astNode, Object parameter) {
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	if (astNode.getLiteral() != null)
	    astNode.getLiteral().accept(this, null);
	if (astNode.getOperatorSymbol() != null)
	    astNode.getOperatorSymbol().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AttributeDesignator astNode, Object parameter) {
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RangeAttributeReference astNode, Object parameter) {
	if (astNode.getPrefix() != null)
	    astNode.getPrefix().accept(this, null);
	if (astNode.getRangeAttributeDesignator() != null)
	    astNode.getRangeAttributeDesignator().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RangeAttributeDesignator astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Aggregate astNode, Object parameter) {
	if (astNode.getRecordAggregate() != null)
	    astNode.getRecordAggregate().accept(this, null);
	if (astNode.getExtensionAggregate() != null)
	    astNode.getExtensionAggregate().accept(this, null);
	if (astNode.getArrayAggregate() != null)
	    astNode.getArrayAggregate().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordAggregate astNode, Object parameter) {
	if (astNode.getRecordComponentAssociationList() != null)
	    astNode.getRecordComponentAssociationList().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordComponentAssociationList astNode, Object parameter) {
	for (RecordComponentAssociation astChild : astNode.getRecordComponentAssociations())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordComponentAssociation astNode, Object parameter) {
	if (astNode.getComponentChoiceList() != null)
	    astNode.getComponentChoiceList().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ComponentChoiceList astNode, Object parameter) {
	for (SelectorName astChild : astNode.getComponentSelectorNames())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExtensionAggregate astNode, Object parameter) {
	if (astNode.getAncestorPart() != null)
	    astNode.getAncestorPart().accept(this, null);
	if (astNode.getRecordComponentAssociationList() != null)
	    astNode.getRecordComponentAssociationList().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AncestorPart astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ArrayAggregate astNode, Object parameter) {
	if (astNode.getPositionalArrayAggregate() != null)
	    astNode.getPositionalArrayAggregate().accept(this, null);
	if (astNode.getNamedArrayAggregate() != null)
	    astNode.getNamedArrayAggregate().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PositionalArrayAggregate astNode, Object parameter) {
	for (Expression astChild : astNode.getExpressions())
	    astChild.accept(this, null);
	if (astNode.getExpressionForOthersClause() != null)
	    astNode.getExpressionForOthersClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(NamedArrayAggregate astNode, Object parameter) {
	for (ArrayComponentAssociation astChild : astNode.getArrayComponentAssociations())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ArrayComponentAssociation astNode, Object parameter) {
	if (astNode.getDiscreteChoiceList() != null)
	    astNode.getDiscreteChoiceList().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Expression astNode, Object parameter) {
	for (Relation astChild : astNode.getRelations())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(Relation astNode, Object parameter) {
	if (astNode.getLeftSimpleExpression() != null)
	    astNode.getLeftSimpleExpression().accept(this, null);
	if (astNode.getRelationalOperator() != null)
	    astNode.getRelationalOperator().accept(this, null);
	if (astNode.getRightSimpleExpression() != null)
	    astNode.getRightSimpleExpression().accept(this, null);
	if (astNode.getRange() != null)
	    astNode.getRange().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SimpleExpression astNode, Object parameter) {
	if (astNode.getUnaryAddingOperator() != null)
	    astNode.getUnaryAddingOperator().accept(this, null);
	if (astNode.getUnaryAddingOperatorTerm() != null)
	    astNode.getUnaryAddingOperatorTerm().accept(this, null);
	for (BinaryAddingOperator astChild : astNode.getBinaryAddingOperators())
	    astChild.accept(this, null);
	for (Term astChild : astNode.getBinaryAddingOperatorTerms())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(Term astNode, Object parameter) {
	if (astNode.getFactor() != null)
	    astNode.getFactor().accept(this, null);
	for (MultiplyingOperator astChild : astNode.getMultiplyingOperators())
	    astChild.accept(this, null);
	for (Factor astChild : astNode.getMultiplyingOperatorFactors())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(Factor astNode, Object parameter) {
	if (astNode.getPrimary() != null)
	    astNode.getPrimary().accept(this, null);
	if (astNode.getPrimaryExp() != null)
	    astNode.getPrimaryExp().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Primary astNode, Object parameter) {
	if (astNode.getNumericLiteral() != null)
	    astNode.getNumericLiteral().accept(this, null);
	if (astNode.getStringLiteral() != null)
	    astNode.getStringLiteral().accept(this, null);
	if (astNode.getAggregate() != null)
	    astNode.getAggregate().accept(this, null);
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	if (astNode.getQualifiedExpression() != null)
	    astNode.getQualifiedExpression().accept(this, null);
	if (astNode.getAllocator() != null)
	    astNode.getAllocator().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LogicalOperator astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(RelationalOperator astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(BinaryAddingOperator astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(UnaryAddingOperator astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(MultiplyingOperator astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(HighestPrecedenceOperator astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(QualifiedExpression astNode, Object parameter) {
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getAggregate() != null)
	    astNode.getAggregate().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Allocator astNode, Object parameter) {
	if (astNode.getSubtypeIndication() != null)
	    astNode.getSubtypeIndication().accept(this, null);
	if (astNode.getQualifiedExpression() != null)
	    astNode.getQualifiedExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(UseClause astNode, Object parameter) {
	if (astNode.getUsePackageClause() != null)
	    astNode.getUsePackageClause().accept(this, null);
	if (astNode.getUseTypeClause() != null)
	    astNode.getUseTypeClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(UsePackageClause astNode, Object parameter) {
	for (Name astChild : astNode.getPackageNames())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(UseTypeClause astNode, Object parameter) {
	for (Name astChild : astNode.getSubtypeMarks())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(RenamingDeclaration astNode, Object parameter) {
	if (astNode.getObjectRenamingDeclaration() != null)
	    astNode.getObjectRenamingDeclaration().accept(this, null);
	if (astNode.getExceptionRenamingDeclaration() != null)
	    astNode.getExceptionRenamingDeclaration().accept(this, null);
	if (astNode.getPackageRenamingDeclaration() != null)
	    astNode.getPackageRenamingDeclaration().accept(this, null);
	if (astNode.getSubprogramRenamingDeclaration() != null)
	    astNode.getSubprogramRenamingDeclaration().accept(this, null);
	if (astNode.getGenericRenamingDeclaration() != null)
	    astNode.getGenericRenamingDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ObjectRenamingDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	if (astNode.getObjectName() != null)
	    astNode.getObjectName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExceptionRenamingDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getExceptionName() != null)
	    astNode.getExceptionName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PackageRenamingDeclaration astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	if (astNode.getPackageName() != null)
	    astNode.getPackageName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubprogramRenamingDeclaration astNode, Object parameter) {
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	if (astNode.getCallableEntityName() != null)
	    astNode.getCallableEntityName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericRenamingDeclaration astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	if (astNode.getGenericUnitName() != null)
	    astNode.getGenericUnitName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SequenceOfStatements astNode, Object parameter) {
	for (Statement astChild : astNode.getStatements())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(Statement astNode, Object parameter) {
	for (Label astChild : astNode.getLabels())
	    astChild.accept(this, null);
	if (astNode.getSimpleStatement() != null)
	    astNode.getSimpleStatement().accept(this, null);
	if (astNode.getCompoundStatement() != null)
	    astNode.getCompoundStatement().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SimpleStatement astNode, Object parameter) {
	if (astNode.getNullStatement() != null)
	    astNode.getNullStatement().accept(this, null);
	if (astNode.getAssignmentStatement() != null)
	    astNode.getAssignmentStatement().accept(this, null);
	if (astNode.getExitStatement() != null)
	    astNode.getExitStatement().accept(this, null);
	if (astNode.getGotoStatement() != null)
	    astNode.getGotoStatement().accept(this, null);
	if (astNode.getProcedureCallStatement() != null)
	    astNode.getProcedureCallStatement().accept(this, null);
	if (astNode.getReturnStatement() != null)
	    astNode.getReturnStatement().accept(this, null);
	if (astNode.getEntryCallStatement() != null)
	    astNode.getEntryCallStatement().accept(this, null);
	if (astNode.getRequeueStatement() != null)
	    astNode.getRequeueStatement().accept(this, null);
	if (astNode.getDelayStatement() != null)
	    astNode.getDelayStatement().accept(this, null);
	if (astNode.getAbortStatement() != null)
	    astNode.getAbortStatement().accept(this, null);
	if (astNode.getRaiseStatement() != null)
	    astNode.getRaiseStatement().accept(this, null);
	if (astNode.getCodeStatement() != null)
	    astNode.getCodeStatement().accept(this, null);
	return null;
    }

    @Override
    public Object visit(CompoundStatement astNode, Object parameter) {
	if (astNode.getIfStatement() != null)
	    astNode.getIfStatement().accept(this, null);
	if (astNode.getCaseStatement() != null)
	    astNode.getCaseStatement().accept(this, null);
	if (astNode.getLoopStatement() != null)
	    astNode.getLoopStatement().accept(this, null);
	if (astNode.getBlockStatement() != null)
	    astNode.getBlockStatement().accept(this, null);
	if (astNode.getAcceptStatement() != null)
	    astNode.getAcceptStatement().accept(this, null);
	if (astNode.getSelectStatement() != null)
	    astNode.getSelectStatement().accept(this, null);
	return null;
    }

    @Override
    public Object visit(NullStatement astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(Label astNode, Object parameter) {
	if (astNode.getLabelStatementIdentifier() != null)
	    astNode.getLabelStatementIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(StatementIdentifier astNode, Object parameter) {
	if (astNode.getDirectName() != null)
	    astNode.getDirectName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AssignmentStatement astNode, Object parameter) {
	if (astNode.getVariableName() != null)
	    astNode.getVariableName().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IfStatement astNode, Object parameter) {
	if (astNode.getCondition() != null)
	    astNode.getCondition().accept(this, null);
	if (astNode.getIfSequenceOfStatements() != null)
	    astNode.getIfSequenceOfStatements().accept(this, null);
	for (IfStatementElsifClause astChild : astNode.getIfStatementElsifClauses())
	    astChild.accept(this, null);
	if (astNode.getElseSequenceOfStatements() != null)
	    astNode.getElseSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IfStatementElsifClause astNode, Object parameter) {
	if (astNode.getCondition() != null)
	    astNode.getCondition().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Condition astNode, Object parameter) {
	if (astNode.getBooleanExpression() != null)
	    astNode.getBooleanExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(CaseStatement astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	for (CaseStatementAlternative astChild : astNode.getCaseStatementAlternatives())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(CaseStatementAlternative astNode, Object parameter) {
	if (astNode.getDiscreteChoiceList() != null)
	    astNode.getDiscreteChoiceList().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LoopStatement astNode, Object parameter) {
	if (astNode.getLoopStatementIdentifier() != null)
	    astNode.getLoopStatementIdentifier().accept(this, null);
	if (astNode.getIterationScheme() != null)
	    astNode.getIterationScheme().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	if (astNode.getLoopIdentifier() != null)
	    astNode.getLoopIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IterationScheme astNode, Object parameter) {
	if (astNode.getWhileCondition() != null)
	    astNode.getWhileCondition().accept(this, null);
	if (astNode.getLoopParameterSpecification() != null)
	    astNode.getLoopParameterSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LoopParameterSpecification astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscreteSubtypeDefinition() != null)
	    astNode.getDiscreteSubtypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(BlockStatement astNode, Object parameter) {
	if (astNode.getBlockStatementIdentifier() != null)
	    astNode.getBlockStatementIdentifier().accept(this, null);
	if (astNode.getDeclarativePart() != null)
	    astNode.getDeclarativePart().accept(this, null);
	if (astNode.getHandledSequenceOfStatements() != null)
	    astNode.getHandledSequenceOfStatements().accept(this, null);
	if (astNode.getBlockIdentifier() != null)
	    astNode.getBlockIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExitStatement astNode, Object parameter) {
	if (astNode.getLoopName() != null)
	    astNode.getLoopName().accept(this, null);
	if (astNode.getCondition() != null)
	    astNode.getCondition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GotoStatement astNode, Object parameter) {
	if (astNode.getLabelName() != null)
	    astNode.getLabelName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(BasicDeclaration astNode, Object parameter) {
	if (astNode.getTypeDeclaration() != null)
	    astNode.getTypeDeclaration().accept(this, null);
	if (astNode.getSubtypeDeclaration() != null)
	    astNode.getSubtypeDeclaration().accept(this, null);
	if (astNode.getObjectDeclaration() != null)
	    astNode.getObjectDeclaration().accept(this, null);
	if (astNode.getNumberDeclaration() != null)
	    astNode.getNumberDeclaration().accept(this, null);
	if (astNode.getSubprogramDeclaration() != null)
	    astNode.getSubprogramDeclaration().accept(this, null);
	if (astNode.getAbstractSubprogramDeclaration() != null)
	    astNode.getAbstractSubprogramDeclaration().accept(this, null);
	if (astNode.getPackageDeclaration() != null)
	    astNode.getPackageDeclaration().accept(this, null);
	if (astNode.getRenamingDeclaration() != null)
	    astNode.getRenamingDeclaration().accept(this, null);
	if (astNode.getExceptionDeclaration() != null)
	    astNode.getExceptionDeclaration().accept(this, null);
	if (astNode.getGenericDeclaration() != null)
	    astNode.getGenericDeclaration().accept(this, null);
	if (astNode.getGenericInstantiation() != null)
	    astNode.getGenericInstantiation().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefiningIdentifier astNode, Object parameter) {
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TypeDeclaration astNode, Object parameter) {
	if (astNode.getFullTypeDeclaration() != null)
	    astNode.getFullTypeDeclaration().accept(this, null);
	if (astNode.getIncompleteTypeDeclaration() != null)
	    astNode.getIncompleteTypeDeclaration().accept(this, null);
	if (astNode.getPrivateTypeDeclaration() != null)
	    astNode.getPrivateTypeDeclaration().accept(this, null);
	if (astNode.getPrivateExtensionDeclaration() != null)
	    astNode.getPrivateExtensionDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FullTypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getKnownDiscriminantPart() != null)
	    astNode.getKnownDiscriminantPart().accept(this, null);
	if (astNode.getTypeDefinition() != null)
	    astNode.getTypeDefinition().accept(this, null);
	if (astNode.getTaskTypeDeclaration() != null)
	    astNode.getTaskTypeDeclaration().accept(this, null);
	if (astNode.getProtectedTypeDeclaration() != null)
	    astNode.getProtectedTypeDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TypeDefinition astNode, Object parameter) {
	if (astNode.getEnumerationTypeDefinition() != null)
	    astNode.getEnumerationTypeDefinition().accept(this, null);
	if (astNode.getIntegerTypeDefinition() != null)
	    astNode.getIntegerTypeDefinition().accept(this, null);
	if (astNode.getRealTypeDefinition() != null)
	    astNode.getRealTypeDefinition().accept(this, null);
	if (astNode.getArrayTypeDefinition() != null)
	    astNode.getArrayTypeDefinition().accept(this, null);
	if (astNode.getRecordTypeDefinition() != null)
	    astNode.getRecordTypeDefinition().accept(this, null);
	if (astNode.getAccessTypeDefinition() != null)
	    astNode.getAccessTypeDefinition().accept(this, null);
	if (astNode.getDerivedTypeDefinition() != null)
	    astNode.getDerivedTypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubtypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getSubtypeIndication() != null)
	    astNode.getSubtypeIndication().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubtypeIndication astNode, Object parameter) {
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	if (astNode.getConstraint() != null)
	    astNode.getConstraint().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Constraint astNode, Object parameter) {
	if (astNode.getScalarConstraint() != null)
	    astNode.getScalarConstraint().accept(this, null);
	if (astNode.getCompositeConstraint() != null)
	    astNode.getCompositeConstraint().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ScalarConstraint astNode, Object parameter) {
	if (astNode.getRangeConstraint() != null)
	    astNode.getRangeConstraint().accept(this, null);
	if (astNode.getDigitsConstraint() != null)
	    astNode.getDigitsConstraint().accept(this, null);
	if (astNode.getDeltaConstraint() != null)
	    astNode.getDeltaConstraint().accept(this, null);
	return null;
    }

    @Override
    public Object visit(CompositeConstraint astNode, Object parameter) {
	if (astNode.getIndexConstraint() != null)
	    astNode.getIndexConstraint().accept(this, null);
	if (astNode.getDiscriminantConstraint() != null)
	    astNode.getDiscriminantConstraint().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ObjectDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	if (astNode.getSubtypeIndication() != null)
	    astNode.getSubtypeIndication().accept(this, null);
	if (astNode.getArrayTypeDefinition() != null)
	    astNode.getArrayTypeDefinition().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getSingleTaskDeclaration() != null)
	    astNode.getSingleTaskDeclaration().accept(this, null);
	if (astNode.getSingleProtectedDeclaration() != null)
	    astNode.getSingleProtectedDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefiningIdentifierList astNode, Object parameter) {
	for (DefiningIdentifier astChild : astNode.getDefiningIdentifiers())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(NumberDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DerivedTypeDefinition astNode, Object parameter) {
	if (astNode.getParentSubtypeIndication() != null)
	    astNode.getParentSubtypeIndication().accept(this, null);
	if (astNode.getRecordExtensionPart() != null)
	    astNode.getRecordExtensionPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RangeConstraint astNode, Object parameter) {
	if (astNode.getRange() != null)
	    astNode.getRange().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Range astNode, Object parameter) {
	if (astNode.getRangeAttributeReference() != null)
	    astNode.getRangeAttributeReference().accept(this, null);
	if (astNode.getLeftSimpleExpression() != null)
	    astNode.getLeftSimpleExpression().accept(this, null);
	if (astNode.getRightSimpleExpression() != null)
	    astNode.getRightSimpleExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EnumerationTypeDefinition astNode, Object parameter) {
	for (EnumerationLiteralSpecification astChild : astNode.getEnumerationLiteralSpecifications())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(EnumerationLiteralSpecification astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDefiningCharacterLiteral() != null)
	    astNode.getDefiningCharacterLiteral().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefiningCharacterLiteral astNode, Object parameter) {
	if (astNode.getCharacterLiteral() != null)
	    astNode.getCharacterLiteral().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IntegerTypeDefinition astNode, Object parameter) {
	if (astNode.getSignedIntegerTypeDefinition() != null)
	    astNode.getSignedIntegerTypeDefinition().accept(this, null);
	if (astNode.getModularTypeDefinition() != null)
	    astNode.getModularTypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SignedIntegerTypeDefinition astNode, Object parameter) {
	if (astNode.getLeftStaticSimpleExpression() != null)
	    astNode.getLeftStaticSimpleExpression().accept(this, null);
	if (astNode.getRightStaticSimpleExpression() != null)
	    astNode.getRightStaticSimpleExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ModularTypeDefinition astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RealTypeDefinition astNode, Object parameter) {
	if (astNode.getFloatingPointDefinition() != null)
	    astNode.getFloatingPointDefinition().accept(this, null);
	if (astNode.getFixedPointDefinition() != null)
	    astNode.getFixedPointDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FloatingPointDefinition astNode, Object parameter) {
	if (astNode.getStaticExpression() != null)
	    astNode.getStaticExpression().accept(this, null);
	if (astNode.getRealRangeSpecification() != null)
	    astNode.getRealRangeSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RealRangeSpecification astNode, Object parameter) {
	if (astNode.getRange() != null)
	    astNode.getRange().accept(this, null);
	if (astNode.getLeftStaticSimpleExpression() != null)
	    astNode.getLeftStaticSimpleExpression().accept(this, null);
	if (astNode.getRightStaticSimpleExpression() != null)
	    astNode.getRightStaticSimpleExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FixedPointDefinition astNode, Object parameter) {
	if (astNode.getOrdinaryFixedPointDefinition() != null)
	    astNode.getOrdinaryFixedPointDefinition().accept(this, null);
	if (astNode.getDecimalFixedPointDefinition() != null)
	    astNode.getDecimalFixedPointDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(OrdinaryFixedPointDefinition astNode, Object parameter) {
	if (astNode.getStaticExpression() != null)
	    astNode.getStaticExpression().accept(this, null);
	if (astNode.getRealRangeSpecification() != null)
	    astNode.getRealRangeSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DecimalFixedPointDefinition astNode, Object parameter) {
	if (astNode.getDeltaStaticExpression() != null)
	    astNode.getDeltaStaticExpression().accept(this, null);
	if (astNode.getDigitsStaticExpression() != null)
	    astNode.getDigitsStaticExpression().accept(this, null);
	if (astNode.getRealRangeSpecification() != null)
	    astNode.getRealRangeSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DigitsConstraint astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getRangeConstraint() != null)
	    astNode.getRangeConstraint().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ArrayTypeDefinition astNode, Object parameter) {
	if (astNode.getUnconstrainedArrayDefinition() != null)
	    astNode.getUnconstrainedArrayDefinition().accept(this, null);
	if (astNode.getConstrainedArrayDefinition() != null)
	    astNode.getConstrainedArrayDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(UnconstrainedArrayDefinition astNode, Object parameter) {
	for (IndexSubtypeDefinition astChild : astNode.getIndexSubtypeDefinitions())
	    astChild.accept(this, null);
	if (astNode.getComponentDefinition() != null)
	    astNode.getComponentDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IndexSubtypeDefinition astNode, Object parameter) {
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	if (astNode.getRange() != null)
	    astNode.getRange().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ConstrainedArrayDefinition astNode, Object parameter) {
	for (DiscreteSubtypeDefinition astChild : astNode.getDiscreteSubtypeDefinitions())
	    astChild.accept(this, null);
	if (astNode.getComponentDefinition() != null)
	    astNode.getComponentDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscreteSubtypeDefinition astNode, Object parameter) {
	if (astNode.getDiscreteSubtypeIndication() != null)
	    astNode.getDiscreteSubtypeIndication().accept(this, null);
	if (astNode.getRange() != null)
	    astNode.getRange().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ComponentDefinition astNode, Object parameter) {
	if (astNode.getSubtypeIndication() != null)
	    astNode.getSubtypeIndication().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IndexConstraint astNode, Object parameter) {
	for (DiscreteRange astChild : astNode.getDiscreteRanges())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscreteRange astNode, Object parameter) {
	if (astNode.getSubtypeIndication() != null)
	    astNode.getSubtypeIndication().accept(this, null);
	if (astNode.getRange() != null)
	    astNode.getRange().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscriminantPart astNode, Object parameter) {
	if (astNode.getUnknownDiscriminantPart() != null)
	    astNode.getUnknownDiscriminantPart().accept(this, null);
	if (astNode.getKnownDiscriminantPart() != null)
	    astNode.getKnownDiscriminantPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(UnknownDiscriminantPart astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(KnownDiscriminantPart astNode, Object parameter) {
	for (DiscriminantSpecification astChild : astNode.getDiscriminantSpecifications())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscriminantSpecification astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	if (astNode.getAccessDefinition() != null)
	    astNode.getAccessDefinition().accept(this, null);
	if (astNode.getDefaultExpression() != null)
	    astNode.getDefaultExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefaultExpression astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscriminantConstraint astNode, Object parameter) {
	for (DiscriminantAssociation astChild : astNode.getDiscriminantAssociations())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscriminantAssociation astNode, Object parameter) {
	for (SelectorName astChild : astNode.getSelectorNames())
	    astChild.accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordTypeDefinition astNode, Object parameter) {
	if (astNode.getRecordDefinition() != null)
	    astNode.getRecordDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordDefinition astNode, Object parameter) {
	if (astNode.getComponentList() != null)
	    astNode.getComponentList().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ComponentList astNode, Object parameter) {
	for (ComponentItem astChild : astNode.getComponentItems())
	    astChild.accept(this, null);
	if (astNode.getVariantPart() != null)
	    astNode.getVariantPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ComponentItem astNode, Object parameter) {
	if (astNode.getComponentDeclaration() != null)
	    astNode.getComponentDeclaration().accept(this, null);
	if (astNode.getAspectClause() != null)
	    astNode.getAspectClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ComponentDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	if (astNode.getComponentDefinition() != null)
	    astNode.getComponentDefinition().accept(this, null);
	if (astNode.getDefaultExpression() != null)
	    astNode.getDefaultExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(VariantPart astNode, Object parameter) {
	if (astNode.getDiscriminantDirectName() != null)
	    astNode.getDiscriminantDirectName().accept(this, null);
	for (Variant astChild : astNode.getVariants())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(Variant astNode, Object parameter) {
	if (astNode.getDiscreteChoiceList() != null)
	    astNode.getDiscreteChoiceList().accept(this, null);
	if (astNode.getComponentList() != null)
	    astNode.getComponentList().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscreteChoiceList astNode, Object parameter) {
	for (DiscreteChoice astChild : astNode.getDiscreteChoices())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(DiscreteChoice astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getDiscreteRange() != null)
	    astNode.getDiscreteRange().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordExtensionPart astNode, Object parameter) {
	if (astNode.getRecordDefinition() != null)
	    astNode.getRecordDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AccessTypeDefinition astNode, Object parameter) {
	if (astNode.getAccessToObjectDefinition() != null)
	    astNode.getAccessToObjectDefinition().accept(this, null);
	if (astNode.getAccessToSubprogramDefinition() != null)
	    astNode.getAccessToSubprogramDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AccessToObjectDefinition astNode, Object parameter) {
	if (astNode.getGeneralAccessModifier() != null)
	    astNode.getGeneralAccessModifier().accept(this, null);
	if (astNode.getSubtypeIndication() != null)
	    astNode.getSubtypeIndication().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GeneralAccessModifier astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(AccessToSubprogramDefinition astNode, Object parameter) {
	if (astNode.getParameterProfile() != null)
	    astNode.getParameterProfile().accept(this, null);
	if (astNode.getParameterAndResultProfile() != null)
	    astNode.getParameterAndResultProfile().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AccessDefinition astNode, Object parameter) {
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	return null;
    }

    @Override
    public Object visit(IncompleteTypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscriminantPart() != null)
	    astNode.getDiscriminantPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DeclarativePart astNode, Object parameter) {
	for (DeclarativeItem astChild : astNode.getDeclarativeItems())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(DeclarativeItem astNode, Object parameter) {
	if (astNode.getBasicDeclarativeItem() != null)
	    astNode.getBasicDeclarativeItem().accept(this, null);
	if (astNode.getBody() != null)
	    astNode.getBody().accept(this, null);
	return null;
    }

    @Override
    public Object visit(BasicDeclarativeItem astNode, Object parameter) {
	if (astNode.getBasicDeclaration() != null)
	    astNode.getBasicDeclaration().accept(this, null);
	if (astNode.getAspectClause() != null)
	    astNode.getAspectClause().accept(this, null);
	if (astNode.getUseClause() != null)
	    astNode.getUseClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Body astNode, Object parameter) {
	if (astNode.getProperBody() != null)
	    astNode.getProperBody().accept(this, null);
	if (astNode.getBodyStub() != null)
	    astNode.getBodyStub().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProperBody astNode, Object parameter) {
	if (astNode.getSubprogramBody() != null)
	    astNode.getSubprogramBody().accept(this, null);
	if (astNode.getPackageBody() != null)
	    astNode.getPackageBody().accept(this, null);
	if (astNode.getTaskBody() != null)
	    astNode.getTaskBody().accept(this, null);
	if (astNode.getProtectedBody() != null)
	    astNode.getProtectedBody().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PackageDeclaration astNode, Object parameter) {
	if (astNode.getPackageSpecification() != null)
	    astNode.getPackageSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PackageSpecification astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	for (BasicDeclarativeItem astChild : astNode.getMainBasicDeclarativeItems())
	    astChild.accept(this, null);
	for (BasicDeclarativeItem astChild : astNode.getPrivateBasicDeclarativeItems())
	    astChild.accept(this, null);
	if (astNode.getParentUnitName() != null)
	    astNode.getParentUnitName().accept(this, null);
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PackageBody astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	if (astNode.getDeclarativePart() != null)
	    astNode.getDeclarativePart().accept(this, null);
	if (astNode.getHandledSequenceOfStatements() != null)
	    astNode.getHandledSequenceOfStatements().accept(this, null);
	if (astNode.getParentUnitName() != null)
	    astNode.getParentUnitName().accept(this, null);
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PrivateTypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscriminantPart() != null)
	    astNode.getDiscriminantPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PrivateExtensionDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscriminantPart() != null)
	    astNode.getDiscriminantPart().accept(this, null);
	if (astNode.getAncestorSubtypeIndication() != null)
	    astNode.getAncestorSubtypeIndication().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TaskTypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getKnownDiscriminantPart() != null)
	    astNode.getKnownDiscriminantPart().accept(this, null);
	if (astNode.getTaskDefinition() != null)
	    astNode.getTaskDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SingleTaskDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getTaskDefinition() != null)
	    astNode.getTaskDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TaskDefinition astNode, Object parameter) {
	for (TaskItem astChild : astNode.getMainTaskItems())
	    astChild.accept(this, null);
	for (TaskItem astChild : astNode.getPrivateTaskItems())
	    astChild.accept(this, null);
	if (astNode.getTaskIdentifier() != null)
	    astNode.getTaskIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TaskItem astNode, Object parameter) {
	if (astNode.getEntryDeclaration() != null)
	    astNode.getEntryDeclaration().accept(this, null);
	if (astNode.getAspectClause() != null)
	    astNode.getAspectClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TaskBody astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDeclarativePart() != null)
	    astNode.getDeclarativePart().accept(this, null);
	if (astNode.getHandledSequenceOfStatements() != null)
	    astNode.getHandledSequenceOfStatements().accept(this, null);
	if (astNode.getTaskIdentifier() != null)
	    astNode.getTaskIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedTypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getKnownDiscriminantPart() != null)
	    astNode.getKnownDiscriminantPart().accept(this, null);
	if (astNode.getProtectedDefinition() != null)
	    astNode.getProtectedDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SingleProtectedDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getProtectedDefinition() != null)
	    astNode.getProtectedDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedDefinition astNode, Object parameter) {
	for (ProtectedOperationDeclaration astChild : astNode.getProtectedOperationDeclarations())
	    astChild.accept(this, null);
	for (ProtectedElementDeclaration astChild : astNode.getProtectedElementDeclarations())
	    astChild.accept(this, null);
	if (astNode.getProtectedIdentifier() != null)
	    astNode.getProtectedIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedOperationDeclaration astNode, Object parameter) {
	if (astNode.getSubprogramDeclaration() != null)
	    astNode.getSubprogramDeclaration().accept(this, null);
	if (astNode.getEntryDeclaration() != null)
	    astNode.getEntryDeclaration().accept(this, null);
	if (astNode.getAspectClause() != null)
	    astNode.getAspectClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedElementDeclaration astNode, Object parameter) {
	if (astNode.getProtectedOperationDeclaration() != null)
	    astNode.getProtectedOperationDeclaration().accept(this, null);
	if (astNode.getComponentDeclaration() != null)
	    astNode.getComponentDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedBody astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	for (ProtectedOperationItem astChild : astNode.getProtectedOperationItems())
	    astChild.accept(this, null);
	if (astNode.getProtectedIdentifier() != null)
	    astNode.getProtectedIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedOperationItem astNode, Object parameter) {
	if (astNode.getSubprogramDeclaration() != null)
	    astNode.getSubprogramDeclaration().accept(this, null);
	if (astNode.getSubprogramBody() != null)
	    astNode.getSubprogramBody().accept(this, null);
	if (astNode.getEntryBody() != null)
	    astNode.getEntryBody().accept(this, null);
	if (astNode.getAspectClause() != null)
	    astNode.getAspectClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscreteSubtypeDefinition() != null)
	    astNode.getDiscreteSubtypeDefinition().accept(this, null);
	if (astNode.getParameterProfile() != null)
	    astNode.getParameterProfile().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AcceptStatement astNode, Object parameter) {
	if (astNode.getEntryDirectName() != null)
	    astNode.getEntryDirectName().accept(this, null);
	if (astNode.getEntryIndex() != null)
	    astNode.getEntryIndex().accept(this, null);
	if (astNode.getParameterProfile() != null)
	    astNode.getParameterProfile().accept(this, null);
	if (astNode.getHandledSequenceOfStatements() != null)
	    astNode.getHandledSequenceOfStatements().accept(this, null);
	if (astNode.getEntryIdentifier() != null)
	    astNode.getEntryIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryIndex astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryBody astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getEntryBodyFormalPart() != null)
	    astNode.getEntryBodyFormalPart().accept(this, null);
	if (astNode.getEntryBarrier() != null)
	    astNode.getEntryBarrier().accept(this, null);
	if (astNode.getDeclarativePart() != null)
	    astNode.getDeclarativePart().accept(this, null);
	if (astNode.getHandledSequenceOfStatements() != null)
	    astNode.getHandledSequenceOfStatements().accept(this, null);
	if (astNode.getEntryIdentifier() != null)
	    astNode.getEntryIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryBodyFormalPart astNode, Object parameter) {
	if (astNode.getEntryIndexSpecification() != null)
	    astNode.getEntryIndexSpecification().accept(this, null);
	if (astNode.getParameterProfile() != null)
	    astNode.getParameterProfile().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryBarrier astNode, Object parameter) {
	if (astNode.getCondition() != null)
	    astNode.getCondition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryIndexSpecification astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscreteSubtypeDefinition() != null)
	    astNode.getDiscreteSubtypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryCallStatement astNode, Object parameter) {
	if (astNode.getEntryName() != null)
	    astNode.getEntryName().accept(this, null);
	if (astNode.getActualParameterPart() != null)
	    astNode.getActualParameterPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RequeueStatement astNode, Object parameter) {
	if (astNode.getEntryName() != null)
	    astNode.getEntryName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DelayStatement astNode, Object parameter) {
	if (astNode.getDelayUntilStatement() != null)
	    astNode.getDelayUntilStatement().accept(this, null);
	if (astNode.getDelayRelativeStatement() != null)
	    astNode.getDelayRelativeStatement().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DelayUntilStatement astNode, Object parameter) {
	if (astNode.getDelayExpression() != null)
	    astNode.getDelayExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DelayRelativeStatement astNode, Object parameter) {
	if (astNode.getDelayExpression() != null)
	    astNode.getDelayExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SelectStatement astNode, Object parameter) {
	if (astNode.getSelectiveAccept() != null)
	    astNode.getSelectiveAccept().accept(this, null);
	if (astNode.getTimedEntryCall() != null)
	    astNode.getTimedEntryCall().accept(this, null);
	if (astNode.getConditionalEntryCall() != null)
	    astNode.getConditionalEntryCall().accept(this, null);
	if (astNode.getAsynchronousSelect() != null)
	    astNode.getAsynchronousSelect().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SelectiveAccept astNode, Object parameter) {
	for (SelectAlternativeClause astChild : astNode.getSelectAlternativeClauses())
	    astChild.accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Guard astNode, Object parameter) {
	if (astNode.getCondition() != null)
	    astNode.getCondition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SelectAlternative astNode, Object parameter) {
	if (astNode.getAcceptAlternative() != null)
	    astNode.getAcceptAlternative().accept(this, null);
	if (astNode.getDelayAlternative() != null)
	    astNode.getDelayAlternative().accept(this, null);
	if (astNode.getTerminateAlternative() != null)
	    astNode.getTerminateAlternative().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SelectAlternativeClause astNode, Object parameter) {
	if (astNode.getGuard() != null)
	    astNode.getGuard().accept(this, null);
	if (astNode.getSelectAlternative() != null)
	    astNode.getSelectAlternative().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AcceptAlternative astNode, Object parameter) {
	if (astNode.getAcceptStatement() != null)
	    astNode.getAcceptStatement().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DelayAlternative astNode, Object parameter) {
	if (astNode.getDelayStatement() != null)
	    astNode.getDelayStatement().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TerminateAlternative astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(TimedEntryCall astNode, Object parameter) {
	if (astNode.getEntryCallAlternative() != null)
	    astNode.getEntryCallAlternative().accept(this, null);
	if (astNode.getDelayAlternative() != null)
	    astNode.getDelayAlternative().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EntryCallAlternative astNode, Object parameter) {
	if (astNode.getEntryCallStatement() != null)
	    astNode.getEntryCallStatement().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ConditionalEntryCall astNode, Object parameter) {
	if (astNode.getEntryCallAlternative() != null)
	    astNode.getEntryCallAlternative().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AsynchronousSelect astNode, Object parameter) {
	if (astNode.getTriggeringAlternative() != null)
	    astNode.getTriggeringAlternative().accept(this, null);
	if (astNode.getAbortablePart() != null)
	    astNode.getAbortablePart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TriggeringAlternative astNode, Object parameter) {
	if (astNode.getTriggeringStatement() != null)
	    astNode.getTriggeringStatement().accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TriggeringStatement astNode, Object parameter) {
	if (astNode.getEntryCallStatement() != null)
	    astNode.getEntryCallStatement().accept(this, null);
	if (astNode.getDelayStatement() != null)
	    astNode.getDelayStatement().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AbortablePart astNode, Object parameter) {
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AbortStatement astNode, Object parameter) {
	for (Name astChild : astNode.getTaskNames())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExceptionDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	return null;
    }

    @Override
    public Object visit(HandledSequenceOfStatements astNode, Object parameter) {
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	for (ExceptionHandler astChild : astNode.getExceptionHandlers())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExceptionHandler astNode, Object parameter) {
	if (astNode.getChoiceParameterSpecification() != null)
	    astNode.getChoiceParameterSpecification().accept(this, null);
	for (ExceptionChoice astChild : astNode.getExceptionChoices())
	    astChild.accept(this, null);
	if (astNode.getSequenceOfStatements() != null)
	    astNode.getSequenceOfStatements().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ChoiceParameterSpecification astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExceptionChoice astNode, Object parameter) {
	if (astNode.getExceptionName() != null)
	    astNode.getExceptionName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RaiseStatement astNode, Object parameter) {
	if (astNode.getExceptionName() != null)
	    astNode.getExceptionName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Compilation astNode, Object parameter) {
	for (CompilationUnit astChild : astNode.getCompilationUnits())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(CompilationUnit astNode, Object parameter) {
	astNode.getContextClause().accept(this, null);
	if (astNode.getLibraryItem() != null)
	    astNode.getLibraryItem().accept(this, null);
	if (astNode.getSubunit() != null)
	    astNode.getSubunit().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LibraryItem astNode, Object parameter) {
	if (astNode.getLibraryUnitBody() != null)
	    astNode.getLibraryUnitBody().accept(this, null);
	if (astNode.getLibraryUnitDeclaration() != null)
	    astNode.getLibraryUnitDeclaration().accept(this, null);
	if (astNode.getLibraryUnitRenamingDeclaration() != null)
	    astNode.getLibraryUnitRenamingDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LibraryUnitDeclaration astNode, Object parameter) {
	if (astNode.getSubprogramDeclaration() != null)
	    astNode.getSubprogramDeclaration().accept(this, null);
	if (astNode.getPackageDeclaration() != null)
	    astNode.getPackageDeclaration().accept(this, null);
	if (astNode.getGenericDeclaration() != null)
	    astNode.getGenericDeclaration().accept(this, null);
	if (astNode.getGenericInstantiation() != null)
	    astNode.getGenericInstantiation().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LibraryUnitRenamingDeclaration astNode, Object parameter) {
	if (astNode.getPackageRenamingDeclaration() != null)
	    astNode.getPackageRenamingDeclaration().accept(this, null);
	if (astNode.getGenericRenamingDeclaration() != null)
	    astNode.getGenericRenamingDeclaration().accept(this, null);
	if (astNode.getSubprogramRenamingDeclaration() != null)
	    astNode.getSubprogramRenamingDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LibraryUnitBody astNode, Object parameter) {
	if (astNode.getSubprogramBody() != null)
	    astNode.getSubprogramBody().accept(this, null);
	if (astNode.getPackageBody() != null)
	    astNode.getPackageBody().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ParentUnitName astNode, Object parameter) {
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ContextClause astNode, Object parameter) {
	for (ContextItem astChild : astNode.getContextItems())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ContextItem astNode, Object parameter) {
	if (astNode.getUseClause() != null)
	    astNode.getUseClause().accept(this, null);
	if (astNode.getWithClause() != null)
	    astNode.getWithClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(WithClause astNode, Object parameter) {
	for (Name astChild : astNode.getLibraryUnitNames())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(BodyStub astNode, Object parameter) {
	if (astNode.getSubprogramBodyStub() != null)
	    astNode.getSubprogramBodyStub().accept(this, null);
	if (astNode.getPackageBodyStub() != null)
	    astNode.getPackageBodyStub().accept(this, null);
	if (astNode.getTaskBodyStub() != null)
	    astNode.getTaskBodyStub().accept(this, null);
	if (astNode.getProtectedBodyStub() != null)
	    astNode.getProtectedBodyStub().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubprogramBodyStub astNode, Object parameter) {
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(PackageBodyStub astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(TaskBodyStub astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProtectedBodyStub astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Subunit astNode, Object parameter) {
	if (astNode.getParentUnitName() != null)
	    astNode.getParentUnitName().accept(this, null);
	if (astNode.getProperBody() != null)
	    astNode.getProperBody().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubprogramDeclaration astNode, Object parameter) {
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AbstractSubprogramDeclaration astNode, Object parameter) {
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubprogramSpecification astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	if (astNode.getParameterProfile() != null)
	    astNode.getParameterProfile().accept(this, null);
	if (astNode.getDefiningDesignator() != null)
	    astNode.getDefiningDesignator().accept(this, null);
	if (astNode.getParameterAndResultProfile() != null)
	    astNode.getParameterAndResultProfile().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Designator astNode, Object parameter) {
	if (astNode.getParentUnitName() != null)
	    astNode.getParentUnitName().accept(this, null);
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	if (astNode.getOperatorSymbol() != null)
	    astNode.getOperatorSymbol().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefiningDesignator astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	if (astNode.getDefiningOperatorSymbol() != null)
	    astNode.getDefiningOperatorSymbol().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefiningProgramUnitName astNode, Object parameter) {
	if (astNode.getParentUnitName() != null)
	    astNode.getParentUnitName().accept(this, null);
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	return null;
    }

    @Override
    public Object visit(OperatorSymbol astNode, Object parameter) {
	if (astNode.getLiteral() != null)
	    astNode.getLiteral().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefiningOperatorSymbol astNode, Object parameter) {
	if (astNode.getOperatorSymbol() != null)
	    astNode.getOperatorSymbol().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ParameterProfile astNode, Object parameter) {
	if (astNode.getFormalPart() != null)
	    astNode.getFormalPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ParameterAndResultProfile astNode, Object parameter) {
	if (astNode.getFormalPart() != null)
	    astNode.getFormalPart().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalPart astNode, Object parameter) {
	for (ParameterSpecification astChild : astNode.getParameterSpecifications())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ParameterSpecification astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	if (astNode.getMode() != null)
	    astNode.getMode().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	if (astNode.getAccessDefinition() != null)
	    astNode.getAccessDefinition().accept(this, null);
	if (astNode.getDefaultExpression() != null)
	    astNode.getDefaultExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Mode astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(SubprogramBody astNode, Object parameter) {
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	if (astNode.getDeclarativePart() != null)
	    astNode.getDeclarativePart().accept(this, null);
	if (astNode.getHandledSequenceOfStatements() != null)
	    astNode.getHandledSequenceOfStatements().accept(this, null);
	if (astNode.getDesignator() != null)
	    astNode.getDesignator().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ProcedureCallStatement astNode, Object parameter) {
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	if (astNode.getActualParameterPart() != null)
	    astNode.getActualParameterPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ActualParameterPart astNode, Object parameter) {
	for (ParameterAssociation astChild : astNode.getParameterAssociations())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ParameterAssociation astNode, Object parameter) {
	if (astNode.getSelectorName() != null)
	    astNode.getSelectorName().accept(this, null);
	if (astNode.getExplicitActualParameter() != null)
	    astNode.getExplicitActualParameter().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExplicitActualParameter astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getVariableName() != null)
	    astNode.getVariableName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ReturnStatement astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AtClause astNode, Object parameter) {
	if (astNode.getDirectName() != null)
	    astNode.getDirectName().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DeltaConstraint astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getRangeConstraint() != null)
	    astNode.getRangeConstraint().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ModClause astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(BooleanExpression astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericDeclaration astNode, Object parameter) {
	if (astNode.getGenericSubprogramDeclaration() != null)
	    astNode.getGenericSubprogramDeclaration().accept(this, null);
	if (astNode.getGenericPackageDeclaration() != null)
	    astNode.getGenericPackageDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericSubprogramDeclaration astNode, Object parameter) {
	if (astNode.getGenericFormalPart() != null)
	    astNode.getGenericFormalPart().accept(this, null);
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericPackageDeclaration astNode, Object parameter) {
	if (astNode.getGenericFormalPart() != null)
	    astNode.getGenericFormalPart().accept(this, null);
	if (astNode.getPackageSpecification() != null)
	    astNode.getPackageSpecification().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericFormalPart astNode, Object parameter) {
	for (GenericFormalParameterDeclaration astChild : astNode.getGenericFormalParameterDeclarations())
	    astChild.accept(this, null);
	for (UseClause astChild : astNode.getUseClauses())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericFormalParameterDeclaration astNode, Object parameter) {
	if (astNode.getFormalObjectDeclaration() != null)
	    astNode.getFormalObjectDeclaration().accept(this, null);
	if (astNode.getFormalTypeDeclaration() != null)
	    astNode.getFormalTypeDeclaration().accept(this, null);
	if (astNode.getFormalSubprogramDeclaration() != null)
	    astNode.getFormalSubprogramDeclaration().accept(this, null);
	if (astNode.getFormalPackageDeclaration() != null)
	    astNode.getFormalPackageDeclaration().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericInstantiation astNode, Object parameter) {
	if (astNode.getDefiningProgramUnitName() != null)
	    astNode.getDefiningProgramUnitName().accept(this, null);
	if (astNode.getDefiningDesignator() != null)
	    astNode.getDefiningDesignator().accept(this, null);
	if (astNode.getGenericUnitName() != null)
	    astNode.getGenericUnitName().accept(this, null);
	if (astNode.getGenericActualPart() != null)
	    astNode.getGenericActualPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericActualPart astNode, Object parameter) {
	for (GenericAssociation astChild : astNode.getGenericAssociations())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(GenericAssociation astNode, Object parameter) {
	if (astNode.getGenericFormalParameterSelectorName() != null)
	    astNode.getGenericFormalParameterSelectorName().accept(this, null);
	if (astNode.getExplicitGenericActualParameter() != null)
	    astNode.getExplicitGenericActualParameter().accept(this, null);
	return null;
    }

    @Override
    public Object visit(ExplicitGenericActualParameter astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalObjectDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifierList() != null)
	    astNode.getDefiningIdentifierList().accept(this, null);
	if (astNode.getMode() != null)
	    astNode.getMode().accept(this, null);
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	if (astNode.getDefaultExpression() != null)
	    astNode.getDefaultExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalTypeDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getDiscriminantPart() != null)
	    astNode.getDiscriminantPart().accept(this, null);
	if (astNode.getFormalTypeDefinition() != null)
	    astNode.getFormalTypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalTypeDefinition astNode, Object parameter) {
	if (astNode.getFormalPrivateTypeDefinition() != null)
	    astNode.getFormalPrivateTypeDefinition().accept(this, null);
	if (astNode.getFormalDerivedTypeDefinition() != null)
	    astNode.getFormalDerivedTypeDefinition().accept(this, null);
	if (astNode.getFormalDiscreteTypeDefinition() != null)
	    astNode.getFormalDiscreteTypeDefinition().accept(this, null);
	if (astNode.getFormalSignedIntegerTypeDefinition() != null)
	    astNode.getFormalSignedIntegerTypeDefinition().accept(this, null);
	if (astNode.getFormalModularTypeDefinition() != null)
	    astNode.getFormalModularTypeDefinition().accept(this, null);
	if (astNode.getFormalFloatingPointDefinition() != null)
	    astNode.getFormalFloatingPointDefinition().accept(this, null);
	if (astNode.getFormalOrdinaryFixedPointDefinition() != null)
	    astNode.getFormalOrdinaryFixedPointDefinition().accept(this, null);
	if (astNode.getFormalDecimalFixedPointDefinition() != null)
	    astNode.getFormalDecimalFixedPointDefinition().accept(this, null);
	if (astNode.getFormalArrayTypeDefinition() != null)
	    astNode.getFormalArrayTypeDefinition().accept(this, null);
	if (astNode.getFormalAccessTypeDefinition() != null)
	    astNode.getFormalAccessTypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalPrivateTypeDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalDerivedTypeDefinition astNode, Object parameter) {
	if (astNode.getSubtypeMark() != null)
	    astNode.getSubtypeMark().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalDiscreteTypeDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalSignedIntegerTypeDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalModularTypeDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalFloatingPointDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalOrdinaryFixedPointDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalDecimalFixedPointDefinition astNode, Object parameter) {
	return null;
    }

    @Override
    public Object visit(FormalArrayTypeDefinition astNode, Object parameter) {
	if (astNode.getArrayTypeDefinition() != null)
	    astNode.getArrayTypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalAccessTypeDefinition astNode, Object parameter) {
	if (astNode.getAccessTypeDefinition() != null)
	    astNode.getAccessTypeDefinition().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalSubprogramDeclaration astNode, Object parameter) {
	if (astNode.getSubprogramSpecification() != null)
	    astNode.getSubprogramSpecification().accept(this, null);
	if (astNode.getSubprogramDefault() != null)
	    astNode.getSubprogramDefault().accept(this, null);
	return null;
    }

    @Override
    public Object visit(SubprogramDefault astNode, Object parameter) {
	if (astNode.getDefaultName() != null)
	    astNode.getDefaultName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(DefaultName astNode, Object parameter) {
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalPackageDeclaration astNode, Object parameter) {
	if (astNode.getDefiningIdentifier() != null)
	    astNode.getDefiningIdentifier().accept(this, null);
	if (astNode.getGenericPackageName() != null)
	    astNode.getGenericPackageName().accept(this, null);
	if (astNode.getFormalPackageActualPart() != null)
	    astNode.getFormalPackageActualPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FormalPackageActualPart astNode, Object parameter) {
	if (astNode.getGenericActualPart() != null)
	    astNode.getGenericActualPart().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AspectClause astNode, Object parameter) {
	if (astNode.getAttributeDefinitionClause() != null)
	    astNode.getAttributeDefinitionClause().accept(this, null);
	if (astNode.getEnumerationRepresentationClause() != null)
	    astNode.getEnumerationRepresentationClause().accept(this, null);
	if (astNode.getRecordRepresentationClause() != null)
	    astNode.getRecordRepresentationClause().accept(this, null);
	if (astNode.getAtClause() != null)
	    astNode.getAtClause().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LocalName astNode, Object parameter) {
	if (astNode.getDirectName() != null)
	    astNode.getDirectName().accept(this, null);
	if (astNode.getAttributeDesignator() != null)
	    astNode.getAttributeDesignator().accept(this, null);
	if (astNode.getLibraryUnitName() != null)
	    astNode.getLibraryUnitName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(AttributeDefinitionClause astNode, Object parameter) {
	if (astNode.getLocalName() != null)
	    astNode.getLocalName().accept(this, null);
	if (astNode.getAttributeDesignator() != null)
	    astNode.getAttributeDesignator().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	if (astNode.getName() != null)
	    astNode.getName().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EnumerationRepresentationClause astNode, Object parameter) {
	if (astNode.getFirstSubtypeLocalName() != null)
	    astNode.getFirstSubtypeLocalName().accept(this, null);
	if (astNode.getEnumerationAggregate() != null)
	    astNode.getEnumerationAggregate().accept(this, null);
	return null;
    }

    @Override
    public Object visit(EnumerationAggregate astNode, Object parameter) {
	if (astNode.getArrayAggregate() != null)
	    astNode.getArrayAggregate().accept(this, null);
	return null;
    }

    @Override
    public Object visit(RecordRepresentationClause astNode, Object parameter) {
	if (astNode.getFirstSubtypeLocalName() != null)
	    astNode.getFirstSubtypeLocalName().accept(this, null);
	if (astNode.getModClause() != null)
	    astNode.getModClause().accept(this, null);
	for (ComponentClause astChild : astNode.getComponentClauses())
	    astChild.accept(this, null);
	return null;
    }

    @Override
    public Object visit(ComponentClause astNode, Object parameter) {
	if (astNode.getComponentLocalName() != null)
	    astNode.getComponentLocalName().accept(this, null);
	if (astNode.getPosition() != null)
	    astNode.getPosition().accept(this, null);
	if (astNode.getFirstBit() != null)
	    astNode.getFirstBit().accept(this, null);
	if (astNode.getLastBit() != null)
	    astNode.getLastBit().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Position astNode, Object parameter) {
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(FirstBit astNode, Object parameter) {
	if (astNode.getSimpleExpression() != null)
	    astNode.getSimpleExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(LastBit astNode, Object parameter) {
	if (astNode.getSimpleExpression() != null)
	    astNode.getSimpleExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(CodeStatement astNode, Object parameter) {
	if (astNode.getQualifiedExpression() != null)
	    astNode.getQualifiedExpression().accept(this, null);
	return null;
    }

    @Override
    public Object visit(Restriction astNode, Object parameter) {
	if (astNode.getIdentifier() != null)
	    astNode.getIdentifier().accept(this, null);
	if (astNode.getExpression() != null)
	    astNode.getExpression().accept(this, null);
	return null;
    }

}
