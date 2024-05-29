package visitor;

import ast.lexicalElements.*;
import ast.namesAndExpressions.*;
import ast.visibilityRules.*;
import ast.statements.*;
import ast.declarationsAndTypes.*;
import ast.packages.*;
import ast.tasksAndSynchronization.*;
import ast.exceptions.*;
import ast.programStructureAndCompilationIssues.*;
import ast.subprograms.*;
import ast.others.*;
import ast.genericUnits.*;
import ast.representationIssues.*;

/**
 * Ada95Visitor auto-generated
 * 
 * @author ial.navy@protonmail.ch
 * @version 2024-05-29 16:35
 */
public interface Ada95Visitor<T> {

	// lexicalElements
	public T visit(Identifier astNode, T parameter);
	public T visit(NumericLiteral astNode, T parameter);
	public T visit(CharacterLiteral astNode, T parameter);
	public T visit(StringLiteral astNode, T parameter);

	// namesAndExpressions
	public T visit(Name astNode, T parameter);
	public T visit(DirectName astNode, T parameter);
	public T visit(SelectorName astNode, T parameter);
	public T visit(AttributeDesignator astNode, T parameter);
	public T visit(RangeAttributeReference astNode, T parameter);
	public T visit(RangeAttributeDesignator astNode, T parameter);
	public T visit(Aggregate astNode, T parameter);
	public T visit(RecordAggregate astNode, T parameter);
	public T visit(RecordComponentAssociationList astNode, T parameter);
	public T visit(RecordComponentAssociation astNode, T parameter);
	public T visit(ComponentChoiceList astNode, T parameter);
	public T visit(ExtensionAggregate astNode, T parameter);
	public T visit(AncestorPart astNode, T parameter);
	public T visit(ArrayAggregate astNode, T parameter);
	public T visit(PositionalArrayAggregate astNode, T parameter);
	public T visit(NamedArrayAggregate astNode, T parameter);
	public T visit(ArrayComponentAssociation astNode, T parameter);
	public T visit(Expression astNode, T parameter);
	public T visit(Relation astNode, T parameter);
	public T visit(SimpleExpression astNode, T parameter);
	public T visit(Term astNode, T parameter);
	public T visit(Factor astNode, T parameter);
	public T visit(Primary astNode, T parameter);
	public T visit(LogicalOperator astNode, T parameter);
	public T visit(RelationalOperator astNode, T parameter);
	public T visit(BinaryAddingOperator astNode, T parameter);
	public T visit(UnaryAddingOperator astNode, T parameter);
	public T visit(MultiplyingOperator astNode, T parameter);
	public T visit(HighestPrecedenceOperator astNode, T parameter);
	public T visit(QualifiedExpression astNode, T parameter);
	public T visit(Allocator astNode, T parameter);

	// visibilityRules
	public T visit(UseClause astNode, T parameter);
	public T visit(UsePackageClause astNode, T parameter);
	public T visit(UseTypeClause astNode, T parameter);
	public T visit(RenamingDeclaration astNode, T parameter);
	public T visit(ObjectRenamingDeclaration astNode, T parameter);
	public T visit(ExceptionRenamingDeclaration astNode, T parameter);
	public T visit(PackageRenamingDeclaration astNode, T parameter);
	public T visit(SubprogramRenamingDeclaration astNode, T parameter);
	public T visit(GenericRenamingDeclaration astNode, T parameter);

	// statements
	public T visit(SequenceOfStatements astNode, T parameter);
	public T visit(Statement astNode, T parameter);
	public T visit(SimpleStatement astNode, T parameter);
	public T visit(CompoundStatement astNode, T parameter);
	public T visit(NullStatement astNode, T parameter);
	public T visit(Label astNode, T parameter);
	public T visit(StatementIdentifier astNode, T parameter);
	public T visit(AssignmentStatement astNode, T parameter);
	public T visit(IfStatement astNode, T parameter);
	public T visit(Condition astNode, T parameter);
	public T visit(CaseStatement astNode, T parameter);
	public T visit(CaseStatementAlternative astNode, T parameter);
	public T visit(LoopStatement astNode, T parameter);
	public T visit(IterationScheme astNode, T parameter);
	public T visit(LoopParameterSpecification astNode, T parameter);
	public T visit(BlockStatement astNode, T parameter);
	public T visit(ExitStatement astNode, T parameter);
	public T visit(GotoStatement astNode, T parameter);

	// declarationsAndTypes
	public T visit(BasicDeclaration astNode, T parameter);
	public T visit(DefiningIdentifier astNode, T parameter);
	public T visit(TypeDeclaration astNode, T parameter);
	public T visit(FullTypeDeclaration astNode, T parameter);
	public T visit(TypeDefinition astNode, T parameter);
	public T visit(SubtypeDeclaration astNode, T parameter);
	public T visit(SubtypeIndication astNode, T parameter);
	public T visit(Constraint astNode, T parameter);
	public T visit(ScalarConstraint astNode, T parameter);
	public T visit(CompositeConstraint astNode, T parameter);
	public T visit(ObjectDeclaration astNode, T parameter);
	public T visit(DefiningIdentifierList astNode, T parameter);
	public T visit(NumberDeclaration astNode, T parameter);
	public T visit(DerivedTypeDefinition astNode, T parameter);
	public T visit(RangeConstraint astNode, T parameter);
	public T visit(Range astNode, T parameter);
	public T visit(EnumerationTypeDefinition astNode, T parameter);
	public T visit(EnumerationLiteralSpecification astNode, T parameter);
	public T visit(DefiningCharacterLiteral astNode, T parameter);
	public T visit(IntegerTypeDefinition astNode, T parameter);
	public T visit(SignedIntegerTypeDefinition astNode, T parameter);
	public T visit(ModularTypeDefinition astNode, T parameter);
	public T visit(RealTypeDefinition astNode, T parameter);
	public T visit(FloatingPointDefinition astNode, T parameter);
	public T visit(RealRangeSpecification astNode, T parameter);
	public T visit(FixedPointDefinition astNode, T parameter);
	public T visit(OrdinaryFixedPointDefinition astNode, T parameter);
	public T visit(DecimalFixedPointDefinition astNode, T parameter);
	public T visit(DigitsConstraint astNode, T parameter);
	public T visit(ArrayTypeDefinition astNode, T parameter);
	public T visit(UnconstrainedArrayDefinition astNode, T parameter);
	public T visit(IndexSubtypeDefinition astNode, T parameter);
	public T visit(ConstrainedArrayDefinition astNode, T parameter);
	public T visit(DiscreteSubtypeDefinition astNode, T parameter);
	public T visit(ComponentDefinition astNode, T parameter);
	public T visit(IndexConstraint astNode, T parameter);
	public T visit(DiscreteRange astNode, T parameter);
	public T visit(DiscriminantPart astNode, T parameter);
	public T visit(UnknownDiscriminantPart astNode, T parameter);
	public T visit(KnownDiscriminantPart astNode, T parameter);
	public T visit(DiscriminantSpecification astNode, T parameter);
	public T visit(DefaultExpression astNode, T parameter);
	public T visit(DiscriminantConstraint astNode, T parameter);
	public T visit(DiscriminantAssociation astNode, T parameter);
	public T visit(RecordTypeDefinition astNode, T parameter);
	public T visit(RecordDefinition astNode, T parameter);
	public T visit(ComponentList astNode, T parameter);
	public T visit(ComponentItem astNode, T parameter);
	public T visit(ComponentDeclaration astNode, T parameter);
	public T visit(VariantPart astNode, T parameter);
	public T visit(Variant astNode, T parameter);
	public T visit(DiscreteChoiceList astNode, T parameter);
	public T visit(DiscreteChoice astNode, T parameter);
	public T visit(RecordExtensionPart astNode, T parameter);
	public T visit(AccessTypeDefinition astNode, T parameter);
	public T visit(AccessToObjectDefinition astNode, T parameter);
	public T visit(GeneralAccessModifier astNode, T parameter);
	public T visit(AccessToSubprogramDefinition astNode, T parameter);
	public T visit(AccessDefinition astNode, T parameter);
	public T visit(IncompleteTypeDeclaration astNode, T parameter);
	public T visit(DeclarativePart astNode, T parameter);
	public T visit(DeclarativeItem astNode, T parameter);
	public T visit(BasicDeclarativeItem astNode, T parameter);
	public T visit(Body astNode, T parameter);
	public T visit(ProperBody astNode, T parameter);

	// packages
	public T visit(PackageDeclaration astNode, T parameter);
	public T visit(PackageSpecification astNode, T parameter);
	public T visit(PackageBody astNode, T parameter);
	public T visit(PrivateTypeDeclaration astNode, T parameter);
	public T visit(PrivateExtensionDeclaration astNode, T parameter);

	// tasksAndSynchronization
	public T visit(TaskTypeDeclaration astNode, T parameter);
	public T visit(SingleTaskDeclaration astNode, T parameter);
	public T visit(TaskDefinition astNode, T parameter);
	public T visit(TaskItem astNode, T parameter);
	public T visit(TaskBody astNode, T parameter);
	public T visit(ProtectedTypeDeclaration astNode, T parameter);
	public T visit(SingleProtectedDeclaration astNode, T parameter);
	public T visit(ProtectedDefinition astNode, T parameter);
	public T visit(ProtectedOperationDeclaration astNode, T parameter);
	public T visit(ProtectedElementDeclaration astNode, T parameter);
	public T visit(ProtectedBody astNode, T parameter);
	public T visit(ProtectedOperationItem astNode, T parameter);
	public T visit(EntryDeclaration astNode, T parameter);
	public T visit(AcceptStatement astNode, T parameter);
	public T visit(EntryIndex astNode, T parameter);
	public T visit(EntryBody astNode, T parameter);
	public T visit(EntryBodyFormalPart astNode, T parameter);
	public T visit(EntryBarrier astNode, T parameter);
	public T visit(EntryIndexSpecification astNode, T parameter);
	public T visit(EntryCallStatement astNode, T parameter);
	public T visit(RequeueStatement astNode, T parameter);
	public T visit(DelayStatement astNode, T parameter);
	public T visit(DelayUntilStatement astNode, T parameter);
	public T visit(DelayRelativeStatement astNode, T parameter);
	public T visit(SelectStatement astNode, T parameter);
	public T visit(SelectiveAccept astNode, T parameter);
	public T visit(Guard astNode, T parameter);
	public T visit(SelectAlternative astNode, T parameter);
	public T visit(AcceptAlternative astNode, T parameter);
	public T visit(DelayAlternative astNode, T parameter);
	public T visit(TerminateAlternative astNode, T parameter);
	public T visit(TimedEntryCall astNode, T parameter);
	public T visit(EntryCallAlternative astNode, T parameter);
	public T visit(ConditionalEntryCall astNode, T parameter);
	public T visit(AsynchronousSelect astNode, T parameter);
	public T visit(TriggeringAlternative astNode, T parameter);
	public T visit(TriggeringStatement astNode, T parameter);
	public T visit(AbortablePart astNode, T parameter);
	public T visit(AbortStatement astNode, T parameter);

	// exceptions
	public T visit(ExceptionDeclaration astNode, T parameter);
	public T visit(HandledSequenceOfStatements astNode, T parameter);
	public T visit(ExceptionHandler astNode, T parameter);
	public T visit(ChoiceParameterSpecification astNode, T parameter);
	public T visit(ExceptionChoice astNode, T parameter);
	public T visit(RaiseStatement astNode, T parameter);

	// programStructureAndCompilationIssues
	public T visit(Compilation astNode, T parameter);
	public T visit(CompilationUnit astNode, T parameter);
	public T visit(LibraryItem astNode, T parameter);
	public T visit(LibraryUnitDeclaration astNode, T parameter);
	public T visit(LibraryUnitRenamingDeclaration astNode, T parameter);
	public T visit(LibraryUnitBody astNode, T parameter);
	public T visit(ParentUnitName astNode, T parameter);
	public T visit(ContextClause astNode, T parameter);
	public T visit(ContextItem astNode, T parameter);
	public T visit(WithClause astNode, T parameter);
	public T visit(BodyStub astNode, T parameter);
	public T visit(SubprogramBodyStub astNode, T parameter);
	public T visit(PackageBodyStub astNode, T parameter);
	public T visit(TaskBodyStub astNode, T parameter);
	public T visit(ProtectedBodyStub astNode, T parameter);
	public T visit(Subunit astNode, T parameter);

	// subprograms
	public T visit(SubprogramDeclaration astNode, T parameter);
	public T visit(AbstractSubprogramDeclaration astNode, T parameter);
	public T visit(SubprogramSpecification astNode, T parameter);
	public T visit(Designator astNode, T parameter);
	public T visit(DefiningDesignator astNode, T parameter);
	public T visit(DefiningProgramUnitName astNode, T parameter);
	public T visit(OperatorSymbol astNode, T parameter);
	public T visit(DefiningOperatorSymbol astNode, T parameter);
	public T visit(ParameterProfile astNode, T parameter);
	public T visit(ParameterAndResultProfile astNode, T parameter);
	public T visit(FormalPart astNode, T parameter);
	public T visit(ParameterSpecification astNode, T parameter);
	public T visit(Mode astNode, T parameter);
	public T visit(SubprogramBody astNode, T parameter);
	public T visit(ProcedureCallStatement astNode, T parameter);
	public T visit(ActualParameterPart astNode, T parameter);
	public T visit(ParameterAssociation astNode, T parameter);
	public T visit(ExplicitActualParameter astNode, T parameter);
	public T visit(ReturnStatement astNode, T parameter);

	// others
	public T visit(AtClause astNode, T parameter);
	public T visit(DeltaConstraint astNode, T parameter);
	public T visit(ModClause astNode, T parameter);
	public T visit(BooleanExpression astNode, T parameter);

	// genericUnits
	public T visit(GenericDeclaration astNode, T parameter);
	public T visit(GenericSubprogramDeclaration astNode, T parameter);
	public T visit(GenericPackageDeclaration astNode, T parameter);
	public T visit(GenericFormalPart astNode, T parameter);
	public T visit(GenericFormalParameterDeclaration astNode, T parameter);
	public T visit(GenericInstantiation astNode, T parameter);
	public T visit(GenericActualPart astNode, T parameter);
	public T visit(GenericAssociation astNode, T parameter);
	public T visit(ExplicitGenericActualParameter astNode, T parameter);
	public T visit(FormalObjectDeclaration astNode, T parameter);
	public T visit(FormalTypeDeclaration astNode, T parameter);
	public T visit(FormalTypeDefinition astNode, T parameter);
	public T visit(FormalPrivateTypeDefinition astNode, T parameter);
	public T visit(FormalDerivedTypeDefinition astNode, T parameter);
	public T visit(FormalDiscreteTypeDefinition astNode, T parameter);
	public T visit(FormalSignedIntegerTypeDefinition astNode, T parameter);
	public T visit(FormalModularTypeDefinition astNode, T parameter);
	public T visit(FormalFloatingPointDefinition astNode, T parameter);
	public T visit(FormalOrdinaryFixedPointDefinition astNode, T parameter);
	public T visit(FormalDecimalFixedPointDefinition astNode, T parameter);
	public T visit(FormalArrayTypeDefinition astNode, T parameter);
	public T visit(FormalAccessTypeDefinition astNode, T parameter);
	public T visit(FormalSubprogramDeclaration astNode, T parameter);
	public T visit(SubprogramDefault astNode, T parameter);
	public T visit(DefaultName astNode, T parameter);
	public T visit(FormalPackageDeclaration astNode, T parameter);
	public T visit(FormalPackageActualPart astNode, T parameter);

	// representationIssues
	public T visit(AspectClause astNode, T parameter);
	public T visit(LocalName astNode, T parameter);
	public T visit(AttributeDefinitionClause astNode, T parameter);
	public T visit(EnumerationRepresentationClause astNode, T parameter);
	public T visit(EnumerationAggregate astNode, T parameter);
	public T visit(RecordRepresentationClause astNode, T parameter);
	public T visit(ComponentClause astNode, T parameter);
	public T visit(Position astNode, T parameter);
	public T visit(FirstBit astNode, T parameter);
	public T visit(LastBit astNode, T parameter);
	public T visit(CodeStatement astNode, T parameter);
	public T visit(Restriction astNode, T parameter);
}
