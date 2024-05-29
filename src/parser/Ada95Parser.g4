/*
Ada 95 grammar.
The MIT License (MIT).

Copyright (c) 2022, Michał Lorek.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

parser grammar Ada95Parser;

options {
    tokenVocab = Ada95Lexer;
}

@parser::header {
import ast.*;
import ast.declarationsAndTypes.*;
import ast.exceptions.*;
import ast.genericUnits.*;
import ast.lexicalElements.*;
import ast.namesAndExpressions.*;
import ast.others.*;
import ast.packages.*;
import ast.programStructureAndCompilationIssues.*;
import ast.representationIssues.*;
import ast.statements.*;
import ast.subprograms.*;
import ast.tasksAndSynchronization.*;
import ast.visibilityRules.*;
}

/*
2 - Lexical Elements
*/

identifier returns [Identifier ast]
    : IDENTIFIER_
        {$ast = new Identifier($IDENTIFIER_);}
    ;

numeric_literal returns [NumericLiteral ast]
    : NUMERIC_LITERAL_
        {$ast = new NumericLiteral($NUMERIC_LITERAL_);}
    ;

character_literal returns [CharacterLiteral ast]
    : CHARACTER_LITERAL
        {$ast = new CharacterLiteral($CHARACTER_LITERAL);}
    ;

string_literal returns [StringLiteral ast]
    : STRING_LITERAL_
        {$ast = new StringLiteral($STRING_LITERAL_);}
    ;

/*
3 - Declarations and Types
*/

basic_declaration returns [BasicDeclaration ast]
    : type_declaration
        {$ast = new BasicDeclaration($type_declaration.ast);}
    | subtype_declaration
        {$ast = new BasicDeclaration($subtype_declaration.ast);}
    | object_declaration
        {$ast = new BasicDeclaration($object_declaration.ast);}
    | number_declaration
        {$ast = new BasicDeclaration($number_declaration.ast);}
    | subprogram_declaration
        {$ast = new BasicDeclaration($subprogram_declaration.ast);}
    | abstract_subprogram_declaration
        {$ast = new BasicDeclaration($abstract_subprogram_declaration.ast);}
    | package_declaration
        {$ast = new BasicDeclaration($package_declaration.ast);}
    | renaming_declaration
        {$ast = new BasicDeclaration($renaming_declaration.ast);}
    | exception_declaration
        {$ast = new BasicDeclaration($exception_declaration.ast);}
    | generic_declaration
        {$ast = new BasicDeclaration($generic_declaration.ast);}
    | generic_instantiation
        {$ast = new BasicDeclaration($generic_instantiation.ast);}
    ;

defining_identifier returns [DefiningIdentifier ast]
    : identifier
        {$ast = new DefiningIdentifier($identifier.ast);}
    ;

type_declaration returns [TypeDeclaration ast]
    : full_type_declaration
        {$ast = new TypeDeclaration($full_type_declaration.ast);}
    | incomplete_type_declaration
        {$ast = new TypeDeclaration($incomplete_type_declaration.ast);}
    | private_type_declaration
        {$ast = new TypeDeclaration($private_type_declaration.ast);}
    | private_extension_declaration
        {$ast = new TypeDeclaration($private_extension_declaration.ast);}
    ;

full_type_declaration returns [FullTypeDeclaration ast]
    : TYPE defining_identifier known_discriminant_part? IS type_definition ';'
        {$ast = new FullTypeDeclaration($defining_identifier.ast, $ctx.known_discriminant_part != null ? $known_discriminant_part.ast : null, $type_definition.ast);}
    | task_type_declaration
        {$ast = new FullTypeDeclaration($task_type_declaration.ast);}
    | protected_type_declaration
        {$ast = new FullTypeDeclaration($protected_type_declaration.ast);}
    ;

type_definition returns [TypeDefinition ast]
    : enumeration_type_definition
        {$ast = new TypeDefinition($enumeration_type_definition.ast);}
    | integer_type_definition
        {$ast = new TypeDefinition($integer_type_definition.ast);}
    | real_type_definition
        {$ast = new TypeDefinition($real_type_definition.ast);}
    | array_type_definition
        {$ast = new TypeDefinition($array_type_definition.ast);}
    | record_type_definition
        {$ast = new TypeDefinition($record_type_definition.ast);}
    | access_type_definition
        {$ast = new TypeDefinition($access_type_definition.ast);}
    | derived_type_definition
        {$ast = new TypeDefinition($derived_type_definition.ast);}
    ;

subtype_declaration returns [SubtypeDeclaration ast]
    : SUBTYPE defining_identifier IS subtype_indication ';'
        {$ast = new SubtypeDeclaration($defining_identifier.ast, $subtype_indication.ast);}
    ;

subtype_indication returns [SubtypeIndication ast]
    : subtype_mark = name constraint?
        {$ast = new SubtypeIndication($name.ast, $ctx.constraint != null ? $constraint.ast : null);}
    ;

constraint returns [Constraint ast]
    : scalar_constraint
        {$ast = new Constraint($scalar_constraint.ast);}
    | composite_constraint
        {$ast = new Constraint($composite_constraint.ast);}
    ;

scalar_constraint returns [ScalarConstraint ast]
    : range_constraint
        {$ast = new ScalarConstraint($range_constraint.ast);}
    | digits_constraint
        {$ast = new ScalarConstraint($digits_constraint.ast);}
    | delta_constraint
        {$ast = new ScalarConstraint($delta_constraint.ast);}
    ;

composite_constraint returns [CompositeConstraint ast]
    : index_constraint
        {$ast = new CompositeConstraint($index_constraint.ast);}
    | discriminant_constraint
        {$ast = new CompositeConstraint($discriminant_constraint.ast);}
    ;

object_declaration returns [ObjectDeclaration ast]
    : defining_identifier_list ':' ALIASED? CONSTANT? subtype_indication (':=' expression)? ';'
        {$ast = new ObjectDeclaration($defining_identifier_list.ast, $subtype_indication.ast, $ctx.expression != null ? $expression.ast : null, $ctx.ALIASED != null ? $ALIASED : null, $ctx.CONSTANT != null ? $CONSTANT : null);}
    | defining_identifier_list ':' ALIASED? CONSTANT? array_type_definition (':=' expression)? ';'
        {$ast = new ObjectDeclaration($defining_identifier_list.ast, $array_type_definition.ast, $ctx.expression != null ? $expression.ast : null, $ctx.ALIASED != null ? $ALIASED : null, $ctx.CONSTANT != null ? $CONSTANT : null);}
    | single_task_declaration
        {$ast = new ObjectDeclaration($single_task_declaration.ast);}
    | single_protected_declaration
        {$ast = new ObjectDeclaration($single_protected_declaration.ast);}
    ;

defining_identifier_list returns [DefiningIdentifierList ast]
    : defining_identifiers
        {$ast = new DefiningIdentifierList($defining_identifiers.list);}
    ;

defining_identifiers returns [List<DefiningIdentifier> list = new ArrayList<>()]
    : defining_identifier {$list.add($defining_identifier.ast);} (',' defining_identifier {$list.add($defining_identifier.ast);})*
    ;

number_declaration returns [NumberDeclaration ast]
    : defining_identifier_list ':' CONSTANT ':=' static_expression = expression ';'
        {$ast = new NumberDeclaration($defining_identifier_list.ast, $static_expression.ast);}
    ;

derived_type_definition returns [DerivedTypeDefinition ast]
    : ABSTRACT? NEW parent_subtype_indication = subtype_indication record_extension_part?
        {$ast = new DerivedTypeDefinition($parent_subtype_indication.ast, $ctx.record_extension_part != null ? $record_extension_part.ast : null, $ctx.ABSTRACT != null ? $ABSTRACT : null);}
    ;

range_constraint returns [RangeConstraint ast]
    : RANGE_ range
        {$ast = new RangeConstraint($range.ast);}
    ;

range returns [Range ast]
    : range_attribute_reference
        {$ast = new Range($range_attribute_reference.ast);}
    | left_simple_expression = simple_expression '..' right_simple_expression = simple_expression
        {$ast = new Range($left_simple_expression.ast, $right_simple_expression.ast);}
    ;

enumeration_type_definition returns [EnumerationTypeDefinition ast]
    : '(' enumeration_literal_specifications ')'
        {$ast = new EnumerationTypeDefinition($enumeration_literal_specifications.list);}
    ;

enumeration_literal_specifications returns [List<EnumerationLiteralSpecification> list = new ArrayList<>()]
    : enumeration_literal_specification {$list.add($enumeration_literal_specification.ast);} (',' enumeration_literal_specification {$list.add($enumeration_literal_specification.ast);})*
    ;

enumeration_literal_specification returns [EnumerationLiteralSpecification ast]
    : defining_identifier
        {$ast = new EnumerationLiteralSpecification($defining_identifier.ast);}
    | defining_character_literal
        {$ast = new EnumerationLiteralSpecification($defining_character_literal.ast);}
    ;

defining_character_literal returns [DefiningCharacterLiteral ast]
    : character_literal
        {$ast = new DefiningCharacterLiteral($character_literal.ast);}
    ;

integer_type_definition returns [IntegerTypeDefinition ast]
    : signed_integer_type_definition
        {$ast = new IntegerTypeDefinition($signed_integer_type_definition.ast);}
    | modular_type_definition
        {$ast = new IntegerTypeDefinition($modular_type_definition.ast);}
    ;

signed_integer_type_definition returns [SignedIntegerTypeDefinition ast]
    : RANGE_ left_static_simple_expression = simple_expression '..' right_static_simple_expression = simple_expression
        {$ast = new SignedIntegerTypeDefinition($left_static_simple_expression.ast, $right_static_simple_expression.ast);}
    ;

modular_type_definition returns [ModularTypeDefinition ast]
    : MOD static_expression = expression
        {$ast = new ModularTypeDefinition($static_expression.ast);}
    ;

real_type_definition returns [RealTypeDefinition ast]
    : floating_point_definition
        {$ast = new RealTypeDefinition($floating_point_definition.ast);}
    | fixed_point_definition
        {$ast = new RealTypeDefinition($fixed_point_definition.ast);}
    ;

floating_point_definition returns [FloatingPointDefinition ast]
    : DIGITS static_expression = expression real_range_specification?
        {$ast = new FloatingPointDefinition($static_expression.ast, $ctx.real_range_specification != null ? $real_range_specification.ast : null);}
    ;

real_range_specification returns [RealRangeSpecification ast]
    : range left_static_simple_expression = simple_expression '..' right_static_simple_expression = simple_expression
        {$ast = new RealRangeSpecification($range.ast, $left_static_simple_expression.ast, $right_static_simple_expression.ast);}
    ;

fixed_point_definition returns [FixedPointDefinition ast]
    : ordinary_fixed_point_definition
        {$ast = new FixedPointDefinition($ordinary_fixed_point_definition.ast);}
    | decimal_fixed_point_definition
        {$ast = new FixedPointDefinition($decimal_fixed_point_definition.ast);}
    ;

ordinary_fixed_point_definition returns [OrdinaryFixedPointDefinition ast]
    : DELTA static_expression = expression real_range_specification
        {$ast = new OrdinaryFixedPointDefinition($static_expression.ast, $real_range_specification.ast);}
    ;

decimal_fixed_point_definition returns [DecimalFixedPointDefinition ast]
    : DELTA delta_static_expression = expression DIGITS digits_static_expression = expression real_range_specification?
        {$ast = new DecimalFixedPointDefinition($delta_static_expression.ast, $digits_static_expression.ast, $ctx.real_range_specification != null ? $real_range_specification.ast : null);}
    ;

digits_constraint returns [DigitsConstraint ast]
    : DIGITS static_expression = expression range_constraint?
        {$ast = new DigitsConstraint($static_expression.ast, $ctx.range_constraint != null ? $range_constraint.ast : null);}
    ;

array_type_definition returns [ArrayTypeDefinition ast]
    : unconstrained_array_definition
        {$ast = new ArrayTypeDefinition($unconstrained_array_definition.ast);}
    | constrained_array_definition
        {$ast = new ArrayTypeDefinition($constrained_array_definition.ast);}
    ;

unconstrained_array_definition returns [UnconstrainedArrayDefinition ast]
    : ARRAY '(' index_subtype_definitions ')' OF component_definition
        {$ast = new UnconstrainedArrayDefinition($index_subtype_definitions.list, $component_definition.ast);}
    ;

index_subtype_definitions returns [List<IndexSubtypeDefinition> list = new ArrayList<>()]
    : index_subtype_definition {$list.add($index_subtype_definition.ast);} (',' index_subtype_definition {$list.add($index_subtype_definition.ast);})*
    ;

index_subtype_definition returns [IndexSubtypeDefinition ast]
    : subtype_mark = name range '<>'
        {$ast = new IndexSubtypeDefinition($subtype_mark.ast, $range.ast);}
    ;

constrained_array_definition returns [ConstrainedArrayDefinition ast]
    : ARRAY '(' discrete_subtype_definitions ')' OF component_definition
        {$ast = new ConstrainedArrayDefinition($discrete_subtype_definitions.list, $component_definition.ast);}
    ;

discrete_subtype_definitions returns [List<DiscreteSubtypeDefinition> list = new ArrayList<>()]
    : discrete_subtype_definition {$list.add($discrete_subtype_definition.ast);} (',' discrete_subtype_definition {$list.add($discrete_subtype_definition.ast);})*
    ;

discrete_subtype_definition returns [DiscreteSubtypeDefinition ast]
    : discrete_subtype_indication = subtype_indication
        {$ast = new DiscreteSubtypeDefinition($discrete_subtype_indication.ast);}
    | range
        {$ast = new DiscreteSubtypeDefinition($range.ast);}
    ;

component_definition returns [ComponentDefinition ast]
    : ALIASED? subtype_indication
        {$ast = new ComponentDefinition($subtype_indication.ast, $ctx.ALIASED != null ? $ALIASED : null);}
    ;

index_constraint returns [IndexConstraint ast]
    : '(' discrete_ranges ')'
        {$ast = new IndexConstraint($discrete_ranges.list);}
    ;

discrete_ranges returns [List<DiscreteRange> list = new ArrayList<>()]
    : discrete_range {$list.add($discrete_range.ast);} (',' discrete_range {$list.add($discrete_range.ast);})*
    ;

discrete_range returns [DiscreteRange ast]
    : discrete_subtype_indication = subtype_indication
        {$ast = new DiscreteRange($discrete_subtype_indication.ast);}
    | range
        {$ast = new DiscreteRange($range.ast);}
    ;

discriminant_part returns [DiscriminantPart ast]
    : unknown_discriminant_part
        {$ast = new DiscriminantPart($unknown_discriminant_part.ast);}
    | known_discriminant_part
        {$ast = new DiscriminantPart($known_discriminant_part.ast);}
    ;

unknown_discriminant_part returns [UnknownDiscriminantPart ast]
    : '(' '<>' ')'
        {$ast = new UnknownDiscriminantPart();}
    ;

known_discriminant_part returns [KnownDiscriminantPart ast]
    : '(' discriminant_specifications ')'
        {$ast = new KnownDiscriminantPart($discriminant_specifications.list);}
    ;

discriminant_specifications returns [List<DiscriminantSpecification> list = new ArrayList<>()]
    : discriminant_specification {$list.add($discriminant_specification.ast);} (';' discriminant_specification {$list.add($discriminant_specification.ast);})*
    ;

discriminant_specification returns [DiscriminantSpecification ast]
    : defining_identifier_list ':' subtype_mark = name (':=' default_expression)?
        {$ast = new DiscriminantSpecification($defining_identifier_list.ast, $subtype_mark.ast, $ctx.default_expression != null ? $default_expression.ast : null);}
    | defining_identifier_list ':' access_definition (':=' default_expression)?
        {$ast = new DiscriminantSpecification($defining_identifier_list.ast, $access_definition.ast, $ctx.default_expression != null ? $default_expression.ast : null);}
    ;

default_expression returns [DefaultExpression ast]
    : expression
        {$ast = new DefaultExpression($expression.ast);}
    ;

discriminant_constraint returns [DiscriminantConstraint ast]
    : '(' discriminant_associations ')'
        {$ast = new DiscriminantConstraint($discriminant_associations.list);}
    ;

discriminant_associations returns [List<DiscriminantAssociation> list = new ArrayList<>()]
    : discriminant_association {$list.add($discriminant_association.ast);} (',' discriminant_association {$list.add($discriminant_association.ast);})*
    ;

discriminant_selector_names returns [List<SelectorName> list = new ArrayList<>()]
    : discriminant_selector_name = selector_name {$list.add($discriminant_selector_name.ast);} ('|' discriminant_selector_name = selector_name {$list.add($discriminant_selector_name.ast);})*
    ;

discriminant_association returns [DiscriminantAssociation ast]
    : (discriminant_selector_names '=>')? expression
        {$ast = new DiscriminantAssociation($ctx.discriminant_selector_names != null ? $discriminant_selector_names.list : new ArrayList<>(), $expression.ast);}
    ;

record_type_definition returns [RecordTypeDefinition ast]
    : (ABSTRACT? TAGGED)? LIMITED? record_definition
        {$ast = new RecordTypeDefinition($record_definition.ast, $ctx.ABSTRACT != null ? $ABSTRACT : null, $ctx.TAGGED != null ? $TAGGED : null, $ctx.LIMITED != null ? $LIMITED : null);}
    ;

record_definition returns [RecordDefinition ast]
    : RECORD component_list END RECORD
        {$ast = new RecordDefinition($component_list.ast);}
    | NULL_ RECORD
        {$ast = new RecordDefinition();}
    ;

component_list returns [ComponentList ast]
    : {$ast = new ComponentList();} component_item {$ast.addComponentItem($component_item.ast);} (component_item {$ast.addComponentItem($component_item.ast);})*
    | {$ast = new ComponentList($variant_part.ast);} (component_item {$ast.addComponentItem($component_item.ast);})* variant_part
    | {$ast = new ComponentList();} NULL_ ';'
    ;

component_item returns [ComponentItem ast]
    : component_declaration
        {$ast = new ComponentItem($component_declaration.ast);}
    | aspect_clause
        {$ast = new ComponentItem($aspect_clause.ast);}
    ;

component_declaration returns [ComponentDeclaration ast]
    : defining_identifier_list ':' component_definition (':=' default_expression)? ';'
        {$ast = new ComponentDeclaration($defining_identifier_list.ast, $component_definition.ast, $ctx.default_expression != null ? $default_expression.ast : null);}
    ;

variant_part returns [VariantPart ast]
    : CASE discriminant_direct_name = direct_name IS variants END CASE ';'
        {$ast = new VariantPart($discriminant_direct_name.ast, $variants.list);}
    ;

variants returns [List<Variant> list = new ArrayList<>()]
    : variant {$list.add($variant.ast);} (variant {$list.add($variant.ast);})*
    ;

variant returns [Variant ast]
    : WHEN discrete_choice_list '=>' component_list
        {$ast = new Variant($discrete_choice_list.ast, $component_list.ast);}
    ;

discrete_choice_list returns [DiscreteChoiceList ast]
    : discrete_choices
        {$ast = new DiscreteChoiceList($discrete_choices.list);}
    ;

discrete_choices returns [List<DiscreteChoice> list = new ArrayList<>()]
    : discrete_choice {$list.add($discrete_choice.ast);} ('|' discrete_choice {$list.add($discrete_choice.ast);})*
    ;

discrete_choice returns [DiscreteChoice ast]
    : expression
        {$ast = new DiscreteChoice($expression.ast);}
    | discrete_range
        {$ast = new DiscreteChoice($discrete_range.ast);}
    | OTHERS
        {$ast = new DiscreteChoice();}
    ;

record_extension_part returns [RecordExtensionPart ast]
    : WITH record_definition
        {$ast = new RecordExtensionPart($record_definition.ast);}
    ;

access_type_definition returns [AccessTypeDefinition ast]
    : access_to_object_definition
        {$ast = new AccessTypeDefinition($access_to_object_definition.ast);}
    | access_to_subprogram_definition
        {$ast = new AccessTypeDefinition($access_to_subprogram_definition.ast);}
    ;

access_to_object_definition returns [AccessToObjectDefinition ast]
    : ACCESS general_access_modifier? subtype_indication
        {$ast = new AccessToObjectDefinition($ctx.general_access_modifier != null ? $general_access_modifier.ast : null, $subtype_indication.ast);}
    ;

general_access_modifier returns [GeneralAccessModifier ast]
    : ALL
        {$ast = new GeneralAccessModifier($ALL);}
    | CONSTANT
        {$ast = new GeneralAccessModifier($CONSTANT);}
    ;

access_to_subprogram_definition returns [AccessToSubprogramDefinition ast]
    : ACCESS PROTECTED? PROCEDURE parameter_profile
        {$ast = new AccessToSubprogramDefinition($parameter_profile.ast, $ctx.PROTECTED != null ? $PROTECTED : null);}
    | ACCESS PROTECTED? FUNCTION parameter_and_result_profile
        {$ast = new AccessToSubprogramDefinition($parameter_and_result_profile.ast, $ctx.PROTECTED != null ? $PROTECTED : null);}
    ;

access_definition returns [AccessDefinition ast]
    : ACCESS subtype_mark = name
        {$ast = new AccessDefinition($subtype_mark.ast);}
    ;

incomplete_type_declaration returns [IncompleteTypeDeclaration ast]
    : TYPE defining_identifier discriminant_part? ';'
        {$ast = new IncompleteTypeDeclaration($defining_identifier.ast, $ctx.discriminant_part != null ? $discriminant_part.ast : null);}
    ;

declarative_part returns [DeclarativePart ast]
    : declarative_items
        {$ast = new DeclarativePart($declarative_items.list);}
    ;

declarative_items returns [List<DeclarativeItem> list = new ArrayList<>()]
    : (declarative_item {$list.add($declarative_item.ast);})*
    ;

declarative_item returns [DeclarativeItem ast]
    : basic_declarative_item
        {$ast = new DeclarativeItem($basic_declarative_item.ast);}
    | body
        {$ast = new DeclarativeItem($body.ast);}
    ;

basic_declarative_item returns [BasicDeclarativeItem ast]
    : basic_declaration
        {$ast = new BasicDeclarativeItem($basic_declaration.ast);}
    | aspect_clause
        {$ast = new BasicDeclarativeItem($aspect_clause.ast);}
    | use_clause
        {$ast = new BasicDeclarativeItem($use_clause.ast);}
    ;

body returns [Body ast]
    : proper_body
        {$ast = new Body($proper_body.ast);}
    | body_stub
        {$ast = new Body($body_stub.ast);}
    ;

proper_body returns [ProperBody ast]
    : subprogram_body
        {$ast = new ProperBody($subprogram_body.ast);}
    | package_body
        {$ast = new ProperBody($package_body.ast);}
    | task_body
        {$ast = new ProperBody($task_body.ast);}
    | protected_body
        {$ast = new ProperBody($protected_body.ast);}
    ;

/*
4 - Names and Expressions
*/

name returns [Name ast]
    : direct_name
        {$ast = new Name($direct_name.ast);}
    | name '.' ALL
        {$ast = new Name($name.ast);}
    | prefix = name '(' expressions ')' //indexed_component
        {$ast = new Name($prefix.ast, $expressions.list);}
    | prefix = name '(' discrete_range ')'               //slice
        {$ast = new Name($prefix.ast, $discrete_range.ast);}
    | prefix = name '.' selector_name                    //selected_component
        {$ast = new Name($prefix.ast, $selector_name.ast);}
    | prefix = name SQ attribute_designator              //attribute_reference
        {$ast = new Name($prefix.ast, $attribute_designator.ast);}
    | subtype_mark = name '(' expression ')'
        {$ast = new Name($subtype_mark.ast, $expression.ast);}
    | subtype_mark = name '(' arg = name ')'
        {$ast = new Name($subtype_mark.ast, $arg.ast);}
    | function_prefix = name actual_parameter_part
        {$ast = new Name($function_prefix.ast, $actual_parameter_part.ast);}
    | character_literal
        {$ast = new Name($character_literal.ast);}
    ;

direct_name returns [DirectName ast]
    : identifier
        {$ast = new DirectName($identifier.ast);}
    | operator_symbol
        {$ast = new DirectName($operator_symbol.ast);}
    ;

selector_name returns [SelectorName ast]
    : identifier
        {$ast = new SelectorName($identifier.ast);}
    | character_literal
        {$ast = new SelectorName($character_literal.ast);}
    | operator_symbol
        {$ast = new SelectorName($operator_symbol.ast);}
    ;

attribute_designator returns [AttributeDesignator ast]
    : identifier ('(' static_expression = expression ')')?
        {$ast = new AttributeDesignator($identifier.ast, $ctx.static_expression != null ? $static_expression.ast : null);}
    | ACCESS
        {$ast = new AttributeDesignator($ACCESS);}
    | DELTA
        {$ast = new AttributeDesignator($DELTA);}
    | DIGITS
        {$ast = new AttributeDesignator($DIGITS);}
    ;

range_attribute_reference returns [RangeAttributeReference ast]
    : prefix = name SQ range_attribute_designator
        {$ast = new RangeAttributeReference($prefix.ast, $range_attribute_designator.ast);}
    ;

range_attribute_designator returns [RangeAttributeDesignator ast]
    : RANGE_ ('(' static_expression = expression ')')?
        {$ast = new RangeAttributeDesignator($ctx.expression != null ? $expression.ast : null);}
    ;

aggregate returns [Aggregate ast]
    : record_aggregate
        {$ast = new Aggregate($record_aggregate.ast);}
    | extension_aggregate
        {$ast = new Aggregate($extension_aggregate.ast);}
    | array_aggregate
        {$ast = new Aggregate($array_aggregate.ast);}
    ;

record_aggregate returns [RecordAggregate ast]
    : '(' record_component_association_list ')'
        {$ast = new RecordAggregate($record_component_association_list.ast);}
    ;

record_component_association_list returns [RecordComponentAssociationList ast]
    : record_component_associations
        {$ast = new RecordComponentAssociationList($record_component_associations.list);}
    | NULL_ RECORD
        {$ast = new RecordComponentAssociationList();}
    ;

record_component_associations returns [List<RecordComponentAssociation> list = new ArrayList<>()]
    : record_component_association {$list.add($record_component_association.ast);} (',' record_component_association {$list.add($record_component_association.ast);})*
    ;

record_component_association returns [RecordComponentAssociation ast]
    : (component_choice_list '=>')? expression
        {$ast = new RecordComponentAssociation($ctx.component_choice_list != null ? $component_choice_list.ast : null, $expression.ast);}
    ;

component_choice_list returns [ComponentChoiceList ast]
    : component_selector_names
        {$ast = new ComponentChoiceList($component_selector_names.list);}
    | OTHERS
        {$ast = new ComponentChoiceList();}
    ;

component_selector_names returns [List<SelectorName> list = new ArrayList<>()]
    : component_selector_name = selector_name {$list.add($component_selector_name.ast);} ('|' component_selector_name = selector_name {$list.add($component_selector_name.ast);})*
    ;

extension_aggregate returns [ExtensionAggregate ast]
    : '(' ancestor_part WITH record_component_association_list ')'
        {$ast = new ExtensionAggregate($ancestor_part.ast, $record_component_association_list.ast);}
    ;

ancestor_part returns [AncestorPart ast]
    : expression
        {$ast = new AncestorPart($expression.ast);}
    | subtype_mark = name
        {$ast = new AncestorPart($subtype_mark.ast);}
    ;

array_aggregate returns [ArrayAggregate ast]
    : positional_array_aggregate
        {$ast = new ArrayAggregate($positional_array_aggregate.ast);}
    | named_array_aggregate
        {$ast = new ArrayAggregate($named_array_aggregate.ast);}
    ;

positional_array_aggregate returns [PositionalArrayAggregate ast]
    : '(' {$ast = new PositionalArrayAggregate();} expression {$ast.addExpression($expression.ast);} ',' expression {$ast.addExpression($expression.ast);} (',' expression {$ast.addExpression($expression.ast);})* ')'
    | '(' {$ast = new PositionalArrayAggregate();} expression {$ast.addExpression($expression.ast);} (',' expression {$ast.addExpression($expression.ast);})* ',' OTHERS '=>' expression {$ast.setExpressionForOthersClause($expression.ast);} ')'
    ;

named_array_aggregate returns [NamedArrayAggregate ast]
    : '(' array_component_associations ')'
        {$ast = new NamedArrayAggregate($array_component_associations.list);}
    ;

array_component_associations returns [List<ArrayComponentAssociation> list = new ArrayList<>()]
    : array_component_association {$list.add($array_component_association.ast);} (',' array_component_association {$list.add($array_component_association.ast);})*
    ;

array_component_association returns [ArrayComponentAssociation ast]
    : discrete_choice_list '=>' expression
        {$ast = new ArrayComponentAssociation($discrete_choice_list.ast, $expression.ast);}
    ;

expressions returns [List<Expression> list = new ArrayList<>()]
    : expression {$list.add($expression.ast);} (',' expression {$list.add($expression.ast);})*
    ;

expression returns [Expression ast]
    : {$ast = new Expression();} relation {$ast.addRelation($relation.ast);} (AND {$ast.setToken1($AND);} relation {$ast.addRelation($relation.ast);})*
    | {$ast = new Expression();} relation {$ast.addRelation($relation.ast);} (AND {$ast.setToken1($AND);} THEN {$ast.setToken2($THEN);} relation {$ast.addRelation($relation.ast);})*
    | {$ast = new Expression();} relation {$ast.addRelation($relation.ast);} (OR {$ast.setToken1($OR);} relation {$ast.addRelation($relation.ast);})*
    | {$ast = new Expression();} relation {$ast.addRelation($relation.ast);} (OR {$ast.setToken1($OR);} ELSE {$ast.setToken2($ELSE);} relation {$ast.addRelation($relation.ast);})*
    | {$ast = new Expression();} relation {$ast.addRelation($relation.ast);} (XOR {$ast.setToken1($XOR);} relation {$ast.addRelation($relation.ast);})*
    ;

relation returns [Relation ast]
    : left_simple_expression = simple_expression (relational_operator right_simple_expression = simple_expression)?
        {$ast = new Relation($left_simple_expression.ast, $ctx.relational_operator != null ? $relational_operator.ast : null, $ctx.right_simple_expression != null ? $right_simple_expression.ast : null);}
    | left_simple_expression = simple_expression NOT? IN range
        {$ast = new Relation($left_simple_expression.ast, $range.ast, $ctx.NOT != null ? $NOT : null);}
    | left_simple_expression = simple_expression NOT? IN subtype_mark = name
        {$ast = new Relation($left_simple_expression.ast, $subtype_mark.ast, $ctx.NOT != null ? $NOT : null);}
    ;

simple_expression returns [SimpleExpression ast]
    : unary_adding_operator? unary_adding_operator_term = term
        {$ast = new SimpleExpression($ctx.unary_adding_operator != null ? $unary_adding_operator.ast : null, $unary_adding_operator_term.ast);}
      (binary_adding_operator {$ast.addBinaryAddingOperator($binary_adding_operator.ast);} binary_adding_operator_term = term {$ast.addBinaryAddingOperatorTerm($binary_adding_operator_term.ast);})*
    ;

term returns [Term ast]
    : factor {$ast = new Term($factor.ast);} (multiplying_operator {$ast.addMultiplyingOperator($multiplying_operator.ast);} multiplying_operator_factor = factor {$ast.addMultiplyingOperatorFactor($multiplying_operator_factor.ast);})*
    ;

factor returns [Factor ast]
    : primary_main = primary ('**' primary_exp = primary)?
        {$ast = new Factor($primary_main.ast, $ctx.primary_exp != null ? $primary_exp.ast : null);}
    | ABS primary
        {$ast = new Factor($primary.ast, null);}
    | NOT primary
        {$ast = new Factor($primary.ast, null);}
    ;

primary returns [Primary ast]
    : numeric_literal
        {$ast = new Primary($numeric_literal.ast);}
    | NULL_
        {$ast = new Primary();}
    | string_literal
        {$ast = new Primary($string_literal.ast);}
    | aggregate
        {$ast = new Primary($aggregate.ast);}
    | name
        {$ast = new Primary($name.ast);}
    | qualified_expression 
        {$ast = new Primary($qualified_expression.ast);}
    | allocator
        {$ast = new Primary($allocator.ast);}
    | '(' expression ')'
        {$ast = new Primary($expression.ast);}
    ;

logical_operator returns [LogicalOperator ast]
    : AND
        {$ast = new LogicalOperator($AND);}
    | OR
        {$ast = new LogicalOperator($OR);}
    | XOR
        {$ast = new LogicalOperator($XOR);}
    ;

relational_operator returns [RelationalOperator ast]
    : '='
        {$ast = new RelationalOperator("=");}
    | '/='
        {$ast = new RelationalOperator("/=");}
    | '<'
        {$ast = new RelationalOperator("<");}
    | '<='
        {$ast = new RelationalOperator("<=");}
    | '>'
        {$ast = new RelationalOperator(">");}
    | '>='
        {$ast = new RelationalOperator(">=");}
    ;

binary_adding_operator returns [BinaryAddingOperator ast]
    : '+'
        {$ast = new BinaryAddingOperator("+");}
    | '-'
        {$ast = new BinaryAddingOperator("-");}
    | '&'
        {$ast = new BinaryAddingOperator("&");}
    ;

unary_adding_operator returns [UnaryAddingOperator ast]
    : '+'
        {$ast = new UnaryAddingOperator("+");}
    | '-'
        {$ast = new UnaryAddingOperator("-");}
    ;

multiplying_operator returns [MultiplyingOperator ast]
    : '*'
        {$ast = new MultiplyingOperator("*");}
    | '/'
        {$ast = new MultiplyingOperator("/");}
    | MOD
        {$ast = new MultiplyingOperator($MOD);}
    | REM
        {$ast = new MultiplyingOperator($REM);}
    ;

highest_precedence_operator returns [HighestPrecedenceOperator ast]
    : '**'
        {$ast = new HighestPrecedenceOperator("**");}
    | ABS
        {$ast = new HighestPrecedenceOperator($ABS);}
    | NOT
        {$ast = new HighestPrecedenceOperator($NOT);}
    ;

qualified_expression returns [QualifiedExpression ast]
    : subtype_mark = name SQ '(' expression ')'
        {$ast = new QualifiedExpression($subtype_mark.ast, $expression.ast);}
    | subtype_mark = name SQ aggregate
        {$ast = new QualifiedExpression($subtype_mark.ast, $aggregate.ast);}
    ;

allocator returns [Allocator ast]
    : NEW subtype_indication
        {$ast = new Allocator($subtype_indication.ast);}
    | NEW qualified_expression
        {$ast = new Allocator($qualified_expression.ast);}
    ;

/*
5 - Statements
*/

sequence_of_statements returns [SequenceOfStatements ast]
    : statements
        {$ast = new SequenceOfStatements($statements.list);}
    ;

statements returns [List<Statement> list = new ArrayList<>()]
    : statement {$list.add($statement.ast);} (statement {$list.add($statement.ast);})*
    ;

statement returns [Statement ast]
    : labels simple_statement
        {$ast = new Statement($labels.list, $simple_statement.ast);}
    | labels compound_statement
        {$ast = new Statement($labels.list, $compound_statement.ast);}
    ;

simple_statement returns [SimpleStatement ast]
    : null_statement
        {$ast = new SimpleStatement($null_statement.ast);}
    | assignment_statement
        {$ast = new SimpleStatement($assignment_statement.ast);}
    | exit_statement
        {$ast = new SimpleStatement($exit_statement.ast);}
    | goto_statement
        {$ast = new SimpleStatement($goto_statement.ast);}
    | procedure_call_statement
        {$ast = new SimpleStatement($procedure_call_statement.ast);}
    | return_statement
        {$ast = new SimpleStatement($return_statement.ast);}
    | entry_call_statement
        {$ast = new SimpleStatement($entry_call_statement.ast);}
    | requeue_statement
        {$ast = new SimpleStatement($requeue_statement.ast);}
    | delay_statement
        {$ast = new SimpleStatement($delay_statement.ast);}
    | abort_statement  
        {$ast = new SimpleStatement($abort_statement.ast);}
    | raise_statement
        {$ast = new SimpleStatement($raise_statement.ast);}
    | code_statement
        {$ast = new SimpleStatement($code_statement.ast);}
    ;

compound_statement returns [CompoundStatement ast]
    : if_statement
        {$ast = new CompoundStatement($if_statement.ast);}
    | case_statement
        {$ast = new CompoundStatement($case_statement.ast);}
    | loop_statement
        {$ast = new CompoundStatement($loop_statement.ast);}
    | block_statement
        {$ast = new CompoundStatement($block_statement.ast);}
    | accept_statement
        {$ast = new CompoundStatement($accept_statement.ast);}
    | select_statement
        {$ast = new CompoundStatement($select_statement.ast);}
    ;

null_statement returns [NullStatement ast]
    : NULL_ ';'
        {$ast = new NullStatement();}
    ;

labels returns [List<Label> list = new ArrayList<>()]
    : (label {$list.add($label.ast);})*
    ;

label returns [Label ast]
    : '<<' label_statement_identifier = statement_identifier '>>'
        {$ast = new Label($label_statement_identifier.ast);}
    ;

statement_identifier returns [StatementIdentifier ast]
    : direct_name
        {$ast = new StatementIdentifier($direct_name.ast);}
    ;

assignment_statement returns [AssignmentStatement ast]
    : variable_name = name ':=' expression ';'
        {$ast = new AssignmentStatement($variable_name.ast, $expression.ast);}
    ;

if_statement returns [IfStatement ast]
    : IF condition THEN if_sequence_of_statements = sequence_of_statements if_statement_elsif_clauses (
        ELSE else_sequence_of_statements = sequence_of_statements
    )? END IF ';'
        {$ast = new IfStatement($condition.ast, $if_sequence_of_statements.ast, $if_statement_elsif_clauses.list, $ctx.else_sequence_of_statements != null ? $else_sequence_of_statements.ast : null);}
    ;

if_statement_elsif_clauses returns [List<IfStatementElsifClause> list = new ArrayList<>()]
    : (if_statement_elsif_clause {$list.add($if_statement_elsif_clause.ast);})*
    ;

if_statement_elsif_clause returns [IfStatementElsifClause ast]
    : ELSIF condition THEN sequence_of_statements
        {$ast = new IfStatementElsifClause($condition.ast, $sequence_of_statements.ast);}
    ;

condition returns [Condition ast]
    : boolean_expression
        {$ast = new Condition($boolean_expression.ast);}
    ;

case_statement returns [CaseStatement ast]
    : CASE expression IS case_statement_alternatives END CASE ';'
        {$ast = new CaseStatement($expression.ast, $case_statement_alternatives.list);}
    ;

case_statement_alternatives returns [List<CaseStatementAlternative> list = new ArrayList<>()]
    : case_statement_alternative {$list.add($case_statement_alternative.ast);} (case_statement_alternative {$list.add($case_statement_alternative.ast);})*
    ;

case_statement_alternative returns [CaseStatementAlternative ast]
    : WHEN discrete_choice_list '=>' sequence_of_statements
        {$ast = new CaseStatementAlternative($discrete_choice_list.ast, $sequence_of_statements.ast);}
    ;

loop_statement returns [LoopStatement ast]
    : (loop_statement_identifier = statement_identifier ':')? iteration_scheme? LOOP sequence_of_statements END LOOP loop_identifier = identifier? ';'
        {$ast = new LoopStatement($ctx.loop_statement_identifier != null ? $loop_statement_identifier.ast : null, $ctx.iteration_scheme != null ? $iteration_scheme.ast : null, $sequence_of_statements.ast, $ctx.loop_identifier != null ? $loop_identifier.ast : null);}
    ;

iteration_scheme returns [IterationScheme ast]
    : WHILE while_condition = condition
        {$ast = new IterationScheme($while_condition.ast);}
    | FOR loop_parameter_specification
        {$ast = new IterationScheme($loop_parameter_specification.ast);}
    ;

loop_parameter_specification returns [LoopParameterSpecification ast]
    : defining_identifier IN REVERSE? discrete_subtype_definition
        {$ast = new LoopParameterSpecification($defining_identifier.ast, $discrete_subtype_definition.ast, $ctx.REVERSE != null ? $REVERSE : null);}
    ;

block_statement returns [BlockStatement ast]
    : (block_statement_identifier = statement_identifier ':')? (DECLARE declarative_part)? BEGIN handled_sequence_of_statements END block_identifier = identifier? ';'
        {$ast = new BlockStatement($ctx.block_statement_identifier != null ? $block_statement_identifier.ast : null, $ctx.declarative_part != null ? $declarative_part.ast : null, $handled_sequence_of_statements.ast, $ctx.block_identifier != null ? $block_identifier.ast : null);}
    ;

exit_statement returns [ExitStatement ast]
    : EXIT loop_name = name? (WHEN condition)? ';'
        {$ast = new ExitStatement($ctx.loop_name != null ? $loop_name.ast : null, $ctx.condition != null ? $condition.ast : null);}
    ;

goto_statement returns [GotoStatement ast]
    : GOTO label_name = name ';'
        {$ast = new GotoStatement($label_name.ast);}
    ;

/*
6 - Subprograms
*/

subprogram_declaration returns [SubprogramDeclaration ast]
    : subprogram_specification ';'
        {$ast = new SubprogramDeclaration($subprogram_specification.ast);}
    ;

abstract_subprogram_declaration returns [AbstractSubprogramDeclaration ast]
    : subprogram_specification IS ABSTRACT ';'
        {$ast = new AbstractSubprogramDeclaration($subprogram_specification.ast);}
    ;

subprogram_specification returns [SubprogramSpecification ast]
    : PROCEDURE defining_program_unit_name parameter_profile
        {$ast = new SubprogramSpecification($defining_program_unit_name.ast, $parameter_profile.ast);}
    | FUNCTION defining_designator parameter_and_result_profile
        {$ast = new SubprogramSpecification($defining_designator.ast, $parameter_and_result_profile.ast);}
    ;

designator returns [Designator ast]
    : (parent_unit_name '.')? identifier
        {$ast = new Designator($ctx.parent_unit_name != null ? $parent_unit_name.ast : null, $identifier.ast);}
    | operator_symbol
        {$ast = new Designator($operator_symbol.ast);}
    ;

defining_designator returns [DefiningDesignator ast]
    : defining_program_unit_name
        {$ast = new DefiningDesignator($defining_program_unit_name.ast);}
    | defining_operator_symbol
        {$ast = new DefiningDesignator($defining_operator_symbol.ast);}
    ;

defining_program_unit_name returns [DefiningProgramUnitName ast]
    : (parent_unit_name '.')? defining_identifier
        {$ast = new DefiningProgramUnitName($ctx.parent_unit_name != null ? $parent_unit_name.ast : null, $defining_identifier.ast);}
    ;

operator_symbol returns [OperatorSymbol ast]
    : string_literal
        {$ast = new OperatorSymbol($string_literal.ast);}
    ;

defining_operator_symbol returns [DefiningOperatorSymbol ast]
    : operator_symbol
        {$ast = new DefiningOperatorSymbol($operator_symbol.ast);}
    ;

parameter_profile returns [ParameterProfile ast]
    : formal_part?
        {$ast = new ParameterProfile($ctx.formal_part != null ? $formal_part.ast : null);}
    ;

parameter_and_result_profile returns [ParameterAndResultProfile ast]
    : formal_part? RETURN subtype_mark = name
        {$ast = new ParameterAndResultProfile($ctx.formal_part != null ? $formal_part.ast : null, $subtype_mark.ast);}
    ;

formal_part returns [FormalPart ast]
    : '(' parameter_specifications ')'
        {$ast = new FormalPart($parameter_specifications.list);}
    ;

parameter_specifications returns [List<ParameterSpecification> list = new ArrayList<>()]
    : parameter_specification {$list.add($parameter_specification.ast);} (';' parameter_specification {$list.add($parameter_specification.ast);})*
    ;

parameter_specification returns [ParameterSpecification ast]
    : defining_identifier_list ':' mode_ subtype_mark = name (':=' default_expression)?
        {$ast = new ParameterSpecification($defining_identifier_list.ast, $mode_.ast, $subtype_mark.ast, $ctx.default_expression != null ? $default_expression.ast : null);}
    | defining_identifier_list ':' access_definition (':=' default_expression)?
        {$ast = new ParameterSpecification($defining_identifier_list.ast, $access_definition.ast, $ctx.default_expression != null ? $default_expression.ast : null);}
    ;

mode_ returns [Mode ast]
    : IN? OUT?
        {$ast = new Mode($ctx.IN != null ? $IN : null, $ctx.OUT != null ? $OUT : null);}
    ;

subprogram_body returns [SubprogramBody ast]
    : subprogram_specification IS declarative_part BEGIN handled_sequence_of_statements END designator? ';'
        {$ast = new SubprogramBody($subprogram_specification.ast, $declarative_part.ast, $handled_sequence_of_statements.ast, $ctx.designator != null ? $designator.ast : null);}
    ;

procedure_call_statement returns [ProcedureCallStatement ast]
    : procedure_name = name ';'
        {$ast = new ProcedureCallStatement($procedure_name.ast);}
    | procedure_prefix = name actual_parameter_part ';'
        {$ast = new ProcedureCallStatement($procedure_prefix.ast, $actual_parameter_part.ast);}
    ;

actual_parameter_part returns [ActualParameterPart ast]
    : '(' parameter_associations ')'
        {$ast = new ActualParameterPart($parameter_associations.list);}
    ;

parameter_associations returns [List<ParameterAssociation> list = new ArrayList<>()]
    : parameter_association {$list.add($parameter_association.ast);} (',' parameter_association {$list.add($parameter_association.ast);})*
    ;

parameter_association returns [ParameterAssociation ast]
    : (formal_parameter_selector_name = selector_name '=>')? explicit_actual_parameter
        {$ast = new ParameterAssociation($ctx.formal_parameter_selector_name != null ? $formal_parameter_selector_name.ast : null, $explicit_actual_parameter.ast);}
    ;

explicit_actual_parameter returns [ExplicitActualParameter ast]
    : expression
        {$ast = new ExplicitActualParameter($expression.ast);}
    | variable_name = name
        {$ast = new ExplicitActualParameter($variable_name.ast);}
    ;

return_statement returns [ReturnStatement ast]
    : RETURN expression? ';'
        {$ast = new ReturnStatement($ctx.expression != null ? $expression.ast : null);}
    ;

/*
7 - Packages
*/

package_declaration returns [PackageDeclaration ast]
    : package_specification ';'
        {$ast = new PackageDeclaration($package_specification.ast);}
    ;

package_specification returns [PackageSpecification ast]
    : PACKAGE defining_program_unit_name IS main_basic_declarative_items = basic_declarative_items (
        PRIVATE private_basic_declarative_items = basic_declarative_items
      )? END ((parent_unit_name '.')? identifier)?
        {$ast = new PackageSpecification($defining_program_unit_name.ast, $main_basic_declarative_items.list, $ctx.private_basic_declarative_items != null ? $private_basic_declarative_items.list : new ArrayList<>(), $ctx.parent_unit_name != null ? $parent_unit_name.ast : null, $ctx.identifier != null ? $identifier.ast : null);}
    ;

basic_declarative_items returns [List<BasicDeclarativeItem> list = new ArrayList<>()]
    : (basic_declarative_item {$list.add($basic_declarative_item.ast);})*
    ;

package_body returns [PackageBody ast]
    : PACKAGE BODY_ defining_program_unit_name IS declarative_part (
        BEGIN handled_sequence_of_statements
      )? END ((parent_unit_name '.')? identifier)? ';'
        {$ast = new PackageBody($defining_program_unit_name.ast, $declarative_part.ast, $ctx.handled_sequence_of_statements != null ? $handled_sequence_of_statements.ast : null, $ctx.parent_unit_name != null ? $parent_unit_name.ast : null, $ctx.identifier != null ? $identifier.ast : null);}
    ;

private_type_declaration returns [PrivateTypeDeclaration ast]
    : TYPE defining_identifier discriminant_part? IS (ABSTRACT? TAGGED)? LIMITED? PRIVATE ';'
        {$ast = new PrivateTypeDeclaration($defining_identifier.ast, $ctx.discriminant_part != null ? $discriminant_part.ast : null, $ctx.ABSTRACT != null ? $ABSTRACT : null, $ctx.TAGGED != null ? $TAGGED : null, $ctx.LIMITED != null ? $LIMITED : null);}
    ;

private_extension_declaration returns [PrivateExtensionDeclaration ast]
    : TYPE defining_identifier discriminant_part? IS ABSTRACT? NEW ancestor_subtype_indication = subtype_indication WITH PRIVATE ';'
        {$ast = new PrivateExtensionDeclaration($defining_identifier.ast, $ctx.discriminant_part != null ? $discriminant_part.ast : null, $ancestor_subtype_indication.ast, $ctx.ABSTRACT != null ? $ABSTRACT : null);}
    ;

/*
8 - Visibility Rules
*/

use_clause returns [UseClause ast]
    : use_package_clause
        {$ast = new UseClause($use_package_clause.ast);}
    | use_type_clause
        {$ast = new UseClause($use_type_clause.ast);}
    ;

use_package_clause returns [UsePackageClause ast]
    : USE package_names = names ';'
        {$ast = new UsePackageClause($package_names.list);}
    ;

use_type_clause returns [UseTypeClause ast]
    : USE TYPE subtype_marks = names ';'
        {$ast = new UseTypeClause($subtype_marks.list);}
    ;

names returns [List<Name> list = new ArrayList<>()]
    : name {$list.add($name.ast);} (',' name {$list.add($name.ast);})*
    ;

renaming_declaration returns [RenamingDeclaration ast]
    : object_renaming_declaration
        {$ast = new RenamingDeclaration($object_renaming_declaration.ast);}
    | exception_renaming_declaration
        {$ast = new RenamingDeclaration($exception_renaming_declaration.ast);}
    | package_renaming_declaration
        {$ast = new RenamingDeclaration($package_renaming_declaration.ast);}
    | subprogram_renaming_declaration
        {$ast = new RenamingDeclaration($subprogram_renaming_declaration.ast);}
    | generic_renaming_declaration
        {$ast = new RenamingDeclaration($generic_renaming_declaration.ast);}
    ;

object_renaming_declaration returns [ObjectRenamingDeclaration ast]
    : defining_identifier ':' subtype_mark = name RENAMES object_name = name ';'
        {$ast = new ObjectRenamingDeclaration($defining_identifier.ast, $subtype_mark.ast, $object_name.ast);}
    ;

exception_renaming_declaration returns [ExceptionRenamingDeclaration ast]
    : defining_identifier ':' EXCEPTION RENAMES exception_name = name ';'
        {$ast = new ExceptionRenamingDeclaration($defining_identifier.ast, $exception_name.ast);}
    ;

package_renaming_declaration returns [PackageRenamingDeclaration ast]
    : PACKAGE defining_program_unit_name RENAMES package_name = name ';'
        {$ast = new PackageRenamingDeclaration($defining_program_unit_name.ast, $package_name.ast);}
    ;

subprogram_renaming_declaration returns [SubprogramRenamingDeclaration ast]
    : subprogram_specification RENAMES callable_entity_name = name ';'
        {$ast = new SubprogramRenamingDeclaration($subprogram_specification.ast, $callable_entity_name.ast);}
    ;

generic_renaming_declaration returns [GenericRenamingDeclaration ast]
    : GENERIC PACKAGE defining_program_unit_name RENAMES generic_package_name = name ';'
        {$ast = new GenericRenamingDeclaration($PACKAGE, $defining_program_unit_name.ast, $generic_package_name.ast);}
    | GENERIC PROCEDURE defining_program_unit_name RENAMES generic_procedure_name = name ';'
        {$ast = new GenericRenamingDeclaration($PROCEDURE, $defining_program_unit_name.ast, $generic_procedure_name.ast);}
    | GENERIC FUNCTION defining_program_unit_name RENAMES generic_function_name = name ';'
        {$ast = new GenericRenamingDeclaration($FUNCTION, $defining_program_unit_name.ast, $generic_function_name.ast);}
    ;

/*
9 - Tasks and Synchronization
*/

task_type_declaration returns [TaskTypeDeclaration ast]
    : TASK TYPE defining_identifier known_discriminant_part? (IS task_definition)? ';'
        {$ast = new TaskTypeDeclaration($defining_identifier.ast, $ctx.known_discriminant_part != null ? $known_discriminant_part.ast : null, $ctx.task_definition != null ? $task_definition.ast : null);}
    ;

single_task_declaration returns [SingleTaskDeclaration ast]
    : TASK defining_identifier (IS task_definition)? ';'
        {$ast = new SingleTaskDeclaration($defining_identifier.ast, $ctx.task_definition != null ? $task_definition.ast : null);}
    ;

task_definition returns [TaskDefinition ast]
    : main_task_items = task_items (PRIVATE private_task_items = task_items)? END task_identifier = identifier?
        {$ast = new TaskDefinition($main_task_items.list, $ctx.main_task_items != null ? $main_task_items.list : new ArrayList<>(), $ctx.task_identifier != null ? $task_identifier.ast : null);}
    ;

task_items returns [List<TaskItem> list = new ArrayList<>()]
    : (task_item {$list.add($task_item.ast);})*
    ;

task_item returns [TaskItem ast]
    : entry_declaration
        {$ast = new TaskItem($entry_declaration.ast);}
    | aspect_clause
        {$ast = new TaskItem($aspect_clause.ast);}
    ;

task_body returns [TaskBody ast]
    : TASK BODY_ defining_identifier IS declarative_part BEGIN handled_sequence_of_statements END task_identifier = identifier? ';'
        {$ast = new TaskBody($defining_identifier.ast, $declarative_part.ast, $handled_sequence_of_statements.ast, $ctx.task_identifier != null ? $task_identifier.ast : null);}
    ;

protected_type_declaration returns [ProtectedTypeDeclaration ast]
    : PROTECTED TYPE defining_identifier known_discriminant_part? IS protected_definition ';'
        {$ast = new ProtectedTypeDeclaration($defining_identifier.ast, $ctx.known_discriminant_part != null ? $known_discriminant_part.ast : null, $protected_definition.ast);}
    ;

single_protected_declaration returns [SingleProtectedDeclaration ast]
    : PROTECTED defining_identifier IS protected_definition ';'
        {$ast = new SingleProtectedDeclaration($defining_identifier.ast, $protected_definition.ast);}
    ;

protected_definition returns [ProtectedDefinition ast]
    : protected_operation_declarations (PRIVATE protected_element_declarations)? END protected_identifier = identifier?
        {$ast = new ProtectedDefinition($protected_operation_declarations.list, $ctx.protected_element_declarations != null ? $protected_element_declarations.list : new ArrayList<>(), $ctx.protected_identifier != null ? $protected_identifier.ast : null);}
    ;

protected_operation_declarations returns [List<ProtectedOperationDeclaration> list = new ArrayList<>()]
    : (protected_operation_declaration {$list.add($protected_operation_declaration.ast);})*
    ;

protected_operation_declaration returns [ProtectedOperationDeclaration ast]
    : subprogram_declaration
        {$ast = new ProtectedOperationDeclaration($subprogram_declaration.ast);}
    | entry_declaration
        {$ast = new ProtectedOperationDeclaration($entry_declaration.ast);}
    | aspect_clause
        {$ast = new ProtectedOperationDeclaration($aspect_clause.ast);}
    ;

protected_element_declarations returns [List<ProtectedElementDeclaration> list = new ArrayList<>()]
    : (protected_element_declaration {$list.add($protected_element_declaration.ast);})*
    ;

protected_element_declaration returns [ProtectedElementDeclaration ast]
    : protected_operation_declaration
        {$ast = new ProtectedElementDeclaration($protected_operation_declaration.ast);}
    | component_declaration
        {$ast = new ProtectedElementDeclaration($component_declaration.ast);}
    ;

protected_body returns [ProtectedBody ast]
    : PROTECTED BODY_ defining_identifier IS protected_operation_items END protected_identifier = identifier? ';'
        {$ast = new ProtectedBody($defining_identifier.ast, $protected_operation_items.list, $ctx.protected_identifier != null ? $protected_identifier.ast : null);}
    ;

protected_operation_items returns [List<ProtectedOperationItem> list = new ArrayList<>()]
    : (protected_operation_item {$list.add($protected_operation_item.ast);})*
    ;

protected_operation_item returns [ProtectedOperationItem ast]
    : subprogram_declaration
        {$ast = new ProtectedOperationItem($subprogram_declaration.ast);}
    | subprogram_body
        {$ast = new ProtectedOperationItem($subprogram_body.ast);}
    | entry_body
        {$ast = new ProtectedOperationItem($entry_body.ast);}
    | aspect_clause
        {$ast = new ProtectedOperationItem($aspect_clause.ast);}
    ;

entry_declaration returns [EntryDeclaration ast]
    : ENTRY defining_identifier ('(' discrete_subtype_definition ')')? parameter_profile ';'
        {$ast = new EntryDeclaration($defining_identifier.ast, $ctx.discrete_subtype_definition != null ? $discrete_subtype_definition.ast : null, $parameter_profile.ast);}
    ;

accept_statement returns [AcceptStatement ast]
    : ACCEPT_ entry_direct_name = direct_name ('(' entry_index ')')? parameter_profile (
        DO handled_sequence_of_statements END entry_identifier = identifier?
    )? ';'
        {$ast = new AcceptStatement($entry_direct_name.ast, $ctx.entry_index != null ? $entry_index.ast : null, $parameter_profile.ast, $ctx.handled_sequence_of_statements != null ? $handled_sequence_of_statements.ast : null, $ctx.entry_identifier != null ? $entry_identifier.ast : null);}
    ;

entry_index returns [EntryIndex ast]
    : expression
        {$ast = new EntryIndex($expression.ast);}
    ;

entry_body returns [EntryBody ast]
    : ENTRY defining_identifier entry_body_formal_part entry_barrier IS declarative_part BEGIN handled_sequence_of_statements END entry_identifier = identifier? ';'
        {$ast = new EntryBody($defining_identifier.ast, $entry_body_formal_part.ast, $entry_barrier.ast, $declarative_part.ast, $handled_sequence_of_statements.ast, $ctx.entry_identifier != null ? $entry_identifier.ast : null);}
    ;

entry_body_formal_part returns [EntryBodyFormalPart ast]
    : ('(' entry_index_specification ')')? parameter_profile
        {$ast = new EntryBodyFormalPart($ctx.entry_index_specification != null ? $entry_index_specification.ast : null, $parameter_profile.ast);}
    ;

entry_barrier returns [EntryBarrier ast]
    : WHEN condition
        {$ast = new EntryBarrier($condition.ast);}
    ;

entry_index_specification returns [EntryIndexSpecification ast]
    : FOR defining_identifier IN discrete_subtype_definition
        {$ast = new EntryIndexSpecification($defining_identifier.ast, $discrete_subtype_definition.ast);}
    ;

entry_call_statement returns [EntryCallStatement ast]
    : entry_name = name actual_parameter_part? ';'
        {$ast = new EntryCallStatement($entry_name.ast, $ctx.actual_parameter_part != null ? $actual_parameter_part.ast : null);}
    ;

requeue_statement returns [RequeueStatement ast]
    : REQUEUE entry_name = name (WITH ABORT)? ';'
        {$ast = new RequeueStatement($entry_name.ast, $ctx.WITH != null ? $WITH : null, $ctx.ABORT != null ? $ABORT : null);}
    ;

delay_statement returns [DelayStatement ast]
    : delay_until_statement
        {$ast = new DelayStatement($delay_until_statement.ast);}
    | delay_relative_statement
        {$ast = new DelayStatement($delay_relative_statement.ast);}
    ;

delay_until_statement returns [DelayUntilStatement ast]
    : DELAY UNTIL delay_expression = expression ';'
        {$ast = new DelayUntilStatement($delay_expression.ast);}
    ;

delay_relative_statement returns [DelayRelativeStatement ast]
    : DELAY delay_expression = expression ';'
        {$ast = new DelayRelativeStatement($delay_expression.ast);}
    ;

select_statement returns [SelectStatement ast]
    : selective_accept
        {$ast = new SelectStatement($selective_accept.ast);}
    | timed_entry_call
        {$ast = new SelectStatement($timed_entry_call.ast);}
    | conditional_entry_call
        {$ast = new SelectStatement($conditional_entry_call.ast);}
    | asynchronous_select
        {$ast = new SelectStatement($asynchronous_select.ast);}
    ;

selective_accept returns [SelectiveAccept ast]
    : SELECT select_alternative_clauses (
        ELSE sequence_of_statements
    )? END SELECT ';'
        {$ast = new SelectiveAccept($select_alternative_clauses.list, $ctx.sequence_of_statements != null ? $sequence_of_statements.ast : null);}
    ;

guard returns [Guard ast]
    : WHEN condition '=>'
        {$ast = new Guard($condition.ast);}
    ;

select_alternative_clauses returns [List<SelectAlternativeClause> list = new ArrayList<>()]
    : select_alternative_clause {$list.add($select_alternative_clause.ast);} (OR select_alternative_clause {$list.add($select_alternative_clause.ast);})*
    ;

select_alternative_clause returns [SelectAlternativeClause ast]
    : guard? select_alternative
        {$ast = new SelectAlternativeClause($ctx.guard != null ? $guard.ast : null, $select_alternative.ast);}
    ;

select_alternative returns [SelectAlternative ast]
    : accept_alternative
        {$ast = new SelectAlternative($accept_alternative.ast);}
    | delay_alternative
        {$ast = new SelectAlternative($delay_alternative.ast);}
    | terminate_alternative
        {$ast = new SelectAlternative($terminate_alternative.ast);}
    ;

accept_alternative returns [AcceptAlternative ast]
    : accept_statement sequence_of_statements?
        {$ast = new AcceptAlternative($accept_statement.ast, $ctx.sequence_of_statements != null ? $sequence_of_statements.ast : null);}
    ;

delay_alternative returns [DelayAlternative ast]
    : delay_statement sequence_of_statements?
        {$ast = new DelayAlternative($delay_statement.ast, $ctx.sequence_of_statements != null ? $sequence_of_statements.ast : null);}
    ;

terminate_alternative returns [TerminateAlternative ast]
    : TERMINATE ';'
        {$ast = new TerminateAlternative();}
    ;

timed_entry_call returns [TimedEntryCall ast]
    : SELECT entry_call_alternative OR delay_alternative END SELECT ';'
        {$ast = new TimedEntryCall($entry_call_alternative.ast, $delay_alternative.ast);}
    ;

entry_call_alternative returns [EntryCallAlternative ast]
    : entry_call_statement sequence_of_statements?
        {$ast = new EntryCallAlternative($entry_call_statement.ast, $ctx.sequence_of_statements != null ? $sequence_of_statements.ast : null);}
    ;

conditional_entry_call returns [ConditionalEntryCall ast]
    : SELECT entry_call_alternative ELSE sequence_of_statements END SELECT ';'
        {$ast = new ConditionalEntryCall($entry_call_alternative.ast, $sequence_of_statements.ast);}
    ;

asynchronous_select returns [AsynchronousSelect ast]
    : SELECT triggering_alternative THEN ABORT abortable_part END SELECT ';'
        {$ast = new AsynchronousSelect($triggering_alternative.ast, $abortable_part.ast);}
    ;

triggering_alternative returns [TriggeringAlternative ast]
    : triggering_statement sequence_of_statements?
        {$ast = new TriggeringAlternative($triggering_statement.ast, $ctx.sequence_of_statements != null ? $sequence_of_statements.ast : null);}
    ;

triggering_statement returns [TriggeringStatement ast]
    : entry_call_statement
        {$ast = new TriggeringStatement($entry_call_statement.ast);}
    | delay_statement
        {$ast = new TriggeringStatement($delay_statement.ast);}
    ;

abortable_part returns [AbortablePart ast]
    : sequence_of_statements
        {$ast = new AbortablePart($sequence_of_statements.ast);}
    ;

abort_statement returns [AbortStatement ast]
    : ABORT task_names ';'
        {$ast = new AbortStatement($task_names.list);}
    ;

task_names returns [List<Name> list = new ArrayList<>()]
    : task_name = name {$list.add($task_name.ast);} (',' task_name = name {$list.add($task_name.ast);})*
    ;

/*
10 - Program Structure and Compilation Issues
*/

compilation returns [Compilation ast]
    : 
        compilation_units EOF
        {$ast = new Compilation($compilation_units.list);}
    ;

compilation_units returns [List<CompilationUnit> list = new ArrayList<>()]
    :
        (compilation_unit { $list.add($compilation_unit.ast); })*
    ;

compilation_unit returns [CompilationUnit ast]
    : context_clause library_item
        {$ast = new CompilationUnit($context_clause.ast, $library_item.ast);}
    | context_clause subunit
        {$ast = new CompilationUnit($context_clause.ast, $subunit.ast);}
    ;

library_item returns [LibraryItem ast]
    : PRIVATE? library_unit_declaration
        {$ast = new LibraryItem($library_unit_declaration.ast, $ctx.PRIVATE != null ? $PRIVATE : null);}
    | library_unit_body
        {$ast = new LibraryItem($library_unit_body.ast);}
    | PRIVATE? library_unit_renaming_declaration
        {$ast = new LibraryItem($library_unit_renaming_declaration.ast, $ctx.PRIVATE != null ? $PRIVATE : null);}
    ;

library_unit_declaration returns [LibraryUnitDeclaration ast]
    : subprogram_declaration
        {$ast = new LibraryUnitDeclaration($subprogram_declaration.ast);}
    | package_declaration
        {$ast = new LibraryUnitDeclaration($package_declaration.ast);}
    | generic_declaration
        {$ast = new LibraryUnitDeclaration($generic_declaration.ast);}
    | generic_instantiation
        {$ast = new LibraryUnitDeclaration($generic_instantiation.ast);}
    ;

library_unit_renaming_declaration returns [LibraryUnitRenamingDeclaration ast]
    : package_renaming_declaration
        {$ast = new LibraryUnitRenamingDeclaration($package_renaming_declaration.ast);}
    | generic_renaming_declaration
        {$ast = new LibraryUnitRenamingDeclaration($generic_renaming_declaration.ast);}
    | subprogram_renaming_declaration
        {$ast = new LibraryUnitRenamingDeclaration($subprogram_renaming_declaration.ast);}
    ;

library_unit_body returns [LibraryUnitBody ast]
    : subprogram_body
        {$ast = new LibraryUnitBody($subprogram_body.ast);}
    | package_body
        {$ast = new LibraryUnitBody($package_body.ast);}
    ;

parent_unit_name returns [ParentUnitName ast]
    : name
        {$ast = new ParentUnitName($name.ast);}
    ;

context_clause returns [ContextClause ast]
    : context_items
        {$ast = new ContextClause($context_items.list);}
    ;

context_items returns [List<ContextItem> list = new ArrayList<>()]
    :
        (context_item { $list.add($context_item.ast); })*
    ;

context_item returns [ContextItem ast]
    : with_clause
        {$ast = new ContextItem($with_clause.ast);}
    | use_clause
        {$ast = new ContextItem($use_clause.ast);}
    ;

library_unit_names returns [List<Name> list = new ArrayList<>()]
    : library_unit_name = name { $list.add($library_unit_name.ast); } (',' library_unit_name = name { $list.add($library_unit_name.ast); })*
    ;

with_clause returns [WithClause ast]
    : WITH library_unit_names ';'
        {$ast = new WithClause($library_unit_names.list);}
    ;

body_stub returns [BodyStub ast]
    : subprogram_body_stub
        {$ast = new BodyStub($subprogram_body_stub.ast);}
    | package_body_stub
        {$ast = new BodyStub($package_body_stub.ast);}
    | task_body_stub
        {$ast = new BodyStub($task_body_stub.ast);}
    | protected_body_stub
        {$ast = new BodyStub($protected_body_stub.ast);}
    ;

subprogram_body_stub returns [SubprogramBodyStub ast]
    : subprogram_specification IS SEPARATE ';'
        {$ast = new SubprogramBodyStub($subprogram_specification.ast);}
    ;

package_body_stub returns [PackageBodyStub ast]
    : PACKAGE BODY_ defining_identifier IS SEPARATE ';'
        {$ast = new PackageBodyStub($defining_identifier.ast);}
    ;

task_body_stub returns [TaskBodyStub ast]
    : TASK BODY_ defining_identifier IS SEPARATE ';'
        {$ast = new TaskBodyStub($defining_identifier.ast);}
    ;

protected_body_stub returns [ProtectedBodyStub ast]
    : PROTECTED BODY_ defining_identifier IS SEPARATE ';'
        {$ast = new ProtectedBodyStub($defining_identifier.ast);}
    ;

subunit returns [Subunit ast]
    : SEPARATE '(' parent_unit_name ')' proper_body
        {$ast = new Subunit($parent_unit_name.ast, $proper_body.ast);}
    ;

/*
11 - Exceptions
*/

exception_declaration returns [ExceptionDeclaration ast]
    : defining_identifier_list ':' EXCEPTION ';'
        {$ast = new ExceptionDeclaration($defining_identifier_list.ast);}
    ;

handled_sequence_of_statements returns [HandledSequenceOfStatements ast]
    : sequence_of_statements (EXCEPTION exception_handlers)?
        {$ast = new HandledSequenceOfStatements($sequence_of_statements.ast, $ctx.exception_handlers != null ? $exception_handlers.list : new ArrayList<>());}
    ;

exception_handlers returns [List<ExceptionHandler> list = new ArrayList<>()]
    : exception_handler {$list.add($exception_handler.ast);} (exception_handler {$list.add($exception_handler.ast);})*
    ;

exception_handler returns [ExceptionHandler ast]
    : WHEN (choice_parameter_specification ':')? exception_choices '=>' sequence_of_statements
        {$ast = new ExceptionHandler($ctx.choice_parameter_specification != null ? $choice_parameter_specification.ast : null, $exception_choices.list, $sequence_of_statements.ast);}
    ;

exception_choices returns [List<ExceptionChoice> list = new ArrayList<>()]
    : exception_choice {$list.add($exception_choice.ast);} ('|' exception_choice {$list.add($exception_choice.ast);})*
    ;

choice_parameter_specification returns [ChoiceParameterSpecification ast]
    : defining_identifier
        {$ast = new ChoiceParameterSpecification($defining_identifier.ast);}
    ;

exception_choice returns [ExceptionChoice ast]
    : exception_name = name
        {$ast = new ExceptionChoice($exception_name.ast);}
    | OTHERS
        {$ast = new ExceptionChoice();}
    ;

raise_statement returns [RaiseStatement ast]
    : RAISE exception_name = name? ';'
        {$ast = new RaiseStatement($ctx.exception_name != null ? $exception_name.ast : null);}
    ;

/*
12 - Generic Units
*/

generic_declaration returns [GenericDeclaration ast]
    : generic_subprogram_declaration
        {$ast = new GenericDeclaration($generic_subprogram_declaration.ast);}
    | generic_package_declaration
        {$ast = new GenericDeclaration($generic_package_declaration.ast);}
    ;

generic_subprogram_declaration returns [GenericSubprogramDeclaration ast]
    : generic_formal_part subprogram_specification ';'
        {$ast = new GenericSubprogramDeclaration($generic_formal_part.ast, $subprogram_specification.ast);}
    ;

generic_package_declaration returns [GenericPackageDeclaration ast]
    : generic_formal_part package_specification ';'
        {$ast = new GenericPackageDeclaration($generic_formal_part.ast, $package_specification.ast);}
    ;

generic_formal_part returns [GenericFormalPart ast]
    : GENERIC {$ast = new GenericFormalPart();} ((generic_formal_parameter_declaration {$ast.addGenericFormalParameterDeclaration($generic_formal_parameter_declaration.ast);}) | (use_clause {$ast.addUseClause($use_clause.ast);}))*
    ;

generic_formal_parameter_declaration returns [GenericFormalParameterDeclaration ast]
    : formal_object_declaration
        {$ast = new GenericFormalParameterDeclaration($formal_object_declaration.ast);}
    | formal_type_declaration
        {$ast = new GenericFormalParameterDeclaration($formal_type_declaration.ast);}
    | formal_subprogram_declaration
        {$ast = new GenericFormalParameterDeclaration($formal_subprogram_declaration.ast);}
    | formal_package_declaration
        {$ast = new GenericFormalParameterDeclaration($formal_package_declaration.ast);}
    ;

generic_instantiation returns [GenericInstantiation ast]
    : PACKAGE defining_program_unit_name IS NEW generic_package_name = name generic_actual_part? ';'
        {$ast = new GenericInstantiation($PACKAGE, $defining_program_unit_name.ast, $generic_package_name.ast, $ctx.generic_actual_part != null ? $generic_actual_part.ast : null);}
    | PROCEDURE defining_program_unit_name IS NEW generic_procedure_name = name generic_actual_part? ';'
        {$ast = new GenericInstantiation($PROCEDURE, $defining_program_unit_name.ast, $generic_procedure_name.ast, $ctx.generic_actual_part != null ? $generic_actual_part.ast : null);}
    | FUNCTION defining_designator IS NEW generic_function_name = name generic_actual_part? ';'
        {$ast = new GenericInstantiation($FUNCTION, $defining_designator.ast, $generic_function_name.ast, $ctx.generic_actual_part != null ? $generic_actual_part.ast : null);}
    ;

generic_actual_part returns [GenericActualPart ast]
    : '(' generic_associations ')'
        {$ast = new GenericActualPart($generic_associations.list);}
    ;

generic_associations returns [List<GenericAssociation> list = new ArrayList<>()]
    : generic_association {$list.add($generic_association.ast);} (',' generic_association {$list.add($generic_association.ast);})*
    ;

generic_association returns [GenericAssociation ast]
    : (generic_formal_parameter_selector_name = selector_name '=>')? explicit_generic_actual_parameter
        {$ast = new GenericAssociation($ctx.generic_formal_parameter_selector_name != null ? $generic_formal_parameter_selector_name.ast : null, $explicit_generic_actual_parameter.ast);}
    ;

explicit_generic_actual_parameter returns [ExplicitGenericActualParameter ast]
    : expression
        {$ast = new ExplicitGenericActualParameter($expression.ast);}
    | variable_name = name
        {$ast = new ExplicitGenericActualParameter($variable_name.ast);}
    | subprogram_name = name
        {$ast = new ExplicitGenericActualParameter($subprogram_name.ast);}
    | entry_name = name
        {$ast = new ExplicitGenericActualParameter($entry_name.ast);}
    | subtype_mark = name
        {$ast = new ExplicitGenericActualParameter($subtype_mark.ast);}
    | package_instance_name = name
        {$ast = new ExplicitGenericActualParameter($package_instance_name.ast);}
    ;

formal_object_declaration returns [FormalObjectDeclaration ast]
    : defining_identifier_list ':' mode_ subtype_mark = name (':=' default_expression)? ';'
        {$ast = new FormalObjectDeclaration($defining_identifier_list.ast, $mode_.ast, $subtype_mark.ast, $ctx.default_expression != null ? $default_expression.ast : null);}
    ;

formal_type_declaration returns [FormalTypeDeclaration ast]
    : TYPE defining_identifier discriminant_part? IS formal_type_definition ';'
        {$ast = new FormalTypeDeclaration($defining_identifier.ast, $ctx.discriminant_part != null ? $discriminant_part.ast : null, $formal_type_definition.ast);}
    ;

formal_type_definition returns [FormalTypeDefinition ast]
    : formal_private_type_definition
        {$ast = new FormalTypeDefinition($formal_private_type_definition.ast);}
    | formal_derived_type_definition
        {$ast = new FormalTypeDefinition($formal_derived_type_definition.ast);}
    | formal_discrete_type_definition
        {$ast = new FormalTypeDefinition($formal_discrete_type_definition.ast);}
    | formal_signed_integer_type_definition
        {$ast = new FormalTypeDefinition($formal_signed_integer_type_definition.ast);}
    | formal_modular_type_definition
        {$ast = new FormalTypeDefinition($formal_modular_type_definition.ast);}
    | formal_floating_point_definition
        {$ast = new FormalTypeDefinition($formal_floating_point_definition.ast);}
    | formal_ordinary_fixed_point_definition
        {$ast = new FormalTypeDefinition($formal_ordinary_fixed_point_definition.ast);}
    | formal_decimal_fixed_point_definition
        {$ast = new FormalTypeDefinition($formal_decimal_fixed_point_definition.ast);}
    | formal_array_type_definition
        {$ast = new FormalTypeDefinition($formal_array_type_definition.ast);}
    | formal_access_type_definition
        {$ast = new FormalTypeDefinition($formal_access_type_definition.ast);}
    ;

formal_private_type_definition returns [FormalPrivateTypeDefinition ast]
    : (ABSTRACT? TAGGED)? LIMITED? PRIVATE
        {$ast = new FormalPrivateTypeDefinition($ctx.ABSTRACT != null ? $ABSTRACT : null, $ctx.TAGGED != null ? $TAGGED : null, $ctx.LIMITED != null ? $LIMITED : null);}
    ;

formal_derived_type_definition returns [FormalDerivedTypeDefinition ast]
    : ABSTRACT? NEW subtype_mark = name (WITH PRIVATE)?
        {$ast = new FormalDerivedTypeDefinition($subtype_mark.ast, $ctx.ABSTRACT != null ? $ABSTRACT : null, $ctx.WITH != null ? $WITH : null, $ctx.PRIVATE != null ? $PRIVATE : null);}
    ;

formal_discrete_type_definition returns [FormalDiscreteTypeDefinition ast]
    : '(' '<>' ')'
        {$ast = new FormalDiscreteTypeDefinition();}
    ;

formal_signed_integer_type_definition returns [FormalSignedIntegerTypeDefinition ast]
    : RANGE_ '<>'
        {$ast = new FormalSignedIntegerTypeDefinition();}
    ;

formal_modular_type_definition returns [FormalModularTypeDefinition ast]
    : MOD '<>'
        {$ast = new FormalModularTypeDefinition();}
    ;

formal_floating_point_definition returns [FormalFloatingPointDefinition ast]
    : DIGITS '<>'
        {$ast = new FormalFloatingPointDefinition();}
    ;

formal_ordinary_fixed_point_definition returns [FormalOrdinaryFixedPointDefinition ast]
    : DELTA '<>'
        {$ast = new FormalOrdinaryFixedPointDefinition();}
    ;

formal_decimal_fixed_point_definition returns [FormalDecimalFixedPointDefinition ast]
    : DELTA '<>' DIGITS '<>'
        {$ast = new FormalDecimalFixedPointDefinition();}
    ;

formal_array_type_definition returns [FormalArrayTypeDefinition ast]
    : array_type_definition
        {$ast = new FormalArrayTypeDefinition($array_type_definition.ast);}
    ;

formal_access_type_definition returns [FormalAccessTypeDefinition ast]
    : access_type_definition
        {$ast = new FormalAccessTypeDefinition($access_type_definition.ast);}
    ;

formal_subprogram_declaration returns [FormalSubprogramDeclaration ast]
    : WITH subprogram_specification (IS subprogram_default)? ';'
        {$ast = new FormalSubprogramDeclaration($subprogram_specification.ast, $ctx.subprogram_default != null ? $subprogram_default.ast : null);}
    ;

subprogram_default returns [SubprogramDefault ast]
    : default_name
        {$ast = new SubprogramDefault($default_name.ast);}
    | '<>'
        {$ast = new SubprogramDefault();}
    ;

default_name returns [DefaultName ast]
    : name
        {$ast = new DefaultName($name.ast);}
    ;

formal_package_declaration returns [FormalPackageDeclaration ast]
    : WITH PACKAGE defining_identifier IS NEW generic_package_name = name formal_package_actual_part ';'
        {$ast = new FormalPackageDeclaration($defining_identifier.ast, $generic_package_name.ast, $formal_package_actual_part.ast);}
    ;

formal_package_actual_part returns [FormalPackageActualPart ast]
    : '(' '<>' ')'
        {$ast = new FormalPackageActualPart();}
    | generic_actual_part?
        {$ast = new FormalPackageActualPart($ctx.generic_actual_part != null ? $generic_actual_part.ast : null);}
    ;

/*
13 - Representation Issues
*/

aspect_clause returns [AspectClause ast]
    : attribute_definition_clause
        {$ast = new AspectClause($attribute_definition_clause.ast);}
    | enumeration_representation_clause
        {$ast = new AspectClause($enumeration_representation_clause.ast);}
    | record_representation_clause
        {$ast = new AspectClause($record_representation_clause.ast);}
    | at_clause
        {$ast = new AspectClause($at_clause.ast);}
    ;

local_name returns [LocalName ast]
    : direct_name
        {$ast = new LocalName($direct_name.ast);}
    | direct_name SQ attribute_designator
        {$ast = new LocalName($direct_name.ast, $attribute_designator.ast);}
    | library_unit_name = name
        {$ast = new LocalName($library_unit_name.ast);}
    ;

attribute_definition_clause returns [AttributeDefinitionClause ast]
    : FOR local_name SQ attribute_designator USE expression ';'
        {$ast = new AttributeDefinitionClause($local_name.ast, $attribute_designator.ast, $expression.ast);}
    | FOR local_name SQ attribute_designator USE name ';'
        {$ast = new AttributeDefinitionClause($local_name.ast, $attribute_designator.ast, $name.ast);}
    ;

enumeration_representation_clause returns [EnumerationRepresentationClause ast]
    : FOR first_subtype_local_name = name USE enumeration_aggregate ';'
        {$ast = new EnumerationRepresentationClause($first_subtype_local_name.ast, $enumeration_aggregate.ast);}
    ;

enumeration_aggregate returns [EnumerationAggregate ast]
    : array_aggregate
        {$ast = new EnumerationAggregate($array_aggregate.ast);}
    ;

record_representation_clause returns [RecordRepresentationClause ast]
    : FOR first_subtype_local_name = name USE RECORD mod_clause? component_clauses END RECORD ';'
        {$ast = new RecordRepresentationClause($first_subtype_local_name.ast, $ctx.mod_clause != null ? $mod_clause.ast : null, $component_clauses.list);}
    ;
component_clauses returns [List<ComponentClause> list = new ArrayList<>()]
    : (component_clause {$list.add($component_clause.ast);})*
    ;

component_clause returns [ComponentClause ast]
    : component_local_name = name AT position RANGE_ first_bit '..' last_bit ';'
        {$ast = new ComponentClause($component_local_name.ast, $position.ast, $first_bit.ast, $last_bit.ast);}
    ;

position returns [ast.representationIssues.Position ast]
    : static_expression = expression
        {$ast = new ast.representationIssues.Position($static_expression.ast);}
    ;

first_bit returns [FirstBit ast]
    : static_simple_expression = simple_expression
        {$ast = new FirstBit($static_simple_expression.ast);}
    ;

last_bit returns [LastBit ast]
    : static_simple_expression = simple_expression
        {$ast = new LastBit($static_simple_expression.ast);}
    ;

code_statement returns [CodeStatement ast]
    : qualified_expression ';'
        {$ast = new CodeStatement($qualified_expression.ast);}
    ;

restriction returns [Restriction ast]
    : restriction_identifier = identifier
        {$ast = new Restriction($restriction_identifier.ast);}
    | restriction_parameter_identifier = identifier '=>' expression
        {$ast = new Restriction($restriction_parameter_identifier.ast, $expression.ast);}
    ;

/*
J
*/

at_clause returns [AtClause ast]
    : FOR direct_name USE AT expression ';'
        {$ast = new AtClause($direct_name.ast, $expression.ast);}
    ;

delta_constraint returns [DeltaConstraint ast]
    : DELTA static_expression = expression range_constraint?
        {$ast = new DeltaConstraint($static_expression.ast, $ctx.range_constraint != null ? $range_constraint.ast : null);}
    ;

mod_clause returns [ModClause ast]
    : AT MOD static_expression = expression ';'
        {$ast = new ModClause($static_expression.ast);}
    ;

boolean_expression returns [BooleanExpression ast]
    : expression
        {$ast = new BooleanExpression($expression.ast);}
    ;